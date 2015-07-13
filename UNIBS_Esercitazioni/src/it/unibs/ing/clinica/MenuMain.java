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
    static final String MSG_ERRORE_INTERV="Inserire un intervallo di giorni corretto";
    static final String MSG_ERRORE_ORARI="Inserire degli orari corretti";
    static final String CANC_DISP="Disponibilità cancellate";
    static final String INS_DISP="Disponibilità inserite";
    static final String NO_DOMENICA="Di domenica non si lavora";
    static final String NOME = "Nome: ";
    static final String COGNOME="Cognome: ";
    static final String DATA_NASCITA="Data di nascita: ";
    static final String LUOGO_NASCITA="Luogo di nascita: ";
    static final String SESSO="Sesso: ";
    static final String TELEFONO="Telefono: ";
    static final String CF="Codice fiscale: ";
    static final String TIPO="Tipo: ";
    static final String CODICE_ALBO="Codice albo: (è necessario che sia univoco) ";
    static final String AREA="Area di competenza: (separare più aree in questo modo: Ortopedia-Cardiologia)", AREA_RICHIESTA="Inserire l'area di competenza richiesta: ";
    static final String RICERCA_MEDICO="Inserire dato per la ricerca di un medico: \n(nome, cognome, data di nascita, luogo di nascita, sesso, telefono, codice fiscale, \ntipo, area di competenza, codice albo)";
    static final String RICERCA_UTENTE="Inserire dato per la ricerca di un utente: \n(nome, cognome, data di nascita, sesso, luogo di nascita, telefono, codice fiscale)";
    static final String DATI_CORR="Dati correnti:\n";
    static final String CAMPI_UTENTE="Campo da modificare: \n(nome, cognome, data di nascita, luogo di nascita, sesso, telefono, codice fiscale)";
    static final String CAMPI_MEDICO="Campo da modificare: \n(nome, cognome, data di nascita, luogo di nascita, sesso, telefono, codice fiscale, \ntipo, area di competenza, codice albo, disponibilità)";
    static final String NUOVO_DATO="Nuovo dato: ";
    static final String AGG_OR_CANC="Aggiungere o cancellare?";
    static final String NO_CAMPO="Campo non esistente";
    static final String GIORNO="Inserire giorno: ", GIORNO_F="Inserire giorno finale: ", 	GIORNO_I="Inserire giorno iniziale: ";
    static final String MESE="Inserire mese: ", 	MESE_F="Inserire mese finale: ", 		MESE_I="Inserire mese iniziale: ";
    static final String ANNO="Inserire anno: ", 	ANNO_F="Inserire anno finale: ", 		ANNO_I="Inserire anno iniziale: ";
    static final String ORA="Inserire ora: ", 		ORA_F="Inserire ora finale: ", 			ORA_I="Inserire ora iniziale: ";
    static final String MINUTI="Inserire minuti: ", MINUTI_F="Inserire minuti finali:", 	MINUTI_I="Inserire minuti iniziali: ";
    static final String TIPO_VIS="Inserire il tipo della visita: ";
    static final String MOTIVO_VIS="Inserire il motivo della visita: ", MOTIVO="Motivo: ";
    static final String CANC_VIS="Cancellare visita/e?";
    static final String REFERTO="Referto: ", REFERTO_SPEC="Inserire il referto dello specialista: ";
    static final String PRESCRIZIONE="Prescrizione: ", PRESC_SPEC="Inserire la prescrizione dello specialista: ";
    static final String APPR_SPEC="Lo specialista ha approvato il referto del medico di base?";
    static final int CORREZIONE_INDICE=1;
    static final String NO_VIS="Nessuna visita trovata";
    static final String SCELTA_VIS="******Scegliere tramite un numero la visita desiderata*******";
    
    
    
    
	
	// Menu principale
	static final String[] MENU_PRINCIPALE = {"Azioni dati", "Azioni visita", "Ricerca", "Statistiche"};
	// Sottomenu Prima scelta menu principale
	static final String[] MENU_DATI = {"Inserisci dati utente", "Inserisci dati medico", "Modifica dati utente", "Modifica dati medico", "Visualizza dati medico", "Visualizza dati utente"};
	// Sottomenu Seconda scelta menu principale
	static final String[] MENU_VISITA = {"Prenota visita", "Modifica prenotazione","Cancellazione visita", "Visualizzazione visite utente (prenotate e concluse)", "Visualizzazione visite medico (prenotate)", "Consulto specialistico" };	
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
							
							 nome = LeggiInput.stringa(NOME);
							 cognome = LeggiInput.stringa(COGNOME);
							 dataNascita = LeggiInput.stringa(DATA_NASCITA);
							 LeggiInput.terminaRiga();
							 luogoNascita = LeggiInput.riga(LUOGO_NASCITA);
							 sesso = LeggiInput.stringa(SESSO);
							 numTelefono = LeggiInput.stringa(TELEFONO);
							 codiceFiscale = LeggiInput.stringa(CF);
							 
							 archivio.inserimentoUtente(nome, cognome, dataNascita, luogoNascita, sesso, numTelefono, codiceFiscale);
							
					}
					break;
					
					// Inserimento dati dottore
					case 2:{
							 String nome, cognome, dataNascita, luogoNascita, sesso, codiceFiscale, numTelefono, tipo, areaCompetenza, codiceAlbo;
							 nome = LeggiInput.stringa(NOME);
							 cognome = LeggiInput.stringa(COGNOME);
							 dataNascita = LeggiInput.stringa(DATA_NASCITA);
							 LeggiInput.terminaRiga();
							 luogoNascita = LeggiInput.riga(LUOGO_NASCITA);
							 sesso = LeggiInput.stringa(SESSO);
							 numTelefono = LeggiInput.stringa(TELEFONO);
							 codiceFiscale = LeggiInput.stringa(CF);
							 tipo = LeggiInput.stringa(TIPO);
							 codiceAlbo = LeggiInput.stringa(CODICE_ALBO);
						     
							 
							 if(tipo.toLowerCase().equals("specialista"))
							 {   
								 LeggiInput.terminaRiga();
								 areaCompetenza = LeggiInput.riga(AREA);
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
							LeggiInput.terminaRiga();
							String dato = LeggiInput.riga(RICERCA_UTENTE);
						    Utente da_modificare = archivio.ricercaUtenti(dato);
						    if(da_modificare!=null){
						    	System.out.println(DATI_CORR+da_modificare.toString());
						    	
						        String campo = LeggiInput.riga(CAMPI_UTENTE);
						        if(!campo.equalsIgnoreCase("nome")&!campo.equalsIgnoreCase("cognome")&!campo.equalsIgnoreCase("data di nascita")&!campo.equalsIgnoreCase("luogo di nascita")
						        &!campo.equalsIgnoreCase("sesso")&!campo.equalsIgnoreCase("telefono")&!campo.equalsIgnoreCase("codice fiscale")) System.out.println(NO_CAMPO);
				            	else{
				            		
				            		String dato_modifica = LeggiInput.riga(NUOVO_DATO);
				            		da_modificare.modificaUtente(campo, dato_modifica);
				            	}
						    }
						  	
					}
					break;
					
					// Modifica dati medico
					case 4:{
							LeggiInput.terminaRiga();
							String dato = LeggiInput.riga(RICERCA_MEDICO);
							Medico da_modificare = archivio.ricercaMedici(dato);
							
				            if(da_modificare!=null){   
				            	System.out.println(DATI_CORR+da_modificare.toString());
					            String campo = LeggiInput.riga(CAMPI_MEDICO);
								campo = campo.toLowerCase();
								if(campo.equals("disponibilità")){
									String dec_disp = LeggiInput.stringa(AGG_OR_CANC);	
									if (dec_disp.equalsIgnoreCase("cancellare")) menuCancDisp(da_modificare, agenda);
									else menuInserimentoDisp(da_modificare, agenda);
								}
								else if(!campo.equalsIgnoreCase("nome")&!campo.equalsIgnoreCase("cognome")&!campo.equalsIgnoreCase("data di nascita")&!campo.equalsIgnoreCase("luogo di nascita")
										&!campo.equalsIgnoreCase("sesso")&!campo.equalsIgnoreCase("telefono")&!campo.equalsIgnoreCase("codice fiscale")&!campo.equalsIgnoreCase("area di competenza")
										&!campo.equalsIgnoreCase("tipo")&!campo.equalsIgnoreCase("codice albo")) System.out.println(NO_CAMPO);
								else {
										String dato_modifica = LeggiInput.riga(NUOVO_DATO);
										da_modificare.modificaMedico(campo, dato_modifica);
								}
				            }
					}
					break;
					//visualizzazione dati medico
					case 5:{
						String dato = LeggiInput.stringa(RICERCA_MEDICO);
						Medico cercato = archivio.ricercaMedici(dato);
						if(cercato!=null){
							System.out.println(cercato.toString());
						}
					}
					break;
					//visualizzazione dati utente
					case 6:{
						String dato = LeggiInput.stringa(RICERCA_UTENTE);
					    Utente cercato = archivio.ricercaUtenti(dato);
					    if(cercato!=null){
					    	System.out.println(cercato.toString());
					    }
					}
					break;
					
					}
		
		}
		break;
		
		// prenotazione e cancellazione visite
		case 2:{  
			 		
			 		int scelta_visita = elenco_visita.stampaSottoMenu();
				
			 		switch(scelta_visita){
				
			 			// Prenotare visita
			 			case 1:{
			 					LeggiInput.terminaRiga();
			 					String dato = LeggiInput.riga(RICERCA_UTENTE);
			 					Utente selezionato = archivio.ricercaUtenti(dato);
			 					if(selezionato!=null){
			 						int giorno = LeggiInput.intero(GIORNO);
			 						int mese = LeggiInput.intero(MESE);
			 						int anno = LeggiInput.intero(ANNO);
			 						int ora = LeggiInput.intero(ORA);
			 						int minuti = LeggiInput.intero(MINUTI);
			 						LocalDate data = LocalDate.of(anno, mese, giorno);
			 						LocalTime orario = LocalTime.of(ora, minuti);
			 						
			 						LeggiInput.terminaRiga();
			 						String tipoVisita = LeggiInput.riga(TIPO_VIS);
			 						String areaCompetenza="";
			 				   	    if(tipoVisita.toLowerCase().equals("specialistica")) areaCompetenza=LeggiInput.riga(AREA_RICHIESTA);
			 						String motivoVisita = LeggiInput.riga(MOTIVO_VIS);
			 					
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
			 							    LeggiInput.terminaRiga();
			 								String campo = LeggiInput.riga(RICERCA_MEDICO);
			 								Medico medico = archivio.ricercaMedici(campo);
			 								if(medico!=null){
			 									int giorno = LeggiInput.intero(GIORNO);
			 									int mese = LeggiInput.intero(MESE);
			 									int anno = LeggiInput.intero(ANNO);
			 									int ora = LeggiInput.intero(ORA);
			 									int minuti = LeggiInput.intero(MINUTI);
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
			 								LeggiInput.terminaRiga();
			 								String campo = LeggiInput.riga(RICERCA_MEDICO);
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
			 									LeggiInput.terminaRiga();
			 									String campo = LeggiInput.riga(RICERCA_UTENTE);
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
			 									String tipo = LeggiInput.stringa(TIPO);
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
			 									LeggiInput.terminaRiga();
			 									String campo = LeggiInput.riga(RICERCA_MEDICO);
			 									Medico medico = archivio.ricercaMedici(campo);
			 									if(medico!=null){
			 									    int giorno = LeggiInput.intero(GIORNO);
			 										int mese = LeggiInput.intero(MESE);
			 										int anno = LeggiInput.intero(ANNO);
			 										int ora = LeggiInput.intero(ORA);
			 										int minuti = LeggiInput.intero(MINUTI);
			 										LocalDate data = LocalDate.of(anno, mese, giorno);
			 										LocalTime orario = LocalTime.of(ora, minuti);
	 				     
			 										Giorno giorno_visita = agenda.specificaVisita(medico, data, orario); 
			 										if(giorno_visita!=null){
			 											boolean decisione = LeggiInput.doppiaScelta(CANC_VIS);
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
			 									LeggiInput.terminaRiga();
			 									String campo = LeggiInput.riga(RICERCA_MEDICO);
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
			 									LeggiInput.terminaRiga();
			 									String campo = LeggiInput.riga(RICERCA_UTENTE);
			 									Utente cercato = archivio.ricercaUtenti(campo);
			 									if(cercato!=null){
			 										ArrayList<Giorno> giorni_visite = agenda.visiteUtente(cercato);
			 								
			 										Giorno giorno_visita = selezionaVisita(giorni_visite);
			 										if(giorno_visita!=null){
			 											boolean decisione = LeggiInput.doppiaScelta(CANC_VIS);
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
			 										String tipo = LeggiInput.stringa(TIPO);
			 										ArrayList<Giorno> giorni_visite = agenda.visiteTipo(tipo);
			 								
			 										Giorno giorno_visita = selezionaVisita(giorni_visite);
					 								
			 										if(giorno_visita!=null){
			 											boolean decisione = LeggiInput.doppiaScelta(CANC_VIS);
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
									LeggiInput.terminaRiga();
									String campo = LeggiInput.riga(RICERCA_UTENTE);
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
												System.out.println(REFERTO + giorno.getVisita().getReferto());
												System.out.println(PRESCRIZIONE + giorno.getVisita().getPrescrizione());
											}
											
										}	
									}
								
						}
						break;
							
						// Visualizzazione visite medico
						case 5:{
										LeggiInput.terminaRiga();
										String campo = LeggiInput.riga(RICERCA_MEDICO);
										Medico cercato = archivio.ricercaMedici(campo);
										if(cercato!=null){
											ArrayList<Giorno> giorni_visite = agenda.visiteMedico(cercato);
								
											for(Giorno giorno: giorni_visite){
											
												if(giorno.getStato() == StatoVisita.Prenotata)
												{
													System.out.println(giorno.getStato().toString());
													System.out.println(giorno.getData().toString());
													System.out.println(MOTIVO+giorno.getVisita().getMotivo());
												}
											
											}
										}
										
							
						} 
						break;
			 			
						case 6:{
								
								ArrayList<Giorno> giorni_visite = agenda.visiteTipo("generica");	
								Giorno giorno_visita = selezionaVisita(giorni_visite);
								if(giorno_visita!=null){
									Medico cercato = archivio.ricercaMedici("specialista");
									if(cercato!=null){
									boolean approvazione=LeggiInput.doppiaScelta(APPR_SPEC);
									LeggiInput.terminaRiga();
									String referto=LeggiInput.riga(REFERTO_SPEC);
									String prescrizione=LeggiInput.riga(PRESC_SPEC);
									giorno_visita.getVisita().inserisciConsulto(cercato, approvazione, referto, prescrizione);
									}
								}
							    
						}
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
								LeggiInput.terminaRiga();
								String campo = LeggiInput.riga(RICERCA_MEDICO);
								Medico cercato = archivio.ricercaMedici(campo);
								if(cercato!=null){
									System.out.println(agenda.orariVisita(cercato));
								}
					}
					break;
					
					// Ricerca medico disponibile per orario
					case 2:{
						        int giorno = LeggiInput.intero(GIORNO);
						        int mese = LeggiInput.intero(MESE);
						        int anno = LeggiInput.intero(ANNO);
						        int ora = LeggiInput.intero(ORA);
						        int minuti = LeggiInput.intero(MINUTI);
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
	    	    boolean valore=true;
	    	    do{
	    	 		int giorno_I = LeggiInput.intero(GIORNO_I);
	    	 		int mese_I = LeggiInput.intero(MESE_I);
	    	 		int anno_I = LeggiInput.intero(ANNO_I);
	    	 		LocalDate data_I = LocalDate.of(anno_I, mese_I, giorno_I);

	    	 		int giorno_F = LeggiInput.intero(GIORNO_F);
	    	 		int mese_F = LeggiInput.intero(MESE_F);
	    	 		int anno_F = LeggiInput.intero(ANNO_F);
	    	 		LocalDate data_F = LocalDate.of(anno_F, mese_F, giorno_F);  
	    	 		
	    	 		int ora_I = LeggiInput.intero(ORA_I);
	    	 		int minuti_I = LeggiInput.intero(MINUTI_I);
	    	 		LocalTime orario_I = LocalTime.of(ora_I, minuti_I);
	    	 		
	    	 		int ora_F = LeggiInput.intero(ORA_F);
	    	 		int minuti_F = LeggiInput.intero(MINUTI_F);
	    	 		LocalTime orario_F = LocalTime.of(ora_F, minuti_F);
	    	 		if(!Date.controlloOrari(orario_I, orario_F)) System.out.println(MSG_ERRORE_ORARI);
	    	 		else if(!Date.controlloIntervallo(data_I, data_F)) System.out.println(MSG_ERRORE_INTERV);       
	    	 		else {
	    	 			agenda.cancellaDisp(da_modificare, data_I, data_F, orario_I, orario_F);
	    	 			System.out.println(CANC_DISP);
	    	 			valore=false;
	    	 		}
	    	 		
	    	    }while(valore);
	    	 		
	    	 		
	     }
	     break;
	    
	     // Cancella giorni specifici ore continuate
	     case 2:{
	    	 	boolean valore=true;
	    	 	do{
	    	 		int ora_I = LeggiInput.intero(ORA_I);
	    	 		int minuti_I = LeggiInput.intero(MINUTI_I);
	    	 		LocalTime orario_I = LocalTime.of(ora_I, minuti_I);
   	 		
	    	 		int ora_F = LeggiInput.intero(ORA_F);
	    	 		int minuti_F = LeggiInput.intero(MINUTI_F);
	    	 		LocalTime orario_F = LocalTime.of(ora_F, minuti_F);
   	 		
	    	 		ArrayList<LocalDate> giorniVari = new ArrayList<LocalDate>();
	    	 		
	    	 		boolean continuare;
					do{
	    	 			
	    	 			int giorno = LeggiInput.intero(GIORNO);
		    	 		int mese = LeggiInput.intero(MESE);
		    	 		int anno = LeggiInput.intero(ANNO);
		    	 		LocalDate data = LocalDate.of(anno, mese, giorno);
	    	 			giorniVari.add(data);
	    	 			
	    	 			
	    	 			continuare = LeggiInput.doppiaScelta("Continuare l'inserimento?");
	    	 		}while(continuare == true);
					
				
					LocalDate []array = new LocalDate[giorniVari.size()];
					giorniVari.toArray(array);
					if(!Date.controlloOrari(orario_I, orario_F)) System.out.println(MSG_ERRORE_ORARI);
	    	 		else if(!Date.controlloElencoGiorni(array)) System.out.println(NO_DOMENICA);
					else {
						agenda.cancellaDisp(da_modificare, orario_I, orario_F, array);
						System.out.println(CANC_DISP);
						valore=false;
					}
	    	 	}while(valore);
	     
	     }
	     break;
	     
	     // Cancella un giorno e orario specifico 
	     case 3: {
	    	 	boolean valore=true;
	    	 	do{
	    	 		int giorno = LeggiInput.intero(GIORNO);
	    	 		int mese = LeggiInput.intero(MESE);
	    	 		int anno = LeggiInput.intero(ANNO);
	    	 		LocalDate data = LocalDate.of(anno, mese, giorno);  
   	 		
	    	 		int ora_I = LeggiInput.intero(ORA_I);
	    	 		int minuti_I = LeggiInput.intero(MINUTI_I);
	    	 		LocalTime orario_I = LocalTime.of(ora_I, minuti_I);
   	 		
	    	 		int ora_F = LeggiInput.intero(ORA_F);
	    	 		int minuti_F = LeggiInput.intero(MINUTI_F);
	    	 		LocalTime orario_F = LocalTime.of(ora_F, minuti_F);
 
	    	 		if(!Date.controlloOrari(orario_I, orario_F)) System.out.println(MSG_ERRORE_ORARI);
	    	 		else if(data.getDayOfWeek().getValue()==7) System.out.println(NO_DOMENICA);
   	 		        else {
   	 		        	agenda.cancellaDisp(da_modificare, data, orario_I, orario_F);
   	 		            System.out.println(CANC_DISP);
   	 		            valore=false;
   	 		        }
	    	 	}while(valore);
	    	 		
	    	 
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
	    	 	boolean valore=true;
	    	 	do{
	    	 		int giorno_I = LeggiInput.intero(GIORNO_I);
	    	 		int mese_I = LeggiInput.intero(MESE_I);
	    	 		int anno_I = LeggiInput.intero(ANNO_I);
	    	 		LocalDate data_I = LocalDate.of(anno_I, mese_I, giorno_I);

	    	 		int giorno_F = LeggiInput.intero(GIORNO_F);
	    	 		int mese_F = LeggiInput.intero(MESE_F);
	    	 		int anno_F = LeggiInput.intero(ANNO_F);
	    	 		LocalDate data_F = LocalDate.of(anno_F, mese_F, giorno_F);  
	    	 		
	    	 		int ora_I = LeggiInput.intero(ORA_I);
	    	 		int minuti_I = LeggiInput.intero(MINUTI_I);
	    	 		LocalTime orario_I = LocalTime.of(ora_I, minuti_I);
	    	 		
	    	 		int ora_F = LeggiInput.intero(ORA_F);
	    	 		int minuti_F = LeggiInput.intero(MINUTI_F);
	    	 		LocalTime orario_F = LocalTime.of(ora_F, minuti_F);
	    	 		if(!Date.controlloOrari(orario_I, orario_F)) System.out.println(MSG_ERRORE_ORARI);
	    	 		else if(!Date.controlloIntervallo(data_I, data_F)) System.out.println(MSG_ERRORE_INTERV);    
	    	 		else {
	    	 			agenda.inserimentoDisp(selezionato, data_I, data_F, orario_I, orario_F);
	    	 			System.out.println(INS_DISP);
	    	 			valore=false;
	    	 		}
	    	 	}while(valore);
	    	 		
	     }
	     break;
	    
	     // Giorni specifici ore continuate
	     case 2:{
	    	 	boolean valore=true;
	    	 	do{
	    	 		int ora_I = LeggiInput.intero(ORA_I);
	    	 		int minuti_I = LeggiInput.intero(MINUTI_I);
	    	 		LocalTime orario_I = LocalTime.of(ora_I, minuti_I);
   	 		
	    	 		int ora_F = LeggiInput.intero(ORA_F);
	    	 		int minuti_F = LeggiInput.intero(MINUTI_F);
	    	 		LocalTime orario_F = LocalTime.of(ora_F, minuti_F);
   	 		
	    	 		ArrayList<LocalDate> giorniVari = new ArrayList<LocalDate>();
	    	 		
	    	 		boolean continuare;
					do{
	    	 			
	    	 			int giorno = LeggiInput.intero(GIORNO);
		    	 		int mese = LeggiInput.intero(MESE);
		    	 		int anno = LeggiInput.intero(ANNO);
		    	 		LocalDate data = LocalDate.of(anno, mese, giorno);
	    	 			giorniVari.add(data);
	    	 			
	    	 			
	    	 			continuare = LeggiInput.doppiaScelta("Continuare l'inserimento?");
	    	 		}while(continuare == true);
					
					LocalDate []array = new LocalDate[giorniVari.size()];
					giorniVari.toArray(array);
					if(!Date.controlloOrari(orario_I, orario_F)) System.out.println(MSG_ERRORE_ORARI);
	    	 		else if(!Date.controlloElencoGiorni(array)) System.out.println(NO_DOMENICA);
	    	 			else {
	    	 				agenda.inserimentoDisp(selezionato, orario_I, orario_F, array);
	    	 				System.out.println(INS_DISP);
	    	 				valore=false;
	    	 			}
	    	 	}while(valore);
					
					
	     }
	     break;
	     
	     //un giorno e orario specifico 
	     case 3: {
	    	 	boolean valore=true;
	    	 	do{
	    	 		int giorno = LeggiInput.intero(GIORNO);
	    	 		int mese = LeggiInput.intero(MESE);
	    	 		int anno = LeggiInput.intero(ANNO);
	    	 		LocalDate data = LocalDate.of(anno, mese, giorno);  
   	 		
	    	 		int ora_I = LeggiInput.intero(ORA_I);
	    	 		int minuti_I = LeggiInput.intero(MINUTI_I);
	    	 		LocalTime orario_I = LocalTime.of(ora_I, minuti_I);
   	 		
	    	 		int ora_F = LeggiInput.intero(ORA_F);
	    	 		int minuti_F = LeggiInput.intero(MINUTI_F);
	    	 		LocalTime orario_F = LocalTime.of(ora_F, minuti_F);
	    	 		if(!Date.controlloOrari(orario_I, orario_F)) System.out.println(MSG_ERRORE_ORARI);
	    	 		else if(data.getDayOfWeek().getValue()==7) System.out.println(NO_DOMENICA);
	    	 			else {
	    	 				agenda.inserimentoDisp(selezionato, data, orario_I, orario_F);
	    	 				System.out.println(INS_DISP);
	    	 				valore=false;
	    	 			}
	    	 	}while(valore);
	    	 		
	    	 			 
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
		int scelta;
		
		if(elencoTemp.isEmpty()){
			System.out.println(NO_VIS);
			return nullo;
		}
		if(elencoTemp.size() >1 ){
			System.out.println("*******"+elencoTemp.size()+" visite trovate:*******\n");
	   for(Giorno giorno: elencoTemp){
		   System.out.println(giorno.getData().toString());
		   System.out.println(giorno.getStato().toString());
		   System.out.println(giorno.getVisita().toString());

	   }
	   do{
	    	scelta=LeggiInput.intero(SCELTA_VIS)-CORREZIONE_INDICE;
	    	LeggiInput.terminaRiga();
	    	}while(scelta<0||scelta>elencoTemp.size()-1);
	    	
	    	
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
		boolean valore=true;
		System.out.println(DATI_CORR+selezionata.toString()+"Stato: "+giorno_visita.getStato().toString()+"\n");
		do{
			String campo_visita = LeggiInput.stringa("Inserire campo da modificare(motivo, referto, prescrizione, tipo, competenza, stato): ");
		    campo_visita=campo_visita.toLowerCase();
		    switch(campo_visita){
		    case ("stato"):
			{
		    	LeggiInput.terminaRiga();
				String input = LeggiInput.riga("Inserire nuovo stato(prenotata, conclusa, non prenotabile, refertata: ");
				if(!input.equalsIgnoreCase("prenotata")&!input.equalsIgnoreCase("conclusa")&!input.equalsIgnoreCase("non prenotabile")&!input.equalsIgnoreCase("refertata")) System.out.println("Stato non esistente");
				else giorno_visita.cambiaStato(input);
				
			}
            break;
		    case ("referto"):
			{
                LeggiInput.terminaRiga();
				String input = LeggiInput.riga("Inserire referto: ");
				selezionata.modificaVisita(campo_visita, input);
				giorno_visita.cambiaStato("refertata");	
            break;
			}
			
		    case ("prescrizione"):
		    {
				LeggiInput.terminaRiga();
				String input = LeggiInput.riga("Inserire prescrizione: ");
				selezionata.modificaVisita(campo_visita, input);
				giorno_visita.cambiaStato("conclusa");
			}
		    break;
            default:{
            	if(!campo_visita.equals("motivo")&!campo_visita.equals("tipo")&!campo_visita.equals("competenza")) System.out.println("Campo non esistente");
            	else{
            		LeggiInput.terminaRiga();
            		String input = LeggiInput.riga("Inserire nuovo dato: ");
            		selezionata.modificaVisita(campo_visita, input);
            	}
            	 	
            }
		   }
			valore=LeggiInput.doppiaScelta("Modificare altri dati?");
		 
		}while(valore);
	}
}
