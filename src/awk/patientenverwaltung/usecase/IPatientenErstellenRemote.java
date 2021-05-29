package awk.patientenverwaltung.usecase;

import java.rmi.Remote;
import java.rmi.RemoteException;

import awk.AnwendungskernException;


public interface IPatientenErstellenRemote extends Remote {
	
	public boolean patientenErstellenR(int patientenID, String name, String nachname, int geburtstag, int geburtsmonat, int geburtsjahr, String email, int telefonNr) throws AnwendungskernException, RemoteException;

}
