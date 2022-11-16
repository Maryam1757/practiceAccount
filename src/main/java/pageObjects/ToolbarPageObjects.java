package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.CommonMethods;

import static utilities.DriverClass.driver;

public class ToolbarPageObjects extends CommonMethods {


    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(linkText = "Barbie")
    private WebElement barbieToys;




    public void getSearchBox() throws InterruptedException {
        searchBox.click();
        Thread.sleep(3000);
        sendKeys(searchBox, "girl toys");
        ;
    }

    public void getBarbieToys() {
        barbieToys.click();
    }



}
