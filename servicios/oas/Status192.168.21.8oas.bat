@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw 1oracle123 oracle@192.168.21.8 "sh status_ias.sh; cat status_ias.log" > c:\servicios\oas\192.168.21.8.txt
exit