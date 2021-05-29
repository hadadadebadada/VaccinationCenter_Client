package awk.patientenverwaltung.entity;

import java.io.Serializable;

public class PatientTO implements Serializable {

	private static final long serialVersionUID = 5322225081307882380L;
	public int patientenID;
	public String name;
	public String nachname;
	public int geburtstag;
	public int geburtsmonat;
	public int geburtsjahr;
	public String email;
	public int telefonNr;

	public int getGeburtstag() {
		return geburtstag;
	}

	public void setGeburtstag(int geburtstag) {
		this.geburtstag = geburtstag;
	}

	public int getGeburtsmonat() {
		return geburtsmonat;
	}

	public void setGeburtsmonat(int geburtsmonat) {
		this.geburtsmonat = geburtsmonat;
	}

	public int getGeburtsjahr() {
		return geburtsjahr;
	}

	public void setGeburtsjahr(int geburtsjahr) {
		this.geburtsjahr = geburtsjahr;
	}

	public int getPatientenID() {
		return patientenID;
	}

	public void setPatientenID(int patientenID) {
		this.patientenID = patientenID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefonNr() {
		return telefonNr;
	}

	public void setTelefonNr(int telefonNr) {
		this.telefonNr = telefonNr;
	}

	@Override
	public String toString() {
		return patientenID + " " + name + " " + " " + nachname;
	}

}
