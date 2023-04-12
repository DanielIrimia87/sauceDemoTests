package tests;

import Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class ChromeOptionTest extends Utils {

    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void mobileTest() {
        driver = getChromeDriverWithOptions();
        driver.get("https://demoqa.com");
    }

    @Test
    public void implicitWaitTest() {
        driver = getChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.emag.ro");

        WebElement closeButton = driver.findElement(By.cssSelector("button.close"));
        closeButton.click();

        WebElement acceptButton = driver.findElement(By.cssSelector("button.js-accept"));
        acceptButton.click();

        WebElement loginButton = driver.findElement(By.cssSelector("a.login-btn"));
        loginButton.click();
    }


    @Test
    public void explicitWaitTest() {
        driver = getChromeDriver();
        driver.get("https://www.emag.ro");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement closeButton = driver.findElement(By.cssSelector("button.close"));
        wait.until(ExpectedConditions.visibilityOf(closeButton));
        closeButton.click();

        WebElement acceptButton = driver.findElement(By.cssSelector("button.js-accept"));
        wait.until(ExpectedConditions.elementToBeClickable(acceptButton));
        acceptButton.click();

        WebElement loginButton = driver.findElement(By.cssSelector("a.login-btn"));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        assertTrue(driver.getCurrentUrl().contains("user/login"), "User is not redirected to the login page");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
