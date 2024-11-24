package demoshop;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    @Test
    public void newUserPositivTest() {

        clickOnRegistrButton();
        fillRegisterLoginForm(new User().setFirstName("FirstName").setLastName("LastName").setEmail("cheburek13223@gmail.com").setPassword("password").setPassword("password"));
        clickOnRegistrationButton();

        Assert.assertTrue(isRegistrationComplete());
    }

}
