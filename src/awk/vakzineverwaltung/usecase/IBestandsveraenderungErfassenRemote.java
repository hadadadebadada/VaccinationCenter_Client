package awk.vakzineverwaltung.usecase;

import java.rmi.Remote;
import java.rmi.RemoteException;

import awk.AnwendungskernException;
import awk.vakzineverwaltung.entity.VakzineTO;

public interface IBestandsveraenderungErfassenRemote extends Remote {
	
public VakzineTO vakzineZuordnenByIdR(int vakzineId) throws AnwendungskernException, RemoteException;
	
public boolean bestandErhoehenR(int vakzineId, int anzahl, int liefertag, int liefermonat, int lieferjahr) throws AnwendungskernException, RemoteException;

public boolean bestandSenkenR(int vakzineId, String name, int lagerbestand) throws AnwendungskernException, RemoteException;

public boolean lagerbestandSenkenR(int vakzineId) throws AnwendungskernException, RemoteException;

}
