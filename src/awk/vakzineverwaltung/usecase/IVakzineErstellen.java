package awk.vakzineverwaltung.usecase;

import awk.AnwendungskernException;

public interface IVakzineErstellen {
	public boolean vakzineErstellen(int vakzineId, int lagerbestand, int liefertag, int liefermonat, int lieferjahr) throws AnwendungskernException;

}
