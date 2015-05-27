 package it.unibs.ing.myutility;

import java.util.Random;

public class RandomValues {
	
	private static Random random = new Random();
	
	/**
	 * Metodo per randomizzare un intero
	 * 
	 * @return i
	 */
	
	public static int ranInt (){
		
		int i = random.nextInt();
		return i;
		
	}
	
	/**
	 * Metodo per randomizzare un double
	 * 
	 * @return i
	 */
	
	public static double ranDouble (){
		
		double i = random.nextDouble();
		return i;
		
	}
	
	/**
	 * Genera un numero intero copreso in un range personalizzabile 
	 * 
	 * @param min
	 * @param max
	 * @return
	 */

	public static int ranIntLimite (int min, int max){
		
	    int limite = max - min +1;
		int i = min + random.nextInt(limite);
		return i;
		
	}

/**
 * Genera un numero double compreso in un range personalizzabile
 * 
 * @param min
 * @param max
 * @return i
 */

public static double ranDoubleLimite (double min, double max){
	
		double limite = max - min;
		double i = min + (limite) * random.nextDouble();
		
		return i;
}

}
