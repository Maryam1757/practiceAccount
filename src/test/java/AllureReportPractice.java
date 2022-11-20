import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AllureReportPractice {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

    }

    @Test(priority =1)
    public void logoPresence(){
        boolean disstatus = driver.findElement(By.xpath("//div[@class='header-logo']//a//img")).isDisplayed();
        Assert.assertEquals(disstatus,true);

    }

    @Test(priority =2)
    public void loginTest(){
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys("pavanoltraining@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Test@123");
        driver.findElement(By.linkText("Log in")).click();
        Assert.assertEquals(driver.getTitle(),"nopCommerce demo store123");

    }

    @Test(priority =3)
    public void registrationTest(){
        throw new SkipException("Skipping this test");
    }
    @AfterClass()
    public void tearDown(){
        driver.quit();
    }








}
