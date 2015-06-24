package it.unibs.ing.clinica;
import it.unibs.ing.myutility.*;
import java.lang.String;

public class MenuMain {
	
	static final String[] MENU_PRINCIPALE = {"Azioni dati", "Azioni visita", "Ricerca"};
	static final String[] MENU_DATI = {"Inserisci dati utente", "Inserisci dati medico", "Modifica dati utente", "modifica dati medico"};
	static final String[] MENU_VISITA = {"Prenota visita", "Modifica prenotazione", "Aggiungi referto"};	
	static final String[] MENU_RICERCA = {"Ricerca giorni dilavoro medici", "Ricerca medico per orario", "Ricerca visite per medico", "Ricerca visite per utente"};
	
	public static void main(String[] args) {
		
		int scelta;
		
		Menu elenco = new Menu(MENU_PRINCIPALE);
		Menu elenco_dati = new Menu(MENU_DATI);
		Menu elenco_visita = new Menu(MENU_VISITA);
		Menu elenco_ricerca = new Menu(MENU_RICERCA);
		
		scelta = elenco.stampaMenu();
		
		
		switch(scelta){
		
		case 1: {   int scelta_dati;
					scelta_dati = elenco_dati.stampaMenu();
					
					switch(scelta_dati){
					
					// Inserimento dati utente
					case 1:{};
					break;
					
					// Inserimento dati dottore
					case 2:{};
					break;
					
					// Modifica dati utente
					case 3:{};
					break;
					
					// Modifica dati medico
					case 4:{};
					break;
					
					// Uscita
					case 0:{};
					break;
					
					}
		
		};
		break;
		
		case 2:{};
		break;
		
		case 3:{};
		break;
		
		case 0: break;
				
		}
		
		
	}

}
