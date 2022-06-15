package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Class12 {
    public static void main(String[] args) {
        WebDriver driver;
        //setting up the chrome driver
        WebDriverManager.chromedriver().setup();
        //  WebDriverManager.firefoxdriver().setup();
        // WebDriverManager.iedriver().setup();
        //WebDriverManager.edgedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Browser opened");
        driver.get("http://syntaxprojects.com/dynamic-data-loading-demo.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        WebElement getNewUser = driver.findElement(By.xpath("//*[text()='Get New User']"));
        getNewUser.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement firstNameField = driver.findElement(By.cssSelector("div#First-Name"));
        WebElement lastNameField = driver.findElement(By.cssSelector("div#Last-Name"));


        if(firstNameField.isDisplayed() && lastNameField.isDisplayed()){
            System.out.println("Fields are available");
        }else{
            System.out.println("Fields are not available");
        }

        //driver.quit();
    }
}
