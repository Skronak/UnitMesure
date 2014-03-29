package com.unite_mesure;

abstract class Conversion {
    private Unite unite_arrivee;

	public Unite getUniteArrivee() {
		return unite_arrivee;
	}

	public void setUniteArrivee(Unite unite_arrivee) {
		this.unite_arrivee = unite_arrivee;
	}
	abstract double calculer(double quantite);

}
