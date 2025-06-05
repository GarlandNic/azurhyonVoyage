package com.azurhyon.azurhyonVoyage.dto;

public class EvenementDto {
	
	private int de200 = 0;
	private int de100 = 0;
	private String nom = "";
	private String description = "";
	
	public EvenementDto(int de200, int de100) {
		this.de200 = de200;
		this.de100 = de100;
	}
	public int getDe200() {
		return de200;
	}
	public void setDe200(int de200) {
		this.de200 = de200;
	}
	public int getDe100() {
		return de100;
	}
	public void setDe100(int de100) {
		this.de100 = de100;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
