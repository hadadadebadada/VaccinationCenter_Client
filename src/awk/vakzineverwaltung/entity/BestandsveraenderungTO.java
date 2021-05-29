package awk.vakzineverwaltung.entity;

import java.io.Serializable;


public class BestandsveraenderungTO implements Serializable{
	

	private static final long serialVersionUID = -3130735335614620677L;
	
	 int anzahl;
	 VakzineTO vakzineTO;
	 
	 int liefertag;
	 int liefermonat;
	 int lieferjahr;
	 
	 
	 
	



	public BestandsveraenderungTO( int anzahl, VakzineTO vakzineTO, int liefertag, int liefermonat , int lieferjahr) {
			this.anzahl = anzahl;
			this.vakzineTO= vakzineTO;
			this.liefertag = liefertag;
			this.liefermonat = liefermonat;
			this.lieferjahr = lieferjahr;
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
		public int getAnzahl() {
			return anzahl;
		}
		public void setAnzahl(int anzahl) {
			this.anzahl = anzahl;
		}
		public VakzineTO getVakzineTO() {
			return vakzineTO;
		}



		public void setVakzineTO(VakzineTO vakzineTO) {
			this.vakzineTO = vakzineTO;
		}
		
		
	
}

