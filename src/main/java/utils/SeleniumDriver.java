package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SeleniumDriver {
    private static SeleniumDriver seleniumDriver;

    //initialize webdriver
    private static WebDriver driver;

    //initialize timeouts
    private static WebDriverWait waitDriver;
    public final static int TIMEOUT = 60;
    public final static int PAGE_LOAD_TIMEOUT = 20;

    private SeleniumDriver() {

        System.setProperty("webdriver.chrome.driver", ResourcePaths.chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        waitDriver = new WebDriverWait(driver, TIMEOUT);
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        String window = driver.getWindowHandle();
    }

    private SeleniumDriver(String browser) {

        if (browser.toLowerCase().trim().equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", ResourcePaths.chromeDriverPath);
            driver = new ChromeDriver();
        } else if (browser.toLowerCase().trim().equals("headless")) {
            System.setProperty("webdriver.chrome.driver", ResourcePaths.chromeDriverPath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            driver = new ChromeDriver(options);
        } else {
            System.setProperty("webdriver.chrome.driver", ResourcePaths.chromeDriverPath);
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        waitDriver = new WebDriverWait(driver, TIMEOUT);
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        String window = driver.getWindowHandle();
    }

    public static void openPage(String url) {
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {
        if (seleniumDriver == null)
            seleniumDriver = new SeleniumDriver();
    }

    public static void setUpDriver(String browser) {
        if (seleniumDriver == null)
            seleniumDriver = new SeleniumDriver(browser);
    }

    public static void tearDown() {
        if (driver != null) {
            driver.close();
            try {
                driver.quit();
            } catch (Exception e) {
            }
            seleniumDriver = null;
        }
    }


//    public static void waitForPageToLoad() {
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}


