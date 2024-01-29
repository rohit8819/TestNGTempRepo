package testNGPractice.readingData;

import org.testng.annotations.Test;

public class TestMethod {

    @Test(dataProvider = "getData", dataProviderClass = DataProviderMethod.class)
    public void verifyLogin(String Name, String City, int Exp, String Company, Boolean b ){

//        String Name, String City, int Exp, String Company, Boolean b
//        System.out.print(Name  + City +  Exp  +  Company  +  b);
        System.out.print(Name + " | ");
        System.out.print(b + " | ");
        System.out.print(Company + " | ");
        System.out.print(City + " | ");
        System.out.print(Exp + " | ");

        System.out.println();


//        String Name, Boolean b, String Company, String City, int Exp

    }



}
