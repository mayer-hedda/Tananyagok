package com.mycompany.teszt.Teszteles;

import junit.framework.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;


@RunWith(Theories.class)
public class TheoryTest {
    
    @DataPoints
    public static int[] data() {
        return new int[] {20, 30, 40};
    }
    
    @Theory
    public void addAmount(int value) {
        Money instance = new Money(1000);
        int result = instance.add(value);
        
        Assert.assertTrue(result > 0);
    }
    
}
