@echo off
set path=%1
psexec.exe \\130.2.120.13 -u Administrator -p 14cmsDu03 c:\cmsTmp\planoStartCms.bat
exit