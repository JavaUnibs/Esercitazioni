package it.unibs.ing.zoo;

import it.unibs.ing.myutility.*;

public class GestoreTamaZoo {

	private static final String MESSAGGIO = "Inserire il numero di Tamagotchi da creare:";
	private static final String MESSAGGIO1 = "Inserire nome Tamagotchi:";
	private static final String MORTI ="Tutti i tamagotchi sono morti.";
	private static final String[] ELENCO = { "Dai biscotti", "Dai carezze" };
	private static final String[] NOMI_TAMAGOTCHI = {"È un tamagotchi normale!" , "È un tamagordo!" , "È un tamatriste!"};

	public static String nome = null;
	public static double felicita, sazieta;

	public static final double MAX_FELICITA = 100, MIN_FELICITA = 0,
			MAX_SAZIETA = 100, MIN_SAZIETA = 0;

	public static final int MIN_SCELTA = 1, MAX_SCELTA = 3;
	public static final double FELICITA_GORDO = 100, FELICITA_TRISTE = 10;

	public static void main(String[] args) {

		int numeroTamagotchi = LeggiInput.intero(MESSAGGIO);

		TamaZoo zoo = new TamaZoo();

		for (int i = 1; i <= numeroTamagotchi; i++) {

			nome = LeggiInput.stringa(MESSAGGIO1);

			int scelta = RandomValues.ranIntLimite(MIN_SCELTA, MAX_SCELTA);
			System.out.println(NOMI_TAMAGOTCHI[scelta-1] + "\n");
			switch (scelta) {

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

			}
		}

		Menu principale = new Menu(ELENCO);

		boolean fine = false;

		do {

			int voceSelezionata = principale.stampaMenu();

			switch (voceSelezionata) {

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

			}
				break;

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

			}
				break;
			}

			if (!zoo.ciSonoVivi()) {
				System.out.println(MORTI);
				fine = true;
			}

		} while (!fine);

	}

}
