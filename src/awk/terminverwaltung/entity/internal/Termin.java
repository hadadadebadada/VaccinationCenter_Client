package awk.terminverwaltung.entity.internal;

import java.io.Serializable;

import awk.terminverwaltung.entity.TerminTO;
import awk.terminverwaltung.type.Zeitpunkt;

public class Termin implements Serializable {

	private static final long serialVersionUID = 5322225081307882380L;
	private int terminID;
	private Zeitpunkt zeitpunkt; // mit uhrzeit
	private String bemerkung;
	private int vakzineID;
	private int patientenID; // ref zum patienten

	public Termin(int terminID, int tag, int monat, int jahr, int std, int min, String bemerkung, int vakzineID,
			int patientenID) {

		this.terminID = terminID;
		this.zeitpunkt = new Zeitpunkt(tag, monat, jahr, std, min);
		this.bemerkung = bemerkung;
		this.vakzineID = vakzineID;
		this.patientenID = patientenID;

	}

	public Termin(TerminTO terminTO) {
		this.terminID = terminTO.getPatientenID();
		this.zeitpunkt = new Zeitpunkt(terminTO.getImpftag(), terminTO.getImpfmonat(), terminTO.getImpfjahr(),
				terminTO.getStd(), terminTO.getMin());
		this.bemerkung = terminTO.getBemerkung();
		this.vakzineID = terminTO.getVakzineID();
		this.patientenID = terminTO.getPatientenID();

	}

	public TerminTO toTerminTO() {
		TerminTO terminTO = new TerminTO();
		terminTO.setTerminID(this.terminID);
		terminTO.setImpftag(this.getZeitpunkt().getTag());
		terminTO.setImpfmonat(this.getZeitpunkt().getMonat());
		terminTO.setImpfjahr(this.getZeitpunkt().getJahr());
		terminTO.setStd(this.getZeitpunkt().getStd());
		terminTO.setMin(this.getZeitpunkt().getMin());
		terminTO.setBemerkung(this.bemerkung);
		terminTO.setVakzineID(this.vakzineID);
		terminTO.setPatientenID(this.patientenID);

		return terminTO;

	}

	public int getVakzineID() {
		return vakzineID;
	}

	public void setVakzineID(int vakzineID) {
		this.vakzineID = vakzineID;
	}

	public String getBemerkung() {
		return bemerkung;
	}

	public void setBemerkung(String bemerkung) {
		this.bemerkung = bemerkung;
	}

	public int getPatientenID() {
		return patientenID;
	}

	public void setPatientenID(int patientenID) {
		this.patientenID = patientenID;
	}

	public int getTerminID() {
		return terminID;
	}

	public void setTerminID(int terminID) {
		this.terminID = terminID;
	}

	public Zeitpunkt getZeitpunkt() {
		return zeitpunkt;
	}

	public void setZeitpunkt(Zeitpunkt zeitpunkt) {
		this.zeitpunkt = zeitpunkt;
	}

//	public boolean equals (Object o) {
//		Kunde k = (Kunde) o; 
//		return this.nachname.equalsIgnoreCase(k.nachname) 
//		&& this.vorname.equalsIgnoreCase(k.vorname) && this.adresse.equals(k.adresse);
//	}

}
