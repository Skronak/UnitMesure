/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unite_mesure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
*
* @author Alex&Guillaume
* Maj: 20/03/2014 :23.45.00
*/
public class GestionConversion {

/* ******************** Creation d'une conversion ********************
 * 		On instancie un objet conversion dans lequel on stock l'unit� d'arriv�e 
 * 		On Stock l'objet conversion dans la liste_conversion de l'unite de depart
 * 		On realise l'operation inverse afin de creer la contrepartie des conversions:  X vers B et B vers X 
 ********************************************************************/
   public void creer_conversion (List <Unite> liste_unite) {
       @SuppressWarnings("resource")
       Scanner sc = new Scanner(System.in);
       String rep_type_depart;
       String rep_type_arrivee;
       String operations[]= {"Addition","Multiplication","Operation complexe"} ;
       double rep=0;
       double val_add=0;
       double taux =0;
       Validator valid=new Validator();
       
	   // Recuperation des donnees utilisateur
       System.out.println("\nCreation d'une nouvelle conversion");		
       	do {
			System.out.println("Veuillez selectionner l'unite de depart");
			for (int j=0;j<liste_unite.size();j++) {
				System.out.println("Type: "+liste_unite.get(j).getType()+"	"+liste_unite.get(j).getNom());
			} 		
			rep_type_depart = sc.nextLine();
       	} while (valid.Entry_validatorStr(rep_type_depart,liste_unite)!=false);
        
	    do {
			System.out.println("Veuillez selectionner l'unite de d'arrivee (en lettre)");
			for (int j=0;j<liste_unite.size();j++) {
				System.out.println("Type: "+liste_unite.get(j).getType()+"	"+liste_unite.get(j).getNom());
			} 		
			rep_type_arrivee = sc.nextLine();
       	} while (valid.Entry_validatorStr(rep_type_arrivee,liste_unite)!=false);

	    // On test si une conversion existe deja
	    if (!valid.conversionExiste(rep_type_depart,rep_type_arrivee,liste_unite)) {    		    
	        //Creation de l'unite de depart a� partir de la chaine de caracteres
	        Unite unite_depart=new Unite();
		        for (int j=0;j<liste_unite.size();j++) {
				if(liste_unite.get(j).getNom().compareTo(rep_type_depart)==0) {
					unite_depart=liste_unite.get(j);
		            j=liste_unite.size();
		        } 
			} 	
	    	
	    	//Creation de l'unite de d'arrivee a� partir de la chaine de caracteres
	       Unite unite_arrivee=new Unite();
	       for (int j=0;j<liste_unite.size();j++) {
	    	   if(liste_unite.get(j).getNom().compareTo(rep_type_arrivee)==0) {
	    		   unite_arrivee=liste_unite.get(j);
	           	   j=liste_unite.size();
	           } 
			} 
	        if (unite_arrivee.getType()==unite_depart.getType()) {
		        //quel operation lie les deux unit
		        do {
			       	System.out.println("Quelle operation souhaitez effectuer pour lier l'unite <"+unite_depart.getNom()+"> a� <"+unite_arrivee.getNom()+"> :");
			       	for (int l=0;l<operations.length;l++) {
			       		System.out.println(l+" : "+operations[l]);
			       	} 
			        System.out.println("Veuillez selectionner le numero correspondant");
					rep = sc.nextDouble();
		  		} while (Validator.Entry_validatorInt(rep,operations)!=false);
		                
		        //Multiplication
		        if(rep==1) {
		        	// creation de la conversion inverse
		        	System.out.println("Veuillez indiquer par quel nombre multiplier les <"+unite_depart.getNom()+"> (/10=> 0,1)");
		            taux = sc.nextDouble();
		            Multiplication multiplication= new Multiplication(taux);
		            multiplication.setUniteArrivee(unite_arrivee);
		            unite_depart.getListe_conversion().add(multiplication);
		
		            // creation de la conversion inverse
		            taux=(1/taux);
		            Multiplication multiplication_inv= new Multiplication(taux);
		            multiplication_inv.setUniteArrivee(unite_depart);
		            unite_arrivee.getListe_conversion().add(multiplication_inv);
		            
		            System.out.println("<< Nouvelle conversion entre <"+unite_depart.getNom()+"> et <"+unite_arrivee.getNom()+"> ajout� avec success >>\n");
		        } 
		        //Addition
		        else if(rep==0) {
			            System.out.println("Veuillez indiquer avec quel nombre additionner l'unit� <"+unite_depart.getNom()+">");
				        val_add = sc.nextDouble();
		
			        //creation de la conversion
			        Addition addition=new Addition(val_add);
			        addition.setUniteArrivee(unite_arrivee);
			        unite_depart.getListe_conversion().add(addition);
		
			        // creation de la conversion inverse
			        val_add=(val_add*-1);
			        Addition addition_inv=new Addition(val_add);
			        addition_inv.setUniteArrivee(unite_depart);
			        unite_arrivee.getListe_conversion().add(addition_inv);        
		            System.out.println("<< Nouvelle conversion entre <"+unite_depart.getNom()+"> et <"+unite_arrivee.getNom()+"> ajout� avec success >>\n");
		
		        } 
		        //Complexe
		        else if(rep==2) {
		        	//permet de savoir si il y a eu une operation de renseignee
		            boolean conv=false;
		            //Creation objet complexe
		            Complexe complexe=new Complexe();
		            Complexe complexe_inv=new Complexe();
		            //initialisation d'une liste de conversion
		            List<Conversion> list_conv= new ArrayList<Conversion>();
		            List<Conversion> list_conv_inv= new ArrayList<Conversion>();
		            
		            do {
		            	//menu sp�cifique aux operations complexes
		            	System.out.println("Quelle op�ration voulez effectuer pour lier l'unit� <"+unite_depart.getNom()+"> et� <"+unite_arrivee.getNom()+"> :");
		            	for (int j=0;j<operations.length-1;j++) {
		            		System.out.println(j+": "+operations[j]);
		            	} 
		        		System.out.println("99: Finaliser la creation");
		        		System.out.println("Selectionnez le numero correspondant");   	               
		            	rep = sc.nextDouble();
		
		            	//Multiplication
		            	if(rep==1) {
		            		System.out.println("Veuillez indiquer par quel nombre multiplier l'unit� <"+unite_depart.getNom()+"> (/10=> 0,1)");
		            		taux = sc.nextDouble();
		            		Multiplication multiplication= new Multiplication(taux);
		            		list_conv.add(multiplication);
	
		            		//operation inverse
		            		Multiplication multiplication_inv= new Multiplication(taux);
		            		list_conv_inv.add(multiplication_inv);
	
		            		conv=true;
		            	} 
		            	
		            	//Addition
		            	else if(rep==0) {
		            		System.out.println("Veuillez indiquer par quel nombre additionner l'unit� <"+unite_depart.getNom()+">(/10=> 0,1)");
		            		val_add = sc.nextDouble();
		            		Addition addition=new Addition(val_add);
		            		list_conv.add(addition);
	
		    		        val_add=(val_add*-1);
		    		        Addition addition_inv=new Addition(val_add);
		    		        list_conv_inv.add(addition_inv);
		            		
		            		conv=true;
		            	} 
		            } while(rep!=99);
		            //si il y a eu une operation renseignee
		            if(conv) {
		            	//on met la liste de conversions dans l'objet
		            	complexe.setConversion(list_conv);
		            	complexe.setUniteArrivee(unite_arrivee);
		            	unite_depart.getListe_conversion().add(complexe);
		                System.out.println("<< Nouvelle conversion entre <"+unite_depart.getNom()+"> et <"+unite_arrivee.getNom()+"> ajout� avec success >>\n");
		                
		            	//on met la liste de conversions_inverse dans l'objet
		            	complexe_inv.setConversion(list_conv_inv);
		            	complexe_inv.setUniteArrivee(unite_depart);
		            	unite_arrivee.getListe_conversion().add(complexe_inv);
		                System.out.println("<< Nouvelle conversion entre <"+unite_depart.getNom()+"> et <"+unite_arrivee.getNom()+"> ajout� avec success >>\n");
		                
		            } 
		        } 	        	
	        } else {
	        	System.out.println(" << Impossible de convertir des "+unite_arrivee.getType()+" en "+unite_depart.getType()+" >>");
	        }
	    } else {
	    	System.out.println(" << Une conversion entre ces unit�s existe deja >>");
	    } 
   } 
   
