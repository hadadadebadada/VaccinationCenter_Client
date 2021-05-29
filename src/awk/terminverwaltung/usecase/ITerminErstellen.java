package awk.terminverwaltung.usecase;

import awk.AnwendungskernException;

public interface ITerminErstellen {
	
	
	public boolean terminErstellen(int terminID, int impftag, int impfmonat, int impfjahr, int std, int min, String bemerkung,
			int vakzineID, int patientenID)throws AnwendungskernException;

}
