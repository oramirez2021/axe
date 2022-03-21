@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw %2 %1@130.2.18.126 "sh start_ias.sh"
exit