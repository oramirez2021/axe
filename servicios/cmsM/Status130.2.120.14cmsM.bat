@echo off
set path=%2
if %1==1 (
psexec.exe \\130.2.120.14 -u Administrator -p 14cmsDu04 c:\cmsTmp\cmsTodArr.bat > %3\cmsM\130.2.120.14.txt )
if %1==2 (
psexec.exe \\130.2.120.14 -u Administrator -p 14cmsDu04 c:\cmsTmp\cmsTodAbj.bat > %3\cmsM\130.2.120.14abajo.txt)
if %1==3 (
psexec.exe \\130.2.120.14 -u Administrator -p 14cmsDu04 c:\cmsTmp\statusActual.bat > %3\cmsM\130.2.120.14act.txt)
exit