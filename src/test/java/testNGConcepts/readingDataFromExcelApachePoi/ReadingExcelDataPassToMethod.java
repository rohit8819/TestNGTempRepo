package testNGConcepts.readingDataFromExcelApachePoi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReadingExcelDataPassToMethod {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test(dataProvider = "getTestdata", dataProviderClass = DataProviderForExcel.class)
    public void loginTest(String Email, int Password){

        System.out.println(Email);
        System.out.println((Password));

        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Email);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(String.valueOf(Password));
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Assert.assertEquals(driver.findElement(By.linkText("Edit your account information")).getText(),"Edit your account information");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
