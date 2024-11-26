package demoshop;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webshop.models.User;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getUser().isLogOutPresent()) {
            app.getUser().clickOnLogOutButton();
        }
    }

    @Test
    public void loginPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setEmail("cheburek13223@gmail.com").setPassword("password"));
        app.getUser().clickOnEnterButton();

        Assert.assertTrue(app.getUser().isLogOutPresent());
    }
/*
*  @Test
* public void loginNegativeTest(){}
* */
}