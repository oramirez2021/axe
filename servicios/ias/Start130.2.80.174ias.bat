@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw %1 oracle@130.2.80.174 "sh start_ias.sh"
exit