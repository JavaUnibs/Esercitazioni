package it.unibs.ing.myutility;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LeggiInput {

	private static Scanner in = new Scanner(System.in);
	
	private final static String ERRORE_FORMATO = "Attenzione: il dato inserito non è nel formato corretto.";

	/**
	 * Questo metodo permette di leggere una stringa senza spazi
	 * 
	 * @return input
	 */

	public static String stringa(String domanda) {

		System.out.println(domanda);
		String input = in.next();
		return input;
	}

	/**
	 * Questo metodo permette di leggere un'intera riga
	 * 
	 * @return input
	 */

	public static String riga(String domanda) {

		System.out.println(domanda);
		String input = in.nextLine();
		return input;

	}

	/**
	 * Questo metodo permette l'inserimento di una riga e il controllo della
	 * lunghezza min e max
	 * 
	 * @return input
	 */

	public static String rigaLimiti(int max, int min) {
		String input;
		do {
			System.out.printf("Inserire una stringa compresa tra %d e %d ",
					min, max);
			input = in.nextLine();
		} while (input.length() > max || input.length() < min);

		return input;

	}

	/**
	 * Questo metodo permette di leggere un numero intero
	 * 
	 * @return input
	 */

	public static int intero(String domanda) {
		
		boolean opEseguita = false;
		   int input = 0;
		   do
		    {
		     System.out.println(domanda);
		     try
		      {
		       input = in.nextInt();
		       opEseguita = true;
		      }
		     catch (InputMismatchException e)
		      {
		       System.out.println(ERRORE_FORMATO);
		      }
		    } while (!opEseguita);
		   return input;
		  }

	

	/**
	 * Questo metodo permette di leggere un numero intero con limiti di min e
	 * max
	 * 
	 * @return input
	 */

	public static int interoLimiti(int min, int max) {

		int input;

		do {
			System.out.printf("Inserire un intero compreso tra %d e %d: ", min,
					max);
			input = in.nextInt();
		} while (input > max || input < min);

		return input;

	}

	/**
	 * Questo metodo permette di leggere un numero double
	 *
	 * @return input
	 */

	public static double doppio(String domanda) {

		boolean opEseguita = false;
		   double input = 0;
		   do
		    {
		     System.out.println(domanda);
		     try
		      {
		       input = in.nextDouble();
		       opEseguita = true;
		      }
		     catch (InputMismatchException e)
		      {
		       System.out.println(ERRORE_FORMATO);
		      }
		    } while (!opEseguita);
		   return input;
		  }
	
	/**
	 * Metodo per la scelta 
	 * 
	 * @param domanda
	 * @return bool
	 */
	
	public static boolean doppiaScelta (String domanda){
		
		boolean bool;
		
		System.out.println(domanda + "(S/N)");
		String input = in.next();
		input = input.toUpperCase();
		
		if(input.equals("S")) bool = true;
		else bool = false;
		
		return bool;
	
	}
	
	public static void terminaRiga (){
		in.nextLine();
	}
}
