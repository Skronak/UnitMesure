package com.unite_mesure;

public class Addition extends AbstractConversion {
    public double valAdd;
    
    Addition(double valAdd){
        this.valAdd=valAdd;
    }
    
    double getValAdd() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.valAdd;
    }

    void setValAdd(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.valAdd = value;
    }
    
    public double calculer(double quantite){
    	return valAdd+quantite;
    }

    @Override
    public String toString() {
        return "Addition{" + "val_add=" + valAdd + '}';
    }


}
