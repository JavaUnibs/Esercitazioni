package it.unibs.ing.clinica;
import it.unibs.ing.myutility.*;
import java.lang.String;

public class MenuMain {
	
	static final String[] MENU_PRINCIPALE = {"Azioni dati", "Azioni visita", "Ricerca"};
	static final String[] MENU_DATI = {"Inserisci dati utente", "Inserisci dati medico", "Modifica dati utente", "modifica dati medico"};
	static final String[] MENU_VISITA = {"Prenota visita", "Modifica prenotazione","Cancellazione visita", "Aggiungi referto"};	
	static final String[] MENU_RICERCA = {"Ricerca giorni di lavoro medici", "Ricerca medico disponibile per orario", "Ricerca visite per medico", "Ricerca visite per utente"};
	
	
	
	public static void main(String[] args) {
		
		int scelta;
		
		Menu elenco = new Menu(MENU_PRINCIPALE);
		Menu elenco_dati = new Menu(MENU_DATI);
		Menu elenco_visita = new Menu(MENU_VISITA);
		Menu elenco_ricerca = new Menu(MENU_RICERCA);
		
		Archivio archivio = new Archivio();
		
		scelta = elenco.stampaMenu();
		
		
		switch(scelta){
		
		// inserimento e modifica dati
		case 1: {   int scelta_dati;
					scelta_dati = elenco_dati.stampaMenu();
					
					switch(scelta_dati){
					
					// Inserimento dati utente
					case 1:{
						     String nome, cognome, dataNascita, luogoNascita, sesso, codiceFiscale, numTelefono;
							
							 nome = LeggiInput.stringa("Nome: ");
							 cognome = LeggiInput.stringa("Cognome: ");
							 dataNascita = LeggiInput.stringa("Data di nascita: ");
							 luogoNascita = LeggiInput.stringa("Luogo di Nascita: ");
							 sesso = LeggiInput.stringa("Sesso: ");
							 codiceFiscale = LeggiInput.stringa("CF: ");
							 numTelefono = LeggiInput.stringa("Numero di telefono: ");
							 
							 archivio.inserimentoUtente(nome, cognome, dataNascita, luogoNascita, sesso, numTelefono, codiceFiscale);
							
					};
					break;
					
					// Inserimento dati dottore
					case 2:{
							 String nome, cognome, dataNascita, luogoNascita, sesso, codiceFiscale, numTelefono, cognomeNome, tipo, areaCompetenza, codiceAlbo;
						     String[] giorni;
							 nome = LeggiInput.stringa("Nome: ");
							 cognome = LeggiInput.stringa("Cognome: ");
							 dataNascita = LeggiInput.stringa("Data di nascita: ");
							 luogoNascita = LeggiInput.stringa("Luogo di Nascita: ");
							 sesso = LeggiInput.stringa("Sesso: ");
							 codiceFiscale = LeggiInput.stringa("CF: ");
							 numTelefono = LeggiInput.stringa("Numero di telefono: ");
							 tipo = LeggiInput.stringa("Tipo: ");
							 areaCompetenza = LeggiInput.stringa("Area di competenza: ");
						     codiceAlbo = LeggiInput.stringa("Codice albo: ");
						
						     archivio.inserimentoMedico(nome, cognome, dataNascita, luogoNascita, sesso, numTelefono, codiceFiscale, codiceAlbo, tipo );
						     
						     
						     
					};
					break;
					
					// Modifica dati utente
					case 3:{
								String dato = LeggiInput.stringa("Inserire dato ricerca: ");
						    	Utente modifica = ricercaUtenti(dato);
						     
						    	String campo = LeggiInput.stringa("Campo da modificare: ");
						    	String dato_modifica = LeggiInput.stringa("Nuovo dato: ");
						 
						    	modifica.modificaUtente(campo, dato_modifica);
						  	
					};
					break;
					
					// Modifica dati medico
					case 4:{
								String dato = LeggiInput.stringa("Inserire dato ricerca: ");
								Utente modifica = ricercaMedici(dato);
				     
								String campo = LeggiInput.stringa("Campo da modificare: ");
								String dato_modifica = LeggiInput.stringa("Nuovo dato: ");
				 
								modifica.modificaUtente(campo, dato_modifica);
						
					};
					break;
					
					// Uscita
					case 0:{};
					break;
					
					}
		
		};
		break;
		
		// prenotazione e cancellazione visite
		case 2:{  
			 		int scelta_visita;
			 		scelta_visita = elenco_visita.stampaMenu();
				
			 		switch(scelta_visita){
				
			 			// Prenotare visita
			 			case 1:{};
			 			break;
				
			 			// modificare visita
			 			case 2:{};
			 			break;
				
			 			// cancellazione visita
			 			case 3:{};
			 			break;
				
			 		    // aggiunta referto
			 			case 4:{};
			 			break;
			 			
			 			// Uscita
			 			case 0:{};
			 			break;
			
			 		};
		}
		break;
		
		// ricerca 
		case 3:{  int scelta_ricerca;
					scelta_ricerca = elenco_ricerca.stampaMenu();
					
					switch(scelta_ricerca){
					
					// Ricerca giorni di lavoro medici
					case 1:{
							 
					};
					break;
					
					// Ricerca medico disponibile per orario
					case 2:{};
					break;
					
					// Ricerca visite per medico
					case 3:{
						
								ricercaVisiteMedico();
						
					};
					break;
					
					// Ricerca visite per utente
					case 4:{
						
								ricervaVisiteUtente
						
					};
					break;
					
					// Uscita
					case 0:{};
					break;
					
					}
			
			
			
		};
		break;
		
		case 0: break;
				
		}
		
		
	}

}
