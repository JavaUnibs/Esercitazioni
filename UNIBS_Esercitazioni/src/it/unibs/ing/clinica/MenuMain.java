package it.unibs.ing.clinica;
import it.unibs.ing.myutility.*;

import java.lang.String;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
//PROVAAA
/**
 * Classe main che costituisce il menu del programma e che consente l'interazione con l'utente
 * @author Riccardo Grespan
 *
 */

public class MenuMain {

	// Menu principale
	static final String[] MENU_PRINCIPALE = {"Azioni dati", "Azioni visita", "Ricerca", "Statistiche"};
	// Sottomenu Prima scelta menu principale
	static final String[] MENU_DATI = {"Inserisci dati utente", "Inserisci dati medico", "Modifica dati utente", "modifica dati medico"};
	// Sottomenu Seconda scelta menu principale
	static final String[] MENU_VISITA = {"Prenota visita", "Modifica prenotazione","Cancellazione visita"};	
	// Sottomenu Terza scelta menu principale
	static final String[] MENU_RICERCA = {"Ricerca giorni di lavoro medici", "Ricerca medico disponibile per orario"};
	// Sottomenu Quarta scelta menu principale
	static final String[] MENU_STATISTICHE = {"Visite totali", "Visite totali per tipo", "Visite divise per competenza", "Min e Max area competenze", "Numero visite per medico"};
	// Menu inserimento disponibilità
	static final String[] MENU_DISP = {"Giorni continuati e orari continuati", "Giorni specifici e ore specifiche", "Un giorno e orario continuato"};
	// Menu cancellazione disponibilità
	static final String[] MENU_CANCELLADISP = {"Cancella giorni continuati e orari continuati", "Cancella giorni specifici e ore specifiche", "Cancella giorno e orario continuato"};
	// Sottomenu del sottomenu della seconda e terza scelta
	static final String[] MENU_SOTTOVISITA = {"Ricerca specifica", "Ricerca visite per medico", "Ricerca visite per utente", "Ricerca visite per tipo"};
	

