package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

public class Utils {

    public static RemoteWebDriver getRemoteWebDriver(){
        try {
            return new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
//        options.setHeadless(true);   browser invizibil
        System.setProperty("webdriver.chrome.driver" , "drivers/chromedriver");
        WebDriver driver = new ChromeDriver(options);  // initilizare
//        driver.manage().window().maximize();
        // setam un wait global (implicit)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver;
    }

    public static void takeScreenshot(WebDriver driver) throws IOException {
        String destinationFile = null;
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        destinationFile = System.getProperty("user.dir")
                + "/Logs/printScreen-" + LocalDateTime.now() + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
    }

    public static void switchToWindow(WebDriver driver, String windowTitle) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals(windowTitle)) {
                break;
            }
        }
    }

//    handle windows with Iterator
//    public static void switchToWindow(WebDriver driver) {
//        Set<String> windowHandles = driver.getWindowHandles();
//        Iterator<String> iterator = windowHandles.iterator();
//        String windowHandle = iterator.next();
//        driver.switchTo().window(windowHandle);
//    }
}



