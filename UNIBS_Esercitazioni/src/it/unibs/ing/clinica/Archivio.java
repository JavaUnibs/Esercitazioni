package it.unibs.ing.clinica;
import java.util.*;
import it.unibs.ing.myutility.*;

public class Archivio {
	
ArrayList<Utente> elencoUtenti = new ArrayList<Utente>();
ArrayList<Medico> elencoMedici = new ArrayList<Medico>();


/*metodo per la ricerca di utenti*/
public Utente ricercaUtenti(String generico, boolean opzione){
Utente nullo=null;
ArrayList<Utente> temp = new ArrayList<Utente>();
	for (Utente utente: elencoUtenti){
		if (generico.equals(utente.codiceFiscale)||generico.equals(utente.cognome)||generico.equals(utente.dataNascita)||
				generico.equals(utente.luogoNascita)||generico.equals(utente.nome)||generico.equals(utente.numTelefono)||
				generico.equals(utente.cognomeNome)) {
             temp.add(utente);
		};
	}
       if(temp.isEmpty()) { 
    	   System.out.println("Nessun utente trovato");
    	   return nullo;
       }
       
       if(temp.size()>1) {
    	   System.out.println("*******"+temp.size()+" utenti trovati:*******\n");
    	   for(Utente utente: temp){
    		   System.out.println(utente.toString());
    	   }
    	int scelta=LeggiInput.intero("******Scegliere tramite un numero l'utente desiderato*******")-1;
    	return temp.get(scelta);
    	
       }
       
       return temp.get(0);
	   
}



/*metodo per la ricerca di più medici*/
public Medico ricercaMedici(String generico, boolean opzione){
Medico nullo=null;
ArrayList<Medico> temp = new ArrayList<Medico>();
	for (Medico medico: elencoMedici){
		if (generico.equals(medico.codiceFiscale)||generico.equals(medico.cognome)||generico.equals(medico.dataNascita)||
				generico.equals(medico.luogoNascita)||generico.equals(medico.nome)||generico.equals(medico.numTelefono)||
				generico.equals(medico.cognomeNome)||generico.equals(medico.codiceAlbo)||generico.equals(medico.tipo)||
				generico.equals(medico.areaCompetenza)) {
             temp.add(medico);
		};
	}
       if(temp.isEmpty()) { 
    	   System.out.println("Nessun medico trovato");
    	   return nullo;
       }
       
       if(temp.size()>1) {
    	   System.out.println("*******"+temp.size()+" medici trovati:*******\n");
    	   for(Medico medico: temp){
    		   System.out.println(medico.toString());
    	   }
    	int scelta=LeggiInput.intero("******Scegliere tramite un numero l'utente desiderato*******")-1;
    	return temp.get(scelta);
    	
       }
       
       return temp.get(0);
	   
}	


public void inserimentoUtente(String nome, String cognome, String dataNascita, String luogoNascita, String sesso, String numTelefono, String codiceFiscale){
	elencoUtenti.add(new Utente(nome, cognome, dataNascita, luogoNascita, sesso, numTelefono, codiceFiscale ));
}

public void inserimentoMedico(String nome, String cognome, String dataNascita, String luogoNascita, String sesso, String numTelefono, String codiceFiscale, String codiceAlbo, String tipo){
	elencoMedici.add(new Medico(nome, cognome, dataNascita, luogoNascita, sesso, numTelefono, codiceFiscale, codiceAlbo, tipo));
	
}

public void inserimentoMedico(String nome, String cognome, String dataNascita, String luogoNascita, String sesso, String numTelefono, String codiceFiscale, String codiceAlbo, String tipo, String areaCompetenza){
	elencoMedici.add(new Medico(nome, cognome, dataNascita, luogoNascita, sesso, numTelefono, codiceFiscale, codiceAlbo, tipo, areaCompetenza));
	
}


public static void inserimentoVisite(int codice, String orario, String tipo){
	/*
	 * si chiede il codice utente, l’orario, il tipo di visita e l'area di competenza
e il programma deve proporre, se esistono, i medici disponibili. Se per quella data non ci sono medici disponibili, 
il programma deve richiedere di indicare una nuova data per la visita, suggerendo la prima data/ora successiva disponibile 
per la prenotazione Superati i controlli, alla visita sarà assegnato il medico di riferimento individuato.

	 */
}

public static void ricercaVisiteMedico(Medico medico){
	/*
	 * visualizza le visite prenotate di questo medico
	 */
}

public static void ricercaVisiteUtente(Utente utente){
	/*
	 * visualizza le visite effettuate da questo utente
	 */
}

public static void ricercaVisiteData(String giorno, String ora){
	/*
	 * richiede di indicare data e ora di visita e restituisce la visita corrispondente
	 */
}

public static void ricercaVisiteTipo(String tipo){
	/*
	 * richiede di indicare se è una visita generica o specialistica, l'eventuale area di competenza e restituisce le visite corrispondenti.
	 */
}



}
