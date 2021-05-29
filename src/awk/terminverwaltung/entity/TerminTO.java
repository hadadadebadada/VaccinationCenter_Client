package awk.terminverwaltung.entity;

import java.io.Serializable;

import awk.AnwendungskernException;
import awk.terminverwaltung.entity.internal.Termin;

public class TerminTO implements Serializable {

	static final long serialVersionUID = 5322225081307882380L;
	public int terminID;
	public int impftag;
	public int impfmonat;
	public int impfjahr;
	public int std;
	public int min;
	public String bemerkung;
	public int vakzineID;
	public int patientenID;

	public Termin toTerminTO() throws AnwendungskernException {
		Termin termin = new Termin(this.terminID, this.impftag, this.impfmonat, this.impfjahr, this.std, this.min,
				this.bemerkung, this.vakzineID, patientenID);

		return termin;

	}

	public int getVakzineID() {
		return vakzineID;
	}

	public void setVakzineID(int vakzineID) {
		this.vakzineID = vakzineID;
	}

	public int getStd() {
		return std;
	}

	public void setStd(int std) {
		this.std = std;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
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

	public int getImpftag() {
		return impftag;
	}

	public void setImpftag(int impftag) {
		this.impftag = impftag;
	}

	public int getImpfmonat() {
		return impfmonat;
	}

	public void setImpfmonat(int impfmonat) {
		this.impfmonat = impfmonat;
	}

	public int getImpfjahr() {
		return impfjahr;
	}

	public void setImpfjahr(int impfjahr) {
		this.impfjahr = impfjahr;
	}

}
