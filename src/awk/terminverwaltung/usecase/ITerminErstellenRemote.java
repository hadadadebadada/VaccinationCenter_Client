package awk.terminverwaltung.usecase;

import java.rmi.Remote;
import java.rmi.RemoteException;

import awk.AnwendungskernException;

public interface ITerminErstellenRemote extends Remote {

	
	public boolean terminErstellen(int terminID, int impftag, int impfmonat, int impfjahr, int std, int min, String bemerkung,
			int vakzineID, int patientenID)throws AnwendungskernException, RemoteException;
	
}
