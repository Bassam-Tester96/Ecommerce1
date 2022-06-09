Feature: User should be able to login to system

  #Test Scenario 1
  Scenario: User login with Valid data
    Given user navigate to login page
    When user enter valid email and password
    And User click on login button
    #Expected Result
  Then User should login Successfully