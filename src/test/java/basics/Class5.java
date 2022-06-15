package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Class5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        //setting up the chrome driver
        WebDriverManager.chromedriver().setup();
        //  WebDriverManager.firefoxdriver().setup();
        // WebDriverManager.iedriver().setup();
        //WebDriverManager.edgedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Browser opened");
        driver.get("https://www.ebay.com/");
        Thread.sleep(2000);

        //to store multiple elements in the form of list
        List<WebElement> links = driver.findElements(By.xpath("//ul[@class='hl-cat-nav__container']/li"));

        System.out.println("The size of the link is: " + links.size());
        for (WebElement link:links
             ) {
            String text = link.getText();
            System.out.println(text);
        }

    }
}
