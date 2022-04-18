@echo off
set path=%1
plink.exe -pw 1oracle123 oracle@130.2.18.194 "sh status_ias.sh; cat status_ias.log" > %2\oas\130.2.18.194%3.txt
exit