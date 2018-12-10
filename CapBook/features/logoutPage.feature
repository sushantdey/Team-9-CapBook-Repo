Feature: User logout Feature
 Using this feature User can logout of Capbook

Scenario: User wants to 'login' of the portal 
    Given User is on the Capbook 'capBookHome'. 
    When User enters all required  details.
    Then User is directed to'profilePage'.
    
Scenario: User wants to 'logout' of the portal 
    Given User is on the Capbook 'profilePage'. 
    When User clicks on 'logout'
    Then User is directed to 'capBookHome'.