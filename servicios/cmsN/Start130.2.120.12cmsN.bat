@echo off
set path=C:\Program Files\pstools
psexec.exe \\130.2.120.12 -u Administrator -p Password.2013 c:\cmsTmp\planoStartCms.bat
exit