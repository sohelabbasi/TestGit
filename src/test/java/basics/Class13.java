package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Class13 {
    public static void main(String[] args) {
        WebDriver driver;
        //setting up the chrome driver
        WebDriverManager.chromedriver().setup();
        //  WebDriverManager.firefoxdriver().setup();
        // WebDriverManager.iedriver().setup();
        //WebDriverManager.edgedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Browser opened");
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();

        WebElement usernameField = driver.findElement(By.name("txtUsername"));
        WebDriverWait wait = new WebDriverWait(driver, 15);

        //put the condition after declaring webdriver wait
        wait.until(ExpectedConditions.elementToBeClickable(usernameField));
        usernameField.sendKeys("adminq2234553");
        usernameField.clear();
        usernameField.sendKeys("admin");

        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys("fhfbbhrrryyr");
        passwordField.clear();
        passwordField.sendKeys("Hum@nhrm123");

        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();



    }
}
