@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw %2 %1@130.2.17.34 "sh start_ias.sh"
exit