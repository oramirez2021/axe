@echo off
set path=%1
plink.exe -pw 1oracle123 oracle@192.168.21.8 "sh start_ias.sh"
exit