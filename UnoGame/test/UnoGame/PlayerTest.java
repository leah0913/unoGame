/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnoGame;

import java.util.ArrayList;
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
public class PlayerTest {
    
    public PlayerTest() {
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
     * Test of numOfCards method, of class Player.
     */
    @Test
    public void testNumOfCards() {
        System.out.println("numOfCards");
        Player instance = new Player("Leah");
        int expResult = 0;
        int result = instance.numOfCards();
        assertEquals(expResult, result);
    }


 
    
    /**
     * Test of hasWon method, of class Player.
     */
    @Test
    public void testHasWon() {
        System.out.println("hasWon");
        Player instance = new Player("Leah");
        boolean expResult = true;
        boolean result = instance.hasWon();
        assertEquals(expResult, result);
    }



}
