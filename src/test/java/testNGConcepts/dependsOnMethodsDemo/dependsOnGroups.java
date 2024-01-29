package testNGConcepts.dependsOnMethodsDemo;

import org.testng.annotations.Test;

public class dependsOnGroups {

    @Test(groups = {"smoke"})
    public void RegisterOne(){
        System.out.println(" RegisterOne");
    }

    @Test(groups = "sanity")
    public void RegisterTwo(){
        int i = 10/0;
        System.out.println(" RegisterTwo");
    }


    @Test(groups ="regression")
    public void RegisterThree(){
        int i = 10/0;
        System.out.println(" RegisterThree");
    }

    @Test(dependsOnGroups = {"smoke"})
    public void RegisterFour(){
        System.out.println(" RegisterFour");
    }
}
