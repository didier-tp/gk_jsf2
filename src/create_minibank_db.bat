cd /d "%~dp0"
set MYSQL_HOME=C:\Program Files\MySQL\MySQL Server 5.7
"%MYSQL_HOME%\bin\mysql" -u root -p < create_minibank_db.sql
pause