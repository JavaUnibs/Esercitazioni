package it.unibs.ing.clinica;
import java.util.*;
import java.time.*;

public class Slot {
	LocalTime ora;
/**
 * Il costruttore necessita di un'orario in ingresso, corrispondente alla riga in cui si trova l'oggetto( per comodità di reperimento)
 * @param _ora 
 * @author Andrea Ferrari
 */
	Slot(LocalTime _ora){
		ora=_ora;
	}

	ArrayList<Giorno> giorni = new ArrayList<Giorno>();

/**
 * Aggiunge all'elenco un nuovo oggetto di tipo Giorno.	
 * @param giorno
 * @author Andrea Ferrari
 */
	public void aggiungiGiorno(Giorno giorno){
		giorni.add(giorno);
	}
}
