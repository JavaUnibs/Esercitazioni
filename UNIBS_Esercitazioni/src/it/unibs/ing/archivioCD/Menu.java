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
			case 1: {System.out.println("Inserire il titolo del CD: ");
			         String nome_cd = LeggiInput.riga();
			         System.out.println("Inserisci l'autore del CD: ");
			 		 String nome_autore = LeggiInput.riga();
				     archivio.aggiungiCd(new Cd(nome_cd, nome_autore));
			         }
					break;
			case 2: {
				     
				     System.out.println("Inserire il titolo e la durata del brano:");
			         System.out.println("Titolo:");	
                     String titolo = LeggiInput.riga();
                     System.out.println("Minuti:");
                     int minuti = LeggiInput.intero();
                     System.out.println("Secondi:");
                     int secondi = LeggiInput.intero();
                     LeggiInput.terminaRiga();
                     archivio.ricerca().aggiungiBrano(new Brano(titolo, minuti, secondi));
					}
					break;
			case 3: archivio.showCD(archivio.ricerca());
					break;
			case 4: {System.out.printf("Inserire il titolo del CD da eliminare:");
					String nomecd = LeggiInput.riga();
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
