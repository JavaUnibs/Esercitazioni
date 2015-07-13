package it.unibs.ing.clinica;
import java.io.Serializable;
import java.util.*;

import it.unibs.ing.myutility.*;

public class Archivio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String NO_UTENTI="Nessun utente trovato";
	private static final String NO_MEDICI="Nessun medico trovato";
	private static final String SCELTA_UTENTE="******Scegliere tramite un numero l'utente desiderato*******";
	private static final String SCELTA_MEDICO="******Scegliere tramite un numero il medico desiderato*******";
	private static final int CORREZIONE_INDICE=1;
	
	private ArrayList<Utente> elencoUtenti = new ArrayList<Utente>();
	private ArrayList<Medico> elencoMedici = new ArrayList<Medico>();


	/**
	 * Cerca uno o più utenti in base ai dati anagrafici corrispondenti ad un campo generico in ingresso. Nel caso di più utenti fornisce 
	 * la possibilità di sceglierne uno stampando i dati degli utenti e richiedendo un numero intero in ingresso. 
	 * @param generico una stringa generica 
	 * @return         l'utente corrispondente
	 * @author Sartori Fabio
	 */
	public Utente ricercaUtenti(String generico){
	Utente nullo=null;
	int scelta;
	ArrayList<Utente> temp = new ArrayList<Utente>();
		for (Utente utente: elencoUtenti){
			if (utente.datoUguale(generico)) {
	             temp.add(utente);
			};
		}
	       if(temp.isEmpty()) { 
	    	   System.out.println(NO_UTENTI);
	    	   return nullo;
	       }
	       
	       if(temp.size()>1) {
	    	   System.out.println("*******"+temp.size()+" utenti trovati:*******\n");
	    	   for(Utente utente: temp){
	    		   System.out.println(utente.toStringNomeCognome()+utente.toStringCodiceFiscale());
	    	   }
	    	do{
	    	scelta=LeggiInput.intero(SCELTA_UTENTE)-CORREZIONE_INDICE;
	    	LeggiInput.terminaRiga();
	    	}while(scelta<0||scelta>temp.size()-CORREZIONE_INDICE);
	    	
	    	return temp.get(scelta);
	    	
	    	
	       }
	       
	       return temp.get(0);
		   
	}
	
	
	
	/**
	 * Cerca uno o più medici in base ai dati anagrafici corrispondenti ad un campo generico in ingresso. Nel caso di più medici fornisce 
	 * la possibilità di sceglierne uno stampando i dati dei medici e richiedendo un numero intero in ingresso. 
	 * @param generico una stringa generica 
	 * @return         il medico corrispondente
	 * @author Sartori Fabio
	 */
	public Medico ricercaMedici(String generico){
	Medico nullo=null;
	int scelta;
	ArrayList<Medico> temp = new ArrayList<Medico>();
		for (Medico medico: elencoMedici){
			if (medico.datoUguale(generico)) {
	             temp.add(medico);
			};
		}
	       if(temp.isEmpty()) { 
	    	   System.out.println(NO_MEDICI);
	    	   return nullo;
	       }
	       
	       if(temp.size()>1) {
	    	   System.out.println("*******"+temp.size()+" medici trovati:*******\n");
	    	   for(Medico medico: temp){
	    		   System.out.println(medico.toStringNomeCognomeAlbo());
	    	   }
	    	   do{
	   	    	scelta=LeggiInput.intero(SCELTA_MEDICO)-CORREZIONE_INDICE;
	   	    	LeggiInput.terminaRiga();
	   	    	}while(scelta<0||scelta>temp.size()-CORREZIONE_INDICE);
	   	    	
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
	 * @author Sartori Fabio
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
	 * @author Sartori Fabio
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
	 * @author Sartori Fabio
	 */
	public void inserimentoMedico(String nome, String cognome, String dataNascita, String luogoNascita, String sesso, String numTelefono, String codiceFiscale, String codiceAlbo, String tipo, String areaCompetenza){
		elencoMedici.add(new Medico(nome, cognome, dataNascita, luogoNascita, sesso, numTelefono, codiceFiscale, codiceAlbo, tipo, areaCompetenza));
		
	}
	
	/**
	 * Restituisce un ArrayList contenente tutte le aree di competenza riscontrate nei medici dell'archivio, non contando i doppioni.
	 * 
	 * @author Sartori Fabio
	 */
	public ArrayList<String> areeCompetenzaTot(){
		boolean valore;
		ArrayList<String> temp= new ArrayList<String>();
		String[] genericaArea={""};
		
		for(Medico medico: elencoMedici){
			if (Arrays.equals(medico.getArea(), genericaArea)) continue;
			else for(int i=0;i<medico.getArea().length;i++){
				valore=true;
				for(String stringa:temp){
					if(stringa.equals(medico.getArea()[i])) valore=false; break;
				}
				if(valore) temp.add(medico.getArea()[i]);
			}
		}
		return temp;
	}
	
	public ArrayList<Medico> getElencoMedici(){
		return elencoMedici;
	}

    public ArrayList<Utente> getElencoUtenti(){
    	return elencoUtenti;
    }

}




