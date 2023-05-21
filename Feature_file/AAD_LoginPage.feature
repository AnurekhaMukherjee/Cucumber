Feature: Login Page

Scenario: Successful Login with Valid Credentials
Given User use Chrome browser
When User open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And User enter email as "admin@yourstore.com" and password as "admin"
And click on login button
Then User verify Title as "Dashboard / nopCommerce administration"
Then User click on logout button
Then User verify Title as "Your store. Login"
And User close the browser

Scenario Outline: Successful login with Valid Credentals DDT
Given User use Chrome browser
When User open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And User enter email as "<email>" and password as "<password>"
And click on login button
Then User verify Title as "Dashboard / nopCommerce administration"
Then User click on logout button
Then User verify Title as "Your store. Login"
And User close the browser

Examples:
|email|password|
|admin@yourstore.com|admin| #valid username and password
|Test@yourstore.com|admin|  #invalid username and password