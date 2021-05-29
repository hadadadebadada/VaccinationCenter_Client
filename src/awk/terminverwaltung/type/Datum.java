package awk.terminverwaltung.type;

import java.io.Serializable;


public class Datum implements Serializable{
	
	private static final long serialVersionUID = 5668483573431584941L;
	
	private int tag;
	private int monat;
	private int jahr;
	
//	private int stunde;
//
//
//	private int minute;



	public Datum(int tag, int monat, int jahr) {
		super();
		this.tag = tag;
		this.monat = monat;
		this.jahr = jahr;
//		this.stunde = stunde;
//		this.minute = minute;
	}

	public int getMonat() {
		return monat;
	}

	public int getJahr() {
		return jahr;
	}
	public int getTag() {
		return tag;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + jahr;

		result = prime * result + monat;

		result = prime * result + tag;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Datum other = (Datum) obj;
		if (jahr != other.jahr)
			return false;

		if (monat != other.monat)
			return false;

		if (tag != other.tag)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Datum [tag=" + tag + ", monat=" + monat + ", jahr=" + jahr + ", stunde="  + ", minute=" 
				+ "]";
	}
	
	




}
