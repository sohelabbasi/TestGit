package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class1 {

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
      driver.get("https://www.amazon.com/");


        driver.navigate().to("https://www.google.com/");
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        driver.navigate().forward();




        driver.manage().deleteAllCookies();


        driver.manage().window().maximize();

      //  driver.manage().window().fullscreen();

        //to close the browser

        //driver.close();
      //  driver.quit();
    }


}
