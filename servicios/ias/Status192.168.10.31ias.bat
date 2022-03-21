@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw %1 oracle@192.168.10.31 "sh status_ias.sh; cat status_ias.log" > c:\servicios\ias\192.168.10.31.txt
exit