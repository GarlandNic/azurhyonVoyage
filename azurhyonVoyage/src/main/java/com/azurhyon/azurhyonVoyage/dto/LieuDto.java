package com.azurhyon.azurhyonVoyage.dto;

public class LieuDto {
	
	private int de8 = 0;
	private int de30 = 0;
	private String nom = "";
	private String description = "";
	
	public LieuDto(int de8, int de30) {
		this.de8 = de8;
		this.de30 = de30;
	}
	public int getDe8() {
		return de8;
	}
	public void setDe8(int de8) {
		this.de8 = de8;
	}
	public int getDe30() {
		return de30;
	}
	public void setDe30(int de30) {
		this.de30 = de30;
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
