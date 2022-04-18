rem @echo off
set path=%4
plink.exe -pw %2 %1@%3 cd %8; sh %9; cat %7> %4\servicios\%3%6%5.txt
pause
exit