package awk.vakzineverwaltung.persistence;

import java.util.Collection;

import awk.DatenhaltungsException;
import awk.vakzineverwaltung.entity.BestandsveraenderungTO;
import awk.vakzineverwaltung.entity.VakzineTO;

public interface IVakzineDBZugriff {

	//public void vakzinedatenErstellen(VakzineTO vakzineTO) throws DatenhaltungsException;
	
	public void valzinedatenListeErstellen(Collection<VakzineTO> vakzinedatenListe) throws DatenhaltungsException;
	
	
	//public Collection<VakzineTO> vakzinedatenLaden() throws DatenhaltungsException;

	public VakzineTO vakzinedatenLadenbyId(int vakzineId)throws DatenhaltungsException;
	
	public void chargeErfassen(int vakzineId, BestandsveraenderungTO bestandsveraenderungTO) throws DatenhaltungsException;
	
	public void lagerbestandUpdaten(VakzineTO vakzineTO) throws DatenhaltungsException;
	public void vakzinebestandSenken(int vakzineId) throws DatenhaltungsException;

}
