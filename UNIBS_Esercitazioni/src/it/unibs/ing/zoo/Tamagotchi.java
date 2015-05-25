// QUESTA CLASSE Tamagotchi e' la stessa usata per l'esercitazione precedente

public class Tamagotchi {
	
	public final static int MAX_AFFETTO = 100;
	public final static int MAX_SAZIETA = 100;
	
	public final static int SOGLIA_AFFETTO_BASSO = 30;
	public final static int SOGLIA_SAZIETA_BASSA = 30;
	public final static int SOGLIA_SAZIETA_ALTA = 90;
	
	private final double FATTORE_CAREZZE = 2;
	private final double FATTORE_BISCOTTI = 4;
	private final double INCREMENTO_BISCOTTO = 1.1;
	
	private final static String DESCRIZIONE = "Sono %s%nIl mio grado di sazietÓ Ŕ %1.2f%nIl mio grado di soddisfazione affettiva Ŕ %1.2f";
	private final static String MESS_DEAD = "\nAttenzione sono violate le condizioni per la mia sopravvivenza! Addio!";
	private final static String MESS_SAD = "\nAttenzione sono infelice!";
	
	
    private String nome;
	private double gradoAffettivo;
	private double gradoSazietÓ;
	
	public Tamagotchi (String nome, int gradoAffettivo, int gradoSazietÓ)
	{
		this.nome=nome;
		this.gradoAffettivo=gradoAffettivo;
		this.gradoSazietÓ=gradoSazietÓ;
	}
	
		
	public void riceviCarezze(int numCarezze)
	{
		gradoAffettivo=Math.min(gradoAffettivo+numCarezze,MAX_AFFETTO);
		gradoSazietÓ = Math.max(0, gradoSazietÓ - numCarezze/FATTORE_CAREZZE);
	}
	
	public void riceviBiscotti(int numBiscotti)
	{
		for (int i = 1; i <= numBiscotti; i++)
		{
		 gradoSazietÓ=Math.min(gradoSazietÓ*INCREMENTO_BISCOTTO,MAX_SAZIETA);
		}
		gradoAffettivo = Math.max(0, gradoAffettivo - numBiscotti/FATTORE_BISCOTTI);
	}
	
	public boolean sonoMorto ()
	{
		return gradoAffettivo == 0 || gradoSazietÓ == 0 || gradoSazietÓ == MAX_SAZIETA; 
	}
	
	public boolean sonoTriste ()
	{
		return gradoAffettivo < SOGLIA_AFFETTO_BASSO || gradoSazietÓ < SOGLIA_SAZIETA_BASSA || gradoSazietÓ > SOGLIA_SAZIETA_ALTA; 
	}
	
	public String toString()
	{
		StringBuffer result = new StringBuffer();
		result.append(String.format(DESCRIZIONE, nome, gradoSazietÓ, gradoAffettivo));
		if (sonoMorto())
			result.append(MESS_DEAD);
		else 
		 if (sonoTriste())
		   result.append(MESS_SAD);
		
		return result.toString(); 
		
	}
}

