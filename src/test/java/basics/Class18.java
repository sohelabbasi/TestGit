package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Class18 {
    public static void main(String[] args) {
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement leaveOption = driver.findElement(By.cssSelector("a#menu_leave_viewLeaveModule"));
        leaveOption.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //open the calendar
        WebElement calendar = driver.findElement(By.cssSelector("input#calFromDate"));
        calendar.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement ddMonth = driver.findElement(By.cssSelector("select.ui-datepicker-month"));
        Select s = new Select(ddMonth);
        s.selectByIndex(5);

        WebElement ddYear = driver.findElement(By.cssSelector("select.ui-datepicker-year"));
        Select s1 = new Select(ddYear);
        s1.selectByVisibleText("2022");

        //selecting a date from date picker

        List<WebElement> dates = driver.findElements(By.xpath("//*[@class='ui-datepicker-calendar']/tbody/tr/td"));

        for (WebElement date:dates
             ) {
            String value = date.getText();
            if(value.equalsIgnoreCase("15")){
                date.click();
            }
        }
    }
}
