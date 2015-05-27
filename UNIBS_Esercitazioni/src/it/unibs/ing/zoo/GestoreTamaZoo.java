package it.unibs.ing.zoo;

import it.unibs.ing.myutility.*;

public class GestoreTamaZoo {

	// QUI SERVIRANNO UN PO' DI COSTANTI DI VARIO TIPO

	private static final String messaggio = "Inserire il numero di Tamagotchi da creare";
	private static final String messaggio1 = "Inserire nome Tamagotchi";
	private static final String[] elenco = { "Dai biscotti", "Dai carezze" };

	public static String nome = null;
	public static double felicita, sazieta;

	public static final double MAX_FELICITA = 100, MIN_FELICITA = 0,
			MAX_SAZIETA = 100, MIN_SAZIETA = 0;

	public static final int MIN_SCELTA = 1, MAX_SCELTA = 3;
	public static final double FELICITA_GORDO = 100, FELICITA_TRISTE = 10;

	// DEFINIRE UN ATTRIBUTO static DI TIPO TamaZoo

	public static void main(String[] args) {

		int numeroTamagotchi = LeggiInput.intero(messaggio); // richiedere il
																// numero
																// all'utente

		TamaZoo zoo = new TamaZoo();

		for (int i = 1; i <= numeroTamagotchi; i++) {
			
			nome = LeggiInput.stringa(messaggio1);

			int scelta = RandomValues.ranIntLimite(MIN_SCELTA, MAX_SCELTA);
System.out.println(scelta);
			switch (scelta) {
			// Tamabase
			case 1: {
				felicita = RandomValues.ranDoubleLimite(MIN_FELICITA,
						MAX_FELICITA);
				sazieta = RandomValues
						.ranDoubleLimite(MIN_SAZIETA, MAX_SAZIETA);
				Tamagotchi tamag = new Tamagotchi(nome, felicita, sazieta);
				zoo.inserisci(tamag);

			}
				break;

			// Tamagordo
			case 2: {
				felicita = FELICITA_GORDO;
				sazieta = RandomValues
						.ranDoubleLimite(MIN_SAZIETA, MAX_SAZIETA);
				Tamagotchi tamag = new TamaGordo(nome, felicita, sazieta);
				zoo.inserisci(tamag);

			}
				break;

			// Tamatriste
			case 3: {
				felicita = FELICITA_TRISTE;
				sazieta = RandomValues
						.ranDoubleLimite(MIN_SAZIETA, MAX_SAZIETA);
				Tamagotchi tamag = new TamaTriste(nome, felicita, sazieta);
				zoo.inserisci(tamag);
			}
				break;

			// e inserirlo nello zoo (usando l'apposito metodo della classe
			// TamaZoo)
			}
		}

		Menu principale = new Menu(elenco);// creare un menu con le scelte a
											// disposizione dell'utente

		boolean fine = false;

		do {

			int voceSelezionata = principale.stampaMenu();

			switch (voceSelezionata) {
			// i casi da gestire sono la somministrazione
			// di biscotti e carezze. In entrambi i casi si estrae un numero
			// casuale e
			// si invoca l'apposito metodo per la somministrazione nella classe
			// TamaZoo

			case 0:
				fine = true;
				break;
			default:
				System.out.println("Scelta non valida");
				break;

			// Biscotti
			case 1: {
				zoo.daiBiscotti();
				int i;
				for (i = 0; i <= zoo.tamazoo.size() - 1; i++) {
					System.out.println("\nTamagochi " + zoo.tamazoo.get(i).nome
							+ ":");
					zoo.tamazoo.get(i).stato();
				}
				for (i = 0; i <= zoo.tamazoo.size() - 1; i++) {
					if (!zoo.tamazoo.get(i).vita())
						zoo.tamazoo.remove(i);
				}
				
			}break;

			// Carezze
			case 2: {
				zoo.daiCarezze();
				int i;
				for (i = 0; i <= zoo.tamazoo.size() - 1; i++) {
					System.out.println("\nTamagochi " + zoo.tamazoo.get(i).nome
							+ ":");
					zoo.tamazoo.get(i).stato();
				}
				for (i = 0; i <= zoo.tamazoo.size() - 1; i++) {
					if (!zoo.tamazoo.get(i).vita())
						zoo.tamazoo.remove(i);
				}
				
			}break;
			}

			if (!zoo.ciSonoVivi()) {
				System.out.println("Tutti i tamagotchi sono morti");
				fine = true;
			}
			// controllare se nello zoo c'e' almeno un Tamagotchi vivo
			// in caso contrario bisogna terminare il programma

		} while (!fine);

	}

	/*
	 * public static Tamagotchi creaTamagotchi() { String nome = // chiedere il
	 * nome all'utente int affetto = // estrarre a caso il valore iniziale di
	 * affetto int sazieta = // estrarre a caso il valore iniziale di sazieta'
	 * // restituire un nuovo Tamagotchi }
	 */
}
