package com.unite_mesure;

public class Multiplication extends AbstractConversion {
	/**
	 *
	 * @author Alex&Guillaume
	 * Maj: 07/03/2014 :18.15.00
	 */

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
