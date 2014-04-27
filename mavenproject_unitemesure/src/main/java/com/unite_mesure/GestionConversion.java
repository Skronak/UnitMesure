/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unite_mesure;


import java.util.List;

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
   public void creerConversionCompl (List <Unite> listeUnite,Unite uniteDepart,Unite uniteArrive,List<AbstractConversion> listConvInv,List<AbstractConversion> listConv) {
       
		        //Complexe
		            //Creation objet complexe
		            Complexe complexe=new Complexe();
		            Complexe complexeInv=new Complexe();
		           
		            	//on met la liste de conversions dans l'objet
		            	complexe.setConversion(listConv);
		            	complexe.setUniteArrivee(uniteArrive);
		            	uniteDepart.addOperationListConversion(complexe);
		                System.out.println("<< Nouvelle conversion entre <"+uniteDepart.getNom()+"> et <"+uniteArrive.getNom()+"> ajoute avec success >>\n");
		                
		            	//on met la liste de conversions_inverse dans l'objet
		            	complexeInv.setConversion(listConvInv);
		            	complexeInv.setUniteArrivee(uniteDepart);
		            	uniteArrive.addOperationListConversion(complexeInv);
		                System.out.println("<< Nouvelle conversion entre <"+uniteDepart.getNom()+"> et <"+uniteArrive.getNom()+"> ajoute avec success >>\n");

   } 
   
   public void creerConversionAdd (List <Unite> listeUnite,Unite uniteDepart,Unite uniteArrive,double taux) {
		                
		        //Multiplication
		       // creation de la conversion
		            Addition addition= new Addition(taux);
		            addition.setUniteArrivee(uniteArrive);
                        //modifie ici
		            uniteDepart.addOperationListConversion(addition);
		
		            // creation de la conversion inverse
		            taux=1/taux;
		            Multiplication multiplicationInv= new Multiplication(taux);
		            multiplicationInv.setUniteArrivee(uniteDepart);
                            //modifie ici
		            uniteArrive.addOperationListConversion(multiplicationInv);
		            
		            System.out.println("<< Nouvelle conversion entre <"+uniteDepart.getNom()+"> et <"+uniteArrive.getNom()+"> ajoute avec success >>\n");
   }
   public void creerConversionMult (List <Unite> listeUnite,Unite uniteDepart,Unite uniteArrive,double taux) {
		                
		        //Multiplication
		       // creation de la conversion
		            Multiplication multiplication= new Multiplication(taux);
		            multiplication.setUniteArrivee(uniteArrive);
                        //modifie ici
		            uniteDepart.addOperationListConversion(multiplication);
		
		            // creation de la conversion inverse
		            taux=1/taux;
		            Multiplication multiplicationInv= new Multiplication(taux);
		            multiplicationInv.setUniteArrivee(uniteDepart);
                            //modifie ici
		            uniteArrive.addOperationListConversion(multiplicationInv);  
		            System.out.println("<< Nouvelle conversion entre <"+uniteDepart.getNom()+"> et <"+uniteArrive.getNom()+"> ajoute avec success >>\n");
   }

   /* ***************** Fonction de conversion d'unites ******************
    * 	Recuperation de l'unite � convertir (depart)
    * 	Recuperation de sa liste de conversion pour trouver l'objet de l'unite d'arrivee
    *   Declenchement de la methode calculer pour effectuer la conversion
    * *********************************************************************/   
   public double convertir(List <Unite> listeUnite,double quantite,AbstractConversion varConv) {

       if (varConv!=null){
           System.out.println("\nConversion d'une unite");
            double quantiteArr=varConv.calculer(quantite);
            return quantiteArr;  	
        } else {
            System.out.println("<< Aucune conversion disponible entre ces deux unites >>");
            return 0;
	} 
   } 

   /* *************** Affichage des conversions disponibles ***************
    * 	Recuperation de la liste d'unites du programme
    * 	Pour chaque unites on affiche sa liste de conversions disponibles
    * *********************************************************************/   
   public void consulterConversions(List <Unite> listeUnite) {
	   System.out.println("\nListe des conversions disponibles :");
	   // Parcours de toute les unit�s disponibles
		for (int j=0;j<listeUnite.size();j++) {
			Unite uniteDepart=listeUnite.get(j);
			System.out.println("conversion disponibles pour <"+uniteDepart.getNom()+">");
			
			// Pour chaque unit� on affiche le contenu de sa liste de conversion si elle n'est pas vide
			if (uniteDepart.isEmpty()==0) {
				System.out.println("	<< Aucune conversion existante >>");
			} else {
                                for(AbstractConversion each : uniteDepart.getListeConversion()) {
						Unite uniteArrivee = each.getUniteArrivee();
						System.out.println("	-"+uniteDepart.getNom()+" to "+ uniteArrivee.getNom());
				} 
			} 
		} 
   } 
   
   /* ***************** Creation d'une unite ******************
    * 	Recuperation des informations sur l'unite a creer
    * 	Instanciation&initialisation de l'objet unite correspondant
    *   Stockage de l'unite dans les liste_unite de l'application
    * ***********************************************************/   
   public void creerUnite(List <Unite> listeUnite,String nom,int insstanceK) {
       System.out.println("\nCreation d'une unit�");
	   //recupere le nom de l'unitee
       @SuppressWarnings("resource")
        Unite unite= new Unite(nom,TypeUnite.values()[insstanceK]);
		   
		   //ajoute l'unitee cree à la liste des unitees
		   try {
			   listeUnite.add(unite);
		   } catch (Exception e) {
			   e.printStackTrace(); 
		   } 
		   System.out.println("<< Unite ajoutee avec succes >>");
   } 
   
   /* ***************** Fonction de conversion d'unites ******************
    * 	Parcours la liste des unites du programme et les affiches
    * *********************************************************************/   
   public void afficherUnites(List <Unite> listeUnite) {
       System.out.println("\nListe des unites disponibles");
       for (int j=0; j<listeUnite.size();j++) {
           Unite unite = listeUnite.get(j);
           System.out.println(unite);
       } 
   } 
} 