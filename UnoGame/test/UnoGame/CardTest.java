/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnoGame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class CardTest {
    
    public CardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCardColour method, of class Card.
     */
    @Test
    public void testGetCardColour() {
        System.out.println("getCardColour");
        Card instance = new Card(4,"ylw");
        String expResult = "ylw";
        String result = instance.getCardColour();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCardNum method, of class Card.
     */
    @Test
    public void testGetCardNum() {
        System.out.println("getCardNum");
        Card instance = new Card(4,"ylw");
        int expResult = 4;
        int result = instance.getCardNum();
        assertEquals(expResult, result);
    }
    

    /**
     * Test of isSpecial method, of class Card.
     */
    @Test
    public void testIsSpecial() {
        System.out.println("isSpecial");
        Card instance = new Card(2);
        boolean expResult = true;
        boolean result = instance.isSpecial();
        assertEquals(expResult, result);
    }
    
    
}
