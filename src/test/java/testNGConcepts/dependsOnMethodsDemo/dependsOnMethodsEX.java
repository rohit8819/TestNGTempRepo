package testNGConcepts.dependsOnMethodsDemo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class dependsOnMethodsEX {

     @Test(priority=6)
    public void RegisterOne(){
         System.out.println(" RegisterOne");
    }

    @Test(priority=5, dependsOnMethods = "RegisterOne")
    public void RegisterTwo(){
         int i = 10/0;
        System.out.println(" RegisterTwo");
    }


    @Test(priority=4, dependsOnMethods = "RegisterTwo", alwaysRun = true)
    public void RegisterThree(){
         int i = 10/0;
        System.out.println(" RegisterThree");
    }

    @Test(priority=3, dependsOnMethods = "RegisterThree", alwaysRun = true)
    public void RegisterFour(){
         System.out.println(" RegisterFour");
    }
}
