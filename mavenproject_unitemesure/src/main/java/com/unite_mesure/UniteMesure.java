package com.unite_mesure;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Alex&Guillaume
 */
public class UniteMesure {
	/**
	 *
	 * @author Alex&Guillaume
	 * Maj: 07/03/2014 :18.15.00
	 * @param args the command line arguments
	 */

	public static void main(String[] args) {
		System.out.println("==================== Systeme de conversion d'unite ====================");
// A remplacer par initialisation
		ArrayList <Unite> liste_unite =new ArrayList<Unite>();
    	menu(liste_unite);
        System.exit(0);
    }
    
    public static void menu(ArrayList <Unite> liste_unite){
        Scanner sc = new Scanner(System.in);
        GestionConversion g_c = new GestionConversion();        
        Unite unite2=new Unite("cm",null);
        liste_unite.add(unite2);
        Unite unite3=new Unite("m",null);
        liste_unite.add(unite3);
        int i;        

        do{
            System.out.println("\n1: Effectuer une convertion");
        	System.out.println("2: Creer une unite");
            System.out.println("3: Creer une nouvelle convertion");
        	System.out.println("4: Afficher les unites disponibles");
            System.out.println("5: Consulter les convertions disponibles");
            System.out.println("99: Quitter");
            i = sc.nextInt();
            
            switch (i){
	            case 1: g_c.convertir(liste_unite);
	            		break;
	            case 2: g_c.creerUnite(liste_unite);
	            		break;
	            case 3: g_c.creer_conversion(liste_unite);
	    				break;
	            case 4:	g_c.afficherUnites(liste_unite);
	    				break;
	            case 5: g_c.consulterConversions(liste_unite);
	            		break;
	            case 99:
	            		System.out.println("Au revoir");
	            		break;
	            default:
	            	  System.out.println("Cette action ne correspond � aucune action");
	            	  break;
            }
        } while ((i!=99));
        sc.close();
    }
}
