@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw 1oracle123 oracle@192.168.10.25 "sh start_ias.sh"
exit