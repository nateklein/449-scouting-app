# Useful Internet resources
#  * https://stackoverflow.com/questions/44031057/pybluez-on-raspbian-android-pybluez-on-windows-losing-bytes-after-around-1kb

import bluetooth as bt

# Bluetooth MAC address
HOST_NATE = "e4:f8:9c:bc:93:0e"
HOST_GEORGE = "28:cf:da:dc:5c:d1"
HOST = HOST_GEORGE

# Bluetooth channel
CHANNEL = 3

# Bluetooth UUID
UUID = "0C1ABDD7-436F-79E0-7152-4D91528DA3D1"

# Open up the service
socket = bt.BluetoothSocket(bt.RFCOMM)
socket.bind((HOST, CHANNEL))
socket.listen(3)
bt.advertise_service(socket, "Scouting app data transfer", UUID, [bt.SERIAL_PORT_CLASS], [bt.SERIAL_PORT_PROFILE],
                     "Team 449", "Receives scouting data from Kindles")
