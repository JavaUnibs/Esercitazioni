package it.unibs.ing.tamag;

public class TamagotchiMain {

	/**
	 * Dichiarazione messaggi
	 */

	private static String messaggio = "Salve, inserisca il nome del Tamagotchi";
	private static String messaggio2 = "Inserisca il grado di sazieta";
	private static String messaggio3 = "Inserisca il grado di felicita";

	/**
	 * Dichiarazione del menu in un array
	 */

	public static final String[] MENU = { "Menu: ", " ", "1) Dai biscotti",
			"2) Dai carezze", "0) Esci ", " ", "Inserisci un numero." };

	/**
	 * Metodo main per rendere eseguibile il tamagotchi
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		double sazieta, felicita;
		int i = 0, j = 0;

		System.out.println(messaggio);
		String nome = LeggiInput.stringa();

		// ciclo per il controllo dei valori inseriti dall'utente

		do {

			System.out.println(messaggio2);
			sazieta = LeggiInput.doppio();

			System.out.println(messaggio3);
			felicita = LeggiInput.doppio();

			if (sazieta <= 0 || felicita <= 0)
				System.out.println("Valori errati");

		} while (sazieta <= 0 || felicita <= 0);

		TamagotchiCostructor tamag = new TamagotchiCostructor(nome, felicita,
				sazieta);

		// Scelta dell'azione da compiere

		int scelta;

		do {

			LeggiInput.menu(MENU);

			scelta = LeggiInput.intero();

			if (scelta == 1) {
				i++;
				j = 0;
			} else {
				j++;
				i = 0;
			}

			// Tramite la scelta inserita viene eseguito una diversa parte del
			// codice

			switch (scelta) {

			case 1: {
				System.out.println("Quanti biscotti??");

				int biscotti = LeggiInput.intero();

				tamag.daiBiscotti(biscotti, i);
				System.out.println(tamag.stringaOutput());
				tamag.stato();

				break;
			}

			case 2: {
				System.out.println("Quante carezze??");

				int carezze = LeggiInput.intero();

				tamag.daiCarezze(carezze, j);
				System.out.println(tamag.stringaOutput());
				tamag.stato();

				break;
			}
			}

		} while (scelta != 0 && tamag.felicita > 0 && tamag.sazieta > 0
				&& tamag.sazieta < tamag.MAX_SAZIETA);
	}
}
