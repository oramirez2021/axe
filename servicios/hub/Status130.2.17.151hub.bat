@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw %2 %1@130.2.17.151 "sh status_ias.sh; cat status_ias.log" > c:\servicios\hub\130.2.17.151.txt
exit