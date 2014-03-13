package unite_mesure;

import java.util.ArrayList;
import java.util.List;

public class Unite {
    public String nom;
    public type_unite type;
    public String system;
    public Quantite qte;
    public List<Conversion> liste_conversion = new ArrayList<Conversion> ();
   
    public Unite(){
        
    }
    public Unite(String nom,type_unite type,String system){
        this.nom=nom;
        this.type=type;
        this.system=system;
    }
    
    String getNom() {
        return this.nom;
    }

    void setNom(String value) {
        this.nom = value;
    }

    void setType(type_unite value) {
        this.type = value;
    }

    type_unite getType() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.type;
    }

    String getSystem() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.system;
    }

    void setSystem(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.system = value;
    }
    
    String toStringok(){
        return nom+"     "+type+"     "+system;
    }

    public List<Conversion> getListe_conversion() {
        return liste_conversion;
    }

    public void setListe_conversion(List<Conversion> liste_conversion) {
        this.liste_conversion = liste_conversion;
    }
    
}
