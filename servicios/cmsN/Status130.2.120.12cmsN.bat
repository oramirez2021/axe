@echo off
set path=C:\Program Files\pstools
if %1==1 (
psexec.exe \\130.2.120.12 -u Administrator -p Password.2013 c:\cmsTmp\cmsTodArr.bat > c:\servicios\cmsN\130.2.120.12.txt )
if %1==2 (
psexec.exe \\130.2.120.12 -u Administrator -p Password.2013 c:\cmsTmp\cmsTodAbj.bat > c:\servicios\cmsN\130.2.120.12abajo.txt
)
if %1==3 (
psexec.exe \\130.2.120.12 -u Administrator -p Password.2013 c:\cmsTmp\statusActual.bat > c:\servicios\cmsN\130.2.120.12act.txt
)
exit