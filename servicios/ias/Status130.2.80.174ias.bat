@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw %1 oracle@130.2.80.174 "sh status_ias.sh; cat status_ias.log" > c:\servicios\ias\130.2.80.174.txt
exit