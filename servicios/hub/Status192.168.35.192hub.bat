@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw %2 %1@192.168.35.192 "sh status_ias.sh; cat status_ias.log" > c:\servicios\hub\192.168.35.192.txt
exit