package awk.terminverwaltung.usecase;

import awk.AnwendungskernException;
import awk.terminverwaltung.entity.TerminTO;

public interface ITerminValidieren {

	

	public TerminTO terminSuchenbyID(int terminID) throws AnwendungskernException;
	public boolean terminValidieren(int terminID, int impftag, int impfmonat, int impfjahr, int std, int min, String bemerkung,
	int vakzineID, int patientenID)throws AnwendungskernException;
}
