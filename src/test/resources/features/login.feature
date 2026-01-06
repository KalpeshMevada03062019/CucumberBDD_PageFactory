Feature: OrangeHRM Login

  Background:
    Given User is opening Chrome browser
    And User navigates to OrangeHRM login

  Scenario: Login with valid credentials
    When User enters <username> and <password>
    And User clicks on login button in orange
    Then User should be logged in successfully to oranghrms
    
    
Examples: #data table for parameterization
|username|password|
|admin|admin123|
|admin|test123|