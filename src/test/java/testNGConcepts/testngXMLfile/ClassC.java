package testNGConcepts.testngXMLfile;

import org.testng.annotations.Test;

public class ClassC {

    @Test(priority=2)
    public void methodCOne(){
        System.out.println(" ClassC - this is methodCOne");
    }

    @Test(priority=1)
    public void methodCTwo(){
        System.out.println(" ClassC - this is methodCTwo");
    }
}
