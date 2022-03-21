@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw %1 oracle@192.168.21.172 "sh start_ias.sh"
exit