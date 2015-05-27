package it.unibs.ing.zoo;

public class TamaGordo extends Tamagotchi {

	public TamaGordo(String _nome, double _felicita, double _sazieta) {

		super(_nome, _felicita, _sazieta);

	}

	/**
	 * Metodo per dare le carezze e che sovrascrive il metodo della superclasse
	 */

	@Override
	public void daiCarezze(int carezze, int eff_carezze) {

		if ((sazieta - (carezze * DIM_SAZIETA)) > MIN_SAZIETA)
			sazieta -= 2 * (carezze * DIM_SAZIETA);
		else
			sazieta = MIN_SAZIETA;

	}

	/**
	 * Metodo per dare i biscotti e che sovrascrive il metodo della superclasse
	 */

	@Override
	public void daiBiscotti(int biscotti, int eff_biscotti) {

		if ((sazieta + (biscotti * INC_SAZIETA) * eff_biscotti) <= MAX_SAZIETA)
			sazieta += (biscotti * INC_SAZIETA) * eff_biscotti;
		else
			sazieta = MAX_SAZIETA;

	}

	/**
	 * Metodo per verificare lo stato del tamagordo e che sovrascrive il metodo
	 * della superclasse
	 */

	@Override
	public void stato() {

		if (sazieta <= 0) {
			System.out.println("Il Tamagotchi è morto.");
			System.out.println(" ");
		} else {
			if (sazieta < SOGLIA_SAZ_MIN)
				System.out.println("Il Tamagotchi è infelice.");
			else
				System.out.println("Il Tamagotchi è felice.");

			if (sazieta < SOGLIA_SAZ_MIN)
				System.out.println("Il Tamagotchi ha fame perché ingordo.\n");
			else
				System.out.println("Il tamagotchi non ha fame ma è ingordo.\n");
		}
	}

	/**
	 * Metodo per verificare se il tamagordo e' vivo o morto
	 */

	public boolean vita() {
		if (sazieta <= 0)
			return false;
		else
			return true;
	}

}
