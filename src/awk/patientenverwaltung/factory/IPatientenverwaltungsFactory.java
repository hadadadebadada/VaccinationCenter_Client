package awk.patientenverwaltung.factory;

import awk.patientenverwaltung.usecase.IPatientenErstellen;

public interface IPatientenverwaltungsFactory {
	IPatientenErstellen getPatientenErstellen(); 

}
