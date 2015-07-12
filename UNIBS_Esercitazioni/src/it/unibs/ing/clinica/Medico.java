package it.unibs.ing.clinica;

import java.io.Serializable;
import java.util.Arrays;


public class Medico extends Utente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String tipo, codiceAlbo;
	String[] areaCompetenza={""};
	String delimita = "[-]+";
	
	Medico(String _nome, String _cognome, String _dataNascita, String _luogoNascita, String _sesso, String _numTelefono, String _codiceFiscale, String _codiceAlbo, String _tipo)
	{
		super(_nome, _cognome, _dataNascita, _luogoNascita, _sesso, _numTelefono, _codiceFiscale);
		
		tipo=_tipo;
		codiceAlbo=_codiceAlbo;
	}
	
	Medico(String _nome, String _cognome, String _dataNascita, String _luogoNascita, String _sesso, String _numTelefono, String _codiceFiscale, String _codiceAlbo, String _tipo, String _areaCompetenza)
	{
		super(_nome, _cognome, _dataNascita, _luogoNascita, _sesso, _numTelefono, _codiceFiscale);
		
		tipo=_tipo;
		codiceAlbo=_codiceAlbo;
		areaCompetenza=_areaCompetenza.split(delimita);
	}
	
	public String[] getArea()
	{
		return areaCompetenza;
	}
	
	public boolean datoUgualeArea(String generico){
		for(int i=0;i<areaCompetenza.length;i++){
			if(areaCompetenza[i].equalsIgnoreCase(generico)) return true;
		}
		return false;
			
	}
	
/**
* Permette di assegnare un nuovo valore ad una variabile con nome uguale alla stringa in ingresso.
* @param campo La variabile che si vuole modificare
* @param input Il nuovo valore da assegnare
* @author Riccardo Grespan
*/
	public void modificaMedico(String campo, String input)
	{
		campo=campo.toLowerCase();
		super.modificaUtente(campo, input);
		switch (campo){
		case "codice albo": codiceAlbo=input;
		break;
		case "tipo": tipo=input;
		break;
		case "area di competenza": areaCompetenza=input.split(delimita);
		break;
		}
		}
	
/**
* Sovrascrive il metodo toString.
* @author Riccardo Grespan
*/
    public String toString()
    {
    	
    	String descrizione=super.toString() + "\n" + "Codice albo: " + codiceAlbo+ "\n" + "Tipo: "+tipo+"\n" + "Area di competenza: " + Arrays.toString(areaCompetenza)+"\n";
    	return descrizione;
    	
    }

/**
* Verifica se la stringa in ingresso è uguale a una variabile anagrafica.	
* @param generico una stringa generica
* @return vero o falso
* @author Riccardo Grespan
*/
    public boolean datoUguale(String generico)
    {
    	
    	if (super.datoUguale(generico)||generico.equalsIgnoreCase(codiceAlbo)||generico.equalsIgnoreCase(tipo.toLowerCase())||datoUgualeArea(generico)) return true;
    	return false;
    }
 /**
  * Versione ridotta di toString 
  * @author Riccardo Grespan
  */
    public String toStringNomeCognomeAlbo()
    {
    	String descrizione=super.toStringNomeCognome() + "Codice albo: " + codiceAlbo + "\n";
    	return descrizione;
    }


}
