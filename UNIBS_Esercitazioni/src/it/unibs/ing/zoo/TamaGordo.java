package it.unibs.ing.zoo;


public class TamaGordo extends Tamagotchi {
	
	private static final int MAX_SAZIETA = 100;
	
	private String nome;
	private double gradoAffettivo;
	private double gradoSazietà;

	public TamaGordo(String _nome, double _gradoAffettivo, double _gradoSazietà) {
		
		super(_nome, _gradoAffettivo, _gradoSazietà);

	}

	@Override
	public void riceviCarezze(int numCarezze)
	{
		
		
	} 
}
