package awk.terminverwaltung.usecase;

import java.util.Collection;

import awk.AnwendungskernException;
import awk.DatenhaltungsException;
import awk.patientenverwaltung.entity.PatientTO;

public interface IPatientenlisteLaden {

	
	public Collection<PatientTO> patientenListeAusgeben() throws AnwendungskernException;
	public Collection<PatientTO> patientenTOlisteAusgeben() throws AnwendungskernException, DatenhaltungsException;
}
