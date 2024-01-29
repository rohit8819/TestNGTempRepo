package testNGConcepts.dataDrivenTestingDemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DifferentReturnTypesOfDataProvider {

    @Test(dataProvider = "getTestData")
    public void verifyLogin(Object[] obj){

        for(int i=0;i<obj.length;i++){
            System.out.println(obj[i]);
        }

//        System.out.println(obj);
    }
    @DataProvider(name = "getTestData")
    public Iterator<Object[]> dataSupplier(){

        List<Object[]> list = new ArrayList<>();
//        list.add("apple");
//        list.add("mango");
//        list.add(5);

        list.add(new Object[]{"Rohit","D"});
        list.add(new Object[]{"ABC", "E"});

     return list.iterator();

    }
}
