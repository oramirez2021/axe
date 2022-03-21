@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw %2 %1@192.168.35.47 "cd \/procesos/masgtw/alarmas; sh monitor_proceso_mas.sh" 
plink.exe -pw %2 %1@192.168.35.47 "cd \/procesos/masgtw/alarmas; cat monitor_proceso_mas.log" > c:\servicios\ide\192.168.35.47.txt
exit