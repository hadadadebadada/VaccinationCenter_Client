package awk.patientenverwaltung.persistence;

import awk.DatenhaltungsException;
import awk.patientenverwaltung.entity.PatientTO;

public interface IPatientenDBZugriff {
	public void patientendatenErstellen(PatientTO patientTO) throws DatenhaltungsException;
}
