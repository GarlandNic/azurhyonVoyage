package com.azurhyon.azurhyonVoyage.dto;

public class LogementDto {
	
	private int confort = -10;
	private int tirageConfort = 0;
	private int variationQualite = 0;
	private int prix = -10;
	private int securite = -10;

	public int getConfort() {
		return confort;
	}

	public void setConfort(int confort) {
		this.confort = confort;
	}

	public int getTirageConfort() {
		return tirageConfort;
	}

	public void setTirageConfort(int tirageConfort) {
		this.tirageConfort = tirageConfort;
	}

	public int getVariationQualite() {
		return variationQualite;
	}

	public void setVariationQualite(int variationQualite) {
		this.variationQualite = variationQualite;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getSecurite() {
		return securite;
	}

	public void setSecurite(int securite) {
		this.securite = securite;
	}
	
	

}
