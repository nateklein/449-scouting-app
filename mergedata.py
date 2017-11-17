import os

# Pull the csv from the Kindle's SD
os.chdir(r"C:\Users\Nate\Desktop")
os.system(r"C:\Users\Nate\AppData\Local\Android\sdk\platform-tools\adb.exe pull /mnt/sdcard/Download/data.csv")

# Read in the extracted CSV
data = open(r"C:\Users\Nate\Desktop\data.csv").read()

# Write it to the master file
mf = open("masterfile.csv", "a")
mf.write(data)
mf.close()
