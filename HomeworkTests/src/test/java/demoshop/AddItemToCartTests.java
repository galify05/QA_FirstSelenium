package demoshop;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webshop.models.User;

public class AddItemToCartTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {

        if (!app.getUser().isLogOutPresent()) {
            app.getUser().clickOnLoginLink();
            app.getUser().fillLoginForm(new User().setEmail("cheburek13223@gmail.com").setPassword("password"));
            app.getUser().clickOnEnterButton();
        }
    }

    @Test
    public void addItemtoCartTest() {
        app.getCart().findItemOnPage();
        app.getCart().addItemToCart();
        app.getCart().moveToCart();
        Assert.assertEquals(app.getCart().getNameOfCartsItem(), "14.1-inch Laptop");
    }
}