package it.unibs.ing.archivioCD;

import java.util.ArrayList;

import it.unibs.ing.myutility.*;

public class ArchivioCd {

	private String nome;

	ArrayList<Cd> elencoCD = new ArrayList<Cd>();

	/**
	 * Costruttore predefinito della classe
	 */

	public ArchivioCd() {

		nome = "Predefinito";

	}

	/**
	 * Metodo per controllare se un CD e' gia' presente
	 * 
	 * @param titolo
	 * @return boolean
	 */
	
	public boolean controllore(String titolo) {

		for (Cd a : elencoCD) {
			if (a.nome_cd.equals(titolo)) {
				System.out.println("Titolo CD gia' presente\n");
				return true;
			}
		}
		return false;

	}

	/**
	 * Metodo per l'aggiunta di un CD
	 */

	public void aggiungiCd(Cd cd) {

		boolean valore = controllore(cd.nome_cd);
		if (!valore) {
		elencoCD.add(cd);
		} 
	}

	/**
	 * Metodo per la ricerca di un CD specifico
	 * 
	 * @return a se vero null se falso
	 */

	public Cd ricerca() {

		String in_titolo = LeggiInput.riga("Inserisci titolo del CD: ");
		Cd b = new Cd(null, null);

		for (Cd a : elencoCD) {
			if (a.nome_cd.equals(in_titolo))
				return a;
		}

		System.out.println("CD non trovato");
		return b;
	}

	/**
	 * Metodo per confermare la presenza di un CD
	 * 
	 * @param in_titolo
	 * @return
	 */
	
	public boolean contiene(String in_titolo){
		
		for (Cd a : elencoCD) {
			if (a.nome_cd.equals(in_titolo))
				return true;
		}
		return false;
	}
	
	
	/**
	 * Metodo per mostrare parametri di un CD e i suoi brani
	 * 
	 * @param cd
	 */

	public void showCD(Cd cd) {

		cd.cdOutput();
		for (Brano a : cd.elencoBrani) {
			a.branoOutput();
			System.out.println(" ");
			System.out.println(" ");
		}
	}

	/**
	 * Metodo per la selezione di un CD random
	 */

	public Cd randomCD() {

		Cd caso = elencoCD.get(RandomValues.ranIntLimite(0, elencoCD.size()));
		return caso;

	}

	/**
	 * Metodo per l'eliminazione di un CD
	 */

	public void eliminaCd(String titolo) {
		for (Cd a : elencoCD) {
			if (a.nome_cd.equals(titolo))
		        elencoCD.remove(a); 
		}

	}

	/**
	 * Metodo per la stampa della ArchivioCD
	 */

	public void showCollection() {
		
		System.out.println("Numero CD:" +getNumeroCd());
		for (Cd a : elencoCD) {
			showCD(a);
			System.out.println("******************************************");
		}
	}
	
	/**
	 *Metodo per contare i CD 
	 *
	 *@return numerocd
	 */
	
	public int getNumeroCd(){
		
		int numerocd = elencoCD.size();
		return numerocd;
		
	}
	
	
	
	
}
