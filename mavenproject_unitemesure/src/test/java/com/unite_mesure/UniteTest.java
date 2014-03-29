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
public class UniteTest extends TestCase {
    
    public UniteTest(String testName) {
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
     * Test of getNom method, of class Unite.
     */
    public void testGetNom() {
        System.out.println("getNom");
        Unite instance = new Unite("m",null);
        String expResult = "m";
        String result = instance.getNom();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNom method, of class Unite.
     */
    public void testSetNom() {
        System.out.println("setNom");
        String value = "m";
        Unite instance = new Unite();
        instance.setNom(value);
    }

    /**
     * Test of setType method, of class Unite.
     */
    public void testSetType() {
        System.out.println("setType");
        TypeUnite value = TypeUnite.values()[0];
        Unite instance = new Unite("cm",null);
        instance.setType(value);
    }

    /**
     * Test of getType method, of class Unite.
     */
    public void testGetType() {
        System.out.println("getType");
        Unite instance = new Unite("cm",TypeUnite.values()[0]);
        TypeUnite expResult = TypeUnite.values()[0];
        TypeUnite result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListe_conversion method, of class Unite.
     */
    public void testGetListe_conversion() {
        System.out.println("getListe_conversion");
        Unite instance=new Unite("cm",TypeUnite.values()[0]);
        List<Conversion> expResult = new ArrayList<Conversion>();
        Multiplication multiplication= new Multiplication(10);
        expResult.add(multiplication);
	instance.getListe_conversion().add(multiplication);
        List<Conversion> result = instance.getListe_conversion();
        assertEquals(expResult, result);
    }

    /**
     * Test of setListe_conversion method, of class Unite.
     */
    public void testSetListe_conversion() {
        System.out.println("setListe_conversion");
        List<Conversion> liste_conversion = new ArrayList<Conversion>();
        Unite instance=new Unite("cm",TypeUnite.values()[0]);
        Multiplication multiplication= new Multiplication(10);
	liste_conversion.add(multiplication);
        instance.setListe_conversion(liste_conversion);
    }  
}
