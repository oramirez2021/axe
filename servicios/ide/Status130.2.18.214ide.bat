@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw %2 %1@130.2.18.214 "cd \/procesos/masgtw/alarmas; sh monitor_proceso_mas.sh" 
plink.exe -pw %2 %1@130.2.18.214 "cd \/procesos/masgtw/alarmas; cat monitor_proceso_mas.log" > c:\servicios\ide\130.2.18.214.txt
exit