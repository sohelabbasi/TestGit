package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class PersonalDetailsPage extends CommonMethods {

    @FindBy(css="div#profile-pic")
    public WebElement imageLocator;


    public PersonalDetailsPage(){
        PageFactory.initElements(driver, this);
    }

}
