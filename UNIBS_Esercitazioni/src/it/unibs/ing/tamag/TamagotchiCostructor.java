package it.unibs.ing.tamag;

public class TamagotchiCostructor {

	public double felicita;
	public double sazieta;
	public String nome;

	/**
	 * Costanti per l'incremento dei valori del tamagotchi.
	 */

	public static final double INC_FELICITA = 0.2, INC_SAZIETA = 0.5,
			DIM_FELICITA = 0.3, DIM_SAZIETA = 0.4;

	/**
	 * Costanti che rappresentano i limiti dello stato del tamagotchi e delle
	 * fasi critiche.
	 */

	public static final double MAX_FELICITA = 100, MIN_FELICITA = 0,
			MAX_SAZIETA = 100, MIN_SAZIETA = 0;

	public static final int SOGLIA_FEL_MIN = 30, SOGLIA_SAZ_MIN = 30,
			SOGLIA_SAZ_MAX = 90;

	/**
	 * Valori del tamagotchi
	 */
	
	public int carezze;
	public int biscotti;
	public int i, j;

	/**
	 * Costruttore della classe TamagotchiCostructor permette la creazione
	 * dell'oggetto tamagotchi nel main
	 * 
	 * @param _nome
	 * @param _felicita
	 * @param _sazieta
	 */

	public TamagotchiCostructor(String _nome, double _felicita, double _sazieta) {

		nome = _nome;
		felicita = _felicita;
		sazieta = _sazieta;
	}

	/**
	 * Metodo per dare carezze al tamgotchi. L'efficacia delle carezze divide
	 * l'incremento in modo che abbia un minore effetto se il metodo viene
	 * richiamato piu' volte consecutivamente.
	 * 
	 * @param carezze
	 * @param eff_carezze
	 * 
	 */

	public void daiCarezze(int carezze, int eff_carezze) {

		if ((felicita + (carezze * INC_FELICITA) / eff_carezze) <= MAX_FELICITA)
			felicita += (carezze * INC_FELICITA) / eff_carezze;
		else
			felicita = MAX_FELICITA;

		if ((sazieta - (carezze * DIM_SAZIETA)) > MIN_SAZIETA)
			sazieta -= (carezze * DIM_SAZIETA);
		else
			sazieta = MIN_SAZIETA;

	}

	/**
	 * Metodo per dare biscotti al tamagotchi. L'efficacia dei biscotti viene
	 * motliplicata perche' piu' il tamagotchi mangia piu' si riempie.
	 * 
	 * @param biscotti
	 * @param eff_biscotti
	 */

	public void daiBiscotti(int biscotti, int eff_biscotti) {

		if ((sazieta + (biscotti * INC_SAZIETA) * eff_biscotti) <= MAX_SAZIETA)
			sazieta += (biscotti * INC_SAZIETA) * eff_biscotti;
		else
			sazieta = MAX_SAZIETA;

		if ((felicita - (biscotti * DIM_FELICITA)) > MIN_FELICITA)
			felicita -= (biscotti * DIM_FELICITA);
		else
			felicita = MIN_FELICITA;

	}

	/**
	 * Metodo per verificare lo stato del tamagotchi, fornendo il grado di
	 * felicita e sazieta, dicendo anche se e' morto o in fasi critiche.
	 */

	public void stato() {

		if (felicita < SOGLIA_FEL_MIN || sazieta > SOGLIA_SAZ_MAX
				|| sazieta < SOGLIA_SAZ_MIN)
			System.out.println("Il Tamagotchi e' infelice");
		else if (felicita > SOGLIA_FEL_MIN || sazieta < SOGLIA_SAZ_MAX)
			System.out.println("Il Tamagotchi e' felice");

		if (sazieta < SOGLIA_SAZ_MIN)
			System.out.println("Il Tamagotchi ha fame");
		else if (sazieta > SOGLIA_SAZ_MAX)
			System.out.println("Il tamagotchi e' gonfio");
		else
			System.out.println("Il tamagotchi non ha fame");

		if (felicita <= 0 || sazieta <= 0 || sazieta >= MAX_SAZIETA)
			System.out.println("Il Tamagotchi e' morto");
	}

	/**
	 * Metodo per la restituzione di una stringa contenente i dati del
	 * tamagotchi
	 */

	public String stringaOutput() {

		String out_messaggio = String.format(
				("I valori di %s sono: \nFelicita: %3.1f\nSazieta: %3.1f"),
				this.nome, this.felicita, this.sazieta);  // puo' essere fatto anche con variabili senza il this.
		return out_messaggio;

	}
	
}
