package it.unibs.ing.myutility;

public class Menu {

	private static final String USCITA = "0) Esci";
	private static final String RITORNO ="0) Ritorna al precedente menu";
	private static final String SCELTA = "Inserisci la tua scelta";
	private  String[] elenco;

	public Menu(String[] _elenco) {

		elenco = _elenco;

	}

	public int stampaMenu() {

		for (int i = 0; i < elenco.length; i++) {

			System.out.println((i + 1) + ") " + elenco[i]);

		}
		System.out.println(" ");
		System.out.println(USCITA);
		return LeggiInput.intero(SCELTA);
		
	}
	
	public int stampaSottoMenu() {

		for (int i = 0; i < elenco.length; i++) {

			System.out.println((i + 1) + ") " + elenco[i]);

		}
		System.out.println(" ");
		System.out.println(RITORNO);
		return LeggiInput.intero(SCELTA);
		
	}
	


}
