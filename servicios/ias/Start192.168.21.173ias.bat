@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw %1 oracle@192.168.21.173 "sh start_ias.sh"
exit