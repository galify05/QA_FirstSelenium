package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import phonebook.data.UserData;
import phonebook.models.User;

public class CreateAccountTests extends TestBase {

    SoftAssert softAsert = new SoftAssert();

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setEmail(UserData.email).setPassword(UserData.password));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setEmail(UserData.email).setPassword(UserData.password));
        app.getUser().clickOnRegistrationButton();
        softAsert.assertTrue(app.getUser().isAlertDisplayed());
        softAsert.assertTrue(app.getUser().isErrorMessagePresent());
        softAsert.assertAll();
    }


}
