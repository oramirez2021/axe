@echo off
set path=%1
psexec.exe \\130.2.120.11 -u Administrator -p Password.2014 c:\cmsTmp\elimina.bat
exit