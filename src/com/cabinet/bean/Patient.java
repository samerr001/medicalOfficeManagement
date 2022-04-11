package com.cabinet.bean;

import java.util.Vector;

public class Patient {
	
	private int cin;
	private String nom;
	private String prenom;
	private String dateNaissance;
	private int mobile;
	private String email;
	private String address;
	private String metier;
	private String gender;
	private String maladie;
	private Vector<RendezVous> rendezVous;
	
	public Patient(int cin, String nom, String prenom, String dateNaissance, int mobile, String email, String address,
			String metier, String gender, String maladie, Vector<RendezVous> rendezVous) {
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.metier = metier;
		this.gender = gender;
		this.maladie = maladie;
		this.rendezVous = rendezVous;	
	}
	
	public Patient(int cin, String nom, String prenom, String dateNaissance, int mobile, String email, String address,
			String metier, String gender) {
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.metier = metier;
		this.gender = gender;
		this.maladie = "inidentifie";
		this.rendezVous = new Vector<RendezVous>();
	}
	
	public Patient(int cin, String nom, String prenom, String dateNaissance, int mobile, String email, String address,
			String metier, String gender, Vector<RendezVous> rendezVous) {
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.metier = metier;
		this.gender = gender;
		this.maladie = "inidentifie";
		this.rendezVous = rendezVous;
	}
	
	public Patient(int cin, String nom, String prenom, String dateNaissance, int mobile, String email, String address,
			String metier, String gender, String maladie) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.metier = metier;
		this.gender = gender;
		this.maladie = maladie;
		this.rendezVous = new Vector<RendezVous>();
	}

	public Patient(){
		this.rendezVous = new Vector<RendezVous>();
	}

	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMetier() {
		return metier;
	}
	public void setMetier(String metier) {
		this.metier = metier;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaladie() {
		return maladie;
	}
	public void setMaladie(String maladie) {
		this.maladie = maladie;
	}
	public Vector<RendezVous> getRendezVous() {
		return rendezVous;
	}
	public void setRendezVous(Vector<RendezVous> rendezVous) {
		this.rendezVous = rendezVous;
	}
	public void AppendeRendezVous(RendezVous r) {
		this.rendezVous.add(r);
	}
	public void resetRendezVous() {
		this.rendezVous = new Vector<RendezVous>();
	}
}

