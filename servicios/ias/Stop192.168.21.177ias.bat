@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw %1 oracle@192.168.21.177 "sh stop_ias.sh"
exit