@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw %1 oracle@192.168.21.168 "sh status_ias.sh; cat status_ias.log" > c:\servicios\ias\192.168.21.168.txt
exit