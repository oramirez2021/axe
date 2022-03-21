@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw %2 %1@192.168.35.47 "cd \/procesos/masgtw; sh shutdown.sh"
exit