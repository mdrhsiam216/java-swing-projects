@echo off
:: cd $(CURRENT_DIRECTORY)
:: Start
set mypath=%cd%
:: echo %mypath%
cd %mypath%
::start DeleteCache.bat :: Before start
javac Start.java
java Start
start DeleteCache.bat :: After Start
