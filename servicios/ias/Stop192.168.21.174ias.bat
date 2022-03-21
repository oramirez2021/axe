@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw %1 oracle@192.168.21.174 "sh stop_ias.sh"
exit