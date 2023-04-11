package tests;

import Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.SauceDemo;

public abstract class BaseTest extends Utils {
    protected WebDriver driver = null;
    SauceDemo page = null;

    @BeforeMethod(onlyForGroups = {"with-login"})
    public void setupWithLogin() {
        driver = getChromeDriver();
        driver.get(SauceDemo.APP_URL);
        page = new SauceDemo(driver);
        loginSteps("standard_user", "secret_sauce");
    }
    @BeforeMethod(onlyForGroups = {"without-login"})
    public void setupWithoutLogin() {
        driver = getChromeDriver();
        driver.get(SauceDemo.APP_URL);
        page = new SauceDemo(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void loginSteps(String username, String password) {
        page.inputUsername.sendKeys(username);
        page.inputPassword.sendKeys(password);
        page.loginButton.click();
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
