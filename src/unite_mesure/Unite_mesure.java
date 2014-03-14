
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
        Gestion_conversion creation = new Gestion_conversion();
        int i,k;
        String nom,system;
        
        Unite unite2=new Unite("cm",null,"metrique");
        liste_unite.add(unite2);
        Unite unite3=new Unite("m",null,"metrique");
        liste_unite.add(unite3);
        
       
        do{
            System.out.println("1: Créer une unite");
            System.out.println("2: Afficher les unités");
            System.out.println("3: Faire une convertion");
            System.out.println("4: Creer une convertion");
            System.out.println("99: Quitter");
            i = sc.nextInt();
            
            //creer une unité
            if(i==1){
                //recupere le nom de l'unité
                System.out.println("Nom de l'unite:");
                nom=scan.nextLine();
                
                //recupere le type de l'unité
                System.out.println("Type de l'unite:");
                k=0; 
                for(type_unite type: type_unite.values()){
                      System.out.println(k+":"+ type);
                      k++;
                }
                k=sc.nextInt();
                
                //recupere le nom du system
                System.out.println("Nom du system (metrique/imperiale):");
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
                convertir(liste_unite);
            }else if (i==4){
                creation.creer_conversion(liste_unite);
            }
        }while(i!=99);
        sc.close();
    }
    
    //Demande les informations � l'utilisateur et verifie qu'il y a une conversion qui existe entre les deux
    public static Object[] getInformations(ArrayList <Unite> liste_unite) {
    	Unite unite_depart;
    	Unite unite_arrivee;
    	Object[]valeurs={null,null,null};
    	
    	Scanner sc = new Scanner(System.in);

	    // R�cuperation des donn�es utilisateur
		System.out.println("Conversion d'unite");		
		
		System.out.println("Selectionner l'unite de depart");
		for (int j=0;j<liste_unite.size();j++) {
			System.out.println(liste_unite.get(j).getNom());
		}		
		String rep_nom_depart = sc.nextLine();
		
		System.out.println("Selectionner l'unit� de d'arrivee");
		for (int j=0;j<liste_unite.size();j++) {
			System.out.println(liste_unite.get(j).getNom());
		}
		String rep_nom_arrivee = sc.nextLine();
		
		// D�but de la conversion
		for (int j=0;j<liste_unite.size();j++) {
			unite_depart=liste_unite.get(j);
			
			if (unite_depart.getNom().compareTo(rep_nom_depart)==0){
				valeurs[0]=unite_depart;
				//On parcours la liste de conversion disponible pour cette unit�
				for (int k=0;k<unite_depart.getListe_conversion().size();k++) {
						unite_arrivee = unite_depart.getListe_conversion().get(j).getUniteArrivee();
					// Si on a trouv� la conversion reliant l'unit� d'arriv� de d�part et d'arriv� on initialise le tableau
					if (unite_arrivee.getNom().compareTo(rep_nom_arrivee)==0){
						valeurs[1]=unite_depart.getListe_conversion().get(j);
						valeurs[2]=unite_arrivee;
					}
				}
			}
		}
		return valeurs;
		
    }
    
    
    public static void convertir(ArrayList <Unite> liste_unite){
        Scanner sc = new Scanner(System.in);      
    	double quantite;
        double quantiteArr;
    	Object[] valeurs;
        System.out.println("Quantite a convertir:");
	quantite = sc.nextDouble();
    	valeurs=getInformations(liste_unite);
    	if (valeurs[1]!=null){ 	
	    	quantiteArr=((Conversion) valeurs[1]).calculer(quantite);
                System.out.println(quantiteArr);
    	}
    }
}
