package demoshop;


import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {
        clickOnLoginLink();
        fillLoginForm(new User().setEmail("cheburek13223@gmail.com").setPassword("password"));
        clickOnEnterButton();

        Assert.assertTrue(isLogOutPresent());
    }

}
