@echo off

echo springrest-Begin
	set "repoLocation=C:\Users\User\eclipse-workspace\springrest"
	set "gitPath=C:\Program Files\Git\cmd\git.exe"
	cd /d "%repoLocation%"
	if not exist "%repoLocation%\.git" (
		"%gitPath%" init
	)
	"%gitPath%" pull
	"%gitPath%" add .
		set commitMessage=LenovoBat %date% %time%
	"%gitPath%" commit -m "%commitMessage%"
	"%gitPath%" push
echo springrest-End








echo This window will close in 2 seconds...
timeout /t 3 >nul
exit