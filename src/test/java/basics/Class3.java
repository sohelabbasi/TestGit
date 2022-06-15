package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class3 {
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
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        WebElement usernameField = driver.findElement(By.name("txtUsername"));
        usernameField.clear();
        usernameField.sendKeys("admin");
     //   Thread.sleep(1000);
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        passwordField.clear();
        passwordField.sendKeys("Hum@nhrm123");
     //   Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
      //  Thread.sleep(1000);
        driver.quit();
    }
}
