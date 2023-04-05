package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    // Inventory page elements declaration and initialization
    public static final String INVENTORY_ITEMS = "div[class='inventory_item']";
    public static final String INVENTORY_ITEM_NAME = "div[class='inventory_item_name']";
    public static final String INVENTORY_ITEM_DESCRIPTION = "div[class='inventory_item_desc']";
    public static final String INVENTORY_ITEM_PRICE = "div[class='inventory_item_price']";
    public static final String INVENTORY_ITEM_ADD_TO_CART = "button[class='btn btn_primary btn_small btn_inventory']";
    public static final String INVENTORY_ITEM_REMOVE = "button[class='btn btn_secondary btn_small btn_inventory']";

    @FindBy(css = INVENTORY_ITEMS)
    public List<WebElement> inventoryItems;
    @FindBy(css = INVENTORY_ITEM_NAME)
    public WebElement inventoryItemName;
    @FindBy(css = INVENTORY_ITEM_DESCRIPTION)
    public WebElement inventoryItemDescription;
    @FindBy(css = INVENTORY_ITEM_PRICE)
    public WebElement inventoryItemPrice;
    @FindBy(css = INVENTORY_ITEM_ADD_TO_CART)
    public WebElement inventoryItemAddToCart;
    @FindBy(css = INVENTORY_ITEM_REMOVE)
    public WebElement inventoryItemRemove;
    // end of Inventory page elements declaration and initialization

    // Shopping cart container elements declaration and initialization
    public static final String SHOPPING_CART_LINK = "//a[@class='shopping_cart_link']";
    public static final String SHOPPING_CART_BADGE = ".shopping_cart_badge";
    public static final String CART_ITEM = ".cart_item";
    public static final String CONTINUE_SHOPPING_BUTTON = "continue-shopping";
    public static final String CHECKOUT_BUTTON = "checkout";

    @FindBy(xpath = SHOPPING_CART_LINK)
    public WebElement shoppingCartLink;
    @FindBy(css = SHOPPING_CART_BADGE)
    public WebElement shoppingCartBadge;
    @FindBy(css = CART_ITEM)
    public List<WebElement> cartItems;
    @FindBy(id = CONTINUE_SHOPPING_BUTTON)
    public WebElement continueShoppingButton;
    @FindBy(id = CHECKOUT_BUTTON)
    public WebElement checkoutButton;

    // end of Shopping cart container elements declaration and initialization

    public SauceDemo(WebDriver driver) {
         PageFactory.initElements(driver, this);
    }
}
