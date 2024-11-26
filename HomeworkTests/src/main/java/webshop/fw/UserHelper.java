package webshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webshop.models.User;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
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
        return isElementPresent((By.cssSelector("[href='/logout']")));
    }

    public void clickOnLogOutButton() {
        click(By.cssSelector("[href='/logout']"));
    }

    public boolean isRegistrationComplete() {
        return isElementPresent(By.className("result"));
    }
}
