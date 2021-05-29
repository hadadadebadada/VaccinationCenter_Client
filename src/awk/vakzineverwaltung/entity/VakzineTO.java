package awk.vakzineverwaltung.entity;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import awk.AnwendungskernException;
import awk.vakzineverwaltung.entity.internal.Bestandsveraenderung;
import awk.vakzineverwaltung.entity.internal.Vakzine;



public class VakzineTO implements Serializable {
	
	private static final long serialVersionUID = -7558883996516598760L;
	private int vakzineId;
	private String name;
	private int lagerbestand;
	private Collection<BestandsveraenderungTO> bestandsveraenderungen;

	public Vakzine toVakzine() throws AnwendungskernException {

		Vakzine vakzine = new Vakzine(this.vakzineId, this.name);
		vakzine.setLagerbestand(this.lagerbestand);
		
		for (BestandsveraenderungTO bestandsveraenderungTO : this.bestandsveraenderungen) 
			vakzine.getBestandsveraenderungen().add(new Bestandsveraenderung(bestandsveraenderungTO.getAnzahl(),vakzine, bestandsveraenderungTO.getLiefertag(), bestandsveraenderungTO.getLiefermonat(), bestandsveraenderungTO.getLieferjahr()));
		

		return vakzine;

	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVakzineId() {
		return vakzineId;
	}

	public void setVakzineId(int vakzineId) {
		this.vakzineId = vakzineId;
	}

	public int getLagerbestand() {
		return lagerbestand;
	}

	public void setLagerbestand(int lagerbestand) {
		this.lagerbestand = lagerbestand;
	}

	public Collection<BestandsveraenderungTO> getBestandsveraenderungen() {
		return bestandsveraenderungen;
	}

	public void setBestandsveraenderungen(Collection<BestandsveraenderungTO> bestandsveraenderungen) {
		this.bestandsveraenderungen = bestandsveraenderungen;
	}

	public VakzineTO() {
		this.bestandsveraenderungen = new HashSet<BestandsveraenderungTO>();
	}

}


