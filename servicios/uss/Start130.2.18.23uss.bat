@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw 1oracle123 oracle@130.2.18.23 "sh start_ias.sh"
exit