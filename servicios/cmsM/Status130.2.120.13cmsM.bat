@echo off
set path=C:\Program Files\pstools
if %1==1 (
psexec.exe \\130.2.120.13 -u Administrator -p 14cmsDu03 c:\cmsTmp\cmsTodArr.bat > c:\servicios\cmsM\130.2.120.13.txt ) 
if %1==2  (
psexec.exe \\130.2.120.13 -u Administrator -p 14cmsDu03 c:\cmsTmp\cmsTodAbj.bat > c:\servicios\cmsM\130.2.120.13abajo.txt
)
if %1==3 (
psexec.exe \\130.2.120.13 -u Administrator -p 14cmsDu03 c:\cmsTmp\statusActual.bat > c:\servicios\cmsM\130.2.120.13act.txt
)
exit