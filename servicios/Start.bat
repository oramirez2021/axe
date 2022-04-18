rem @echo off
set path=%4
plink.exe -pw %2 %1@%3 cd %6; sh %7
pause
exit