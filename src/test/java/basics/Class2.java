package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class2 {
        public static void main(String[] args) throws InterruptedException {
                WebDriver driver;
                //setting up the chrome driver
                WebDriverManager.chromedriver().setup();
                //  WebDriverManager.firefoxdriver().setup();
                // WebDriverManager.iedriver().setup();
                //WebDriverManager.edgedriver().setup();
                driver = new ChromeDriver();
                System.out.println("Browser opened");
                Thread.sleep(2000);
             //   driver.get("https://www.amazon.com/");
                driver.navigate().to("https://www.google.com/");
                System.out.println(driver.getCurrentUrl());
                System.out.println(driver.getTitle());
                driver.quit();
        }
        }
