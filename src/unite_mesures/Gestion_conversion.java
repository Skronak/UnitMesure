/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unite_mesures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class Gestion_conversion {
    
   @SuppressWarnings("null")
   public void creer_conversion (ArrayList <Unite> liste_unite){
       Scanner sc = new Scanner(System.in);
       Scanner s = new Scanner(System.in);
       String rep_type_depart;
       String rep_type_arrivee;
       String operations[]={"Multiplication","Addition","Operation complexe"};
       double rep;
       double val_add;
       
	   // Recuperation des donnees utilisateur
       System.out.println("Conversion d'unite");		
       	do {
			System.out.println("Veuillez selectionner l'unite de depart");
			for (int j=0;j<liste_unite.size();j++) {
				System.out.println(liste_unite.get(j).getNom());
			}		
			rep_type_depart = sc.nextLine();
       	}while (Entry_validatorStr(rep_type_depart,liste_unite)!=false);
        
        //Creation de l'unite de depart a  partir de la chaine de caracteres
        Unite unite_depart=new Unite();
	        for (int j=0;j<liste_unite.size();j++) {
			if(liste_unite.get(j).getNom().compareTo(rep_type_depart)==0){
				unite_depart=liste_unite.get(j);
	            j=liste_unite.size();
	        }
		}	

	    do {
			System.out.println("Veuillez selectionner l'unite de d'arrivee (en lettre)");
			for (int j=0;j<liste_unite.size();j++) {
				System.out.println(liste_unite.get(j).getNom());
			}		
			rep_type_arrivee = sc.nextLine();
       	}while (Entry_validatorStr(rep_type_arrivee,liste_unite)!=false);
              
       //Creation de l'unite de d'arrivee a  partir de la chaine de caracteres
       Unite unite_arrivee=new Unite();
       for (int j=0;j<liste_unite.size();j++) {
    	   if(liste_unite.get(j).getNom().compareTo(rep_type_arrivee)==0){
    		   unite_arrivee=liste_unite.get(j);
           	   j=liste_unite.size();
           }
		}
       
        //quel operation lie les deux unit
        do {
	       	System.out.println("Quelle operation souhaitez effectuer pour lier l'unite <"+unite_depart.getNom()+"> a  <"+unite_arrivee.getNom()+"> :");
	       	for (int l=0;l<operations.length;l++){
	       		System.out.println(l+" : "+operations[l]);
	       	}
	        System.out.println("Veuillez selectionner le numero correspondant");
			rep = sc.nextDouble();
  		}while (Entry_validatorInt(rep,operations)!=false);

                
        //Multiplication
        if(rep==0){
        	// creation de la conversion inverse
        	System.out.println("Veuillez indiquer par quel nombre multiplier les <"+unite_depart.getNom()+"> (/10=> 0,1)");
            double taux = sc.nextDouble();
            Multiplication multiplication= new Multiplication(taux);
            multiplication.setUniteArrivee(unite_arrivee);
            unite_depart.getListe_conversion().add(multiplication);

            // creation de la conversion inverse
            taux=(1/taux);
            Multiplication multiplication_inv= new Multiplication(taux);
            multiplication.setUniteArrivee(unite_depart);
            unite_arrivee.getListe_conversion().add(multiplication_inv);
            
            System.out.println("<< Nouvelle conversion entre <"+unite_depart.getNom()+"> et <"+unite_arrivee.getNom()+"> ajouté avec success >>\n");
        }
        //Addition
        else if(rep==1){
	            System.out.println("Veuillez indiquer avec quel nombre additionner l'unité <"+unite_depart.getNom()+">");
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
            System.out.println("<< Nouvelle conversion entre<"+unite_depart.getNom()+"> et <"+unite_arrivee.getNom()+"> ajouté avec success >>\n");

        }
        //Complexe
        else if(rep==2){
        	int i=0;       
        	//permet de savoir si il y a eu une operation de renseignee
            boolean conv=false;
            //Creation objet complexe
            Complexe complexe=new Complexe();
            //initialisation d'une liste de conversion
            List<Conversion> list_conv= new ArrayList<Conversion>();

            do{
            	//menu spécifique aux operations complexes
            	System.out.println("Quelle opération voulez effectuer pour lier l'unité <"+unite_depart.getNom()+"> et  <"+unite_arrivee.getNom()+"> :");
            	for (int j=0;j<operations.length-1;j++) {
            		System.out.println(j+": "+operations[j]);
            	}
        		System.out.println("99: Finaliser la creation");
        		System.out.println("Selectionnez le numero correspondant");   	               
            	rep = sc.nextDouble();

            	//Multiplication
            	if(rep==0){
            		System.out.println("Veuillez indiquer par quel nombre multiplier l'unité <"+unite_depart.getNom()+"> (/10=> 0,1)");
            		double taux = sc.nextDouble();
            		Multiplication multiplication= new Multiplication(taux);
            		list_conv.add(multiplication);
            		conv=true;
            	}
            	
            	//Addition
            	else if(rep==1){
            		System.out.println("Veuillez indiquer par quel nombre additionner l'unité <"+unite_depart.getNom()+">(/10=> 0,1)");
            		val_add = sc.nextDouble();
            		Addition addition=new Addition(val_add);
            		list_conv.add(addition);
            		conv=true;
            	}
            }while(rep!=99);
            //si il y a eu une operation renseignee
            if(conv){
            	//on met la liste de conversions dans l'objet
            	complexe.setConversion(list_conv);
            	complexe.setUniteArrivee(unite_arrivee);
            	unite_depart.getListe_conversion().add(complexe);
                System.out.println("<< Nouvelle conversion entre <"+unite_depart.getNom()+"> et <"+unite_arrivee.getNom()+"> ajouté avec success >>\n");
            }
        } 
   }
   
   /* Methode pour recuperer les objets correspondants aux saisies de l'utilsateur
    * L'unite d'arrivee est recuperée en parcourant toute la liste de conversion pour l'unité selectionnée
    * et en testant pour chacune l'objet unité_d'arrivée.
    * Renvoi un tableau contenant: Unite _depart, Conversion, Unite d'arrivée
    */
   public static Object[] RetrieveObjects(ArrayList <Unite> liste_unite) {
   	Unite unite_depart;
   	Unite unite_arrivee;
   	Object[]valeurs={null,null,null};
   	String rep_nom_depart;
   	String rep_nom_arrivee;
   	Scanner sc = new Scanner(System.in);
   	int j,k;

   	// Recuperation des donnees utilisateurs
		System.out.println("Conversion d'unite");			
		do {
			System.out.println("Veuillez selectionner l'unite de depart  (en lettre)");
			for (j=0;j<liste_unite.size();j++) {
				System.out.println(liste_unite.get(j).getNom());
			}		
			rep_nom_depart = sc.nextLine();
		}while (Entry_validatorStr(rep_nom_depart,liste_unite)!=false);
		
		do {
			System.out.println("Veuillez selectionner l'unite de d'arrivee  (en lettre)");
			for (j=0;j<liste_unite.size();j++) {
				System.out.println(liste_unite.get(j).getNom());
			}
			rep_nom_arrivee = sc.nextLine();
   		}while (Entry_validatorStr(rep_nom_arrivee,liste_unite)!=false);
		
		// Debut de la conversion
		for (j=0;j<liste_unite.size();j++) {
			unite_depart=liste_unite.get(j);
			
			if (unite_depart.getNom().compareTo(rep_nom_depart)==0){
				valeurs[0]=unite_depart;
				//On parcours la liste de conversion disponible pour cette unite
				for (k=0;k<unite_depart.getListe_conversion().size();k++) {
						unite_arrivee = unite_depart.getListe_conversion().get(k).getUniteArrivee();
					// Si on a trouvé la conversion reliant l'unitï¿½ d'arrivee de depart et d'arrivee on initialise le tableau
					if (unite_arrivee.getNom().compareTo(rep_nom_arrivee)==0){
						valeurs[1]=unite_depart.getListe_conversion().get(k);
						valeurs[2]=unite_arrivee;
					}
				}
			}
		}
		return valeurs;		
   }
   
   public void convertir(ArrayList <Unite> liste_unite){
	   Scanner sc = new Scanner(System.in);      
	   double quantite;
	   double quantiteArr;
	   Object[] valeurs;

	   System.out.println("Veuillez indiquer la quantite a convertir:");
	   quantite = sc.nextDouble();
	   valeurs=RetrieveObjects(liste_unite);
	   if (valeurs[1]!=null){ 	
		   quantiteArr=((Conversion) valeurs[1]).calculer(quantite);
		   System.out.println("Resultat de la conversion: "+quantiteArr);   	
	   }else{
		   System.out.println("Aucune conversion disponible entre ces deux unites");
	   }
   }
   
   public void consulter_conversions(ArrayList <Unite> liste_unite){
	   System.out.println("Liste des conversions disponibles :");
		for (int j=0;j<liste_unite.size();j++) {
			Unite unite_depart=liste_unite.get(j);
			System.out.println("\n	conversion disponibles pour <"+unite_depart.getNom()+">");
			if (unite_depart.getListe_conversion().size()==0){
				System.out.println("	<< Aucune conversion existante >>");
			}
				for (int k=0;k<unite_depart.getListe_conversion().size();k++) {
						Unite unite_arrivee = unite_depart.getListe_conversion().get(k).getUniteArrivee();
						System.out.println("	-"+unite_depart.getNom()+" to "+ unite_arrivee.getNom());
				}   
		}
   }
   
   public static boolean Entry_validatorStr(String str, ArrayList<Unite> liste_unite){
	   try{
		   int i = Integer.parseInt(str);
	   }catch(Exception e){
		   for(int j=0;j<liste_unite.size();j++){
			   if (str.compareTo(liste_unite.get(j).getNom())==0){
				   return false;
			   }
		   }
	   }
	System.out.println("<< Saisie incorrecte >>\n");
	return true;   
   }
   
   public static boolean Entry_validatorInt(double rep, String[] liste){
	   try{
		   if (rep >=0 &&rep<=liste.length){			   
			   return false;
		   }
	   }catch(Exception e){
			System.out.println("<< Saisie incorrecte >>\n");		   
		   return true;
	   }
	System.out.println("<< Saisie incorrecte >>\n");
	return true;   
   }
}