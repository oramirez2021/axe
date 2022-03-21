@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw 1oracle123 oracle@192.168.21.8 "sh stop_ias.sh"
exit