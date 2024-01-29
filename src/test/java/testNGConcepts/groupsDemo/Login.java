package testNGConcepts.groupsDemo;

import org.testng.annotations.Test;

public class Login {

    @Test(priority=1, groups = {"smoke","login","regression"})
    public void loginOne(){
        System.out.println("loginOne");
    }

    @Test(priority=2, groups = {"login", "regression"})
    public void loginTwo(){
        System.out.println("loginTwo");
    }

    @Test(priority=3, groups = {"login","regression"})
    public void loginThree(){
        System.out.println("loginThree");
    }
}
