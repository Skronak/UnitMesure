package unite_mesure;

import java.util.ArrayList;
import java.util.List;

public class Complexe extends Conversion {
    public List<Conversion> conversion = new ArrayList<Conversion> ();

    public List<Conversion> getConversion() {
        return conversion;
    }

    public void setConversion(List<Conversion> conversion) {
        this.conversion = conversion;
    }
    
    public double calculer(double quantite){
    	for(int i=0;i<conversion.size();i++){
    		quantite=conversion.get(i).calculer(quantite);
    	}
    	return quantite;
    }


}
