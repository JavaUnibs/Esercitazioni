package it.unibs.ing.zoo;


public class TamaGordo extends Tamagotchi {
	
	private static final int MAX_SAZIETA = 100;
	
	private String nome;
	private double gradoAffettivo;
	private double gradoSaziet�;

	public TamaGordo(String nome, int gradoAffettivo, int gradoSaziet�) {
		
		super(nome, gradoAffettivo, gradoSaziet�);

	}

	@Override
	public void riceviCarezze(int numCarezze)
	{
		super.riceviCarezze(numCarezze);
		
	} 
}
