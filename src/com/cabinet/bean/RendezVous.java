package com.cabinet.bean;

public class RendezVous {
	
	private String date;
	private int prix;
	private String type;
	
	
	public RendezVous(String date, int prix, String type) {
		this.date = date;
		this.prix = prix;
		this.type = type;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
