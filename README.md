# Masters_Thesis
- This project translate the second generation layout based mobile testing test scripts into third generation GUI based test scripts. 
- The exiting layout based test scripts written in java language which runs through appium server and executes in amdroid emulator, are parsed through a java program, which looks for all the lines of code, which makes interaction in the mobile screen. For exampke, all the lines which contains - "driver.findElement". 
- After finding all the interactions, the test script is updated with a line of code -  addScreenshot(element) - before every line which found in previous step. 
- Now, when the updated script is run, a screenhost of the element is taken before the interaction of that particular element take place. -
- an action list is also maintained by extracting the actions from all the line of codes which perform some interaction. eg. click, sendKeys, assertTrue. 
- This action list is written into a text file, with updated keywords according to the third generation visual based testing tool. In our case, Sikuli tool was used. So, accordingly the sendKeys is converted to 'type', while assertTrue is converted to 'exists'.
- At last when screenshots of all the elements and text file are collected at saved in one of sikuli folder, they are run through the sikuli tool, to examine how many scripts were translated successfully based on the result of the script in sikuli log. 
- this project proved to be an efficient way to test mobile applications through GUI tools, without creating tests scripts from scratch. 
