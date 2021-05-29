package awk.patientenverwaltung.usecase;

import awk.AnwendungskernException;

public interface IPatientenErstellen {
	public boolean patientenErstellen(int patientenID, String name, String nachname, int geburtstag, int geburtsmonat, int geburtsjahr, String email, int telefonNr) throws AnwendungskernException;

}
