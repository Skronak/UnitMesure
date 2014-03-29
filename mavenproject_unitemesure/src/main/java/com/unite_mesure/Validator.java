package com.unite_mesure;

import java.util.ArrayList;
import java.util.List;

public class Validator {
	/**
	 *
	 * @author Alex&Guillaume
	 * Maj: 20/03/2014 :23.57.00
	 */

  /* *************** Validation des saisies utilisateurs****************
   * 	Retourne false si la saisie correspond � une unite existante
   * 	Retourne un message si la saisie n'est pas un string
   * *********************************************************************/   
	public boolean Entry_validatorStr(String str, List<Unite> liste_unite) {
		   try{			   
			   for(int j=0;j<liste_unite.size();j++) {
				   if (str.compareTo(liste_unite.get(j).getNom())==0) {
					   return false;
				   }
			   }
		   }catch(Exception e) {
			   System.out.println("<< Saisie incorrecte >>\n");
			   return true;   
		   }
		   return true;
	   }
	
	  /* *************** Validation des saisies utilisateurs* ***************
	   * 	Reuperation de la saisie utilisateur
	   * 	Retourne true si la saisie correspond aux choix propos�s
	   * 	Retourne un message si la saisie n'est pas correcte
	   * *********************************************************************/   
	   public static boolean Entry_validatorInt(double rep, String[] liste) {
		   
		   try {
			   if (rep >=0 &&rep<=liste.length) {			   
				   return false;
			   }
		   } catch(Exception e) {
				System.out.println("<< Saisie incorrecte >>\n");		   
				return true;
		   }
			System.out.println("<< Saisie incorrecte >>\n");
			return true;   
	   }

	   /* *************** Validation de l'existence d'une unite ***************
	    * 	Retourne true si la saisie correspond � une unite existante dans le programme
	    * *********************************************************************/   
		public boolean Unite_existe(String str, ArrayList<Unite> liste_unite) {

			for(int j=0;j<liste_unite.size();j++) {
				if (str.compareTo(liste_unite.get(j).getNom())==0) {
						   return true;
				}
			}
			return false;
		}
		
		/* *************** Validation de l'existence d'une conversion ***************
		* 	Parcours de la liste unite du programme pour trouver l'objet correspond a unite1
		* 	Parcours de la liste conversion de l'unite1 puis parcours de toute les unit�s d'arrivee des conversions
		* 	Si l'unite d'arrivee correspond � unite2 on renvoie true
	    *********************************************************************/   
		public boolean conversionExiste(String unite1, String unite2, List<Unite> liste_unite) {
			assert liste_unite != null : "Null list unite";
			
//			for(Unite each : liste_unite) {				
//			}
			for (int j=0;j<liste_unite.size();j++) {
				if (liste_unite.get(j).getNom().compareTo(unite1)==0) {
					//On parcours la liste de conversion disponible pour cette unite
					
					for (int k=0;k<liste_unite.get(j).getListe_conversion().size();k++) {
						// Si on a trouv� la conversion reliant l'unit� d'arrivee de depart et d'arrivee on initialise le tableau
						if (liste_unite.get(j).getListe_conversion().get(k).getUniteArrivee().getNom().compareTo(unite2)==0) {
							return true;
						}
					}
				}			
			}
			return false;
		}
}