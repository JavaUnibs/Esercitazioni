package it.unibs.ing.zoo;


public class TamaGordo extends Tamagotchi {
	
	private static final int MAX_SAZIETA = 100;
	
	private String nome;
	private double gradoAffettivo;
	private double gradoSazietà;

	public TamaGordo(String nome, int gradoAffettivo, int gradoSazietà) {
		
		super(nome, gradoAffettivo, gradoSazietà);

	}

	@Override
	public void riceviCarezze(int numCarezze)
	{
		super.riceviCarezze(numCarezze);
		
	} 
}
