package demoshop;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginPositiveTest() {
        click(By.cssSelector("[href='/login']"));
        type(By.name("Email"), "yourEmail");
        type(By.name("Password"), password);
        click(By.cssSelector("input.button-1.login-button"));

        Assert.assertTrue(IsElementPresent((By.className("account"))));
    }
}
