package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.PageInitializer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static utils.ConfigReader.*;

public class CommonMethods extends PageInitializer {

    public static WebDriver driver;

    public static void openBrowserAndLaunchApplication() {
        readProperties(Constants.FILEPATH);
        switch(ConfigReader.getPropertyValue("browser")) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(true);
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                System.out.println("Browser opened");
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser name is inavlid");
        }

        driver.navigate().to(ConfigReader.getPropertyValue("url"));
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(Constants.WAIT_TIME, TimeUnit.SECONDS);
        initializeObjects();
    }

    public static void sendText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }


    public static WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver, Constants.WAIT_TIME);
        return wait;
    }

    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }

    public static byte[] takeScreenshot(String fileName){
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH + fileName
            + " " + getTimeStamp("yyyy-MM-dd-HH-mm-ss")+ ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }

    public static String getTimeStamp(String pattern){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static void tearDown(){
        driver.quit();
    }





}
