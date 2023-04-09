package saucedemo.com;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {
    @DataProvider(name = "loginUsers")
    public Object[][] loginUsers() {
        return new Object[][]{
                {"standard_user", "secret_sauce", true, false},
                {"locked_out_user", "secret_sauce", false, false},
                {"problem_user", "secret_sauce", true, false},
                {"performance_glitch_user", "secret_sauce", true, true},
        };
    }

    @Test(description = "Verifies login scenario with different sets of credentials",
            dataProvider = "loginUsers", groups = {"without-login"})
    public void testLoginScenarios(String username, String password,
                                   boolean isLoginSuccessful, boolean isPerformanceGlitchUser) throws InterruptedException {
        loginSteps(username, password);
        if (isLoginSuccessful) {
            assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                    "User is not redirected to the right page after login");
            List<WebElement> inventoryItems = page.inventoryItems;
            assertFalse(inventoryItems.isEmpty(),
                    "No items are displayed after successful login");
            for (WebElement item : inventoryItems) {
                assertTrue(item.isDisplayed(),
                        "Inventory item is not displayed after successful login");
            }
        } else {
            assertFalse(driver.getCurrentUrl().contains("inventory.html"),
                    "User is redirected to the items page with a user that should not able to see that page");
            if (isPerformanceGlitchUser) {
                Thread.sleep(5000);
            }
            assertTrue(page.errorMessage.isDisplayed(),
                    "Error message is not displayed after login with invalid credentials");
        }


    }
}
