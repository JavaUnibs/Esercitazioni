package it.unibs.ing.zoo;


public class TamaGordo extends Tamagotchi {
	
	private static final int MAX_SAZIETA = 100;
	
	private String nome;
	private double gradoAffettivo;
	private double gradoSazietÓ;

	public TamaGordo(String _nome, double _gradoAffettivo, double _gradoSazietÓ) {
		
		super(_nome, _gradoAffettivo, _gradoSazietÓ);

	}

	@Override
	public void riceviCarezze(int numCarezze)
	{
		
		
	} 
}
