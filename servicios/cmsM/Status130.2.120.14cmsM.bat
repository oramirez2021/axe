@echo off
set path=C:\Program Files\pstools
if %1==1 (
psexec.exe \\130.2.120.14 -u Administrator -p 14cmsDu04 c:\cmsTmp\cmsTodArr.bat > c:\servicios\cmsM\130.2.120.14.txt )
if %1==2 (
psexec.exe \\130.2.120.14 -u Administrator -p 14cmsDu04 c:\cmsTmp\cmsTodAbj.bat > c:\servicios\cmsM\130.2.120.14abajo.txt
)
if %1==3 (
psexec.exe \\130.2.120.14 -u Administrator -p 14cmsDu04 c:\cmsTmp\statusActual.bat > c:\servicios\cmsM\130.2.120.14act.txt
)

exit