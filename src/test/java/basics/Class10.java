package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class10 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        //setting up the chrome driver
        WebDriverManager.chromedriver().setup();
        //  WebDriverManager.firefoxdriver().setup();
        // WebDriverManager.iedriver().setup();
        //WebDriverManager.edgedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Browser opened");
        driver.get("http://www.uitestpractice.com/students/Switchto");
        Thread.sleep(3000);
        driver.manage().window().maximize();

        //identify the option to enable the alert
        WebElement alertOption = driver.findElement(By.cssSelector("button#alert"));
        alertOption.click();
        Thread.sleep(2000);

        //here we have to switch the focus of selenium to alert page
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        System.out.println(alertMessage);
        alert.accept();
        System.out.println("Alert accepted");
        Thread.sleep(2000);
        driver.quit();
    }
}
