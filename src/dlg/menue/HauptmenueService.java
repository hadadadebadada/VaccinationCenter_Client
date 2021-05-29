package dlg.menue;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

import awk.patientenverwaltung.usecase.IPatientenErstellenRemote;
import awk.terminverwaltung.usecase.IPatientenlisteLadenRemote;
import awk.terminverwaltung.usecase.ITerminErstellenRemote;
import awk.terminverwaltung.usecase.ITerminValidierenRemote;
import awk.vakzineverwaltung.usecase.IBestandsveraenderungErfassenRemote;
import awk.vakzineverwaltung.usecase.IVakzineErstellenRemote;

public class HauptmenueService {
	
	private IPatientenErstellenRemote patientenErfassenRemote = null;
	private IVakzineErstellenRemote vakzineErstellenRemote = null;
	private IBestandsveraenderungErfassenRemote bestandsveraenderungErfassenRemote = null;
	private IPatientenlisteLadenRemote patientenlisteLadenRemote = null;
	private ITerminErstellenRemote terminErstellenRemote = null;
	private ITerminValidierenRemote terminValidierenRemote = null;
	
	public HauptmenueService() throws RemoteException, NotBoundException, AccessException {
		
		Registry registry = LocateRegistry.getRegistry("127.0.0.1");
		
		patientenErfassenRemote = (IPatientenErstellenRemote) registry.lookup("patientenErstellen");
		
		vakzineErstellenRemote = (IVakzineErstellenRemote) registry.lookup("vakzineErstellen");
		
		bestandsveraenderungErfassenRemote = (IBestandsveraenderungErfassenRemote) registry.lookup("bestandsveraenderungErfassen");
		
		patientenlisteLadenRemote  = (IPatientenlisteLadenRemote) registry.lookup("patientenlisteLaden");
		
		terminErstellenRemote = (ITerminErstellenRemote) registry.lookup("terminErstellen");
		
		terminValidierenRemote = (ITerminValidierenRemote) registry.lookup("terminLadenByID");
		
		System.out.println("Connected to Server at: "+ new Date());

	}

	
	public IPatientenErstellenRemote getPatientenErfassen() {
		return patientenErfassenRemote;
	}
	public IVakzineErstellenRemote getVakzineErstellen() {
		return vakzineErstellenRemote;
	}
	
	public IBestandsveraenderungErfassenRemote getBestandsveraenderungErfassenRemote() {
		return bestandsveraenderungErfassenRemote;
	}
	
	public IPatientenlisteLadenRemote getPatientenlisteLadenRemote() {
		return patientenlisteLadenRemote;
	}
	
	public ITerminErstellenRemote getTerminErstellenRemote() {
		return terminErstellenRemote;
	}
	public ITerminValidierenRemote getTerminValidierenRemote() {
		return terminValidierenRemote;
	}

}
