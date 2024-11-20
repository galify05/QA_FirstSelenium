package demoshop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    @Test
    public void newUserPositivTest() {
        click(By.cssSelector("[href='/register']"));

        type(By.name("FirstName"), "FirstName");
        type(By.name("LastName"), "LastName");
        type(By.name("Email"), email);
//        type(By.name("Email"), "cheburek123@gmail.com");
        type(By.name("Password"), password);
        type(By.name("ConfirmPassword"), password);
        click(By.name("register-button"));

        Assert.assertTrue(IsElementPresent(By.className("result")));
    }
}
