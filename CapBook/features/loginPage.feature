Feature: Capbook Home page
Using this feature User can go to Capbook Profile page

Scenario: User wants to "login" on the portal
Given User is on the CapBook home page
When User enters valid details
Then User is navigated to CapBook Profile Page

Scenario: User fails  to "login" on the portal
Given User is on the CapBook home page
When User enters invalid email Id or User enters invalid password
Then User is navigated to CapBook Home Page with an error message 