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
	
public static int ranIntLimite (int min, int max){
		
	    int limite = max - min;
		int i = min + random.nextInt(limite);
		return i;
		
	}

}
