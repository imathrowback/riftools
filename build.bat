@echo off
set JAVA_HOME=c:\Program Files (x86)\Java\jdk1.8.0_45
set ANT_HOME=L:\downloads\apache-ant-1.9.4-bin\apache-ant-1.9.4

cd rifttools
%ANT_HOME%\bin\ant.bat 

echo See "RiftTools\build\jar" for the compiled files

cd ..
