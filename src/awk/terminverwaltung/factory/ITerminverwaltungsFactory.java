package awk.terminverwaltung.factory;

import awk.terminverwaltung.usecase.IPatientenlisteLaden;
import awk.terminverwaltung.usecase.ITerminErstellen;
import awk.terminverwaltung.usecase.ITerminValidieren;

public interface ITerminverwaltungsFactory {
	public IPatientenlisteLaden getPatientenlisteLaden();
	public ITerminErstellen getTerminErstellen();
	public ITerminValidieren getTerminValidieren();
	
}
