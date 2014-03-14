/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unite_mesure;

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
	    // R�cuperation des donn�es utilisateur
		System.out.println("Conversion d'unite");		
		
		System.out.println("Selectionner l'unite de depart");
		for (int j=0;j<liste_unite.size();j++) {
			System.out.println(liste_unite.get(j).getNom());
		}		
		String rep_type_depart = sc.nextLine();
                
                //Creation de l'unité de depart à partir de la chaine de caractéres
                Unite unite_depart=new Unite();
                for (int j=0;j<liste_unite.size();j++) {
			if(liste_unite.get(j).getNom().compareTo(rep_type_depart)==0){
                            unite_depart=liste_unite.get(j);
                            j=liste_unite.size();
                        }
		}
	
		System.out.println("Selectionner l'unite de d'arrivee");
		for (int j=0;j<liste_unite.size();j++) {
			System.out.println(liste_unite.get(j).getNom());
		}
		String rep_type_arrivee = sc.nextLine();
                
                //Creation de l'unité de d'arrivee à partir de la chaine de caractéres
                Unite unite_arrivee=new Unite();
                for (int j=0;j<liste_unite.size();j++) {
			if(liste_unite.get(j).getNom().compareTo(rep_type_arrivee)==0){
                            unite_arrivee=liste_unite.get(j);
                            j=liste_unite.size();
                        }
		}
                //quel opération lie les deux unités
                System.out.println("Quelle opération voulez effectuer pour lier "+unite_depart.getNom()+" à "+unite_arrivee.getNom()+":");
                System.out.println("1 Multiplication");
                System.out.println("2 Addition");
                System.out.println("3 Operation complexe");
                System.out.println("Selectinnez le numero correspondant");
		double rep = sc.nextDouble();
                
                //Multiplication
                if(rep==1){
                    System.out.println("Quel est le nombre par lequel vous voulez multiplier (/10=> 0,1)");
                    double taux = sc.nextDouble();
                    Multiplication multiplication= new Multiplication(taux);
                    multiplication.setUniteArrivee(unite_arrivee);
                    System.out.println("Taux :"+multiplication.toString());
                    System.out.println("Unite d'arrive :"+multiplication.getUniteArrivee().toString());
                    //ArrayList <Conversion> l=(ArrayList <Conversion>) unite_depart.getListe_conversion();
                    //l.add(multiplication);
                    unite_depart.getListe_conversion().add(multiplication);
                }
                //Addition
                else if(rep==2){
                    System.out.println("Quel est le nombre par lequel vous voulez additioner (/10=> 0,1)");
                    double val_add = sc.nextDouble();
                    Addition addition=new Addition(val_add);
                    addition.setUniteArrivee(unite_arrivee);
                    unite_depart.getListe_conversion().add(addition);
                }
                //Complexe
                else if(rep==3){
                    int i=0;
                    
                    //permet de savoir si il y a eu une operation de renseigné
                    boolean conv=false;
                    //Creation objet complexe
                    Complexe complexe=new Complexe();
                    //initialisation d'une liste de conversion
                    List<Conversion> list_conv= new ArrayList<Conversion>();
                    double rep2;
                    do{
                        //menu complexe
                        System.out.println("Quelle opération voulez effectuer pour lier "+unite_depart.getNom()+" à "+unite_arrivee.getNom()+":");
                        System.out.println("1 Multiplication");
                        System.out.println("2 Addition");
                        System.out.println("99 Valider et quitter");
                        System.out.println("Selectinnez le numero correspondant");
                        rep2 = sc.nextDouble();
                        
                       
                        
                        
                        //Multiplication
                        if(rep2==1){
                            System.out.println("Quel est le nom par lequel vous voulez multiplier (/10=> 0,1)");
                            double taux = sc.nextDouble();
                            Multiplication multiplication= new Multiplication(taux);
                            list_conv.add(multiplication);
                            conv=true;
                            
                        }
                        //Addition
                        else if(rep2==2){
                            System.out.println("Quel est le nom par lequel vous voulez multiplier (/10=> 0.1)");
                            double val_add = sc.nextDouble();
                            Addition addition=new Addition(val_add);
                            list_conv.add(addition);
                            conv=true;
                        }
                    }while(rep2!=99);
                    //si il y a eu une opération renseigné
                    if(conv){
                        //on met la liste de conversions dans l'objet
                        complexe.setConversion(list_conv);
                        complexe.setUniteArrivee(unite_arrivee);
                        unite_depart.getListe_conversion().add(complexe);
                    }
                } 
   }
}