	public static void main(String[] args) {
		
		int scelta;
		
		Menu elenco = new Menu(MENU_PRINCIPALE);
		Menu elenco_dati = new Menu(MENU_DATI);
		Menu elenco_visita = new Menu(MENU_VISITA);
		Menu elenco_ricerca = new Menu(MENU_RICERCA);
		Menu elenco_statistiche = new Menu(MENU_STATISTICHE);
		Menu elenco_sottovisita = new Menu(MENU_SOTTOVISITA);
		
		Archivio archivio = new Archivio();
		
		Agenda agenda = new Agenda();
		
		do{scelta = elenco.stampaMenu();
		
		
		switch(scelta){
		
		// inserimento e modifica dati
		case 1: {   int scelta_dati;
					scelta_dati = elenco_dati.stampaSottoMenu();
					
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
							 String nome, cognome, dataNascita, luogoNascita, sesso, codiceFiscale, numTelefono, tipo, areaCompetenza, codiceAlbo;
							 nome = LeggiInput.stringa("Nome: ");
							 cognome = LeggiInput.stringa("Cognome: ");
							 dataNascita = LeggiInput.stringa("Data di nascita: ");
							 luogoNascita = LeggiInput.stringa("Luogo di Nascita: ");
							 sesso = LeggiInput.stringa("Sesso: ");
							 codiceFiscale = LeggiInput.stringa("CF: ");
							 numTelefono = LeggiInput.stringa("Numero di telefono: ");
							 tipo = LeggiInput.stringa("Tipo: ");
							 codiceAlbo = LeggiInput.stringa("Codice albo: ");
						     
							 boolean spec = LeggiInput.doppiaScelta("Specialista?");
							 if(spec)
							 {
							 areaCompetenza = LeggiInput.stringa("Area di competenza: ");
						     archivio.inserimentoMedico(nome, cognome, dataNascita, luogoNascita, sesso, numTelefono, codiceFiscale, codiceAlbo, tipo, areaCompetenza );
						     Medico selezionato = new Medico(nome, cognome, dataNascita, luogoNascita, sesso, numTelefono, codiceFiscale, codiceAlbo, tipo, areaCompetenza );
						     menuInserimentoDisp(selezionato, agenda);
							 };
							 archivio.inserimentoMedico(nome, cognome, dataNascita, luogoNascita, sesso, numTelefono, codiceFiscale, codiceAlbo, tipo );
						     Medico selezionato = new Medico(nome, cognome, dataNascita, luogoNascita, sesso, numTelefono, codiceFiscale, codiceAlbo, tipo );
						     menuInserimentoDisp(selezionato, agenda);
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
								
								campo = campo.toLowerCase();
								if(campo.equals("disponibilità")){
								String dec_disp = LeggiInput.stringa("Aggiungere o cancellare?");
								
									
								if (dec_disp.equalsIgnoreCase("cancellare")) menuCancDisp(da_modificare, agenda);
								menuInserimentoDisp(da_modificare, agenda);
								};
								String dato_modifica = LeggiInput.stringa("Nuovo dato: ");
				 
								da_modificare.modificaMedico(campo, dato_modifica);
						
					};
					break;
					
					// Visualizzazione visite utente
					case 5:{
						
						
					};
					
					// Uscita
					case 0:{};
					break;
					
					}
		
		};
		break;
		
		// prenotazione e cancellazione visite
		case 2:{  
			 		int scelta_visita;
			 		scelta_visita = elenco_visita.stampaSottoMenu();
				
			 		switch(scelta_visita){
				
			 			// Prenotare visita
			 			case 1:{
			 					String dato = LeggiInput.stringa("Inserire dato ricerca utente: ");
			 					Utente selezionato = archivio.ricercaUtenti(dato);
			 					
			 					int giorno = LeggiInput.intero("Inserire giorno: ");
			 					int mese = LeggiInput.intero("Inserire mese: ");
			 					int anno = LeggiInput.intero("Inserire anno: ");
			 					int ora = LeggiInput.intero("Inserire ora: ");
			 					int minuti = LeggiInput.intero("Inserire minuti: ");
			 					LocalDate data = LocalDate.of(anno, mese, giorno);
			 					LocalTime orario = LocalTime.of(ora, minuti);
			 					
			 					String tipoVisita = LeggiInput.riga("Inserire il tipo della visita: ");
			 					String motivoVisita = LeggiInput.riga("Inserire motivo della visita: ");
			 					
			 					agenda.inserimentoVisita(selezionato, motivoVisita, data, orario, tipoVisita);
			 					
			 			};
			 			break;
				
			 			// modificare visita
			 			case 2:{ int scelta_sottovisita = elenco_sottovisita.stampaSottoMenu();

			 					switch(scelta_sottovisita){
			 				
			 						// Ricerca Visita precisa
			 						case 1: {
			 								String campo = LeggiInput.stringa("Dato medico: ");
			 						
			 								Medico medico = archivio.ricercaMedici(campo);
			 								int giorno = LeggiInput.intero("Inserire giorno: ");
			 								int mese = LeggiInput.intero("Inserire mese: ");
			 								int anno = LeggiInput.intero("Inserire anno: ");
			 								int ora = LeggiInput.intero("Inserire ora: ");
			 								int minuti = LeggiInput.intero("Inserire minuti: ");
			 								LocalDate data = LocalDate.of(anno, mese, giorno);
			 								LocalTime orario = LocalTime.of(ora, minuti);
		 				     
			 								Giorno giorno_visita = agenda.specificaVisita(medico, data, orario); 
			 								String campo_visita = LeggiInput.riga("Inserire campo da modificare(motivo, referto, prescrizione, tipo, competenza): ");
			 								if(campo_visita.equalsIgnoreCase("stato")) 
			 								{
			 									String input = LeggiInput.riga("Inserire nuovo stato(prenotata, conclusa, non prenotabile, refertata: ");
			 									giorno_visita.cambiaStato(input);
			 								}
			 					
			 								if(campo_visita.equalsIgnoreCase("referto medico"))
			 								{
			 						
			 									String input = LeggiInput.riga("Inserire referto: ");
			 									Visita da_modificare = giorno_visita.getVisita();
			 									da_modificare.modificaVisita(campo, input);
			 									giorno_visita.cambiaStato("refertata");	
			 						
			 								}
			 					
			 								String input = LeggiInput.riga("Inserire nuovo dato: ");
			 								Visita da_modificare = giorno_visita.getVisita();
			 								da_modificare.modificaVisita(campo_visita, input);
			 						}; break;
			 					
			 						// Ricerca visita per medico
			 						case 2:{
			 									String campo = LeggiInput.stringa("Dato medico: ");
			 									Medico cercato = archivio.ricercaMedici(campo);
			 									ArrayList<Giorno> giorni_visite = agenda.visiteMedico(cercato);
										
			 									Giorno giorno_visita = selezionaVisita(giorni_visite);
			 									Visita selezionata = giorno_visita.getVisita();	
											
										
			 									String campo_visita = LeggiInput.riga("Inserire campo da modificare(motivo, referto, prescrizione, tipo, competenza): ");
			 									if(campo_visita.equalsIgnoreCase("stato")) 
			 									{
			 										String input = LeggiInput.riga("Inserire nuovo stato(prenotata, conclusa, non prenotabile, refertata: ");
			 										giorno_visita.cambiaStato(input);
			 									}
						 					
			 									if(campo_visita.equalsIgnoreCase("referto medico"))
			 									{
						 						
			 										String input = LeggiInput.riga("Inserire referto: ");
			 										selezionata.modificaVisita(campo, input);
			 										giorno_visita.cambiaStato("refertata");	
			 									
			 									}
						 					
			 									String input = LeggiInput.riga("Inserire nuovo dato: ");
			 									selezionata.modificaVisita(campo_visita, input);
			 							
			 							
			 							}; break;
			 							
			 						// Ricerca visite per utente
			 						case 3: {
			 									String campo = LeggiInput.stringa("Dato utente: ");
			 									Utente cercato = archivio.ricercaUtenti(campo);
			 									ArrayList<Giorno> giorni_visite = agenda.visiteUtente(cercato);
			 									String input;
			 									Giorno giorno_visita = selezionaVisita(giorni_visite);
			 									Visita selezionata = giorno_visita.getVisita();	
			 									String campo_visita = LeggiInput.riga("Inserire campo da modificare(motivo, referto, prescrizione, tipo, competenza): ");
			 									if(campo_visita.equalsIgnoreCase("stato")) 
			 									{
			 											input = LeggiInput.riga("Inserire nuovo stato(prenotata, conclusa, non prenotabile, refertata: ");
			 											giorno_visita.cambiaStato(input);
			 									}
			 			 					
			 									if(campo_visita.equalsIgnoreCase("referto medico"))
			 									{
			 			 						
			 											input = LeggiInput.riga("Inserire referto: ");
			 											selezionata.modificaVisita(campo, input);
			 											giorno_visita.cambiaStato("refertata");	
			 			 						
			 									}
			 			 					
			 									input = LeggiInput.riga("Inserire nuovo dato: ");
			 									selezionata.modificaVisita(campo_visita, input);
			 	                       }; break;
			 							
			 	                      // Ricerca visite per tipo
			 						case 4:{ 
			 									String tipo = LeggiInput.stringa("Inserisci il tipo della visita:");
			 									
			 									
			 								
			 								
			 						}; break;
			 	                       
			 	                       
			 						}; break;
			 					
			 							
			 					}
			 			
			 			
			 			
			 			// cancellazione visita
			 			case 3:{ 
			 						int scelta_sottovisita = elenco_sottovisita.stampaSottoMenu();
			 			
			 						switch(scelta_sottovisita){
			 							case 1 :{ 
			 										String campo = LeggiInput.stringa("Dato medico: ");
			 										Medico medico = archivio.ricercaMedici(campo);
			 										int giorno = LeggiInput.intero("Inserire giorno: ");
			 										int mese = LeggiInput.intero("Inserire mese: ");
			 										int anno = LeggiInput.intero("Inserire anno: ");
			 										int ora = LeggiInput.intero("Inserire ora: ");
			 										int minuti = LeggiInput.intero("Inserire minuti: ");
			 										LocalDate data = LocalDate.of(anno, mese, giorno);
			 										LocalTime orario = LocalTime.of(ora, minuti);
	 				     
			 										Giorno giorno_visita = agenda.specificaVisita(medico, data, orario); 
			 										boolean decisione = LeggiInput.doppiaScelta("Cancellare visita?");
			 										if (decisione) 
			 										{ 
			 											giorno_visita.rimuoviVisita();
			 											giorno_visita.cambiaStato("prenotabile");
			 							
			 										}
			 				
			 							};break;
			 							
			 							// Ricerca visite per medico
			 							case 2:{
			 										String campo = LeggiInput.stringa("Dato medico: ");
			 										Medico cercato = archivio.ricercaMedici(campo);
			 										ArrayList<Giorno> giorni_visite = agenda.visiteMedico(cercato);
											
			 										Giorno giorno_visita = selezionaVisita(giorni_visite);
			 							
			 										boolean decisione = LeggiInput.doppiaScelta("Cancellare visita?");
													if (decisione)
													{ 
														giorno_visita.rimuoviVisita();
														giorno_visita.cambiaStato("prenotabile");
													}
			 							  		
			 							}; break;
			 							
			 							// Ricerca visite per utente
			 							case 3: {
			 										String campo = LeggiInput.stringa("Dato utente: ");
			 										Utente cercato = archivio.ricercaUtenti(campo);
			 										ArrayList<Giorno> giorni_visite = agenda.visiteUtente(cercato);
			 								
			 										Giorno giorno_visita = selezionaVisita(giorni_visite);
			 								
			 										boolean decisione = LeggiInput.doppiaScelta("Cancellare visita?");
													if (decisione)
													{ 
														giorno_visita.rimuoviVisita();
														giorno_visita.cambiaStato("prenotabile");
													}
			 							}; break;
			 							
			 							case 0: {}; break;
			 							
			 						};break;
			 			
			 			}
			 			
			 			
			 			// Uscita
			 			case 0:{};break;
			
			 		};
		}; break;
		
		// ricerca 
		case 3:{ 
			        int scelta_ricerca;
					scelta_ricerca = elenco_ricerca.stampaSottoMenu();
					
					switch(scelta_ricerca){
					
					// Ricerca giorni di lavoro medici
					case 1:{
								String campo = LeggiInput.stringa("Dato medico: ");
								Medico cercato = archivio.ricercaMedici(campo);
								System.out.println(agenda.orariVisita(cercato));
							 
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
								System.out.println(agenda.mediciDisponibili(data, orario));
						
					};
					break;
					
					// Uscita
					case 0:{};break;
					
					}; break;
			
			
			
		}
		
		// Statistiche
		
		case 4:{ 
			     
					int scelta_statistiche;
					scelta_statistiche = elenco_statistiche.stampaSottoMenu();
			
					switch(scelta_statistiche){
							// Visite totali		 
							case 1:{
									agenda.statisticheVisite();
							}; break;
			 
							//
							case 2:{
			 
							}; break;
					}; break;	
		}
		
		case 0: { };return;
				
		}}while(scelta != 0);
	}
	
	
	
	
	/**
	 * Metodo che costruisce un menu per la cancellazione delle disponibilità
	 * 
	 * @param da_modificare
	 * @param agenda
	 * @author Riccardo Grespan
	 */
	public static void menuCancDisp (Medico da_modificare, Agenda agenda){
		
		System.out.println("Come si desidera cancellare la disponibilità?");
		Menu elenco_cancelladisp = new Menu(MENU_CANCELLADISP); 
		int scelta_cancelladisp = elenco_cancelladisp.stampaMenu();
	     
	     switch(scelta_cancelladisp){
	     
	     // Cancella intervallo di giorni e ore
	     case 1:{
	    	 		int giorno_I = LeggiInput.intero("Inserire giorno iniziale: ");
	    	 		int mese_I = LeggiInput.intero("Inserire mese iniziale: ");
	    	 		int anno_I = LeggiInput.intero("Inserire anno iniziale: ");
	    	 		LocalDate data_I = LocalDate.of(anno_I, mese_I, giorno_I);

	    	 		int giorno_F = LeggiInput.intero("Inserire giorno finale: ");
	    	 		int mese_F = LeggiInput.intero("Inserire mese finale: ");
	    	 		int anno_F = LeggiInput.intero("Inserire anno finale: ");
	    	 		LocalDate data_F = LocalDate.of(anno_F, mese_F, giorno_F);  
	    	 		
	    	 		int ora_I = LeggiInput.intero("Inserire ora iniziale: ");
	    	 		int minuti_I = LeggiInput.intero("Inserire minuti inziali: ");
	    	 		LocalTime orario_I = LocalTime.of(ora_I, minuti_I);
	    	 		
	    	 		int ora_F = LeggiInput.intero("Inserire ora finale: ");
	    	 		int minuti_F = LeggiInput.intero("Inserire minuti finali: ");
	    	 		LocalTime orario_F = LocalTime.of(ora_F, minuti_F);
	    	 		
	    	 		agenda.cancellaDisp(da_modificare, data_I, data_F, orario_I, orario_F);
	     };
	     break;
	    
	     // Cancella giorni specifici ore continuate
	     case 2:{
	    	 		int ora_I = LeggiInput.intero("Inserire ora iniziale: ");
	    	 		int minuti_I = LeggiInput.intero("Inserire minuti inziali: ");
	    	 		LocalTime orario_I = LocalTime.of(ora_I, minuti_I);
   	 		
	    	 		int ora_F = LeggiInput.intero("Inserire ora finale: ");
	    	 		int minuti_F = LeggiInput.intero("Inserire minuti finali: ");
	    	 		LocalTime orario_F = LocalTime.of(ora_F, minuti_F);
   	 		
	    	 		ArrayList<LocalDate> giorniVari = new ArrayList<LocalDate>();
	    	 		
	    	 		boolean continuare;
					do{
	    	 			
	    	 			int giorno = LeggiInput.intero("Inserire giorno: ");
		    	 		int mese = LeggiInput.intero("Inserire mese: ");
		    	 		int anno = LeggiInput.intero("Inserire anno: ");
		    	 		LocalDate data = LocalDate.of(anno, mese, giorno);
	    	 			giorniVari.add(data);
	    	 			
	    	 			
	    	 			continuare = LeggiInput.doppiaScelta("Continuare l'inserimento?");
	    	 		}while(continuare == true);
					
				
					LocalDate []array = new LocalDate[giorniVari.size()];
					giorniVari.toArray(array);
					
					agenda.cancellaDisp(da_modificare, orario_I, orario_F, array);
	     
	     };
	     break;
	     
	     // Cancella un giorno e orario specifico 
	     case 3: {
	    	 		int giorno = LeggiInput.intero("Inserire giorno: ");
	    	 		int mese = LeggiInput.intero("Inserire mese: ");
	    	 		int anno = LeggiInput.intero("Inserire anno: ");
	    	 		LocalDate data = LocalDate.of(anno, mese, giorno);  
   	 		
	    	 		int ora_I = LeggiInput.intero("Inserire ora iniziale: ");
	    	 		int minuti_I = LeggiInput.intero("Inserire minuti inziali: ");
	    	 		LocalTime orario_I = LocalTime.of(ora_I, minuti_I);
   	 		
	    	 		int ora_F = LeggiInput.intero("Inserire ora finale: ");
	    	 		int minuti_F = LeggiInput.intero("Inserire minuti finali: ");
	    	 		LocalTime orario_F = LocalTime.of(ora_F, minuti_F);
 
	    	 		
	    	 		agenda.cancellaDisp(da_modificare, data, orario_I, orario_F);
	    	 		
	    	 
	     };
	     break;
	     
	     case 0: { } break;
	     }
		}
	
	
	
	
	/**
	 * Metodo che costruisce un menu per l'inserimento della disponibilità
	 * 
	 * @param selezionato
	 * @param agenda
	 * @author Riccardo Grespan
	 */
	
	public static void menuInserimentoDisp(Medico selezionato, Agenda agenda){
		System.out.println("Come si desidera inserire la disponibilità?");
		Menu elenco_disp = new Menu(MENU_DISP);
		int scelta_disp = elenco_disp.stampaMenu();
	     
	     switch(scelta_disp){
	     
	     // Intervallo di giorni e ore
	     case 1:{
	    	 		int giorno_I = LeggiInput.intero("Inserire giorno iniziale: ");
	    	 		int mese_I = LeggiInput.intero("Inserire mese iniziale: ");
	    	 		int anno_I = LeggiInput.intero("Inserire anno iniziale: ");
	    	 		LocalDate data_I = LocalDate.of(anno_I, mese_I, giorno_I);

	    	 		int giorno_F = LeggiInput.intero("Inserire giorno finale: ");
	    	 		int mese_F = LeggiInput.intero("Inserire mese finale: ");
	    	 		int anno_F = LeggiInput.intero("Inserire anno finale: ");
	    	 		LocalDate data_F = LocalDate.of(anno_F, mese_F, giorno_F);  
	    	 		
	    	 		int ora_I = LeggiInput.intero("Inserire ora iniziale: ");
	    	 		int minuti_I = LeggiInput.intero("Inserire minuti inziali: ");
	    	 		LocalTime orario_I = LocalTime.of(ora_I, minuti_I);
	    	 		
	    	 		int ora_F = LeggiInput.intero("Inserire ora finale: ");
	    	 		int minuti_F = LeggiInput.intero("Inserire minuti finali: ");
	    	 		LocalTime orario_F = LocalTime.of(ora_F, minuti_F);
	    	 		
	    	 		agenda.inserimentoDisp(selezionato, data_I, data_F, orario_I, orario_F);
	     };
	     break;
	    
	     // Giorni specifici ore continuate
	     case 2:{
	    	 		int ora_I = LeggiInput.intero("Inserire ora iniziale: ");
	    	 		int minuti_I = LeggiInput.intero("Inserire minuti inziali: ");
	    	 		LocalTime orario_I = LocalTime.of(ora_I, minuti_I);
   	 		
	    	 		int ora_F = LeggiInput.intero("Inserire ora finale: ");
	    	 		int minuti_F = LeggiInput.intero("Inserire minuti finali: ");
	    	 		LocalTime orario_F = LocalTime.of(ora_F, minuti_F);
   	 		
	    	 		ArrayList<LocalDate> giorniVari = new ArrayList<LocalDate>();
	    	 		
	    	 		boolean continuare;
					do{
	    	 			
	    	 			int giorno = LeggiInput.intero("Inserire giorno: ");
		    	 		int mese = LeggiInput.intero("Inserire mese: ");
		    	 		int anno = LeggiInput.intero("Inserire anno: ");
		    	 		LocalDate data = LocalDate.of(anno, mese, giorno);
	    	 			giorniVari.add(data);
	    	 			
	    	 			
	    	 			continuare = LeggiInput.doppiaScelta("Continuare l'inserimento?");
	    	 		}while(continuare == true);
					
					LocalDate []array = new LocalDate[giorniVari.size()];
					giorniVari.toArray(array);
					
					agenda.inserimentoDisp(selezionato, orario_I, orario_F, array);
	     
	     };
	     break;
	     
	     //un giorno e orario specifico 
	     case 3: {
	    	 		int giorno = LeggiInput.intero("Inserire giorno: ");
	    	 		int mese = LeggiInput.intero("Inserire mese: ");
	    	 		int anno = LeggiInput.intero("Inserire anno: ");
	    	 		LocalDate data = LocalDate.of(anno, mese, giorno);  
   	 		
	    	 		int ora_I = LeggiInput.intero("Inserire ora iniziale: ");
	    	 		int minuti_I = LeggiInput.intero("Inserire minuti inziali: ");
	    	 		LocalTime orario_I = LocalTime.of(ora_I, minuti_I);
   	 		
	    	 		int ora_F = LeggiInput.intero("Inserire ora finale: ");
	    	 		int minuti_F = LeggiInput.intero("Inserire minuti finali: ");
	    	 		LocalTime orario_F = LocalTime.of(ora_F, minuti_F);
   	 		
	    	 		agenda.inserimentoDisp(selezionato, data, orario_I, orario_F);
	    	 		
	    	 
	     };
	     break;
	     
	     case 0: { } break;
	     }
	}

	/**
	 * Metodo per la resituzione di un giorno preciso da un arraylist di giorni
	 * @param elencoTemp
	 * @return giorno_visita o nullo se non viene trovato
	 * @author Riccardo Grespan
	 */
	
	public static Giorno selezionaVisita(ArrayList<Giorno> elencoTemp)
	{
		Giorno nullo = null;
		
		if(elencoTemp.isEmpty()){
			System.out.println("Nessuna visita trovata");
			return nullo;
		};
		if(elencoTemp.size() >1 ){
			System.out.println("*******"+elencoTemp.size()+" visite trovate:*******\n");
	   for(Giorno giorno: elencoTemp){
		   System.out.println(giorno.toString());

	   };
	   int scelta=LeggiInput.intero("******Scegliere tramite un numero la visita desiderata*******")-1;
	   Giorno giorno_visita = elencoTemp.get(scelta);
	   return giorno_visita;
	
		}
   
		Giorno giorno_visita = elencoTemp.get(0);
		return giorno_visita;
	};
	
}
