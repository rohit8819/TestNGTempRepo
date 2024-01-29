package testNGConcepts.parallelTesting;

import org.testng.annotations.Test;

public class ClassC {

    @Test(priority=2)
    public void methodCOne(){
        System.out.println(" ClassC - this is methodCOne - " + Thread.currentThread().getId());
    }

    @Test(priority=1)
    public void methodCTwo(){
        System.out.println(" ClassC - this is methodCTwo - " + Thread.currentThread().getId());
    }
}
