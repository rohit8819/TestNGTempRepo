package testNGConcepts.listenersDemo;

import org.testng.*;
import org.testng.internal.annotations.IListeners;

import java.io.IOException;

public class MyListeners extends GetScreenshot implements ITestListener {
//    @Override
//    public void onTestStart(ITestResult result) {
//        System.out.println(result.getName());
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        ITestListener.super.onTestSuccess(result);
//    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test is failed, this is code for test failure");
        String testName = result.getName();
        try {
            getScreenshotMethod(testName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

//    @Override
//    public void onTestSkipped(ITestResult result) {
//        ITestListener.super.onTestSkipped(result);
//    }
//
//    @Override
//    public void onTestFailedWithTimeout(ITestResult result) {
//        ITestListener.super.onTestFailedWithTimeout(result);
//    }
//
//    @Override
//    public void onStart(ITestContext context) {
//        ITestListener.super.onStart(context);
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        ITestListener.super.onFinish(context);
//    }
}
