@echo off
set path=%1
psexec.exe \\130.2.120.10 -u Administrator -p Password.2013 c:\cmsTmp\elimina.bat
exit