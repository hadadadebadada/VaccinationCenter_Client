package awk.terminverwaltung.usecase;

import java.rmi.Remote;
import java.rmi.RemoteException;

import awk.AnwendungskernException;
import awk.terminverwaltung.entity.TerminTO;

public interface ITerminValidierenRemote extends Remote{
	public TerminTO terminSuchenByIDR(int terminID) throws AnwendungskernException, RemoteException;
	public boolean terminValidierenR(int terminID, int impftag, int impfmonat, int impfjahr, int std, int min, String bemerkung,
			int vakzineID, int patientenID) throws AnwendungskernException, RemoteException;

}
