package unite_mesures;

public class Addition extends Conversion {
    public double val_add;
    
    Addition(double val_add){
        this.val_add=val_add;
    }
    
    double getVal_add() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.val_add;
    }

    void setVal_add(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.val_add = value;
    }
    
    public double calculer(double quantite){
    	return val_add+quantite;
    }

    @Override
    public String toString() {
        return "Addition{" + "val_add=" + val_add + '}';
    }


}
