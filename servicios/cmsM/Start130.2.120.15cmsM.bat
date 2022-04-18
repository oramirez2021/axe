@echo off
set path=%1
psexec.exe \\130.2.120.15 -u Administrator -p 14cmsDu05 c:\cmsTmp\planoStartCms.bat
exit