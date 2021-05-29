package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dlg.menue.Hauptmenue;
import dlg.menue.HauptmenueService;

public class StartClient {
	public static void main(String[] args) {
		
		HauptmenueService awkService = null;
		
		try {
			awkService = new HauptmenueService();
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		};
		
		if (awkService != null) {
			Hauptmenue.main(args,awkService);
		}	else {
			System.out.println("Keine Connection zum Server!");
		}
	}
	

}
