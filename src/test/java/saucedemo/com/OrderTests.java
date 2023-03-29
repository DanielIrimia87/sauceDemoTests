package saucedemo.com;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class OrderTests extends BaseTest {
    @Test(description = "Verify that adding elements to the cart works as expected")
    public void addItemsToCart() {
        WebElement shoppingCart = page.shoppingCartLink;
        List<WebElement> inventoryItems = page.inventoryItems;
        WebElement firstItem = inventoryItems.get(0);
        String firstItemTitle = page.inventoryItemName.getText();
        String firstItemDescription = page.inventoryItemDescription.getText();
        String firstItemPrice = page.inventoryItemPrice.getText();
        WebElement firstItemAddToCart = page.inventoryItemAddToCart;
        Assert.assertEquals(firstItemAddToCart.getText().toLowerCase(), "add to cart",
                "The first item in the inventory should have an 'Add to cart' button");
        Assert.assertFalse(isElementPresent(By.xpath(page.SHOPPING_CART_BADGE)),
                "The shopping cart badge should not be present before adding items to the cart");
        firstItemAddToCart.click();
        Assert.assertEquals(page.inventoryItemRemove.getText().toLowerCase(), "remove",
                "The first item in the inventory should have a 'Remove' button");
        Assert.assertTrue(isElementPresent(By.cssSelector(page.SHOPPING_CART_BADGE)),
                "The shopping cart badge is not present after adding items to the cart");
        Assert.assertEquals(page.shoppingCartBadge.getText().toLowerCase(), "1",
                "Number of items in the shopping cart is incorrect");
        shoppingCart.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"),
                "User is not redirected to the shopping cart page after clicking on the shopping cart link");
    }

    private boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}