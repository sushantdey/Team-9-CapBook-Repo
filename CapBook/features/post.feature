Feature: Capbook post page
Using this feature User can post something on portal

Scenario: User wants to "login" on the portal
Given User is on CapBook home page
When User enters  the valid details
Then User is navigated to the  CapBook Profile Page

Scenario: User wants to "post" on the portal
Given User is on the CapBook  'Profile Page'
When User writes something on the textfield
Then User post gets posted and is navigated to CapBook 'Profile Page'