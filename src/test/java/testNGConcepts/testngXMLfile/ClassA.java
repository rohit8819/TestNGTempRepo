package testNGConcepts.testngXMLfile;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


public class ClassA {

    @Test(priority=1)
    public void methodAOne(){
        System.out.println(" ClassA - this is methodAOne");
    }

    @Test(priority=2)
    public void methodATwo(){
        System.out.println(" Class A - this is methodATwo");
    }

    @Test(priority=3)
    public void methodAThree(){
        System.out.println(" Class A - this is methodAThree");
    }

}