   /* ********* Recuperation d'objets unites pour creer une conversion ***********
    * 	Recuperation de l'unite � convertir (depart)
    * 	Recuperation de sa liste de conversion pour trouver l'objet de l'unite d'arrivee
    * 	Renvoi un tableau contenant les objets : Unite _depart, Conversion, Unite d'arriv�e
    ******************************************************************************/   
   public static Object[] RetrieveObjects(ArrayList <Unite> liste_unite) {
    Unite unite_depart;
   	Unite unite_arrivee;
   	Object[]valeurs= {null,null,null} ;
   	String rep_nom_depart;
   	String rep_nom_arrivee;
   	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
   	Validator valid=new Validator();
   	int j;
   	int k;

   	// Recuperation des donnees utilisateurs			
		do {
			System.out.println("Veuillez selectionner l'unite de depart  (en lettre)");
			for (j=0;j<liste_unite.size();j++) {
				System.out.println(liste_unite.get(j).getNom());
			} 		
			rep_nom_depart = sc.nextLine();
		} while (valid.Entry_validatorStr(rep_nom_depart,liste_unite)!=false);
		
		do {
			System.out.println("Veuillez selectionner l'unite de d'arrivee  (en lettre)");
			for (j=0;j<liste_unite.size();j++) {
				System.out.println(liste_unite.get(j).getNom());
			} 
			rep_nom_arrivee = sc.nextLine();
   		} while (valid.Entry_validatorStr(rep_nom_arrivee,liste_unite)!=false);
		
		// Debut de la conversion
		for (j=0;j<liste_unite.size();j++) {
			unite_depart=liste_unite.get(j);
			
			if (unite_depart.getNom().compareTo(rep_nom_depart)==0) {
				valeurs[0]=unite_depart;
				//On parcours la liste de conversion disponible pour cette unite
				for (k=0;k<unite_depart.getListe_conversion().size();k++) {
						unite_arrivee = unite_depart.getListe_conversion().get(k).getUniteArrivee();
					// On a trouv� la conversion reliant l'unitee d'arrivee et de depart
					if (unite_arrivee.getNom().compareTo(rep_nom_arrivee)==0) {
						// Si le type de l'unit� de d�part est le meme que celui de l'unit� d'arrive on initialise le tableau
						if (unite_depart.getType()==unite_arrivee.getType()) {
							valeurs[1]=unite_depart.getListe_conversion().get(k);
							valeurs[2]=unite_arrivee;
						} else {
							System.out.println(" << Vous ne pouvez pas convertir des "+unite_depart.getType()+" en "+unite_arrivee.getType()+" >>");
						} 
					} 
				} 
			} 
		} 
		return valeurs;		
   } 

