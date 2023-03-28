package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemo {
    public static final String APP_URL = "https://www.saucedemo.com";

    // Login page elements declaration and initialization
    public static final String INPUT_USERNAME = "user-name";
    public static final String INPUT_PASSWORD = "password";
    public static final String LOGIN_BUTTON = "login-button";
    public static final String ERROR_MESSAGE = "h3[data-test='error']";
    public static final String ERROR_BUTTON = "//button[@class='error-button']";
    @FindBy(id = INPUT_USERNAME)
    public WebElement inputUsername;
    @FindBy(id = INPUT_PASSWORD)
    public WebElement inputPassword;
    @FindBy(id = LOGIN_BUTTON)
    public WebElement loginButton;
    @FindBy(css = ERROR_MESSAGE)
    public WebElement errorMessage;
    @FindBy(xpath = ERROR_BUTTON)
    public WebElement errorButton;
    // end of Login page elements declaration and initialization

    public SauceDemo(WebDriver driver) {
         PageFactory.initElements(driver, this);
    }
}
