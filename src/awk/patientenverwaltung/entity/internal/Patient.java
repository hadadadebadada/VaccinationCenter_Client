package awk.patientenverwaltung.entity.internal;
import java.io.Serializable;

import awk.AnwendungskernException;
import awk.patientenverwaltung.entity.PatientTO;
import awk.patientenverwaltung.type.Datum;

public class Patient implements Serializable{
	
	private static final long serialVersionUID = -1791762923927701475L;
	
	 private int patientenID;
	 private String name;
	 private String nachname;
	 private Datum datum;
	 private String email;
	 private int telefonNr;
	 
	 
	 
	 
	public Patient(int patientenID, String name, String nachname, Datum datum, String email, int telefonNr) throws AnwendungskernException {
		super();
		this.patientenID = patientenID;
		this.name = name;
		this.nachname = nachname;
		this.datum = datum;
		this.email = email;
		this.telefonNr = telefonNr;
	}
	
	public PatientTO toPatientTO() {
		PatientTO patientTO = new PatientTO();
		patientTO.getPatientenID();
		patientTO.getName();
		patientTO.getNachname();
		patientTO.getGeburtstag();
		patientTO.getGeburtsmonat();
		patientTO.getGeburtsjahr();
		patientTO.getEmail();
		patientTO.getTelefonNr();
		return patientTO;
		
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
	public Datum getDatum() {
		return datum;
	}
	public void setDatum(Datum datum) {
		this.datum = datum;
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
	 
	 
}
