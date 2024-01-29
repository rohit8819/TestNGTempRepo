package testNGConcepts.groupsDemo;

import org.testng.annotations.Test;

public class Register {

    @Test(priority=1, groups = {"smoke","regression","register"})
    public void RegisterOne(){

        System.out.println(" RegisterOne");
    }

    @Test(priority=2, groups = {"smoke","regression"})
    public void RegisterTwo(){

        System.out.println(" RegisterTwo");
    }

    @Test(priority=3, groups = {"regression"})
    public void RegisterThree(){

        System.out.println(" RegisterThree");
    }

    @Test(priority=4, groups = {"regression"})
    public void RegisterFour(){

        System.out.println(" RegisterFour");
    }
}
