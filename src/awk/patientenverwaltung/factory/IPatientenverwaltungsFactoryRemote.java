package awk.patientenverwaltung.factory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import awk.patientenverwaltung.usecase.IPatientenErstellenRemote;



public interface IPatientenverwaltungsFactoryRemote extends Remote{
	IPatientenErstellenRemote getPatientenErstellenRemote() throws RemoteException;

}
