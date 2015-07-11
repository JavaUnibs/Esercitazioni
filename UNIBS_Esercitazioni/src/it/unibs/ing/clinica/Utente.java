package it.unibs.ing.clinica;
import java.io.Serializable;

import it.unibs.ing.myutility.*;

public class Utente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome, cognome, dataNascita, luogoNascita, sesso, codiceFiscale, numTelefono, cognomeNome;
	

	Utente(String _nome, String _cognome, String _dataNascita, String _luogoNascita, String _sesso, String _numTelefono, String _codiceFiscale) 
	{
		nome=_nome;
		cognome=_cognome;
		dataNascita=_dataNascita;
		luogoNascita=_luogoNascita;
		sesso=_sesso;
		numTelefono=_numTelefono;
		while(!verificaCodice(_codiceFiscale)) {
		_codiceFiscale=LeggiInput.stringa("Codice Fiscale non valido, inserire quello corretto");
		}
		codiceFiscale=_codiceFiscale;
		cognomeNome=cognome+" "+ nome;
	}
	
/**
 * Permette di assegnare un nuovo valore ad una variabile con nome uguale alla stringa in ingresso.
 * 
 * @param campo La variabile che si vuole modificare
 * @param input Il nuovo valore da assegnare
 * @author Riccardo Grespan
 */
	public void modificaUtente(String campo, String input)
	{
		campo=campo.toLowerCase();
		switch (campo){
		case "nome": nome=input;
		break;
        case "cognome": cognome=input;
		break;
		case "data di nascita": dataNascita=input;
		break;
		case "luogo di nascita": luogoNascita=input;
		break;
		case "sesso": sesso=input;
		break;
		case "telefono": numTelefono=input;
		break;
		case "codice fiscale": codiceFiscale=input;
		break;
		}
	}
	
/**
 * Verifica che la stringa in ingresso abbia un ordine di numeri e caratteri uguale ai codici fiscali. 	
 * @param codiceFiscale la stringa da verificare
 * @return vero o falso
 * @author Riccardo Grespan
 */
	public static boolean verificaCodice(String codiceFiscale)
	{
		if(codiceFiscale.length()==16){
			int i;
			String lettere=codiceFiscale.substring(0, 6)+codiceFiscale.substring(8, 9)+
			codiceFiscale.substring(8, 9)+codiceFiscale.substring(11, 12)+codiceFiscale.substring(15, 16);
			String cifre=codiceFiscale.substring(6, 8)+codiceFiscale.substring(9, 11)+codiceFiscale.substring(12, 15);
			lettere.toUpperCase();
			for(i=0;i<cifre.length();i++) {if(cifre.charAt(i)<48||cifre.charAt(i)>57) return false;}
			for(i=0;i<lettere.length();i++) {if(lettere.charAt(i)<65||lettere.charAt(i)>90) return false;}
			return true;
			}
		else return false;
		
	}

/**
 * Sovrascrive il metodo toString.
 * @author Riccardo Grespan
 */
	public String toString(){
    	String descrizione="-----------\n"
    						+ "Nome: "+nome+"\n"
    						+ "Cognome: "+cognome+"\n"
    						+ "Data di nascita: "+dataNascita+"\n" 
    						+ "Luogo di nascita: "+luogoNascita+"\n"
    						+ "Sesso: "+sesso+"\n"
    						+ "Telefono: "+numTelefono+"\n"
    						+ "Codice fiscale: "+codiceFiscale
    						+"\n";
    	return descrizione;
    	
    }
/**
 * Verifica se la stringa in ingresso ha nome uguale a una variabile anagrafica.	
 * @param generico una stringa generica
 * @return vero o falso
 * @author Riccardo Grespan
 */
	public boolean datoUguale(String generico){
		generico=generico.toLowerCase();
		if (generico.equals(codiceFiscale.toLowerCase())||generico.equals(cognome.toLowerCase())||generico.equals(dataNascita.toLowerCase())||
				generico.equals(luogoNascita.toLowerCase())||generico.equals(nome.toLowerCase())||generico.equals(numTelefono.toLowerCase())||
				generico.equals(cognomeNome.toLowerCase())) return true;
		return false;
	}
/**
 * Versione ridotta di toString
 *@author Riccardo Grespan
 */
	public String toStringNomeCognome(){
		String descrizione="-----------\n"
    			+ "Nome: "+nome+"\n"
    			+ "Cognome: "+cognome+"\n";
		return descrizione;
	}
/**
* Versione ridotta di toString
*@author Riccardo Grespan
*/	
	
	public String toStringCodiceFiscale(){
		return "Codice fiscale: "+codiceFiscale+"\n";
	}

}

  
