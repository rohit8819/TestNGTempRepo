package testNGConcepts.priority;

import org.testng.annotations.Test;

public class PriorityDemoEx {

        @Test(priority=1)
        public void methodOne(){
            System.out.println(" this is methodOne");
        }

        @Test(priority=2)
        public void methodTwo(){
            System.out.println(" this is methodTwo");
        }

        @Test(priority=3)
        public void methodThree(){
            System.out.println(" this is methodThree");
        }

        @Test(priority=4)
        public void methodFour(){
            System.out.println(" this is methodFour");
        }
    }

