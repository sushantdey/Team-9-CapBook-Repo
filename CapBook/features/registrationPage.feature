Feature: User Register Feature
 Using this feature User can register in Capbook

Scenario: User wants to 'Register' on the portal  with valid details
    Given User is on the Capbook 'homePage'. 
    When User enters all valid details.
    Then User is directed to 'profilePage'.
    
Scenario: User fails to register due to empty firstName
    Given User is on the Capbook 'homePage'.
    When User does not enters firstName.
    Then User is directed to 'homePage' with enter 'firstName' Error.
    
Scenario: User fails to register due to empty lastName
    Given User is on the Capbook 'homePage'. 
    When User does not enters lastName.
    Then User is directed to 'homePage' with enter 'lastName' Error.

 Scenario: User fails to register due to invalid emailId
    Given User is on the Capbook 'homePage'.
    When User does not enters valid emailId.
    Then User is directed to 'homePage' with  'valid emailId' Error.
    
Scenario: User fails to register due to invalid password
    Given User is on the Capbook 'homePage'. 
    When User does not enters valid password.
    Then User is directed to 'homePage' with  'valid password' Error.
    
Scenario: User fails to register due to empty homeTown
    Given User is on the Capbook 'homePage'. 
    When User does not enters  homeTown.
    Then User is directed to 'homePage' with enter 'homeTown' Error.

Scenario: User fails to register due to mismatch of confirm password
    Given User is on the Capbook 'homePage'. 
    When User password does not match..
    Then User is directed to 'homePage' with 'mismatch password' Error .
    
Scenario: User fails to register due to empty dateOfBirth
    Given User is on the Capbook 'homePage'.
    When User does not enters dateOfBirth .
    Then User is directed to 'homePage' with enter 'dateOfBirth' Error.