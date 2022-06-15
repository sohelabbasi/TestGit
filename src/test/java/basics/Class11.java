package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class11 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        //setting up the chrome driver
        WebDriverManager.chromedriver().setup();
        //  WebDriverManager.firefoxdriver().setup();
        // WebDriverManager.iedriver().setup();
        //WebDriverManager.edgedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Browser opened");
        driver.get("https://demoqa.com/frames");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.switchTo().frame("frame1");
        Thread.sleep(2000);
        WebElement frameHeading = driver.findElement(By.xpath("//*[@id='sampleHeading']"));
        System.out.println(frameHeading.getText());
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.quit();

    }
}

