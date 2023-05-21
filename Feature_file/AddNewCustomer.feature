Feature: Customer

Background: Steps common for all scenarios
Given User use Chrome browser
When User open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And User enter email as "admin@yourstore.com" and password as "admin"
Then User verify Title as "Dashboard / nopCommerce administration"
And click on login button

@sanity
Scenario: Add New Customer

When User click on customers Menu
And click on customers Menu Item
And click on Add New button
Then User can view Add new customer page
When User enter customer Info
And Click on Save button
Then User can view confirmation message "The new customer has been added successfully."
And close browser

@Regression
Scenario: Search Customer by Email

When User click on customers Menu
And click on customers Menu Item
And Enter Customer Email
When Click on Search button
Then User should found Email in the Search table
And User close the browser

@Regression #@2345
Scenario: Search Customer by Name

When User click on customers Menu
And click on customers Menu Item
And Enter customer FirstName
And Enter customer LastName
When Click on Search button
Then User should found Name in the Search table
And User close the browser