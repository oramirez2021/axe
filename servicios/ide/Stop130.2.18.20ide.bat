@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw %2 %1@130.2.18.20 "sh stop_ias.sh"
exit