package it.unibs.ing.zoo;

public class TamaTriste extends Tamagotchi {

	public TamaTriste (String _nome, double _felicita, double _sazieta ){
		
		super(_nome, _felicita, _sazieta);
		
	}
	
	/**
	 * Metodo per dare le carezze e che sovrascrive il metodo della superclasse
	 */
	
	@Override
	public void daiCarezze(int carezze, int eff_carezze) {

		if ((sazieta - (carezze * DIM_SAZIETA)) > MIN_SAZIETA)
			sazieta -= (carezze * DIM_SAZIETA);
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
	 * Metodo per verificare lo stato del tamagordo e che sovrascrive il metodo della superclasse
	 */
	
	@Override
	public void stato() {

	   System.out.println("Il Tamagotchi e' infelice (proprieta' intrinseca");
		

		if (sazieta < SOGLIA_SAZ_MIN)
			System.out.println("Il Tamagotchi ha fame");
		else if (sazieta > SOGLIA_SAZ_MAX)
			System.out.println("Il tamagotchi e' gonfio");
		else
			System.out.println("Il tamagotchi non ha fame");

		if (sazieta <= 0 || sazieta >= MAX_SAZIETA)
			System.out.println("Il Tamagotchi e' morto");
		System.out.println(" ");
		
	}
   
	/**
	 * Metodo per verificare se il tamagordo e' vivo o morto
	 */
	public boolean vita(){
		if (sazieta <= 0 || sazieta >= MAX_SAZIETA) return false;
		else return true;
	}
	
	
}
