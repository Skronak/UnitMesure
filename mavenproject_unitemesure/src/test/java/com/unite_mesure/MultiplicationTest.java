/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.unite_mesure;

import junit.framework.TestCase;

/**
 *
 * @author Alex
 */
public class MultiplicationTest extends TestCase {
    
    public MultiplicationTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getTaux method, of class Multiplication.
     */
    public void testGetTaux() {
        System.out.println("getTaux");
        Multiplication instance = new Multiplication(2);
        double expResult = 2;
        double result = instance.getTaux();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTaux method, of class Multiplication.
     */
    public void testSetTaux() {
        System.out.println("setTaux");
        double value = 10;
        Multiplication instance = new Multiplication(2);
        instance.setTaux(value);
    }

    /**
     * Test of calculer method, of class Multiplication.
     */
    public void testCalculer() {
        System.out.println("calculer");
        double quantite = 10;
        Multiplication instance = new Multiplication(2);
        double expResult = 20;
        double result = instance.calculer(quantite);
        assertEquals(expResult, result);
    }
}
