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
public class AdditionTest extends TestCase {
    
    public AdditionTest(String testName) {
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
     * Test of getVal_add method, of class Addition.
     */
    public void testGetVal_add() {
        System.out.println("getVal_add");
        Addition instance = new Addition(10);
        double expResult = 10;
        double result = instance.getVal_add();
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setVal_add method, of class Addition.
     */
    public void testSetVal_add() {
        System.out.println("setVal_add");
        int value = 0;
        Addition instance = new Addition(10);
        instance.setVal_add(value);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calculer method, of class Addition.
     */
    public void testCalculer() {
        System.out.println("calculer");
        double quantite = 10;
        Addition instance = new Addition(10);
        double expResult = 20;
        double result = instance.calculer(quantite);
        assertEquals(expResult, result);
    }   
}
