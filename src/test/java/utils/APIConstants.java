package utils;

import io.restassured.RestAssured;

public class APIConstants {
    public static final String BaseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    public static final String CREATE_EMPLOYEE_URI = BaseURI + "/createEmployee.php";
    public static final String GET_ONE_EMPLOYEE = BaseURI + "/getOneEmployee.php";
    public static final String UPDATE_EMPLOYEE_URI = BaseURI + "/updateEmployee.php";
    public static final String GET_ALL_EMPLOYEE_URI = BaseURI + "/getAllEmployees.php";
    public static final String DELETE_EMPLOYEE_URI = BaseURI + "/deleteEmployee.php";
    public static final String generateToken_URI = BaseURI + "/generateToken.php";
    public static final String Header_Content_Type_key = "Content-Type";
    public static final String Header_Content_Type_Value = "application/json";
    public static final String Header_Authorization_key = "Authorization";
}
