package it.unibs.ing.zoo;

import it.unibs.ing.myutility.RandomValues;

import java.util.ArrayList;

	
	public class TamaZoo 
	{
		// Numeri stabiliti per dare un senso al metodo e non generare numeri troppo alti
		public static final int MIN_BISCOTTI = 1, MAX_BISCOTTI = 75;
		public static final int MIN_CAREZZE = 1, MAX_CAREZZE = 75;
	  
		public ArrayList<Tamagotchi> tamazoo;
		
	 /**
	  * Costruttore della classe TamaZoo	
	  */
		
	public TamaZoo ()
	  {
		  // inizializzare la struttura dati che conterra' i Tamagotchi
		  
		this.tamazoo = new ArrayList<Tamagotchi> ();
	  }
	  
	/**
	 * Metodo che permette di aggiungere un tamagotchi al tamazoo
	 * 
	 * @param daInserire
	 */
	
	  public void inserisci (Tamagotchi daInserire)
	  {  
		  tamazoo.add(daInserire);
	  }
	  
	  /**
	   * Metodo per controllare se sono presnti tamagotchi vivi
	   * 
	   * @return valor booleano
	   */
	  
	  public boolean ciSonoVivi ()
	  {
		  
		  boolean stato;
		  
		  
		  for(Tamagotchi a: tamazoo){ stato = a.vita();
		  if (stato) return stato;
		  }
		  return false;
		  
	  }
	  
	  /**
	   * Metodo per dare biscotti a tutti i tamagotchi presenti nel tamazoo
	   */
	  
	  public void daiBiscotti ()
	  {
		  int eff_biscotti = 1;
		  int biscotti = RandomValues.ranIntLimite(MIN_CAREZZE, MAX_CAREZZE);
		  for(Tamagotchi a: tamazoo){ a.daiBiscotti(biscotti, eff_biscotti);}
	  }
	  
	  /**
	   * Metodo per dare carezze a tutti i tamagotchi presenti nel tamazoo
	   */
	  
	  public void daiCarezze ()
	  {
	  
		  int eff_carezze = 1;
		  int carezze = RandomValues.ranIntLimite(MIN_CAREZZE, MAX_CAREZZE);
		  for(Tamagotchi a: tamazoo){ a.daiCarezze(carezze, eff_carezze);}

	  }
	  
	    
	}




