package testNGConcepts.parallelTesting;

import org.testng.annotations.Test;


public class ClassA {

    @Test(priority=1, invocationCount = 3)
    public void methodAOne() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println(" Class A - this is methodAOne - " + Thread.currentThread().getId());
    }

    @Test(priority=2)
    public void methodATwo(){
        System.out.println(" Class A - this is methodATwo - " + Thread.currentThread().getId());
    }

    @Test(priority=3)
    public void methodAThree(){
        System.out.println(" Class A - this is methodAThree - " + Thread.currentThread().getId());
    }

}
