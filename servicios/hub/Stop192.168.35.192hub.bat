@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw %2 %1@192.168.35.192 "sh start_ias.sh"
exit