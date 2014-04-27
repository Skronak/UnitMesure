package com.unite_mesure;

import java.util.ArrayList;
import java.util.List;

public class Complexe extends AbstractConversion {
    public List<AbstractConversion> conversion = new ArrayList<AbstractConversion> ();

    public List<AbstractConversion> getConversion() {
        return conversion;
    }

    public void setConversion(List<AbstractConversion> conversion) {
        this.conversion = conversion;
    }
    
    public double calculer(double quantite){
        for(AbstractConversion each : conversion) {
    		quantite=each.calculer(quantite);
    	}
    	return quantite;
    }

    @Override
    public String toString() {
        return "Complexe{" + "conversion=" + conversion + '}';
    }


}
