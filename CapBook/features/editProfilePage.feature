Feature: User EditProfilePage Feature
 Using this feature User can edit profile in Capbook

  Scenario: User wants to 'EditProfile' on the portal  with valid details
    Given User is on Capbook 'capBookHome'. 
    When User enters all the valid details.
    Then User is directed to the'profilePage'.
    
    Scenario: User wants to 'EditProfile' with valid details
    Given User is on Capbook 'profilePage'. 
    When User clicks on 'editProfile'.
    Then User is directed to 'editProfilePage'.
    
    Scenario: User wants to 'Edit Profile' with valid details
    Given User is on Capbook 'editProfilePage'. 
    When User enters all valid inputs and cliks on 'updateProfile'
    Then User profile is directed to 'editProfilePage'updated with alert message.