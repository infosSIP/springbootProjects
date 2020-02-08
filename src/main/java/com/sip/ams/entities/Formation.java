package com.sip.ams.entities;

public class Formation {
	private int id;
	private String libelle;
	private double heures;
	private String language;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getHeures() {
		return heures;
	}

	public void setHeures(double heures) {
		this.heures = heures;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Formation(int id,String lib, double h, String lan)
	{
		this.id = id;
		this.libelle = lib;
		this.heures = h;
		this.language = lan;
		
	}
}
