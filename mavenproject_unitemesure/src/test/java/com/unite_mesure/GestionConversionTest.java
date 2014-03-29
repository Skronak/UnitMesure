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
public class GestionConversionTest extends TestCase {
    
    public GestionConversionTest(String testName) {
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
     * Test of creer_conversion method, of class GestionConversion
     */
    /**
     * Test of RetrieveObjects method, of class GestionConversion.
     */
    /**
     * Test of convertir method, of class GestionConversion.
     */

    /**
     * Test of consulterConversions method, of class GestionConversion.
     */
    public void testConsulterConversions() {
        System.out.println("consulterConversions");
        ArrayList <Unite> liste_unite =new ArrayList<Unite>();
        Unite unite2=new Unite("cm",null);
        Unite unite3=new Unite("m",null);
        Multiplication multiplication= new Multiplication(10);
	multiplication.setUniteArrivee(unite2);
	unite3.getListe_conversion().add(multiplication);
        liste_unite.add(unite2);
        liste_unite.add(unite3);
        GestionConversion instance = new GestionConversion();
        instance.consulterConversions(liste_unite);
    }

    /**
     * Test of creerUnite method, of class GestionConversion.
     */

    /**
     * Test of afficherUnites method, of class GestionConversion.
     */
    public void testAfficherUnites() {
        System.out.println("afficherUnites");
        ArrayList <Unite> liste_unite =new ArrayList<Unite>();
        Unite unite2=new Unite("cm",null);
        liste_unite.add(unite2);
        Unite unite3=new Unite("m",null);
        liste_unite.add(unite3);
        GestionConversion instance = new GestionConversion();
        instance.afficherUnites(liste_unite);
    }
    
}
