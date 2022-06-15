package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {
    @FindBy(name="firstName")
    public WebElement firstNameField;

    @FindBy(name="middleName")
    public WebElement middleNameField;

    @FindBy(name="lastName")
    public WebElement lastNameField;

    @FindBy(id="btnSave")
    public WebElement saveButtonOption;

    @FindBy(css="input#photofile")
    public WebElement photograph;

    @FindBy(css="input#chkLogin")
    public WebElement checkBox;

    @FindBy(css="input#user_name")
    public WebElement usernamefieldEmployee;

    @FindBy(css="input#user_password")
    public WebElement passwordfieldEmployee;

    @FindBy(css="input#re_password")
    public WebElement confirmpasswordfield;

    public AddEmployeePage(){
        PageFactory.initElements(driver, this);
    }

}
