package awk.vakzineverwaltung.entity.internal;

import java.io.Serializable;




public class Bestandsveraenderung implements Serializable {

	private static final long serialVersionUID = -3130735335614620677L;

	private int anzahl;
	private Vakzine vakzine;
	int liefertag;
	int liefermonat;
	int lieferjahr;

	public Bestandsveraenderung(int anzahl, Vakzine vakzine, int liefertag, int liefermonat, int lieferjahr) {

		this.anzahl = anzahl;
		this.vakzine = vakzine;
		this.liefertag = liefertag;
		this.liefermonat = liefermonat;
		this.lieferjahr = lieferjahr;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	public Vakzine getVakzine() {
		return vakzine;
	}

	public void setVakzine(Vakzine vakzine) {
		this.vakzine = vakzine;
	}

	public int getLiefertag() {
		return liefertag;
	}

	public void setLiefertag(int liefertag) {
		this.liefertag = liefertag;
	}

	public int getLiefermonat() {
		return liefermonat;
	}

	public void setLiefermonat(int liefermonat) {
		this.liefermonat = liefermonat;
	}

	public int getLieferjahr() {
		return lieferjahr;
	}

	public void setLieferjahr(int lieferjahr) {
		this.lieferjahr = lieferjahr;
	}

}
