package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class6 {
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

        WebElement firstLink = driver.findElement(By.xpath("//*[text()='Alerts & Modals']"));

        //to check whether the link is enabled or not
        if(firstLink.isEnabled()){
            firstLink.click();
            System.out.println("Click taken");
        }else{
            System.out.println("link is not clickable");
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
