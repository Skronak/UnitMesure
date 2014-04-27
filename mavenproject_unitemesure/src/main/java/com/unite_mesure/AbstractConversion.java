package com.unite_mesure;

abstract class AbstractConversion {
    private Unite uniteArrivee;

	public Unite getUniteArrivee() {
		return uniteArrivee;
	}

	public void setUniteArrivee(Unite uniteArrivee) {
		this.uniteArrivee = uniteArrivee;
	}
        public String getNomUniteArrivee() {
		return this.getUniteArrivee().getNom();
	}
	abstract double calculer(double quantite);
        
}
