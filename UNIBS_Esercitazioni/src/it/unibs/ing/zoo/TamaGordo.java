package it.unibs.ing.zoo;


public class TamaGordo extends Tamagotchi {

	public TamaGordo(String _nome, double _gradoAffettivo, double _gradoSazietà) {
		
		super(_nome, _gradoAffettivo, _gradoSazietà);

	}

	@Override
	public void daiCarezze(int carezze, int eff_carezze) {

		if ((sazieta - (carezze * DIM_SAZIETA)) > MIN_SAZIETA)
			sazieta -= 2*(carezze * DIM_SAZIETA);
		else
			sazieta = MIN_SAZIETA;

	}
	
	@Override
	public void daiBiscotti(int biscotti, int eff_biscotti) {

		if ((sazieta + (biscotti * INC_SAZIETA) * eff_biscotti) <= MAX_SAZIETA)
			sazieta += (biscotti * INC_SAZIETA) * eff_biscotti;
		else
			sazieta = MAX_SAZIETA;


	}
	
	@Override
	public void stato() {

		if (sazieta < SOGLIA_SAZ_MIN)
			System.out.println("Il Tamagotchi e' infelice");
		else System.out.println("Il Tamagotchi e' felice");

		if (sazieta < SOGLIA_SAZ_MIN)
			System.out.println("Il Tamagotchi ha fame");
		else
			System.out.println("Il tamagotchi non ha fame ma e' ingordo");

		if (sazieta <= 0)
			System.out.println("Il Tamagotchi e' morto");
	}
	
	public boolean vita(){
		if (sazieta <= 0) return false;
		else return true;
	}

}
