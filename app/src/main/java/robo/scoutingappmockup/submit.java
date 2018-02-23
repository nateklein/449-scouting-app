package robo.scoutingappmockup;

import android.app.Activity;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelUuid;
import android.util.Log;
import android.bluetooth.BluetoothDevice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.UUID;

public class submit extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!MainActivity.db.checkData().equals("")) {
            Intent viewErrors = new Intent(this, fixErrors.class);
            startActivity(viewErrors);
        }
        else {
            try {
                // Writes data to files
                File root = Environment.getExternalStorageDirectory();
                File dir = new File (root.getAbsolutePath() + "/download");
                dir.mkdirs();
                // One line file - rewritten every match
                File data = new File(dir, "data.csv");
                PrintWriter writer = new PrintWriter(data);
                // File with all matches from the current Kindle - appended to every match
                BufferedWriter allWriter = new BufferedWriter(
                                            new FileWriter(root.getAbsolutePath() + "/download/" +
                                                            "alldata.csv", true));
                String csvString = MainActivity.db.toString();
                writer.println(csvString);
                allWriter.append(csvString + "\n");
                writer.close();
                allWriter.close();

                /* Bluetooth connect - https://code.tutsplus.com/tutorials/create-a-bluetooth-scanner-with-androids-bluetooth-api--cms-24084 */
                Log.i("ScoutBT", "Starting Bluetooth connection\n");

                MainActivity.pairedDevices = MainActivity.adapter.getBondedDevices();
                //if (MainActivity.pairedDevices.size() > 0)
                //{
                //    for (BluetoothDevice device : MainActivity.pairedDevices)
                //    {
                //        Log.i("ScoutBT", device.getName() + " " + device.getAddress());
                //    }
                //}

                /* Only do stuff with Bluetooth if we have a paired device */
                if (MainActivity.pairedDevices.size() == 1)
                {
                    /* Obtain the PC device */
                    BluetoothDevice pc = null;
                    for (BluetoothDevice device : MainActivity.pairedDevices)
                    {
                        pc = device;
                    }

                    /* Go through supported UUIDs and ensure one is what we want */
                    ParcelUuid[] uuids = pc.getUuids();
                    boolean hasWanted = false;
                    for (ParcelUuid pUuid : uuids)
                    {
                        UUID uuid = pUuid.getUuid();
                        Log.i("ScoutBT", "UUID found: " + uuid.toString());

                        if (uuid.toString().toUpperCase().equals("0C1ABDD7-436F-79E0-7152-4D91528DA3D1"))
                        {
                            hasWanted = true;
                            break;
                        }
                    }

                    /* Perform the connection and transfer */
                    if (hasWanted)
                    {
                        Log.i("ScoutBT", "PC is running the scout server");

                        UUID uuid = UUID.fromString("0C1ABDD7-436F-79E0-7152-4D91528DA3D1");
                        BluetoothSocket sock;
                        try
                        {
                            /* Make a socket for the PC and connect -
                                https://stackoverflow.com/questions/24573755/android-bluetooth-socket-connect-fails
                                https://bugreports.qt.io/browse/QTBUG-40172
                            */
                            //sock = pc.createInsecureRfcommSocketToServiceRecord(uuid);
                            Method m = pc.getClass().getMethod("createInsecureRfcommSocket", new Class[] {int.class});
                            sock = (BluetoothSocket) m.invoke(pc, 17);
                            sock.connect();

                            Log.i("ScoutBT", "Connected to socket");
                        }
                        catch (Exception e)
                        {
                            Log.e("ScoutBT", "Failed to do BT transfer");
                        }
                    }
                    else
                    {
                        Log.i("ScoutBT", "No proper scouting interface on PC");
                    }
                }

                // Go to confirmation page
                Intent toSubmitted = new Intent(this, submitted.class);
                startActivity(toSubmitted);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
