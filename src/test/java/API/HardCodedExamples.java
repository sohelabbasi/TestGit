package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples  {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NTUxODM0MTAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY1NTIyNjYxMCwidXNlcklkIjoiMzc3MCJ9.xZlEWul_9LMbAYYj5ML6lHJUPi_tJ8WcE-te6g9lnq0";
    static String employee_id;

    @Test
    public void aCreateEmployee(){

        //request specification allows you to specify the type of request we are making
        //headers, base url, body, authorization token, type of method

        RequestSpecification preparedRequest =
                given().header("Content-Type", "application/json").
                        header("Authorization", token).body("{\n" +
                                "  \"emp_firstname\": \"jahanvi\",\n" +
                                "  \"emp_lastname\": \"GB\",\n" +
                                "  \"emp_middle_name\": \"MS\",\n" +
                                "  \"emp_gender\": \"F\",\n" +
                                "  \"emp_birthday\": \"2012-06-13\",\n" +
                                "  \"emp_status\": \"Probation\",\n" +
                                "  \"emp_job_title\": \"QA\"\n" +
                                "}");

        Response response = preparedRequest.when().post("/createEmployee.php");
        response.prettyPrint();

        //we use jsonPath() to get specific value against any key

        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);
        response.then().assertThat().statusCode(201);
        response.then().assertThat().body("Employee.emp_birthday", equalTo("2012-06-13"));
        response.then().assertThat().body("Employee.emp_firstname", equalTo("jahanvi"));
        response.then().assertThat().body("Message", equalTo("Employee Created"));
    }

    @Test
    public void bGetCreatedEmployee(){
        RequestSpecification preparedRequest = given().header("Authorization", token).
                queryParam("employee_id", employee_id);

    Response response =    preparedRequest.when().get("/getOneEmployee.php");
    response.then().assertThat().statusCode(200);

    String empId = response.jsonPath().getString("employee.employee_id");
        System.out.println(empId);

    boolean comp = empId.contentEquals(employee_id);

    }

}
