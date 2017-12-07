import bluetooth as bt

host = "e4:f8:9c:bc:93:0e"
channel = 3
uuid = "0C1ABDD7-436F-79E0-7152-4D91528DA3D1"

socket = bt.BluetoothSocket(bt.RFCOMM)
socket.listen(3)
socket.bind((host, channel))
bt.advertise_service(socket, "Scouting app data transfer", uuid, [bt.SERIAL_PORT_CLASS], [bt.SERIAL_PORT_PROFILE],
                     "Team 449", "Receives scouting data from Kindles")
