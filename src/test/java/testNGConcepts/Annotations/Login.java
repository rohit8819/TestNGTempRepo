package testNGConcepts.Annotations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Login {

    WebDriver driver;

    @BeforeSuite
    public void beforeS(){
        System.out.println(" Before Suite");
    }

    @BeforeTest
    public void beforeT(){
        System.out.println("Before Test");
    }

    @BeforeClass
    public void beforeC(){
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Parameters({"url","email","password"})
    @Test(priority = 1)
    public void verifyUserLoginWithValidCredentials(@Optional("https://tutorialsninja.com/demo/index.php?route=account/login") String URL,
                                                    String Email, String Password){
        System.out.println("Test 1");
        driver.get(URL);
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Email);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(Password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Assert.assertEquals(driver.findElement(By.linkText("Edit your account information")).getText(),"Edit your account information");
    }

    @Test(priority = 2)
    public void verifyUserLoginWithValidEmailInvalidPassword(){
        System.out.println("Test 2");
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("rohit37@gmail.com");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("1234567");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText(),"Warning: No match for E-Mail Address and/or Password.");
    }


    @Test(priority = 3 , enabled = true)
    public void verifyUserLoginWithInvalidValidEmailValidPassword(){
        System.out.println("Test 3");
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText(),"Warning: No match for E-Mail Address and/or Password.");
    }

    @Ignore
    @Test(priority = 4 , enabled = false)
    public void verifyUserLoginWithInvalidValidEmailInValidPassword(){
        System.out.println("Test 4");
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("abc@123");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("1234788");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText(),"Warning: No match for E-Mail Address and/or Password.");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After Method");
        driver.quit();
    }

    @AfterClass
    public void afterC(){
        System.out.println("After Class");
    }

    @AfterTest
    public void afterT(){
        System.out.println("After Test");
    }

    @AfterSuite
    public void afterS(){
        System.out.println("After Suite");
    }


}
