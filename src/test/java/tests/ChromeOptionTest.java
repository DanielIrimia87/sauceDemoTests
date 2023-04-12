package tests;

import Utilities.Utils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ChromeOptionTest extends Utils {

    @Test
    public void mobileTest() {
        ChromeDriver driver = getChromeDriverWithOptions();
        driver.get("https://demoqa.com");
        driver.quit();
    }
}
