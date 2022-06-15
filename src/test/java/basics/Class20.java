package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class20 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        //setting up the chrome driver
        WebDriverManager.chromedriver().setup();
        //  WebDriverManager.firefoxdriver().setup();
        // WebDriverManager.iedriver().setup();
        //WebDriverManager.edgedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Browser opened");
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);
        //driver.navigate().to("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        //scrolling the screen
        //scroll to down
        js.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(2000);
        //scroll to up
        js.executeScript("window.scrollBy(0,-2000)");
    }
}
