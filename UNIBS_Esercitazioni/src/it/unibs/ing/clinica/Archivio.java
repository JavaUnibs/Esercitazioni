package it.unibs.ing.clinica;
import java.util.*;
import it.unibs.ing.myutility.*;

public class Archivio {
	
private ArrayList<Utente> elencoUtenti = new ArrayList<Utente>();
private ArrayList<Medico> elencoMedici = new ArrayList<Medico>();


/**
 * Cerca uno o più utenti in base ai dati anagrafici corrispondenti ad un campo generico in ingresso. Nel caso di più utenti fornisce 
 * la possibilità di sceglierne uno stampando i dati degli utenti e richiedendo un numero intero in ingresso. 
 * @param generico una stringa generica 
 * @return         l'utente corrispondente
 * @author Andrea Ferrari
 */
public Utente ricercaUtenti(String generico){
Utente nullo=null;
ArrayList<Utente> temp = new ArrayList<Utente>();
	for (Utente utente: elencoUtenti){
		if (utente.datoUguale(generico)) {
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



/**
 * Cerca uno o più medici in base ai dati anagrafici corrispondenti ad un campo generico in ingresso. Nel caso di più medici fornisce 
 * la possibilità di sceglierne uno stampando i dati dei medici e richiedendo un numero intero in ingresso. 
 * @param generico una stringa generica 
 * @return         il medico corrispondente
 * @author Andrea Ferrari
 */
public Medico ricercaMedici(String generico){
Medico nullo=null;
ArrayList<Medico> temp = new ArrayList<Medico>();
	for (Medico medico: elencoMedici){
		if (medico.datoUguale(generico)) {
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

/**
 * Crea un nuovo Utente in base ai dati inseriti e lo aggiunge all'elenco.
 * @param nome
 * @param cognome
 * @param dataNascita
 * @param luogoNascita
 * @param sesso
 * @param numTelefono
 * @param codiceFiscale
 * @author Andrea Ferrari
 */
public void inserimentoUtente(String nome, String cognome, String dataNascita, String luogoNascita, String sesso, String numTelefono, String codiceFiscale){
	elencoUtenti.add(new Utente(nome, cognome, dataNascita, luogoNascita, sesso, numTelefono, codiceFiscale ));
}

/**
 * Crea un nuovo Medico in base ai dati inseriti e lo aggiunge all'elenco.
 * @param nome
 * @param cognome
 * @param dataNascita
 * @param luogoNascita
 * @param sesso
 * @param numTelefono
 * @param codiceFiscale
 * @param codiceAlbo
 * @param tipo
 */
public void inserimentoMedico(String nome, String cognome, String dataNascita, String luogoNascita, String sesso, String numTelefono, String codiceFiscale, String codiceAlbo, String tipo){
	elencoMedici.add(new Medico(nome, cognome, dataNascita, luogoNascita, sesso, numTelefono, codiceFiscale, codiceAlbo, tipo));
	
}

/**
 * Crea un nuovo Utente in base ai dati inseriti e lo aggiunge all'elenco. Costruttore alternativo in caso di medico specifico..
 * @param nome
 * @param cognome
 * @param dataNascita
 * @param luogoNascita
 * @param sesso
 * @param numTelefono
 * @param codiceFiscale
 * @param codiceAlbo
 * @param tipo
 * @param areaCompetenza
 */
public void inserimentoMedico(String nome, String cognome, String dataNascita, String luogoNascita, String sesso, String numTelefono, String codiceFiscale, String codiceAlbo, String tipo, String areaCompetenza){
	elencoMedici.add(new Medico(nome, cognome, dataNascita, luogoNascita, sesso, numTelefono, codiceFiscale, codiceAlbo, tipo, areaCompetenza));
	
}


}




