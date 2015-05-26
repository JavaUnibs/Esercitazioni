package it.unibs.ing.myutility;

public class Menu {

	private static final String USCITA = "0) Esci";
	private static final String SCELTA = "Inserisci la tua scelta";
	private static String[] elenco;

	public Menu(String[] _elenco) {

		elenco = _elenco;

	}

	public int stampaMenu() {

		for (int i = 0; i < elenco.length; i++) {

			System.out.println((i + 1) + ") " + elenco[i]);

		}
		System.out.println(" ");
		System.out.println(USCITA);
		int decisione;
		return decisione= LeggiInput.intero(SCELTA);
		
	}
	
	

}
