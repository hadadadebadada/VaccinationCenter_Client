package awk.vakzineverwaltung.usecase;

import java.rmi.Remote;
import java.rmi.RemoteException;

import awk.AnwendungskernException;

public interface IVakzineErstellenRemote extends Remote{
	public boolean vakzineErstellenR(int vakzineId, int lagerbestand, int liefertag, int liefermonat, int lieferjahr) throws AnwendungskernException, RemoteException;

}
