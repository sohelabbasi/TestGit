package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Class9 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        //setting up the chrome driver
        WebDriverManager.chromedriver().setup();
        //  WebDriverManager.firefoxdriver().setup();
        // WebDriverManager.iedriver().setup();
        //WebDriverManager.edgedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Browser opened");
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        Thread.sleep(3000);
        driver.manage().window().maximize();

        WebElement dropdown = driver.findElement(By.xpath("//*[@name='country']"));
        Select s = new Select(dropdown);
       // s.selectByIndex(5);
      //  s.selectByValue("INDIA");
        s.selectByVisibleText("CHINA");

        Thread.sleep(5000);
        driver.quit();

    }
}
