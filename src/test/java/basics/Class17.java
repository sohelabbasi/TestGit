package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Class17 {
    public static void main(String[] args) {
        WebDriver driver;
        //setting up the chrome driver
        WebDriverManager.chromedriver().setup();
        //  WebDriverManager.firefoxdriver().setup();
        // WebDriverManager.iedriver().setup();
        //WebDriverManager.edgedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Browser opened");
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement rightClickElement = driver.findElement(By.xpath("//*[text()='right click me']"));

        Actions actions = new Actions(driver);
        //actions.contextClick(rightClickElement).perform();

        WebElement doubleClickElement = driver.findElement(By.xpath("//*[text()='Double-Click Me To See Alert']"));
        actions.doubleClick(doubleClickElement).perform();




    }
}
