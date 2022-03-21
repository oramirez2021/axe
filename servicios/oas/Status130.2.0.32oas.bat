@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw 1oracle123 oracle@130.2.0.32 "sh status_ias.sh; cat status_ias.log" > c:\servicios\oas\130.2.0.32.txt
exit