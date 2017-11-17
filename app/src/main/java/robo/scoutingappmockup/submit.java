package robo.scoutingappmockup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class submit extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!checkData().equals("")) {
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
                BufferedWriter allWriter = new BufferedWriter(new FileWriter(root.getAbsolutePath() + "/download/" + "alldata.csv", true));
                String csvString = MainActivity.db.toString();
                writer.println(csvString);
                allWriter.append(csvString + "\n");
                writer.close();
                allWriter.close();
                Intent toSubmitted = new Intent(this, submitted.class);
                startActivity(toSubmitted);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String checkData() {
        String errors = "";
        if (MainActivity.db.scoutName.equals("")) {
            errors += "Scout name cannot be empty\n";
        }
        if (MainActivity.db.matchNumber == 0) {
            errors += "Match number cannot be empty\n";
        }
        if (MainActivity.db.teamNumber == 0) {
            errors += "Team number cannot be empty\n";
        }
        if (MainActivity.db.autoGear == 0) {
            errors += "Select an option for auto gear\n";
        }
        if (MainActivity.db.dead == 0) {
            errors += "Select an option for deadness\n";
        }
        if (MainActivity.db.climb == 0) {
            errors += "Select an option for climbing\n";
        }
        return errors;
    }

}
