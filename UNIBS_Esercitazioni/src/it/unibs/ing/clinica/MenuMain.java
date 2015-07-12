package it.unibs.ing.clinica;
import it.unibs.ing.myutility.*;

import java.io.File;
import java.lang.String;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;






/**
 * Classe main che costituisce il menu del programma e che consente l'interazione con l'utente
 * @author Riccardo Grespan
 *
 */

public class MenuMain {

	static final String NOMEFILECLINICA = "clinicamedica.dat";
	static final String MSG_SALVA = "Salvataggio dati in corso!";
	static final String MSG_NO_CAST = "Attenzione, ci sono problemi con il cast del file!";
	static final String MSG_OK_FILE = "Benvenuto, il caricamento dal file è avvenuto con successo!";
	static final String MSG_NO_FILE = "Benvenuto nel programma di gestione di una clinica medica!";
    static final String MSG_SALUTO = "Arrivederci, grazie per aver usato il programma di gestione della clinica!";
	
	// Menu principale
	static final String[] MENU_PRINCIPALE = {"Azioni dati", "Azioni visita", "Ricerca", "Statistiche"};
	// Sottomenu Prima scelta menu principale
	static final String[] MENU_DATI = {"Inserisci dati utente", "Inserisci dati medico", "Modifica dati utente", "Modifica dati medico", "Visualizza dati medico", "Visualizza dati utente"};
	// Sottomenu Seconda scelta menu principale
	static final String[] MENU_VISITA = {"Prenota visita", "Modifica prenotazione","Cancellazione visita", "Visualizzazione elenco visite utente", "Visualizzazione elenco visite medico" };	
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
		
		//Inizio caricamento (il salvataggio è in fondo al main)
				File fClinica = new File(NOMEFILECLINICA);
				Archivio archivio = null;
				
				Agenda agenda = null;
				
				Contenitore c1 = null;
				
				boolean caricamentoRiuscito = false;
				
				if ( fClinica.exists() )
				{
				 try 
				  {
					 c1 = (Contenitore)SalvataggioFile.caricaOggetto(fClinica);
					 archivio = c1.getArchivio();
					 agenda = c1.getAgenda();
				   }
				  catch (ClassCastException e)
				   {
					 System.out.println(MSG_NO_CAST);
					}
				   finally
					{
				      if ( (archivio != null) || (agenda != null) )
					    {
						 System.out.println(MSG_OK_FILE);
						 caricamentoRiuscito = true;
						 }
					  }
					
				 }//fine caricamento
					
				if (!caricamentoRiuscito)//Viene effettutato se il file non esiste(possibilità di mettere la scelta di creare o meno un nuovo file in un menu iniziale)
				   {
					System.out.println(MSG_NO_FILE);
					archivio = new Archivio();
					agenda = new Agenda();
				    }
		