   /* ***************** Fonction de conversion d'unites ******************
    * 	Recuperation de l'unite � convertir (depart)
    * 	Recuperation de sa liste de conversion pour trouver l'objet de l'unite d'arrivee
    *   Declenchement de la methode calculer pour effectuer la conversion
    * *********************************************************************/   
   public void convertir(ArrayList <Unite> liste_unite) {
	   @SuppressWarnings("resource")
	   Scanner scan = new Scanner(System.in);      
	   double quantite;
	   double quantiteArr;
	   Object[] valeurs;

	   System.out.println("\nConversion d'une unit�");
	   valeurs=RetrieveObjects(liste_unite);
	   if (valeurs[1]!=null) { 	
		   System.out.println("Veuillez indiquer la quantite a convertir:");
		   quantite = scan.nextDouble();
		   quantiteArr=((Conversion) valeurs[1]).calculer(quantite);
		   System.out.println("\n Resultat de la conversion: "+quantiteArr);   	
	   } else {
		   System.out.println("<< Aucune conversion disponible entre ces deux unites >>");
	   } 
   } 

   /* *************** Affichage des conversions disponibles ***************
    * 	Recuperation de la liste d'unites du programme
    * 	Pour chaque unites on affiche sa liste de conversions disponibles
    * *********************************************************************/   
   public void consulterConversions(ArrayList <Unite> liste_unite) {
	   System.out.println("\nListe des conversions disponibles :");
	   // Parcours de toute les unit�s disponibles
		for (int j=0;j<liste_unite.size();j++) {
			Unite unite_depart=liste_unite.get(j);
			System.out.println("conversion disponibles pour <"+unite_depart.getNom()+">");
			
			// Pour chaque unit� on affiche le contenu de sa liste de conversion si elle n'est pas vide
			if (unite_depart.getListe_conversion().size()==0) {
				System.out.println("	<< Aucune conversion existante >>");
			} else {
				for (int k=0;k<unite_depart.getListe_conversion().size();k++) {
						Unite unite_arrivee = unite_depart.getListe_conversion().get(k).getUniteArrivee();
						System.out.println("	-"+unite_depart.getNom()+" to "+ unite_arrivee.getNom());
				} 
			} 
		} 
   } 
   
   /* ***************** Creation d'une unite ******************
    * 	Recuperation des informations sur l'unite a creer
    * 	Instanciation&initialisation de l'objet unite correspondant
    *   Stockage de l'unite dans les liste_unite de l'application
    * ***********************************************************/   
   public void creerUnite(ArrayList <Unite> liste_unite) {
       Validator valid=new Validator();
	   System.out.println("\nCreation d'une unit�");
	   //recupere le nom de l'unitee
       @SuppressWarnings("resource")
       Scanner sc = new Scanner(System.in);
       System.out.println("Nom de l'unite:");
	   String nom=sc.nextLine();
	   int k=0;
	   
	   if (!valid.Unite_existe(nom,liste_unite)) {
		   //recupere le type de l'unitee		   
		   System.out.println("Type de l'unite:");
		   
		   for(TypeUnite type: TypeUnite.values()) {
		         System.out.println(k+":"+ type);
		         k++;
		   } 
		   k=sc.nextInt();		   		   
		   //instancie une unite
		   Unite unite= new Unite(nom,TypeUnite.values()[k]);
		   
		   //ajoute l'unitee cree à la liste des unitees
		   try {
			   liste_unite.add(unite);
		   } catch (Exception e) {
			   e.printStackTrace(); 
		   } 
		   System.out.println("<< Unit� ajout�e avec succ�s >>");
	   } else {
		   System.out.println("<< Cette unit� existe deja >>");
	   } 
   } 
   
   /* ***************** Fonction de conversion d'unites ******************
    * 	Parcours la liste des unites du programme et les affiches
    * *********************************************************************/   
   public void afficherUnites(ArrayList <Unite> liste_unite) {
       System.out.println("\nListe des unit�s disponibles");
       for (int j=0; j<liste_unite.size();j++) {
           Unite ligne = liste_unite.get(j);
           System.out.println(ligne.toStringok());
       } 
   } 
} 