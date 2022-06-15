package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class4 {
        public static void main(String[] args) throws InterruptedException {
                WebDriver driver;
                //setting up the chrome driver
                WebDriverManager.chromedriver().setup();
                //  WebDriverManager.firefoxdriver().setup();
                // WebDriverManager.iedriver().setup();
                //WebDriverManager.edgedriver().setup();
                driver = new ChromeDriver();
                System.out.println("Browser opened");
                 driver.get("https://www.saucedemo.com/");
             //   driver.navigate().to("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
                System.out.println(driver.getCurrentUrl());
                System.out.println(driver.getTitle());
Thread.sleep(2000);
                WebElement usernameField = driver.findElement(By.xpath("//*[@placeholder='Username']"));
                WebElement passwordField = driver.findElement(By.cssSelector("input#password"));
                WebElement loginButton = driver.findElement(By.cssSelector("input#login-button"));

                usernameField.clear();
                usernameField.sendKeys("standard_user");


                passwordField.clear();
                passwordField.sendKeys("secret_sauce");

                loginButton.click();
                Thread.sleep(2000);
                WebElement headingProducts = driver.findElement(By.xpath("//*[text()='Products']"));

                //isDisplayed method is used to verify the existence of the web element on the page
                if (headingProducts.isDisplayed()){
                        //fetch the text of that element
                      String text =  headingProducts.getText();
                      System.out.println(text);
                      if(text.equals("PRODUCTS")){
                              System.out.println("Test case is passed");
                      }else{
                              System.out.println("Test case is failed");
                      }
                }else{
                        System.out.println("element not visible");
                }

                driver.quit();

        }
        }
