@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw %1 oracle@192.168.21.177 "sh start_ias.sh"
exit