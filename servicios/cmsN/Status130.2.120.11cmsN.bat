@echo off
set path=%2
if %1==1 (
psexec.exe \\130.2.120.11 -u Administrator -p Password.2014 c:\cmsTmp\cmsTodArr.bat > %3\cmsN\130.2.120.11.txt )
if %1==2 (
psexec.exe \\130.2.120.11 -u Administrator -p Password.2014 c:\cmsTmp\cmsTodAbj.bat > %3\cmsN\130.2.120.11abajo.txt)
if %1==3 (
psexec.exe \\130.2.120.11 -u Administrator -p Password.2014 c:\cmsTmp\StatusActual.bat > %3\cmsN\130.2.120.11act.txt)
exit
