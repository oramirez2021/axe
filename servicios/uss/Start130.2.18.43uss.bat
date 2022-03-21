@echo off
set path=C:\Program Files\PuTTY
plink.exe -pw 1oracle123 oracle@130.2.18.43 "linux32 /oracle/ias/OraHome/opmn/bin/opmnctl startall;linux32 /oracle/ias/OraHome/bin/emctl start iasconsole"
exit