@echo off
set path=%1
psexec.exe \\130.2.120.14 -u Administrator -p 14cmsDu04 c:\cmsTmp\elimina.bat
exit