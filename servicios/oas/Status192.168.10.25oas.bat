@echo off
set path=%1
plink.exe -pw 1oracle123 oracle@192.168.10.25 "sh status_ias.sh; cat status_ias.log" > %2\oas\192.168.10.25%3.txt
exit