package awk.terminverwaltung.type;

import java.io.Serializable;


public class Zeitpunkt extends Datum implements Serializable{

	private static final long serialVersionUID = 8937458934759873489L;
	private int std;
	private int min;
	
	public Zeitpunkt(int tag, int monat, int jahr, int std, int min) {
		super(tag, monat, jahr);
		this.std = std;
		this.min = min;
		
		// TODO Auto-generated constructor stub
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
	
	

}
