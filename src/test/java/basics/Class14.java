package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Class14 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        //setting up the chrome driver
        WebDriverManager.chromedriver().setup();
        //  WebDriverManager.firefoxdriver().setup();
        // WebDriverManager.iedriver().setup();
        //WebDriverManager.edgedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Browser opened");
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
Thread.sleep(2000);
        //identifying the new tab locator
        WebElement newTab = driver.findElement(By.cssSelector("button#tabButton"));
        newTab.click();
        Thread.sleep(2000);

        //print the handle of the main page
        //this method returns the handle of current window
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println(parentWindowHandle);

        //to switch to the new tab, we have to fetch the id's of the windows
        //get all windows

        Set<String> allHandles = driver.getWindowHandles();

        Iterator<String> it = allHandles.iterator();

        while (it.hasNext()) {
            String handler = it.next();
            driver.switchTo().window(handler);
            //now putting the condition whether we are in the correct window or not
            if (driver.getCurrentUrl().equalsIgnoreCase("https://demoqa.com/sample")) {
                System.out.println(driver.getCurrentUrl());
                break;
            }

        }


        WebElement childHeading = driver.findElement(By.cssSelector("h1#sampleHeading"));
        System.out.println(childHeading.getText());
        Thread.sleep(2000);

        driver.switchTo().window(parentWindowHandle);

        WebElement newWindowButton = driver.findElement(By.cssSelector("button#windowButton"));
        newWindowButton.click();

    }
}
