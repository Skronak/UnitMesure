package unite_mesures;

public class Multiplication extends Conversion {
    public double taux;
    
    Multiplication(double taux){
        this.taux=taux;
     }
    
    double getTaux() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.taux;
    }

    void setTaux(double value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.taux = value;
    }
    
    public double calculer(double quantite){
    	return taux*quantite;
    }

    @Override
    public String toString() {
        return "Multiplication{" + "taux=" + taux + '}';
    }

}
