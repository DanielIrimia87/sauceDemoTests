package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;
public class OrderTests extends BaseTest {
    @Test(description = "Verify that adding elements to the cart works as expected", groups = {"with-login"})
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
        Assert.assertFalse(isElementPresent(By.cssSelector(page.SHOPPING_CART_BADGE)),
                "The shopping cart badge should not be present before adding items to the cart");
        firstItemAddToCart.click();
        page.shoppingCartLink.click();
        Assert.assertEquals(page.inventoryItemRemove.getText().toLowerCase(), "remove",
                "The first item in the inventory should have a 'Remove' button");
        assertTrue(isElementPresent(By.cssSelector(page.SHOPPING_CART_BADGE)),
                "The shopping cart badge is not present after adding items to the cart");
        Assert.assertEquals(page.shoppingCartBadge.getText().toLowerCase(), "1",
                "Number of items in the shopping cart is incorrect");
        shoppingCart.click();
        assertTrue(driver.getCurrentUrl().contains("cart.html"),
                "User is not redirected to the shopping cart page after clicking on the shopping cart link");
        List<WebElement> cartItems = page.cartItems;
        String cartItemName = page.inventoryItemName.getText();
        Assert.assertEquals(cartItemName, firstItemTitle,
                "Wrong item added to the shopping cart");
        String cartItemPrice = page.inventoryItemPrice.getText();
        Assert.assertEquals(cartItemPrice, firstItemPrice,
                "Wrong item added to the shopping cart");

        assertTrue(isElementPresent(page.inventoryItemRemove),
                "Remove button on card item is not present ");
        assertTrue(isElementPresent(By.id("continue-shopping")),
                "Continue shopping is not present ");
        assertTrue(isElementPresent(By.id("checkout")),
                "Checkout is not present ");

        System.out.println("The first item in the inventory was added to the shopping cart successfully");
    }


}