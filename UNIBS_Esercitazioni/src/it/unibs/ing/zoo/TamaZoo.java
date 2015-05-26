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
		  boolean stato;
		  
		  
		  for(Tamagotchi a: tamazoo){ stato = a.vita();
		  if (stato) return stato;
		  }
		  return false;
		  
	  }
	  
	  public void daiBiscotti (int quantiBiscotti)
	  {
		  int eff_biscotti = 1;
		  
		  for(Tamagotchi a: tamazoo){ a.daiBiscotti(quantiBiscotti, eff_biscotti);

	  }
	  
	  public void daiCarezze (int quanteCarezze){
	  
		  int eff_carezze = 1;
		  for(Tamagotchi a: tamazoo){ a.daiCarezze(quanteCarezze, eff_carezze);}

	  }
	  
	    
	}



}
