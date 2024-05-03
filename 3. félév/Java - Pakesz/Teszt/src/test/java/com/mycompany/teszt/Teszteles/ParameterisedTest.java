package com.mycompany.teszt.Teszteles;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class ParameterisedTest {
    
    private static Money instance = new Money(1000);
    private int input;                                      // bemenő érték
    private int expected;                                   // várható érték
    
    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {500, 2500},
            {500, 2000},
            {-2200, 0},
            {1200, 1200},
            {600, 1800}
        });
    }
    
    public ParameterisedTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }
    
    @Test
    public void test() {
        int result;
        if(input >= 0) {
            result = instance.add(input);
        } else {
            result = instance.remove(-input);
        }
        
        Assert.assertEquals(result, expected);
    }
    
}
