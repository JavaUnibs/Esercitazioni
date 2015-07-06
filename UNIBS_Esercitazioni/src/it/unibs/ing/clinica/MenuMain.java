package it.unibs.ing.clinica;
import it.unibs.ing.myutility.*;
import java.lang.String;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Classe main che costituisce il menu del programma e che consente l'interazione con l'utente
 * @author Riccardo Grespan
 *
 */

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
		
		Agenda agenda = new Agenda();
		
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
						    	Utente da_modificare = archivio.ricercaUtenti(dato);
						     
						    	String campo = LeggiInput.stringa("Campo da modificare: ");
						    	String dato_modifica = LeggiInput.stringa("Nuovo dato: ");
						 
						    	da_modificare.modificaUtente(campo, dato_modifica);
						  	
					};
					break;
					
					// Modifica dati medico
					case 4:{
								String dato = LeggiInput.stringa("Inserire dato ricerca: ");
								Medico da_modificare = archivio.ricercaMedici(dato);
				     
								String campo = LeggiInput.stringa("Campo da modificare: ");
								String dato_modifica = LeggiInput.stringa("Nuovo dato: ");
				 
								da_modificare.modificaMedico(campo, dato_modifica);
						
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
			 			case 2:{
			 				
			 					String campo = LeggiInput.stringa("Dato medico: ");
			 					Medico medico = archivio.ricercaMedici(campo);
			 					int giorno = LeggiInput.intero("Inserire giorno: ");
			 					int mese = LeggiInput.intero("Inserire mese: ");
			 					int anno = LeggiInput.intero("Inserire anno: ");
			 					int ora = LeggiInput.intero("Inserire ora: ");
			 					int minuti = LeggiInput.intero("Inserire minuti: ");
			 					LocalDate data = LocalDate.of(anno, mese, giorno);
			 					LocalTime orario = LocalTime.of(ora, minuti);
		 				     
			 					Visita da_modificare = agenda.specificaVisita(medico, data, orario); //ricky il metodo specificaVisita non restituisce un oggetto visita, ma un oggetto Giorno con dentro la Visita che si sta cercando
			 					String campo_visita = LeggiInput.riga("Inserire campo da modificare(motivo, referto, prescrizione, tipo, competenza): ");
			 					String input = LeggiInput.riga("Inserire nuovo dato: ");
			 					da_modificare.modificaVisita(campo, input);
			 				
			 			};
			 			break;
				
			 			// cancellazione visita
			 			case 3:{};
			 			break;
				
			 		    // aggiunta referto
			 			case 4:{
			 					 String campo = LeggiInput.stringa("Dato medico: ");
			 				     Medico medico = archivio.ricercaMedici(campo);
			 				     int giorno = LeggiInput.intero("Inserire giorno: ");
			 				     int mese = LeggiInput.intero("Inserire mese: ");
			 				     int anno = LeggiInput.intero("Inserire anno: ");
			 				     int ora = LeggiInput.intero("Inserire ora: ");
			 				     int minuti = LeggiInput.intero("Inserire minuti: ");
			 				     LocalDate data = LocalDate.of(anno, mese, giorno);
			 				     LocalTime orario = LocalTime.of(ora, minuti);
			 				     
			 				     Visita da_modificare = agenda.specificaVisita(medico, data, orario);
			 				     String campo_visita = "referto medico";
			 				     String input = LeggiInput.riga("Inserire referto: ");
			 				     da_modificare.modificaVisita(campo, input);
			 					
			 			};
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
								String campo = LeggiInput.stringa("Dato medico: ");
								Medico cercato = archivio.ricercaMedici(campo);
								agenda.orariVisita(cercato);
							 
					};
					break;
					
					// Ricerca medico disponibile per orario
					case 2:{
						        int giorno = LeggiInput.intero("Inserire giorno: ");
						        int mese = LeggiInput.intero("Inserire mese: ");
						        int anno = LeggiInput.intero("Inserire anno: ");
						        int ora = LeggiInput.intero("Inserire ora: ");
						        int minuti = LeggiInput.intero("Inserire minuti: ");
						        LocalDate data = LocalDate.of(anno, mese, giorno);
						        LocalTime orario = LocalTime.of(ora, minuti);
								agenda.mediciDisponibili(data, orario);
						
					};
					break;
					
					// Ricerca visite per medico
					case 3:{
								String campo = LeggiInput.stringa("Dato medico: ");
								Medico cercato = archivio.ricercaMedici(campo);
								agenda.visiteMedico(cercato);
						
					};
					break;
					
					// Ricerca visite per utente
					case 4:{
						
						String campo = LeggiInput.stringa("Dato utente: ");
						Utente cercato = archivio.ricercaUtenti(campo);
						agenda.visiteUtente(cercato);
						
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
