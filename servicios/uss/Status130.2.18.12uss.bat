@echo off
set path=%1
plink.exe -pw 1oracle123 oracle@130.2.18.12 "sh status_ias.sh; cat status_ias.log" > %2\uss\130.2.18.12%3.txt
exit