package com.mycompany.teszt.Teszteles;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.experimental.categories.Category;
import static org.junit.internal.matchers.StringContains.containsString;
import org.junit.rules.ExpectedException;


public class MoneyTest {
    
    private Money instance;
    
    public MoneyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.instance = new Money(1000);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class Money.
     */
    @Test
    public void testAdd() {
        System.out.println("Test Money class add() method!");
        Integer amount = 1000;
        Integer expResult = 2000;
        Integer result = instance.add(amount);
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class Money.
     */
    @Test
    public void testRemove() {
        System.out.println("Test Money class remove() method!");
        Integer amount = 1500;
        Integer expResult = 0;
        Integer result = instance.remove(amount);
        assertEquals(expResult, result);
    }
    
    @Test(expected = NegativeGoalException.class)
    public void createGoalTest() throws NegativeGoalException {
        Integer amount = -200;
        instance.setGoal(amount);
    }
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void exceptionTest() throws NegativeGoalException {
        thrown.expect(NegativeGoalException.class);
        thrown.expectMessage("Nem lehet mínusz az összeg!");
//        thrown.expectMessage(containsString("mínusz"));
        Integer amount = -200;
        instance.setGoal(amount);
    }
    
    @Test(timeout = 10)
    @Category(LoginCategory.class)
    public void badTest() {
        for(int i = 0; i < 9999999; i++) {
            int result = instance.add(200);
        }
    }
    
}
