package demoshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


public class TestBase {

    WebDriver driver;
    String email = newEmail();
    String password = "Password";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    public boolean IsElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }


    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public String newEmail(){
        int i =(int)(System.currentTimeMillis()/1000%3600);
        String email = "cheburek" +  i + "@gmail.com";
        return  email;
}

//public String newUser(){
//    String user1 = driver.findElement(By.xpath("//div[@class='header-links']/ul/li/a[@class='account']")).getText();
//return user=user1;
//    }
}

