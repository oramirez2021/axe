@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw %1 oracle@192.168.10.31 "sh stop_ias.sh"
exit