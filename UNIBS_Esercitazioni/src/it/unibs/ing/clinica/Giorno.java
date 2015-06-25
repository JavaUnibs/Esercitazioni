package it.unibs.ing.clinica;
import java.time.*;

public class Giorno {
	Medico medico;
	Visita visita;
	LocalDate data;
	Utente utente;
/**
 * Il costruttore necessita di un medico disponibile in una certa data.	
 * @param _medico il medico disponibile 
 * @param _data   la data di disponibilità
 * @author Andrea Ferrari
 */
	Giorno(Medico _medico, LocalDate _data){
		medico=_medico;
		data=_data;
	}

/**
 * Setta il campo visita su null.
 * @author Andrea Ferrari
 */
	public void rimuoviVisita(){
		visita=null;
	}
	
}
