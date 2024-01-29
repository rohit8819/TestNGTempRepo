package testNGConcepts.testngXMLfile;

import org.testng.annotations.Test;

public class ClassB {

    @Test(priority=1)
    public void methodBOne(){
        System.out.println(" ClassB - this is methodBOne");
    }

    @Test(priority=2)
    public void methodBTwo(){
        System.out.println(" ClassB - this is methodBTwo");
    }

    @Test(priority=3)
    public void methodBThree(){
        System.out.println(" ClassB - this is methodBThree");
    }

    @Test(priority=4)
    public void methodBFour(){
        System.out.println(" ClassB - this is methodBFour");
    }
}
