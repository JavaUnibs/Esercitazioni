package it.unibs.ing.archivioCD;

import it.unibs.ing.myutility.*;

public class Menu {
	
	private static final String benvenuto = "Menu per la gestione di un Archivio CD.";
	private static final String scelta = "Seleziona una delle seguenti opzioni: ";
	private static final String op1 = "1) Inserimento nuovo CD";
	private static final String op7 = "2) Inserimento nuovo CD";
	private static final String op2 = "3) Visualizzazione di un CD (ricerca per titolo)";
	private static final String op3 = "4) Rimozione di un CD (ricerca per titolo)";
	private static final String op4 = "5) Visualizzazione intera collezione";
	private static final String op5 = "6) Visualizzazione di un brano random";
	private static final String op6 = "0) Termina programma";
	private static final String capo = " ";
	
	private static final String [] menu = { benvenuto, scelta, op1, op7, op2, op3, op4, op5, capo, op6, capo};  
	static int min = 0, max = 6;
	
	public static void showMenuArchivioCD(){
		
		int selezione;
		ArchivioCd archivio = new ArchivioCd();
		
		do{
			
			FormatOutput.menu(menu);
			selezione = LeggiInput.interoLimiti(min, max);
			LeggiInput.terminaRiga();
			
			switch(selezione){
			
			case 0: break;
			case 1: {
			         String nome_cd = LeggiInput.riga("Inserire il titolo del CD: ");
			        
			 		 String nome_autore = LeggiInput.riga("Inserisci l'autore del CD: ");
				     archivio.aggiungiCd(new Cd(nome_cd, nome_autore));
			         }
					break;
			case 2: {
				     
				     
                     String titolo = LeggiInput.riga("Inserire il titolo e la durata del brano:\nTitolo:");
                     int minuti = LeggiInput.intero("Minuti:");
                     int secondi = LeggiInput.intero("Secondi:");
                     LeggiInput.terminaRiga();
                     archivio.ricerca().aggiungiBrano(new Brano(titolo, minuti, secondi));
					}
					break;
			case 3: archivio.showCD(archivio.ricerca());
					break;
			case 4: {
					String nomecd = LeggiInput.riga("Inserire il titolo del CD da eliminare:");
					archivio.eliminaCd(nomecd);
			}
					break;
			case 5: archivio.showCollection();
					break;
			case 6: archivio.randomCD().branoCasuale().branoOutput();
					break;
			
			}
			
			
		}while(selezione != 0);
		
	}

}
