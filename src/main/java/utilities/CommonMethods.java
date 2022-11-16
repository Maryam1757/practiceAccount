package utilities;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utilities.DriverClass.driver;

public class CommonMethods {

    public static void sendKeys(WebElement element, String textToSend) throws InterruptedException {
        element.click();
        element.clear();
        element.sendKeys(textToSend);
        element.sendKeys(Keys.ENTER);
        Thread.sleep(3000);


    }
    public static void clickElement(WebElement element){
        element.click();
    }

    }
