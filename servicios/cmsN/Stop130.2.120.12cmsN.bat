@echo off
set path=%1
psexec.exe \\130.2.120.12 -u Administrator -p Password.2013 c:\cmsTmp\elimina.bat
exit