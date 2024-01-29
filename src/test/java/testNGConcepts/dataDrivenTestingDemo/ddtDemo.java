package testNGConcepts.dataDrivenTestingDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ddtDemo {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test (dataProvider = "getTestdata")
    public void verifyUserLoginWithValidCredentials(String Email, String Password){
        System.out.println("Test 1");
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Email);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(Password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Assert.assertEquals(driver.findElement(By.linkText("Edit your account information")).getText(),"Edit your account information");
    }

    @DataProvider(name = "getTestdata")
    public Object[][] dataSupplier(){

        Object[][] data = {{"rohit37@gmail.com","1234"},{"amotooricap3@gmail.com","12345"},
                {"amotooricap1@gmail.com","12345"}};

        return data;
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }


}
