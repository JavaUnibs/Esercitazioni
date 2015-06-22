package it.unibs.ing.clinica;
import java.util.*;
public class Clinica {
	
ArrayList<Utente> elencoUtenti = new ArrayList<Utente>();
ArrayList<Medico> elencoMedici = new ArrayList<Medico>();




/*metodo per la ricerca di singoli utenti*/
public Utente ricercaUtenti(String generico){
	int cont=0;
	Utente copia= null;
	boolean condizione=false;

	
	while(!condizione) {
	for (Utente utente: elencoUtenti){
		if (generico.equals(utente.codiceFiscale)||generico.equals(utente.cognome)||generico.equals(utente.dataNascita)||
				generico.equals(utente.luogoNascita)||generico.equals(utente.nome)||generico.equals(utente.numTelefono)) {
			cont++;
			copia=utente;
		};
	}
		if(cont>=2) System.out.println("Più utenti trovati, usare un altro criterio");
		if(cont<1) {
			System.out.println("Nessun utente trovato");
			return copia;
		}
		if(cont==1) condizione=true;
		}
	return copia;
	}	


/*metodo per la ricerca di più utenti*/
public ArrayList<Utente> ricercaUtenti(String generico, boolean opzione){

ArrayList<Utente> temp = new ArrayList<Utente>();
	for (Utente utente: elencoUtenti){
		if (generico.equals(utente.codiceFiscale)||generico.equals(utente.cognome)||generico.equals(utente.dataNascita)||
				generico.equals(utente.luogoNascita)||generico.equals(utente.nome)||generico.equals(utente.numTelefono)) {
             temp.add(utente);
		};
	}
       if(temp.size()<1) System.out.println("Nessun utente trovato");
		return temp;
}
			


	
/*metodo per la ricerca di singoli medici*/
public Utente ricercaMedici(String generico){
	int cont=0;
	Utente copia= null;
	boolean condizione=false;

	
	while(!condizione) {
	for (Medico medico: elencoMedici){
		if (generico.equals(medico.codiceFiscale)||generico.equals(medico.cognome)||generico.equals(medico.dataNascita)||
				generico.equals(medico.luogoNascita)||generico.equals(medico.nome)||generico.equals(medico.numTelefono)
				||generico.equals(medico.numTelefono)) {
			cont++;
			copia=medico;
		};
	}
		if(cont>=2) System.out.println("Più utenti trovati, usare un altro criterio");
		if(cont<1) {
			System.out.println("Nessun utente trovato");
			return copia;
		}
		if(cont==1) condizione=true;
		}
	return copia;
	}	


/*metodo per la ricerca di più medici*/
public ArrayList<Medico> ricercaMedici(String generico, boolean opzione){

ArrayList<Medico> temp = new ArrayList<Medico>();
	for (Medico medico: elencoMedici){
		if (generico.equals(medico.codiceFiscale)||generico.equals(medico.cognome)||generico.equals(medico.dataNascita)||
				generico.equals(medico.luogoNascita)||generico.equals(medico.nome)||generico.equals(medico.numTelefono)||
				generico.equals(medico.codiceAlbo)||generico.equals(medico.tipo)||generico.equals(medico.areaCompetenza)) {
             temp.add(medico);
		};
	}
       if(temp.size()<1) System.out.println("Nessun medico trovato");
		return temp;
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


public static void orariVisita(String medico){
	/*
	 * stampa gli orari di visita di un medico
	 */
}

public static void disponibilità(String giorno, String ora){
	/*
	 * stampa i medici disponibili in quell'orario
	 */
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
