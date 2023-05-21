Feature: Login Page
Scenario: Successful login with multiple valid credential
Given Customer launch the chrome browser
When Customer enter the given url as "https://www.saucedemo.com/"
And Customer username as "<username>" and password as "<password>"
And Customer is going to click on login button
Then Customer is verified the given title "Swag Labs"
And Customer click on Menu button 
Then Customer click on logout button
And Customer close the browser

Examples:
|username|password|
|standard_user|secret_sauce|
#|locked_out_user|secret_sauce|
|performance_glitch_user|secret_sauce|
|problem_user|secret_sauce|