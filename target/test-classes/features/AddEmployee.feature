Feature: This feature covers the functionality of adding an employee in HRMS

  Background:
    When user enters username in the username textfield
    And enters password in the passowrd textfield
    And user clicks on login button
    When user clicks on PIM option
    And user clicks on add employee button

  @sprint1
  Scenario: Adding one employee
    Then user should be able to see add employee page
    When user enters firstname, middlename and lastname
    And user clicks on save button
    Then user should be able to add an employee in the system

    @test123
    Scenario: Adding one employee from feature
      When user enters "prateek" , "MS" and "Sharma"
      And user clicks on save button
      Then user should be able to add an employee in the system

   @DDT
   Scenario Outline: Adding multiple employees
     When user enters "<firstname>" "<middlename>" and "<lastname>" values
     And user clicks on save button
     Then user should be able to add an employee in the system
     Examples:
     |firstname|middlename|lastname|
     |bushra1   |MS        |firdose |
     |bharath1  |MS        |sharma  |
     |mike1     |MS        |Lopez   |
     |vijay1    |birthday  |boy     |
     |sharath1  |for       |example |

  @datatable
  Scenario: Adding multiple employees using data table
    When user add multiple employees using data table and verify that the user has been added
    |firstName|middleName|lastName|
    |omkar1    |MS        |sutar   |
    |prateek2  |MS        |chacha  |
    |sharath3  |MS        |example |

  @excel
  Scenario: Adding the employee using excel file
    When user adds multiple employee frome excel file using "EmployeeData" and verify it









