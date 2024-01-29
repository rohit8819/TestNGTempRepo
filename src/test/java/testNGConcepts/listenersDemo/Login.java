package testNGConcepts.listenersDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListeners.class)
public class Login {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void verifyUserLoginWithValidCredentials(){
        System.out.println("Test 1");
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("rohit37@gmail.com");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("1234678");
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

}
