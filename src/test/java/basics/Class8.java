package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class8 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        //setting up the chrome driver
        WebDriverManager.chromedriver().setup();
        //  WebDriverManager.firefoxdriver().setup();
        // WebDriverManager.iedriver().setup();
        //WebDriverManager.edgedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Browser opened");
        driver.get("https://syntaxprojects.com/basic-radiobutton-demo.php");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        WebElement radioButton = driver.findElement(By.xpath("(//*[@value='Male'])[1]"));
        Thread.sleep(2000);
        //checking the response of boolean condition
        boolean response = radioButton.isEnabled();
        System.out.println(response);

        if(!radioButton.isSelected()){
            radioButton.click();
        }else{
            System.out.println("It is already selected");
        }
        Thread.sleep(2000);
        driver.quit();


    }
}
