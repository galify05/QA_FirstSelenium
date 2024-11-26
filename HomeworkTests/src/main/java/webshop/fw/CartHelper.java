package webshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartHelper extends BaseHelper{

    public CartHelper(WebDriver driver) {
        super(driver);
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
