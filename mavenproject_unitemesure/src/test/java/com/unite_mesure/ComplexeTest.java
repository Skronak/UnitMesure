/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.unite_mesure;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Alex
 */
public class ComplexeTest extends TestCase {
    
    public ComplexeTest(String testName) {
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
     * Test of getConversion method, of class Complexe.
     */
    public void testGetConversion() {
        System.out.println("getConversion");
        Addition addi= new Addition(10);
        Multiplication multi=new Multiplication(2);
        List<AbstractConversion> liste=new ArrayList<AbstractConversion>();
        liste.add(addi);
        liste.add(multi);
        
        Complexe instance = new Complexe();
        instance.setConversion(liste);
        @SuppressWarnings("Convert2Diamond")
        List<AbstractConversion> expResult = new ArrayList<AbstractConversion>();
        expResult.add(addi);
        expResult.add(multi);
        List<AbstractConversion> result = instance.getConversion();
        assertEquals(expResult, result);
    }

    /**
     * Test of setConversion method, of class Complexe.
     */
    public void testSetConversion() {
        System.out.println("setConversion");
        List<AbstractConversion> conversion = new ArrayList<AbstractConversion>();
        Addition addi= new Addition(10);
        Multiplication multi=new Multiplication(2);
        conversion.add(addi);
        conversion.add(multi);
        Complexe instance = new Complexe();
        instance.setConversion(conversion);
    }

    /**
     * Test of calculer method, of class Complexe.
     */
    public void testCalculer() {
        System.out.println("calculer");
        Addition addi= new Addition(10);
        Multiplication multi=new Multiplication(2);
        List<AbstractConversion> liste=new ArrayList<AbstractConversion>();
        liste.add(addi);
        liste.add(multi);
        double quantite=1;
        Complexe instance = new Complexe();
        instance.setConversion(liste);
        double expResult = 22;
        double result = instance.calculer(quantite);
        assertEquals(expResult, result);
    }    
}
