@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw 1oracle123 oracle@130.2.18.23 "sh status_ias.sh; cat status_ias.log" > c:\servicios\uss\130.2.18.23.txt
exit