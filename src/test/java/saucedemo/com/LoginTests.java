package saucedemo.com;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @DataProvider(name = "loginDataProvider")
    public Object [][] loginDataProvider() {
        return new Object[][] {
                {"standard_user","secret_sauce", true, false},
                {"locked_out_user","secret_sauce", true, false},

        };
    }


    @Test(description = "Verifies login scenario with different sets of credentials")
    public void testLoginScenarios() {

    }
}
