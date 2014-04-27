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
     * Test of creerConversionCompl method, of class GestionConversion.
     */
    public void testCreerConversionCompl() {
        System.out.println("creerConversionCompl");

        Validator valid=new Validator();
        List<Unite> listeUnite = new ArrayList<Unite>();
        Unite uniteDepart =  new Unite("cm",null);
        Unite uniteArrivee =  new Unite("m",null);
        listeUnite.add(uniteDepart);
        listeUnite.add(uniteArrivee);
        assert(uniteArrivee.getType()==uniteDepart.getType());
        assert(!valid.conversionExiste(uniteDepart.getNom(),uniteArrivee.getNom(),listeUnite));
        List<AbstractConversion> listConvInv = new ArrayList<AbstractConversion>();
        List<AbstractConversion> listConv = new ArrayList<AbstractConversion>();
        
        Multiplication multiplication= new Multiplication(10);
        Multiplication multiplicationInv= new Multiplication(0.1);
	listConv.add(multiplication);
        listConvInv.add(multiplicationInv);
        
        Addition addition=new Addition(1);
        Addition additionInv=new Addition(-1);
        listConv.add(addition);
        listConvInv.add(additionInv);
        
        GestionConversion instance = new GestionConversion();
        instance.creerConversionCompl(listeUnite, uniteDepart, uniteArrivee, listConvInv, listConv);
    }

    /**
     * Test of creerConversionAdd method, of class GestionConversion.
     */
    public void testCreerConversionAdd() {
        System.out.println("creerConversionAdd");
        Validator valid=new Validator();
        List<Unite> listeUnite =  new ArrayList<Unite>();
        Unite uniteDepart =  new Unite("cm",null);
        Unite uniteArrivee =  new Unite("m",null);
        assert(uniteArrivee.getType()==uniteDepart.getType());
        assert(!valid.conversionExiste(uniteDepart.getNom(),uniteArrivee.getNom(),listeUnite));
        listeUnite.add(uniteDepart);
        listeUnite.add(uniteArrivee);
        
        double taux = 10;
        GestionConversion instance = new GestionConversion();
        instance.creerConversionAdd(listeUnite, uniteDepart, uniteArrivee, taux);
    }

    /**
     * Test of creerConversionMult method, of class GestionConversion.
     */
    public void testCreerConversionMult() {
        Validator valid=new Validator();
        System.out.println("creerConversionMult");
        List<Unite> listeUnite = new ArrayList<Unite>();
        Unite uniteDepart =  new Unite("cm",null);
        Unite uniteArrivee =  new Unite("m",null);
        assert(uniteArrivee.getType()==uniteDepart.getType());
        assert(!valid.conversionExiste(uniteDepart.getNom(),uniteArrivee.getNom(),listeUnite));
        listeUnite.add(uniteDepart);
        listeUnite.add(uniteArrivee);
        
        double taux = 10;
        GestionConversion instance = new GestionConversion();
        instance.creerConversionMult(listeUnite, uniteDepart, uniteArrivee, taux);
    }

    /**
     * Test of convertir method, of class GestionConversion.
     */
    public void testConvertir() {
        System.out.println("convertir");
        List<Unite> listeUnite = new ArrayList<Unite>();
        Unite uniteDepart =  new Unite("cm",null);
        Unite uniteArrivee =  new Unite("m",null);
        listeUnite.add(uniteDepart);
        listeUnite.add(uniteArrivee);
        
        GestionConversion instance = new GestionConversion();
        
        double quantite = 10;
        AbstractConversion varConv = new Multiplication(10);
        double expResult = 100;
        double result = instance.convertir(listeUnite, quantite, varConv);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of consulterConversions method, of class GestionConversion.
     */
    public void testConsulterConversions() {
        System.out.println("consulterConversions");
        List<Unite> listeUnite = new ArrayList<Unite>();
        
        Unite uniteDepart =  new Unite("cm",null);
        Unite uniteArrivee =  new Unite("m",null);
        
        Multiplication multiplication= new Multiplication(10);
        multiplication.setUniteArrivee(uniteArrivee);
        uniteDepart.addOperationListConversion(multiplication);
        // creation de la conversion inverse
        Multiplication multiplicationInv = new Multiplication(0.1);
        multiplicationInv.setUniteArrivee(uniteDepart);
        uniteArrivee.addOperationListConversion(multiplicationInv);
        listeUnite.add(uniteDepart);
        listeUnite.add(uniteArrivee);
        
        GestionConversion instance = new GestionConversion();
        instance.consulterConversions(listeUnite);
    }

    /**
     * Test of creerUnite method, of class GestionConversion.
     */
    public void testCreerUnite() {
        Validator valid=new Validator();
        System.out.println("creerUnite");
        List<Unite> listeUnite = new ArrayList<Unite>();
        String nom = "dm";
        int insstanceK = 2;
        assert(!valid.uniteExiste(nom,listeUnite));
        GestionConversion instance = new GestionConversion();
        instance.creerUnite(listeUnite, nom, insstanceK);
        instance.afficherUnites(listeUnite);
    }

    /**
     * Test of afficherUnites method, of class GestionConversion.
     */
    public void testAfficherUnites() {
        System.out.println("afficherUnites");
        List<Unite> listeUnite = new ArrayList<Unite>();
        
        GestionConversion instance = new GestionConversion();
        instance.creerUnite(listeUnite, "cm", 2);
        instance.creerUnite(listeUnite, "m", 2);
        instance.creerUnite(listeUnite, "dm", 2);
        instance.afficherUnites(listeUnite);
    }
    
}
