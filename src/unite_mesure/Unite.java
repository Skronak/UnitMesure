package unite_mesure;

import java.util.ArrayList;
import java.util.List;

public class Unite {
	// cm,dm,
    private String nom;
    // volume etc
    private type_unite type;
    // imperial, metrique
    private String system;
    private Quantite qte;
    private List<Conversion> liste_conversion = new ArrayList<Conversion> ();
   
    public Unite(){
        
    }
    public Unite(String nom,type_unite type,String system){
        this.nom=nom;
        this.type=type;
        this.system=system;
    }
    
    public String getNom() {
        return this.nom;
    }

    void setNom(String value) {
        this.nom = value;
    }

    void setType(type_unite value) {
        this.type = value;
    }

    public type_unite getType() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.type;
    }

    public String getSystem() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.system;
    }

    void setSystem(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.system = value;
    }
    
    public String toStringok(){
        return nom+"     "+type+"     "+system;
    }

	public Quantite getQte() {
		return qte;
	}

	public void setQte(Quantite qte) {
		this.qte = qte;
	}

	public List<Conversion> getListe_conversion() {
		return liste_conversion;
	}

	public void setListe_conversion(List<Conversion> liste_conversion) {
		this.liste_conversion = liste_conversion;
	}

    @Override
    public String toString() {
        return "Unite{" + "nom=" + nom + ", type=" + type + ", system=" + system + ", qte=" + qte + ", liste_conversion=" + liste_conversion + '}';
    }

}
