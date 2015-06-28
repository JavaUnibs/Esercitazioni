package it.unibs.ing.clinica;
import java.time.*;

enum statoVisita {
	Prenotata, Prenotabile, Conclusa, Refertata, Non_prenotabile
}

public class Giorno {
	private Medico medico;
	private Visita visita;
	private LocalDate data;
	private Utente utente;
	private statoVisita stato;
	
	
/**
 * Il costruttore necessita di un medico disponibile in una certa data.	
 * @param _medico il medico disponibile 
 * @param _data   la data di disponibilità
 * @author Andrea Ferrari
 */
	Giorno(Medico _medico, LocalDate _data){
		medico=_medico;
		data=_data;
		stato=statoVisita.Prenotabile;
	}
	
	public Medico getMedico(){
		return medico;
	}
	
	public Visita getVisita(){
		return visita;
	}
	
	public LocalDate getData(){
		return data;
	}
	
	public Utente getUtente(){
		return utente;
	}
	
	public statoVisita getStato(){
		return stato;
	}
	
	
	public void setMedico(Medico _medico){
		medico=_medico;
	}
	
	public void setVisita(Visita _visita){
		visita=_visita;
	}
	
	public void setData(LocalDate _data){
		data=_data;
	}
	
	public void setUtente(Utente _utente){
		utente=_utente;
	}

	public void setStato(statoVisita _stato){
		stato=_stato;
	}
	
/**
 * Setta il campo visita su null.
 * @author Andrea Ferrari
 */
	public void rimuoviVisita(){
		visita=null;
	}
/**
 * Cambia la variabile stato di questo oggetto in base al riscontro di una stringa generica in ingresso.	
 * @param generico
 */
	public void cambiaStato(String generico){
		switch(generico.toLowerCase()){
		case "prenotata": stato=statoVisita.Prenotata;
		break;
		case "conclusa": stato=statoVisita.Conclusa;
		break;
		case "non prenotabile":stato=statoVisita.Non_prenotabile;
		break;
		case "refertata":stato=statoVisita.Refertata;
		break;
		case "prenotabile":stato=statoVisita.Prenotabile;
		break;
		}
	}
	
}
