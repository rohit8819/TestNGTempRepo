package testNGConcepts.listenersDemo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class GetScreenshot {

     WebDriver driver;

    @Test
    public void getScreenshotMethod(String testName) throws IOException {

        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destFilePath = System.getProperty("user.dir")+"\\Screenshots"+testName;
        System.out.println("new changes by user 1");
        System.out.println("new changes 2 by user 1");
        System.out.println(("changes by user 2"));
        FileUtils.copyFile(srcFile,new File(destFilePath));

    }





}
