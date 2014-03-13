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
    

}
