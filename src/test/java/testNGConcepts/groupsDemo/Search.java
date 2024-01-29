package testNGConcepts.groupsDemo;

import org.testng.annotations.Test;

public class Search {

    @Test(priority=1, groups = {"smoke","regression","search"})
    public void SearchOne(){

        System.out.println(" SearchOne");
    }

    @Test(priority=2, groups = {"smoke","regression","search"})
    public void SearchTwo(){

        System.out.println(" SearchTwo");
    }

    @Test(priority=3, groups = {"regression","search"})
    public void SearchThree(){
        System.out.println(" SearchThree");
    }

    @Test(priority=4, groups = {"smoke","regression","search"})
    public void SearchFour(){

        System.out.println(" SearchFour");
    }

    @Test(priority=5, groups = {"regression","search"})
    public void SearchFive(){
        System.out.println(" SearchFive");
    }

}
