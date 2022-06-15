package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import org.junit.Assert;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods{

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        click(dashboardPage.pimOption);
    }

    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {
       click(dashboardPage.addEmployeeOption);
    }
    @Then("user should be able to see add employee page")
    public void user_should_be_able_to_see_add_employee_page() {
        System.out.println("Page is visible");
    }
    @When("user enters firstname, middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        sendText(addEmployeePage.firstNameField, "mike123");
        sendText(addEmployeePage.middleNameField, "MS");
        sendText(addEmployeePage.lastNameField, "kasprowicz");

    }

    @When("user enters {string} , {string} and {string}")
    public void user_enters_and(String firstNameValue, String middleNameValue, String lastNameValue) {
        sendText(addEmployeePage.firstNameField, firstNameValue);
        sendText(addEmployeePage.middleNameField, middleNameValue);
        sendText(addEmployeePage.lastNameField, lastNameValue);
    }

    @When("user enters {string} {string} and {string} values")
    public void user_enters_and_values(String fn, String mn, String ln) {
        sendText(addEmployeePage.firstNameField, fn);
        sendText(addEmployeePage.middleNameField, mn);
        sendText(addEmployeePage.lastNameField, ln);
    }

    @When("user add multiple employees using data table and verify that the user has been added")
    public void user_add_multiple_employees_using_data_table_and_verify_that_the_user_has_been_added(DataTable dataTable) throws InterruptedException {

        //fetching the data from data table
        //every row is giving one map and we are getting multiple maps in the form of list of maps
        List<Map<String,String>> employeeNames = dataTable.asMaps();

        for (Map<String, String> emp:employeeNames
             ) {
            String firstNameValue = emp.get("firstName");
            String middleNameValue = emp.get("middleName");
            String lastNameValue = emp.get("lastName");
            sendText(addEmployeePage.firstNameField, firstNameValue);
            sendText(addEmployeePage.middleNameField, middleNameValue);
            sendText(addEmployeePage.lastNameField, lastNameValue);
            click(addEmployeePage.saveButtonOption);
            Thread.sleep(2000);
            //assertion
            Assert.assertTrue(personalDetailsPage.imageLocator.isDisplayed());
            click(dashboardPage.addEmployeeOption);
            Thread.sleep(2000);
        }
    }

    @When("user adds multiple employee frome excel file using {string} and verify it")
    public void user_adds_multiple_employee_frome_excel_file_using_and_verify_it(String sheetName) throws InterruptedException {

        List<Map<String, String>> newEmployees = ExcelReader.excelListIntoMap(Constants.TESTDATA_FILEPATH,sheetName);
        Iterator<Map<String, String>> itr = newEmployees.iterator();

        while (itr.hasNext()){
            Map<String, String> mapNewEmp = itr.next();
            sendText(addEmployeePage.firstNameField, mapNewEmp.get("firstName"));
            sendText(addEmployeePage.middleNameField, mapNewEmp.get("middleName"));
            sendText(addEmployeePage.lastNameField, mapNewEmp.get("lastName"));
            sendText(addEmployeePage.photograph, mapNewEmp.get("photograph"));
            Thread.sleep(2000);
            if(!addEmployeePage.checkBox.isSelected()){
                click(addEmployeePage.checkBox);
            }
            sendText(addEmployeePage.usernamefieldEmployee, mapNewEmp.get("username"));
            sendText(addEmployeePage.passwordfieldEmployee, mapNewEmp.get("password"));
            sendText(addEmployeePage.confirmpasswordfield, mapNewEmp.get("confirmPassword"));
            click(addEmployeePage.saveButtonOption);
            Thread.sleep(2000);
            click(dashboardPage.addEmployeeOption);
        }

    }



        @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(addEmployeePage.saveButtonOption);
    }
    @Then("user should be able to add an employee in the system")
    public void user_should_be_able_to_add_an_employee_in_the_system() {
        System.out.println("User added");
    }

}
