import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class DataDrivenTest {
    static WebDriver driver = null;

    @BeforeClass
    public static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        return driver;
    }

    @Test(dataProvider = "LoginData")
    public void loginTest(String user, String pwd, String exp) {

        driver.get("https://admin-demo.nopcommerce.com/login");

        WebElement txtEmail = driver.findElement(By.id("Email"));
        txtEmail.clear();
        txtEmail.sendKeys(user);

        WebElement txtPassword = driver.findElement(By.id("Password"));
        txtPassword.clear();
        txtPassword.sendKeys(pwd);

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String expTitle = "Dashboard / nopCommerce administration";
        String actTitle = driver.getTitle();

        if (expTitle.equals(actTitle)) {
            driver.findElement(By.linkText("Logout")).click();
            Assert.assertTrue(true);

        } else if (exp.equals("Invalid")) {
            if (expTitle.equals(actTitle)) {
                driver.findElement(By.linkText("Logout")).click();
                Assert.assertTrue(false);

            } else {
                Assert.assertTrue(true);
            }
        }
    }

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {
       /*String loginData[][] = {
                {"admin@yourstore.com", "admin", "Valid"},
                {"admin@yourstore.com", "adm", "Invalid"},
                {"adm@yourstore.com", "admin", "Invalid"},
                {"adm@yourstore.com", "adm", "Invalid"}};*/

      String path = "src/main/Test/SDET PRACTICE.xlsx";
        XLUtility xlUtility = new XLUtility(path);
        int totalrows = xlUtility.getRowCount("Sheet1");
        int totalcolumns= xlUtility.getCellCount("Sheet1",1);

        String loginData[][] = new String[totalrows][totalcolumns];

        for(int i =0;i<totalrows;i++)//1
        {
            for (int j =0; j<totalcolumns;j++)//0
            {
                loginData[i][j]=xlUtility.getCellData("Sheet1",i,j);
            }
        }

        return loginData;
    }



    @AfterClass
    void tearDown() {
        driver.close();
    }

}





