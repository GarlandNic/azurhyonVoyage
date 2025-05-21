package com.azurhyon.azurhyonVoyage.dto;

public class BashDto {
	
	private int jet = 0;
	private int gravite = 0;
	private int peril = 0;
	private int deEvnmt = 0;
	private boolean critique = false;
	private boolean bash = false;
	private String effet = "";
	private String monstre = "";

	public int getJet() {
		return jet;
	}
	public void setJet(int jet) {
		this.jet = jet;
	}
	public int getGravite() {
		return gravite;
	}
	public void setGravite(int gravite) {
		this.gravite = gravite;
	}
	public int getPeril() {
		return peril;
	}
	public void setPeril(int peril) {
		this.peril = peril;
	}
	public boolean isCritique() {
		return critique;
	}
	public void setCritique(boolean critique) {
		this.critique = critique;
	}
	public boolean isBash() {
		return bash;
	}
	public void setBash(boolean bash) {
		this.bash = bash;
	}
	public String getEffet() {
		return effet;
	}
	public void setEffet(String effet) {
		this.effet = effet;
	}
	public String getMonstre() {
		return monstre;
	}
	public void setMonstre(String monstre) {
		this.monstre = monstre;
	}
	public int getDeEvnmt() {
		return deEvnmt;
	}
	public void setDeEvnmt(int deEvnmt) {
		this.deEvnmt = deEvnmt;
	}

}
