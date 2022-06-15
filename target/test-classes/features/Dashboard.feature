Feature: This feature verify the functionality of dashboard feature

  Background:
    When user enters username in the username textfield
    And enters password in the passowrd textfield
    And user clicks on login button

  @test456
  Scenario: verify dashboard
    Then user is able to verify dashboard options

    @test456
    Scenario: verify logout functionality
      When user selects welcome admin dropdown
      And user clicks on logout button
      Then user should redirect back to login page


