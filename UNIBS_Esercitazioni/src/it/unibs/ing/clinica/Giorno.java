package it.unibs.ing.clinica;
import java.time.*;

public class Giorno {
	Medico medico;
	Visita visita;
	LocalDate data;
	Utente utente;
	
	Giorno(Medico _medico, LocalDate _data){
		medico=_medico;
		data=_data;
	}

	
	public void rimuoviVisita(){
		visita=null;
	}
	
}
