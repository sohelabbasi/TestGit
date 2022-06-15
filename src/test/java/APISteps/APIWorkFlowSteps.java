package APISteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.runner.Request;
import utils.APIConstants;
import utils.APIPayloadConstants;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APIWorkFlowSteps {

    RequestSpecification request;
    Response response;
    public static String employee_id;

    @Given("a request is prepared for creating an employee")
    public void a_request_is_prepared_for_creating_an_employee() {
        request = given().
                header(APIConstants.Header_Content_Type_key, APIConstants.Header_Content_Type_Value).
                header(APIConstants.Header_Authorization_key, GenerateTokenSteps.token).
                body(APIPayloadConstants.createEmployeePayload());
    }

    @When("a Post call is made to create an employee")
    public void a_post_call_is_made_to_create_an_employee() {
        response = request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
    }
    @Then("the status code for creating an employee is {int}")
    public void the_status_code_for_creating_an_employee_is(Integer statusCode) {
       response.then().assertThat().statusCode(statusCode);
    }

    @Then("the employee created contains key {string} and value {string}")
    public void the_employee_created_contains_key_and_value(String key, String value) {
        response.then().assertThat().body(key, equalTo(value));
    }

    @Then("the employee id {string} is stored as a global variable to be used for other calls")
    public void the_employee_id_is_stored_as_a_global_variable_to_be_used_for_other_calls(String empID) {
      employee_id = response.jsonPath().getString(empID);
      System.out.println(employee_id);
    }

    //-------------------------------------------------------------------------------------



    @Given("a request is prepared to get the created employee")
    public void a_request_is_prepared_to_get_the_created_employee() {
        request = given().header(APIConstants.Header_Authorization_key, GenerateTokenSteps.token).
                queryParam("employee_id", employee_id);
    }

    @When("a GET call is made to retrieve the created employee")
    public void a_get_call_is_made_to_retrieve_the_created_employee() {
        response = request.when().get(APIConstants.GET_ONE_EMPLOYEE);
    }
    @Then("the status code for this request is {int}")
    public void the_status_code_for_this_request_is(Integer int1) {
        response.then().assertThat().statusCode(int1);

    }
    @Then("the employee data having ID {string} must match with globally stored ID")
    public void the_employee_data_having_id_must_match_with_globally_stored_id(String empID) {
        String temp = response.jsonPath().getString(empID);
        Assert.assertEquals(employee_id, temp);
    }

    @Then("the retrieved data at {string} object matches with the data used to create employee with {string}")
    public void the_retrieved_data_at_object_matches_with_the_data_used_to_create_employee_with
            (String empObject, String responseEmpiD, DataTable dataTable) {


        List<Map<String, String>> expectedData = dataTable.asMaps(String.class, String.class);
        Map<String, String> actualData = response.body().jsonPath().get(empObject);

        for (Map<String, String> map : expectedData
        ) {
            Set<String> keys = map.keySet();
            for (String key : keys) {
                String expectedValue = map.get(key);
                String actualValue =  actualData.get(key);
                Assert.assertEquals(expectedValue, actualValue);
            }
        }

        String emp = response.body().jsonPath().getString(responseEmpiD);
        Assert.assertEquals(emp, employee_id);
    }

    @Given("a request is prepared for creating an employee via json payload")
    public void a_request_is_prepared_for_creating_an_employee_via_json_payload() {
        request = given().header(APIConstants.Header_Authorization_key, GenerateTokenSteps.token).
                header(APIConstants.Header_Content_Type_key, APIConstants.Header_Content_Type_Value).
                body(APIPayloadConstants.createEmployeePayloadJson());
    }

    @Given("a request is prepared for creating an employee with dynamic data {string} , {string} , {string} , {string} , {string} , {string} , {string}")
    public void a_request_is_prepared_for_creating_an_employee_with_dynamic_data
            (String emp_firstname, String emp_lastname, String emp_middle_name,
             String emp_gender, String emp_birthday,
             String emp_status, String emp_job_title) {
        request = given().header(APIConstants.Header_Authorization_key, GenerateTokenSteps.token).
                header(APIConstants.Header_Content_Type_key, APIConstants.Header_Content_Type_Value).
                body(APIPayloadConstants.dynamicPayload(emp_firstname, emp_lastname, emp_middle_name,
                        emp_gender, emp_birthday, emp_status, emp_job_title));

    }

}
