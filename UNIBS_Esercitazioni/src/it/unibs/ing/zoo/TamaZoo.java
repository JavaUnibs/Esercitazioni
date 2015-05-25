package it.unibs.ing.zoo;

import java.util.ArrayList;

	
	public class TamaZoo 
	{
	  // definire come attributo una struttura dati destinata a contenere i vari Tamagotchi presenti;
	  
		public ArrayList<Tamagotchi> tamazoo;
		
	  public TamaZoo ()
	  {
		  // inizializzare la struttura dati che conterra' i Tamagotchi
		  
		this.tamazoo = new ArrayList<Tamagotchi> ();
	  }
	  
	  public void inserisci (Tamagotchi daInserire)
	  {
		  // effettuare l'inserimento di un nuovo Tamagotchi entro la struttura  
		  tamazoo.add(daInserire);
	  }
	  
	  public boolean ciSonoVivi ()
	  {
		  // verificare se nello zoo c'e' almeno un Tamagotchi vivo (la classe Tamagotchi offre un metodo utile a tale scopo)
		  boolean stato = false;
		  
		  while(!stato){
			  
			  
	  }
	  
	  public void daiBiscotti (int quantiBiscotti, int eff_biscotti)
	  {
		  // somministrare il numero di biscotti specificato ai Tamagotchi presenti (la classe Tamagotchi offre un metodo utile a tale scopo)
			// ovviamente la somministrazione puo' avvenire solo per Tamagotchi vivi
			// per ogni Tamagotchi si stampa la sua nuova situazione
		
		  while(tamazoo.Size()) 
		  tamazoo.daiBiscotti(quantiBiscotti, eff_biscotti);
		  
	  }
	  
	  public void daiCarezze (int quanteCarezze)
	  {
		  // somministrare il numero di carezze specificato ai Tamagotchi presenti (la classe Tamagotchi offre un metodo utile a tale scopo)
			// ovviamente la somministrazione puo' avvenire solo per Tamagotchi vivi
		  // per ogni Tamagotchi si stampa la sua nuova situazione

		  tamazoo.daiCarezze (quanteCarezze, eff_carezze);
	  }
	  
	    
	}



}
