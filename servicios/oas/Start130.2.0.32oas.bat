@echo off
set path=%1
plink.exe -pw 1oracle123 oracle@130.2.0.32 "sh start_ias.sh"
exit