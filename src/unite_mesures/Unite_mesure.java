package unite_mesures;

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
        Gestion_conversion g_c = new Gestion_conversion();
        int i,k;
        String nom,system;
        
        Unite unite2=new Unite("cm",null,"metrique");
        liste_unite.add(unite2);
        Unite unite3=new Unite("m",null,"metrique");
        liste_unite.add(unite3);
               
        do{
            System.out.println("\n1: Creer une unite");
            System.out.println("2: Afficher les unites disponibles");
            System.out.println("3: Effectuer une convertion");
            System.out.println("4: Creer une nouvelle convertion");
            System.out.println("5: Consulter les convertions disponibles");
            System.out.println("99: Quitter");
            i = sc.nextInt();
            
            //creer une unitee
            if(i==1){
                //recupere le nom de l'unitee
                System.out.println("Nom de l'unite:");
                nom=scan.nextLine();
                
                //recupere le type de l'unitee
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
                
                //instancie une unite
                Unite unite= new Unite(nom,type_unite.values()[k],system);
                
                //ajoute l'unitee cree à la liste des unitees
                System.out.println(liste_unite.add(unite));
            }
            else if (i==2){
                System.out.println("Nom     Type     System");
                for (int j=0; j<liste_unite.size();j++){
                    Unite ligne = liste_unite.get(j);
                    System.out.println(ligne.toStringok());
                    // afficher les conversion dispo ici
                }
            }else if (i==3){
                g_c.convertir(liste_unite);
            }else if (i==4){
            	g_c.creer_conversion(liste_unite);
	        }else if (i==5){
	            g_c.consulter_conversions(liste_unite);
	        }else if (i==6){
	        	System.out.println("Made by Darmon&Couturier");
	        }
        }while((i!=99));
        sc.close();
    }
}
