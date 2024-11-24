package demoshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


public class TestBase {

    WebDriver driver;

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

    public void clickOnEnterButton() {
        click(By.cssSelector("input.button-1.login-button"));
    }

    public void fillLoginForm(User user) {
        type(By.name("Email"), user.getEmail());
        type(By.name("Password"), user.getPassword());
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void clickOnRegistrationButton() {
        click(By.name("register-button"));
    }

    public void fillRegisterLoginForm(User user) {
        type(By.name("FirstName"), user.getFirstName());
        type(By.name("LastName"), user.getLastName());
        type(By.name("Email"), user.getEmail());
        type(By.name("Password"), user.getPassword());
        type(By.name("ConfirmPassword"), user.getPassword());
    }

    public void clickOnRegistrButton() {
        click(By.cssSelector("[href='/register']"));
    }

    public boolean isLogOutPresent() {
        return IsElementPresent((By.className("account")));
    }

    public boolean isRegistrationComplete() {
        return IsElementPresent(By.className("result"));
    }

    public String getNameOfCartsItem() {
        return driver.findElement(By.xpath("//td[@class='product']//a")).getText();
    }

    public void moveToCart() {
        click(By.xpath("//a[@class='ico-cart']//span[@class='cart-label']"));
    }

    public void addItemToCart() {
        click(By.cssSelector("#add-to-cart-button-31"));
    }

    public void findItemOnPage() {
        click(By.cssSelector("div.product-item div.picture a[href='/141-inch-laptop'] img"));
    }
}

