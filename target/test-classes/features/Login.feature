Feature: This feature contains all the login test scenarios

  @mvn123
  Scenario: Valid admin login
    #Given user is able to launch the HRMS application in the browser
    When user enters username in the username textfield
    And enters password in the passowrd textfield
    And user clicks on login button
    Then user should be able to see dashboard page
