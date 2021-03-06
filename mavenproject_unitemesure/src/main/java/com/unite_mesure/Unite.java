package com.unite_mesure;

import java.util.ArrayList;
import java.util.List;

public class Unite {
	/**
	 *
	 * @author Alex&Guillaume
	 * Maj: 17/03/2014 :08.07.00
	 */
	// cm,dm,
    private String nom;
    // volume etc
    private TypeUnite type;
    private Quantite qte;
    private List<AbstractConversion> listeConversion = new ArrayList<AbstractConversion> ();
   
    public Unite(){
        
    }
    public Unite(String nom,TypeUnite type){
        this.nom=nom;
        this.type=type;
    }
    
    public String getNom() {
        return this.nom;
    }

    void setNom(String value) {
        this.nom = value;
    }

    void setType(TypeUnite value) {
        this.type = value;
    }

    public TypeUnite getType() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.type;
    }
    
    @Override
    public String toString(){
        return nom+"     "+type;
    }

	public Quantite getQte() {
		return qte;
	}

	public void setQte(Quantite qte) {
		this.qte = qte;
	}

	public List<AbstractConversion> getListeConversion() {
		return listeConversion;
	}

	public void setListeConversion(List<AbstractConversion> listeConversion) {
		this.listeConversion = listeConversion;
	}
        public void addOperationListConversion(AbstractConversion conv) {
		this.getListeConversion().add(conv);
	}
        public int isEmpty() {
		return this.getListeConversion().size();
	}
}
