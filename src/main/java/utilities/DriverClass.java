package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageObjects.ToolbarPageObjects;

public class DriverClass {

    public static WebDriver driver = null;


    public static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        return driver;
    }

    public static WebDriver getFireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--private");
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        driver = new FirefoxDriver(options);
        return driver;
    }

    public void closeWebDriver() {
        driver.quit();
    }



}
