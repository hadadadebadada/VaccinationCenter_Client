package awk.vakzineverwaltung.factory;

import awk.vakzineverwaltung.usecase.IBestandsveraenderungErfassen;
import awk.vakzineverwaltung.usecase.IVakzineErstellen;

public interface IVakzineverwaltungsFactory {

	IVakzineErstellen getVakzineErstellen();
	
	IBestandsveraenderungErfassen getBestandsveraenderungErfassen();

}
