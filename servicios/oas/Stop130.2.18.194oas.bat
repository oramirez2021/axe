@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw 1oracle123 oracle@130.2.18.194 "sh stop_ias.sh"
exit