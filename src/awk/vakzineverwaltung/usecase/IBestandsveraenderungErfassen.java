package awk.vakzineverwaltung.usecase;

import java.rmi.RemoteException;

import awk.AnwendungskernException;
import awk.vakzineverwaltung.entity.VakzineTO;

public interface IBestandsveraenderungErfassen {
	
	public VakzineTO vakzineZuordnenById(int vakzineId) throws AnwendungskernException, RemoteException;
	
	public boolean bestandErhoehen (int anzahl, int vakzineId, int liefertag, int liefermonat, int lieferjahr) throws AnwendungskernException;
	public boolean bestandSenken(int vakzineId, String name, int lagerbestand ) throws AnwendungskernException;
	public boolean lagerbestandSenken(int vakzineId) throws AnwendungskernException;

}
