package saucedemo.com;

import Utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.SauceDemo;

public abstract class BaseTest extends Utils {
    protected WebDriver driver = null;
    SauceDemo page = null;

    @BeforeMethod
    public void setup() {
        driver = getChromeDriver();
        driver.get(SauceDemo.APP_URL);
        page = new SauceDemo(driver);
        page.inputUsername.sendKeys("standard_user");
        page.inputPassword.sendKeys("secret_sauce");
    }

    @AfterMethod(alwaysRun = true)
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
