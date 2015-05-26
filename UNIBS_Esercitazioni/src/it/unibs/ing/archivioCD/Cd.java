package it.unibs.ing.archivioCD;

import java.util.ArrayList;

import it.unibs.ing.myutility.*;

public class Cd {

	public String nome_cd = "none";
	public String nome_autore = "none";
	public ArrayList<Brano> elencoBrani = new ArrayList<Brano>();

	
	
	/**
	 * Costruttore della classe CD
	 *
	 * @param _nomecd
	 * @param _autore
	 */

	public Cd(String _nomecd, String _autore) {

		nome_cd = _nomecd;
		nome_autore = _autore;

	}
    
	/**
	 * Metodo per verificare il titolo del CD
	 * @param titolo
	 * @return boolean
	 */
	public boolean haTitolo(String titolo){
		if (nome_cd.equals(titolo))
			return true;
	
		return false;
		}
	/**
	 * Metodo per l'aggiunta di un brano ad un CD
	 */

	public void aggiungiBrano(Brano brano) {
			
			elencoBrani.add(brano);
			
	}

	/**
	 * Metodo per la selezione di un brano random
	 */

	public Brano branoCasuale() {

		Brano caso = elencoBrani.get(RandomValues.ranIntLimite(0,
				elencoBrani.size()));
		return caso;

	}

	/**
	 * Metodo per la ricerca di un brano predefinito
	 */

	public void searchBrano() {

		String in_titolo = LeggiInput.riga("Inserisci titolo del brano: ");

		for (Brano a : elencoBrani) {
			if (a.titolo.equals(in_titolo))
				a.branoOutput();
			else
				System.out.println("Titolo non trovato");
		}

	}

	/**
	 * Metodo per la restituzione dei parametri del CD
	 * 
	 * @return
	 */

	public void cdOutput() {

		String output = String.format(
				"%s - %s", nome_cd,
				nome_autore);
		System.out.println(output); ;
	}
	
	/**
	 * Metodo toString per il CD
	 */
	
	@Override
	public String toString(){
		String stringa = (nome_cd +" - "+ nome_autore+"\n");
		String output;
		
		for(Brano a: elencoBrani){
			
			output = String.format ("%s [%02d:%02d]\n", a.titolo, a.min, a.sec);
			stringa+=output;
			
			
		}
		stringa = FormatOutput.removeCh(stringa,stringa.length()-1);
		return stringa;
		
	}
}
