package demoshop;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        clickOnLoginLink();
        fillLoginForm(new User().setEmail("cheburek13223@gmail.com").setPassword("password"));
        clickOnEnterButton();
    }

    @Test
    public void addItemtoCartTest() {
        findItemOnPage();
        addItemToCart();
        moveToCart();
        Assert.assertEquals(getNameOfCartsItem(), "14.1-inch Laptop");
    }
}
