
package unite_mesure;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class Unite_mesure {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       ArrayList <Unite> liste_unite =new ArrayList();
       menu(liste_unite);
    }
    
    public static void menu(ArrayList <Unite> liste_unite){
        Scanner sc = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        int i,k;
        String nom,system;
       
        do{
            System.out.println("1: Créer une unité");
            System.out.println("2: Afficher les unités");
            System.out.println("3: Faire une convertion");
            System.out.println("99: Quitter");
            i = sc.nextInt();
            
            //creer une unité
            if(i==1){
                //recupere le nom de l'unité
                System.out.println("Nom de l'unité:");
                nom=scan.nextLine();
                
                //recupere le type de l'unité
                System.out.println("Type de l'unité:");
                k=0; 
                for(type_unite type: type_unite.values()){
                      System.out.println(k+":"+ type);
                      k++;
                }
                k=sc.nextInt();
                
                //recupere le nom du system
                System.out.println("Nom du system (métrique/impériale):");
                system=scan.nextLine();
                
                //instancie une unité
                Unite unite= new Unite(nom,type_unite.values()[k],system);
                
                //ajoute l'unité créée à la liste des unités
                System.out.println(liste_unite.add(unite));
            }
            else if (i==2){
                System.out.println("Nom     Type     System");
                for (int j=0; j<liste_unite.size();j++){
                    Unite ligne = liste_unite.get(j);
                    System.out.println(ligne.toStringok());
                }
            }else if (i==3){
                conversion(liste_unite);
            }
        }while(i!=99);
        sc.close();
    }
    
    public static void conversion(ArrayList <Unite> liste_unite) {
    	
    	Scanner sc = new Scanner(System.in);
	    // R�cuperation des donn�es utilisateur
		System.out.println("Conversion d'unite");		
		
		System.out.println("Selectionner l'unit� de d�part");
		for (int j=0;j<liste_unite.size();j++) {
			System.out.println(liste_unite.get(j).getNom());
		}		
		String rep_type_depart = sc.nextLine();
	
		System.out.println("Quantit� :");
		double rep_quantite_depart = sc.nextDouble();
	
		System.out.println("Selectionner l'unit� de d'arriv�");
		for (int j=0;j<liste_unite.size();j++) {
			System.out.println(liste_unite.get(j).getNom());
		}
		String rep_type_arrivee = sc.nextLine();
	
		// D�but de la conversion
		for (int j=0;j<liste_unite.size();j++) {
			if (liste_unite.get(j).getNom()==rep_type_depart){	
//				for (int k=0;k<liste_conversion.size();k++) {
//					if (liste_conversion.get(j).getUnite().getNom()==rep_type_arrivee){	
						//traitement
//					}
//				}
			}
		}		
  }   
}
