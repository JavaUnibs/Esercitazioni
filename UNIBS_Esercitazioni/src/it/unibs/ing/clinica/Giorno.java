package it.unibs.ing.clinica;
import java.time.*;

enum StatoVisita {
	Prenotata, Prenotabile, Conclusa, Refertata, Non_prenotabile
}

public class Giorno {
	private Medico medico;
	private Visita visita;
	private LocalDate data;
	private Utente utente;
	private StatoVisita stato;
	
/**
 * Override di equals, per qualche motivo non funzionava.	
 */
	
	public boolean equals(final Object obj)
    {
        if ( obj == null || obj == this || !(obj instanceof Giorno) ) 
            return false;

        Giorno altroGiorno = (Giorno) obj;

        if (altroGiorno.medico != this.medico)       return false;
        if (altroGiorno.visita != this.visita)     return false;
        if (!altroGiorno.data.equals(this.data)) return false;
        if (altroGiorno.utente != this.utente)   return false;
        if (!altroGiorno.stato.equals(this.stato)) return false;

        return true;
    }
	
/**
 * Il costruttore necessita di un medico disponibile in una certa data.	
 * @param _medico il medico disponibile 
 * @param _data   la data di disponibilità
 * @author Andrea Ferrari
 */
	Giorno(Medico _medico, LocalDate _data){
		medico=_medico;
		data=_data;
		stato=StatoVisita.Prenotabile;
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
	
	public StatoVisita getStato(){
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

	public void setStato(StatoVisita _stato){
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
		case "prenotata": stato=StatoVisita.Prenotata;
		break;
		case "conclusa": stato=StatoVisita.Conclusa;
		break;
		case "non prenotabile":stato=StatoVisita.Non_prenotabile;
		break;
		case "refertata":stato=StatoVisita.Refertata;
		break;
		case "prenotabile":stato=StatoVisita.Prenotabile;
		break;
		}
	}
	
}
