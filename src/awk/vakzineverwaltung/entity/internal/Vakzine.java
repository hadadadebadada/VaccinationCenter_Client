package awk.vakzineverwaltung.entity.internal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import awk.vakzineverwaltung.entity.BestandsveraenderungTO;
import awk.vakzineverwaltung.entity.VakzineTO;

public class Vakzine  implements Serializable{
	 private static final long serialVersionUID = -7558883996516598760L;
	private int vakzineId;
	private String name;
	private int lagerbestand;

	private Collection<Bestandsveraenderung> bestandsveraenderungen;
	
	
	public Vakzine(int vakzineId, String name) {
		super();
		this.vakzineId = vakzineId;
		this.name = name;
		this.lagerbestand = 0;
		bestandsveraenderungen = new ArrayList<Bestandsveraenderung>();
		
		// bei bank wird hier noch ein kunde dem konto zugeordenen und das konto registiert 
		
		// z.b 1 biontec 2. astra 3 johnson
		//this.lagerbestand = lagerbestand;
	}



//	public Vakzine(int vakzineId, int lagerbestand) {
//		super();
//		this.vakzineId = vakzineId; // z.b 1 biontec 2. astra 3 johnson
//		this.lagerbestand = lagerbestand;
//	}
	
	
//	public Vakzine toVakzine() throws AnwendungskernException{
//		
//		Vakzine vakzine = new Vakzine(this.vakzineId, this.name);
//		vakzine.setLagerbestand(this.lagerbestand);
//		for (Bestandsveraenderung bestandsveraenderungTO:this.bestandsveraenderungen) {
//			vakzine.getBestandsveraenderungen().add(
//					new Bestandsveraenderung(vakzine,bestandsveraenderungTO.getAnzahl()));
//		}
//		return vakzine;
//		
//	}
	
	
	
	//METHODE UM VAKZINE IN DER DB ZU SPEICHERN
	
//	public VakzineTO toVakzineTO() {
//		VakzineTO vakzineTO = new VakzineTO();
//		vakzineTO.setVakzineId(vakzineId);
//		vakzineTO.setLagerbestand(lagerbestand);
//		vakzineTO.setLiefertag(this.getDatum().getTag());
//		vakzineTO.setLiefermonat(this.getDatum().getMonat());
//		vakzineTO.setLieferjahr(this.getDatum().getJahr());
//		//bestandsveränderung fehlt
//		return vakzineTO;
//	}
	
	
	public VakzineTO toVakzineTO() {
		VakzineTO vakzineTO = new VakzineTO();
		vakzineTO.setVakzineId(vakzineId);
		vakzineTO.setLagerbestand(lagerbestand);
		vakzineTO.setName(name);
		vakzineTO.setBestandsveraenderungen(new ArrayList<BestandsveraenderungTO>());
		
		for (Bestandsveraenderung bestandsveraenderung:this.getBestandsveraenderungen()) {
			vakzineTO.getBestandsveraenderungen().add(new BestandsveraenderungTO(bestandsveraenderung.getAnzahl(), vakzineTO, bestandsveraenderung.getLiefertag(), bestandsveraenderung.getLiefermonat(), bestandsveraenderung.getLieferjahr()));
		}
		
		
		return vakzineTO;
		
	}

	public int getLagerbestand() {
		return lagerbestand;
	}
	
	public void addBestandsveraenderung(Bestandsveraenderung bestandsveraenderung) {
		this.bestandsveraenderungen.add(bestandsveraenderung);
	}
	public void setLagerbestand(int lagerbestand) {
		this.lagerbestand = lagerbestand;
	}
	public int getVakzineId() {
		return vakzineId;
	}
	public Collection<Bestandsveraenderung> getBestandsveraenderungen() {
		return bestandsveraenderungen;
	}


	
}
