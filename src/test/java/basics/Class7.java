package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Class7 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        //setting up the chrome driver
        WebDriverManager.chromedriver().setup();
        //  WebDriverManager.firefoxdriver().setup();
        // WebDriverManager.iedriver().setup();
        //WebDriverManager.edgedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Browser opened");
        driver.get("https://syntaxprojects.com/basic-checkbox-demo.php");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        WebElement checkbox = driver.findElement(By.cssSelector("input#isAgeSelected"));
        if(!checkbox.isSelected()){
            checkbox.click();
        }else{
            System.out.println("Checkbox is already selected");
        }
        Thread.sleep(2000);

        //dealing with multiple checkboxes
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input.cb1-element"));

        for (WebElement singleCheckbox: checkboxes
             ) {
            //select the checkbox having the value 3

            String valueOfAttribute = singleCheckbox.getAttribute("value");
            System.out.println(valueOfAttribute);
            if(valueOfAttribute.contains("Option-3")){
                singleCheckbox.click();
                System.out.println("Click taken");
            }else{
                System.out.println("Click cannot perform");
            }
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