		do{scelta = elenco.stampaMenu();
		
		
		switch(scelta){
		
		// inserimento e modifica dati
		case 1: {    
					int scelta_dati = elenco_dati.stampaSottoMenu();
					
					switch(scelta_dati){
					
					// Inserimento dati utente
					case 1:{
						     String nome, cognome, dataNascita, luogoNascita, sesso, codiceFiscale, numTelefono;
							
							 nome = LeggiInput.stringa("Nome: ");
							 cognome = LeggiInput.stringa("Cognome: ");
							 dataNascita = LeggiInput.stringa("Data di nascita: ");
							 luogoNascita = LeggiInput.stringa("Luogo di Nascita: ");
							 sesso = LeggiInput.stringa("Sesso: ");
							 numTelefono = LeggiInput.stringa("Numero di telefono: ");
							 codiceFiscale = LeggiInput.stringa("CF: ");
							 
							 archivio.inserimentoUtente(nome, cognome, dataNascita, luogoNascita, sesso, numTelefono, codiceFiscale);
							
					}
					break;
					
					// Inserimento dati dottore
					case 2:{
							 String nome, cognome, dataNascita, luogoNascita, sesso, codiceFiscale, numTelefono, tipo, areaCompetenza, codiceAlbo;
							 nome = LeggiInput.stringa("Nome: ");
							 cognome = LeggiInput.stringa("Cognome: ");
							 dataNascita = LeggiInput.stringa("Data di nascita: ");
							 luogoNascita = LeggiInput.stringa("Luogo di Nascita: ");
							 sesso = LeggiInput.stringa("Sesso: ");
							 numTelefono = LeggiInput.stringa("Numero di telefono: ");
							 codiceFiscale = LeggiInput.stringa("CF: ");
							 tipo = LeggiInput.stringa("Tipo: ");
							 codiceAlbo = LeggiInput.stringa("Codice albo: ");
						     
							 
							 if(tipo.toLowerCase().equals("specialista"))
							 {
								 areaCompetenza = LeggiInput.stringa("Area di competenza: ");
								 archivio.inserimentoMedico(nome, cognome, dataNascita, luogoNascita, sesso, numTelefono, codiceFiscale, codiceAlbo, tipo, areaCompetenza );
								 Medico selezionato = archivio.ricercaMedici(codiceAlbo);
								 menuInserimentoDisp(selezionato, agenda);
							 }
							 else{
								 archivio.inserimentoMedico(nome, cognome, dataNascita, luogoNascita, sesso, numTelefono, codiceFiscale, codiceAlbo, tipo );
								 Medico selezionato = archivio.ricercaMedici(codiceAlbo);
								 menuInserimentoDisp(selezionato, agenda);
							 }
					}
					break;
					
					// Modifica dati utente
					case 3:{
						
							String dato = LeggiInput.stringa("Inserire dato ricerca: ");
						    Utente da_modificare = archivio.ricercaUtenti(dato);
						    if(da_modificare!=null){
						        String campo = LeggiInput.stringa("Campo da modificare: \n(nome, cognome, data di nascita, luogo di nascita, sesso, telefono, codice fiscale)");
						        String dato_modifica = LeggiInput.stringa("Nuovo dato: ");
						        da_modificare.modificaUtente(campo, dato_modifica);
						    }
						  	
					}
					break;
					
					// Modifica dati medico
					case 4:{
							String dato = LeggiInput.stringa("Inserire dato ricerca: ");
							Medico da_modificare = archivio.ricercaMedici(dato);
				            if(da_modificare!=null){   
					            String campo = LeggiInput.stringa("Campo da modificare: \n(nome, cognome, data di nascita, luogo di nascita, sesso, telefono, codice fiscale, \ntipo, area di Competenza, codice albo, disponibilità)");
								campo = campo.toLowerCase();
								if(campo.equals("disponibilità")){
									String dec_disp = LeggiInput.stringa("Aggiungere o cancellare?");	
									if (dec_disp.equalsIgnoreCase("cancellare")) menuCancDisp(da_modificare, agenda);
									else menuInserimentoDisp(da_modificare, agenda);
								}
								else{
								String dato_modifica = LeggiInput.stringa("Nuovo dato: ");
								da_modificare.modificaMedico(campo, dato_modifica);
								}
				            }
					}
					break;
					
					case 5:{
						String dato = LeggiInput.stringa("Inserire dato ricerca: ");
						Medico cercato = archivio.ricercaMedici(dato);
						if(cercato!=null){
							System.out.println(cercato.toStringNomeCognomeAlbo());
						}
					}
					
					case 6:{
						String dato = LeggiInput.stringa("Inserire dato ricerca: ");
					    Utente cercato = archivio.ricercaUtenti(dato);
					    if(cercato!=null){
					    	System.out.println(cercato.toStringNomeCognome()+cercato.toStringCodiceFiscale());
					    }
					}
					
					}
		
		}
		break;
		
		// prenotazione e cancellazione visite
		case 2:{  
			 		
			 		int scelta_visita = elenco_visita.stampaSottoMenu();
				
			 		switch(scelta_visita){
				
			 			// Prenotare visita
			 			case 1:{
			 					String dato = LeggiInput.stringa("Inserire dato ricerca utente: ((nome, cognome, data di nascita, luogo di nascita, telefono, codice Fiscale)");
			 					Utente selezionato = archivio.ricercaUtenti(dato);
			 					if(selezionato!=null){
			 						int giorno = LeggiInput.intero("Inserire giorno: ");
			 						int mese = LeggiInput.intero("Inserire mese: ");
			 						int anno = LeggiInput.intero("Inserire anno: ");
			 						int ora = LeggiInput.intero("Inserire ora: ");
			 						int minuti = LeggiInput.intero("Inserire minuti: ");
			 						LeggiInput.terminaRiga();
			 						LocalDate data = LocalDate.of(anno, mese, giorno);
			 						LocalTime orario = LocalTime.of(ora, minuti);
			 						
			 					
			 						String tipoVisita = LeggiInput.riga("Inserire il tipo della visita: ");
			 						String areaCompetenza="";
			 				   	    if(tipoVisita.toLowerCase().equals("specialistica")) areaCompetenza=LeggiInput.riga("Inserire l'area di competenza richiesta");
			 						String motivoVisita = LeggiInput.riga("Inserire motivo della visita: ");
			 					
			 						if(!agenda.inserimentoVisita(selezionato, motivoVisita, data, orario, tipoVisita, areaCompetenza)){
			 							if(!agenda.trovaDispGiorno(selezionato, data, orario, tipoVisita, areaCompetenza)){
			 								if(!agenda.trovaDispSett(selezionato, data, tipoVisita, areaCompetenza)){
			 									agenda.trovaDispOvunque(selezionato, data, tipoVisita, areaCompetenza);
			 								}
			 							}
			 						}
			 					}
			 			}
			 			break;
				
			 			// modificare visita
			 			case 2:{ 
			 				    int scelta_sottovisita = elenco_sottovisita.stampaSottoMenu();

			 					switch(scelta_sottovisita){
			 				
			 						// Ricerca Visita precisa
			 						case 1: {
			 							    
			 								String campo = LeggiInput.stringa("Dato medico: ");
			 								Medico medico = archivio.ricercaMedici(campo);
			 								if(medico!=null){
			 									int giorno = LeggiInput.intero("Inserire giorno: ");
			 									int mese = LeggiInput.intero("Inserire mese: ");
			 									int anno = LeggiInput.intero("Inserire anno: ");
			 									int ora = LeggiInput.intero("Inserire ora: ");
			 									int minuti = LeggiInput.intero("Inserire minuti: ");
			 									LocalDate data = LocalDate.of(anno, mese, giorno);
			 									LocalTime orario = LocalTime.of(ora, minuti);
		 				     
			 									Giorno giorno_visita = agenda.specificaVisita(medico, data, orario); 
			 									if(giorno_visita!=null){
			 										Visita selezionata = giorno_visita.getVisita();
			 										modificaVisitaMain(giorno_visita, selezionata);
			 									}
			 								}	
			 						}
			 						break;
			 					
			 						// Ricerca visita per medico
			 						case 2:{
			 								String campo = LeggiInput.stringa("Dato medico: ");
			 								Medico cercato = archivio.ricercaMedici(campo);
			 									if(cercato!=null){
			 										ArrayList<Giorno> giorni_visite = agenda.visiteMedico(cercato);
										
			 										Giorno giorno_visita = selezionaVisita(giorni_visite);
			 										if(giorno_visita!=null){
				 										Visita selezionata = giorno_visita.getVisita();
				 										modificaVisitaMain(giorno_visita, selezionata);
				 									}
			 									}
			 							
			 							} 
			 							break;
			 							
			 						// Ricerca visite per utente
			 						case 3: {
			 									String campo = LeggiInput.stringa("Dato utente: ");
			 									Utente cercato = archivio.ricercaUtenti(campo);
			 									if(cercato!=null){
			 										ArrayList<Giorno> giorni_visite = agenda.visiteUtente(cercato);
			 										Giorno giorno_visita = selezionaVisita(giorni_visite);
			 										if(giorno_visita!=null){
				 										Visita selezionata = giorno_visita.getVisita();
				 										modificaVisitaMain(giorno_visita, selezionata);
				 									}
			 									}
			 	                       }
			 	                       break;
			 							
			 	                      // Ricerca visite per tipo
			 						case 4:{ 
			 									String tipo = LeggiInput.stringa("Inserisci il tipo della visita:");
			 									ArrayList<Giorno> giorni_visite = agenda.visiteTipo(tipo);
			 									Giorno giorno_visita = selezionaVisita(giorni_visite);
			 									if(giorno_visita!=null){
			 										Visita selezionata = giorno_visita.getVisita();
			 										modificaVisitaMain(giorno_visita, selezionata);
			 									}
			 									
			 						} 
			 						break;
			 	                       
			 						case 0: {}
			 						break;
			 						
			 					}
			 						
			 					
			 							
			 			}
			 			break;
			 			
			 			
			 			// cancellazione visita
			 			case 3:{ 
			 						int scelta_sottovisita = elenco_sottovisita.stampaSottoMenu();
			 			
			 						switch(scelta_sottovisita){
			 							case 1 :{ 
			 									String campo = LeggiInput.stringa("Dato medico: ");
			 									Medico medico = archivio.ricercaMedici(campo);
			 									if(medico!=null){
			 									    int giorno = LeggiInput.intero("Inserire giorno: ");
			 										int mese = LeggiInput.intero("Inserire mese: ");
			 										int anno = LeggiInput.intero("Inserire anno: ");
			 										int ora = LeggiInput.intero("Inserire ora: ");
			 										int minuti = LeggiInput.intero("Inserire minuti: ");
			 										LocalDate data = LocalDate.of(anno, mese, giorno);
			 										LocalTime orario = LocalTime.of(ora, minuti);
	 				     
			 										Giorno giorno_visita = agenda.specificaVisita(medico, data, orario); 
			 										if(giorno_visita!=null){
			 											boolean decisione = LeggiInput.doppiaScelta("Cancellare visita?");
			 											if (decisione) 
			 											{ 
			 												giorno_visita.rimuoviVisita();
			 												giorno_visita.cambiaStato("prenotabile");
			 											}
			 										}	
			 									}
			 				
			 							}
			 							break;
			 							
			 							// Ricerca visite per medico
			 							case 2:{
			 									String campo = LeggiInput.stringa("Dato medico: ");
			 									Medico cercato = archivio.ricercaMedici(campo);
			 									if(cercato!=null){	
			 										ArrayList<Giorno> giorni_visite = agenda.visiteMedico(cercato);
											
			 										Giorno giorno_visita = selezionaVisita(giorni_visite);
			 							
			 										if(giorno_visita!=null){
			 											boolean decisione = LeggiInput.doppiaScelta("Cancellare visita?");
			 											if (decisione) 
			 											{ 
			 												giorno_visita.rimuoviVisita();
			 												giorno_visita.cambiaStato("prenotabile");
			 											}
			 										}
			 									}
			 							  		
			 							}
			 							break;
			 							
			 							// Ricerca visite per utente
			 							case 3: {
			 									String campo = LeggiInput.stringa("Dato utente: ");
			 									Utente cercato = archivio.ricercaUtenti(campo);
			 									if(cercato!=null){
			 										ArrayList<Giorno> giorni_visite = agenda.visiteUtente(cercato);
			 								
			 										Giorno giorno_visita = selezionaVisita(giorni_visite);
			 										if(giorno_visita!=null){
			 											boolean decisione = LeggiInput.doppiaScelta("Cancellare visita?");
			 											if (decisione) 
			 											{ 
			 												giorno_visita.rimuoviVisita();
			 												giorno_visita.cambiaStato("prenotabile");
			 											}
			 										}	
			 									}
			 							}
			 							break;
			 							
			 							// Ricerca visite per tipo
			 							case 4:{
			 										String tipo = LeggiInput.stringa("Inserisci il tipo della visita:");
			 										ArrayList<Giorno> giorni_visite = agenda.visiteTipo(tipo);
			 								
			 										Giorno giorno_visita = selezionaVisita(giorni_visite);
					 								
			 										if(giorno_visita!=null){
			 											boolean decisione = LeggiInput.doppiaScelta("Cancellare visita?");
			 											if (decisione) 
			 											{ 
			 												giorno_visita.rimuoviVisita();
			 												giorno_visita.cambiaStato("prenotabile");
			 											}
			 										}	
													
			 							}
			 							break;
			 						
			 							// Uscita
			 							case 0:{}
			 							break;
			 						
			 							
			 						}
			 						
			 			
			 			}
			 			break;
			 			
						// Visualizzazione visite utente
						case 4:{
									String campo = LeggiInput.stringa("Dato utente: ");
									Utente cercato = archivio.ricercaUtenti(campo);
									if(cercato!=null){
										ArrayList<Giorno> giorni_visite = agenda.visiteUtente(cercato);
								
										for(Giorno giorno: giorni_visite){
									
											if(giorno.getStato() == StatoVisita.Prenotata)
											{
												System.out.println(giorno.getStato().toString());
												System.out.println(giorno.getData().toString());
											}
											
											if(giorno.getStato() == StatoVisita.Conclusa)
											{
												System.out.println(giorno.getStato().toString());
												System.out.println(giorno.getData().toString());
												System.out.println("Referto: " + giorno.getVisita().getReferto());
												System.out.println("Prescrizione: " + giorno.getVisita().getPrescrizione());
											}
											
										}	
									}
								
						}
						break;
							
						// Visualizzazione visite medico
						case 5:{
										String campo = LeggiInput.stringa("Dato medico: ");
										Medico cercato = archivio.ricercaMedici(campo);
										if(cercato!=null){
											ArrayList<Giorno> giorni_visite = agenda.visiteMedico(cercato);
								
											for(Giorno giorno: giorni_visite){
											
												if(giorno.getStato() == StatoVisita.Prenotata)
												{
													System.out.println(giorno.getStato().toString());
													System.out.println(giorno.getData().toString());
													System.out.println("Motivo: "+giorno.getVisita().getMotivo());
												}
											
											}
										}
										
							
						} 
						break;
			 			
			 			
			 			// Uscita
			 			case 0:{}
			 			break;
			
			 		}
		}
		break;
		
		// ricerca 
		case 3:{ 
			        int scelta_ricerca;
					scelta_ricerca = elenco_ricerca.stampaSottoMenu();
					
					switch(scelta_ricerca){
					
					// Ricerca giorni di lavoro medici
					case 1:{
								String campo = LeggiInput.stringa("Dato medico: ");
								Medico cercato = archivio.ricercaMedici(campo);
								if(cercato!=null){
									System.out.println(agenda.orariVisita(cercato));
								}
					}
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
						
					}
					break;
					
					// Uscita
					case 0:{}
					break;
					
					}	
		}
		break;
		
		// Statistiche
		
		case 4:{ 
					
					archivio.areeCompetenzaTot();
			     
					int scelta_statistiche;
					scelta_statistiche = elenco_statistiche.stampaSottoMenu();
			
					switch(scelta_statistiche){
							// Visite totali		 
							case 1:{
									System.out.println(agenda.statisticheVisite());
							} break;
			 
							//Visite totali per tipo
							case 2:{
									System.out.println(agenda.statisticheVisiteTipo());
							} break;
							
							//Visite prenotate e concluse per competenza
							case 3:{
									System.out.println(agenda.statisticheVisiteArea(archivio.areeCompetenzaTot()));
							} break;
							
							//Aree con minor e maggior numero di visite
							case 4:{
									System.out.println(agenda.statisticheVisiteAreaMinMax(archivio.areeCompetenzaTot()));
							} break;
							
							//Visite per medico
							case 5:{
									System.out.println(agenda.statisticheVisiteMedici(archivio.getElencoMedici()));
							} break;
						
					}; break;	
		}
		
		case 0: {}
		break;
				
		}
		}while(scelta != 0);
		
		//Salvataggio dati
       
		System.out.println(MSG_SALVA);
		c1 = new Contenitore(archivio,agenda);
        SalvataggioFile.salvaOggetto(fClinica, c1);
        System.out.println(MSG_SALUTO);
        
        //Fine salvataggio
        
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
	    	 		if(!Date.controlloIntervallo(data_I, data_F)) System.out.println("Inserire un intervallo di giorni corretto");       
	    	 		else agenda.cancellaDisp(da_modificare, data_I, data_F, orario_I, orario_F);
	    	 		System.out.println("Disponibilità cancellate");
	    	 		
	     }
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
					if(!Date.controlloElencoGiorni(array)) System.out.println("La domenica non si lavora");
					else agenda.cancellaDisp(da_modificare, orario_I, orario_F, array);
					System.out.println("Disponibilità cancellate");
	     
	     }
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
 
	    	 		if(data.getDayOfWeek().getValue()==7) System.out.println("La domenica non si lavora");
   	 		        else agenda.cancellaDisp(da_modificare, data, orario_I, orario_F);
	    	 		System.out.println("Disponibilità cancellate");
	    	 
	     }
	     break;
	     
	     case 0: {} 
	     break;
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
	    	 		if(!Date.controlloIntervallo(data_I, data_F)) System.out.println("Inserire un intervallo di giorni corretto");       
	    	 		else agenda.inserimentoDisp(selezionato, data_I, data_F, orario_I, orario_F);
	    	 		System.out.println("Disponibilità inserite");
	     }
	     break;
	    
	     // Giorni specifici ore continuate
	     case 2:{
	    	 		int ora_I = LeggiInput.intero("Inserire ora iniziale: ");
	    	 		int minuti_I = LeggiInput.intero("Inserire minuti iniziali: ");
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
					if(!Date.controlloOrari(orario_I, orario_F)) System.out.println("Inserire orari corretti");
	    	 		else if(!Date.controlloElencoGiorni(array)) System.out.println("La domenica non si lavora");
	    	 			else agenda.inserimentoDisp(selezionato, orario_I, orario_F, array);
					
					System.out.println("Disponibilità inserite");
	     }
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
	    	 		if(!Date.controlloOrari(orario_I, orario_F)) System.out.println("Inserire orari corretti");
	    	 		else if(data.getDayOfWeek().getValue()==7) System.out.println("La domenica non si lavora");
	    	 			else agenda.inserimentoDisp(selezionato, data, orario_I, orario_F);
	    	 		
	    	 		System.out.println("Disponibilità inserite");	 
	     }
	     break;
	     
	     case 0: {} 
	     break;
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
		}
		if(elencoTemp.size() >1 ){
			System.out.println("*******"+elencoTemp.size()+" visite trovate:*******\n");
	   for(Giorno giorno: elencoTemp){
		   System.out.println(giorno.getData().toString());
		   System.out.println(giorno.getStato().toString());
		   System.out.println(giorno.getVisita().toString());

	   }
	   int scelta=LeggiInput.intero("******Scegliere tramite un numero la visita desiderata*******")-1;
	   Giorno giorno_visita = elencoTemp.get(scelta);
	   return giorno_visita;
	
		}
   
		Giorno giorno_visita = elencoTemp.get(0);
		return giorno_visita;
	}
    
	/**
	 * Sottomenu per modificare i vari campi di una visita
	 * @param giorno_visita l'oggetto Giorno che contiene la visita selezionata
	 * @param selezionata la visita che si vuole modificare
	 * @author Riccardo Grespan
	 */
	public static void modificaVisitaMain(Giorno giorno_visita, Visita selezionata){
		String campo_visita = LeggiInput.riga("Inserire campo da modificare(motivo, referto, prescrizione, tipo, competenza): ");
			if(campo_visita.equalsIgnoreCase("stato")) 
			{
				String input = LeggiInput.riga("Inserire nuovo stato(prenotata, conclusa, non prenotabile, refertata: ");
				giorno_visita.cambiaStato(input);
			}

			if(campo_visita.equalsIgnoreCase("referto medico"))
			{

				String input = LeggiInput.riga("Inserire referto: ");
				selezionata.modificaVisita(campo_visita, input);
				giorno_visita.cambiaStato("refertata");	

			}

			String input = LeggiInput.riga("Inserire nuovo dato: ");
			selezionata.modificaVisita(campo_visita, input);
	}
}
