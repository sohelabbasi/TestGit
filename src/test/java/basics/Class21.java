package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Class21 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        //setting up the chrome driver
        WebDriverManager.chromedriver().setup();
        //  WebDriverManager.firefoxdriver().setup();
        // WebDriverManager.iedriver().setup();
        //WebDriverManager.edgedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Browser opened");
        //   driver.get("https://www.amazon.com/");
        driver.navigate().to("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1000);
        WebElement usernameField = driver.findElement(By.name("txtUsername"));
        js.executeScript("arguments[0].style.border='2px solid orange'", usernameField);
        usernameField.clear();
        usernameField.sendKeys("admin");
        //   Thread.sleep(1000);
        Thread.sleep(2000);
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        js.executeScript("arguments[0].style.background='yellow'", passwordField);
        passwordField.clear();
        passwordField.sendKeys("Hum@nhrm123");
        //   Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        js.executeScript("arguments[0].style.border='2px solid orange'", loginButton);
        Thread.sleep(2000);
        loginButton.click();
    }
}
