Feature: This file contains all the scenarios

  Background:
    Given a JWT bearer token is generated

  @api
  Scenario: Creating a request to add an employee
    Given a request is prepared for creating an employee
    When a Post call is made to create an employee
    Then the status code for creating an employee is 201
    And the employee created contains key "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as a global variable to be used for other calls

  @api
  Scenario: Fetch the details of recently created employee
    Given a request is prepared to get the created employee
    When a GET call is made to retrieve the created employee
    Then the status code for this request is 200
    And the employee data having ID "employee.employee_id" must match with globally stored ID
    And the retrieved data at "employee" object matches with the data used to create employee with "employee.employee_id"
    |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title|
    |shobha       |GB          |MS             |Female    |2022-06-13  |Probation |QA           |


  @json
  Scenario: Creating a request to add an employee
    Given a request is prepared for creating an employee via json payload
    When a Post call is made to create an employee
    Then the status code for creating an employee is 201
    And the employee created contains key "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as a global variable to be used for other calls


  @dynamic
  Scenario: Creating a request to add an employee
    Given a request is prepared for creating an employee with dynamic data "Denis" , "Lilly" , "MS" , "M" , "2018-12-12" , "Confirmed" , "Lead"
    When a Post call is made to create an employee
    Then the status code for creating an employee is 201
    And the employee created contains key "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as a global variable to be used for other calls


