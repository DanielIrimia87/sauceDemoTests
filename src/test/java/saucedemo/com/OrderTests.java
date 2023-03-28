package saucedemo.com;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class OrderTests extends BaseTest {
    @Test(description = "Verify that adding elements to the cart works as expected")
    public void addItemsToCart() {
        List<WebElement> invetoryItems = page.inventoryItems;
        WebElement firstItem = invetoryItems.get(0);
        String firstItemTitle = page.inventoryItemName.getText();
        String firstItemDescription = page.inventoryItemDescription.getText();
        String firstItemPrice = page.inventoryItemPrice.getText();
        WebElement firstItemAddToCart = page.inventoryItemAddToCart;
        Assert.assertEquals(firstItemAddToCart.getText().toLowerCase(), "add to cart",
                "The first item in the inventory should have an 'Add to cart' button");
        firstItemAddToCart.click();
        Assert.assertEquals(page.inventoryItemRemove.getText().toLowerCase(), "remove",
                "The first item in the inventory should have a 'Remove' button");

    }
}
