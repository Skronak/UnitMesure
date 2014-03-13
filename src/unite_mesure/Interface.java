
package unite_mesure;

import java.util.Scanner;

public class Interface {
    
    public void menu(){
        Scanner sc = new Scanner(System.in);
        int i;
        do{
            System.out.println("1: Créer une unité");
            System.out.println("2: Faire une convertion");
            i = sc.nextInt();
            
            //creer une unité
            if(i==1){
                
                
            }
        }while(i!=0);
        sc.close();
    }
  
}
