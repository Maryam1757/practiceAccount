

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ToolbarPageObjects;
import utilities.DriverClass;

import static org.testng.TestRunner.PriorityWeight.priority;

public class ToolBarPageTest extends DriverClass {

    ToolbarPageObjects objOfToolbarPageObjects = null;

    @BeforeMethod
    public void initializationOfObject(){
        objOfToolbarPageObjects = PageFactory.initElements(driver,ToolbarPageObjects.class);
    }

    @Test(priority = 0)
    public void test() {
        driver = getChromeDriver();
        driver.get("https://www.amazon.com/");
    }

    @Test (priority = 1)
    public void getPropertiesTest() throws InterruptedException {
        objOfToolbarPageObjects.getSearchBox();
    }

    @Test (priority = 2)
    public void getBarbieToys(){
        objOfToolbarPageObjects.getBarbieToys();
    }


    @Test(priority = 4)
    public void results() throws InterruptedException {
        Thread.sleep(3000);
        WebElement results = driver.findElement(By.xpath("//span[@class='rush-component']"));
        Assert.assertTrue(results.isDisplayed(), "Your Orders is displayed");
    }

}
