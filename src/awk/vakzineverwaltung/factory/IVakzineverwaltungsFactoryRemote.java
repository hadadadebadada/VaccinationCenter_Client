package awk.vakzineverwaltung.factory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import awk.vakzineverwaltung.usecase.IBestandsveraenderungErfassenRemote;
import awk.vakzineverwaltung.usecase.IVakzineErstellenRemote;

public interface IVakzineverwaltungsFactoryRemote extends Remote{
	
	IVakzineErstellenRemote getVakzineErstellenRemote() throws RemoteException;

	IBestandsveraenderungErfassenRemote getBestandsveraenderungErfassenRemote() throws RemoteException;
	

}
