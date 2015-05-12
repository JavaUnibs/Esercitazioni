package it.unibs.ing.prova;

import java.util.Scanner;

public class LeggiInput {

	private static Scanner in = new Scanner(System.in);

	/**
	 * Questo metodo permette di leggere una stringa
	 * 
	 * @return input
	 */

	public static String stringa() {

		String input = in.next();
		return input;
	}

	/**
	 * Questo metodo permette di leggere un numero intero
	 * 
	 * @return input
	 */

	public static int intero() {

		int input = in.nextInt();
		return input;

	}

	/**
	 * Questo metodo permette di leggere un numero double
	 *
	 * @return input
	 */

	public static double doppio(){
		
		double input = in.nextDouble();
		return input;
		
		
	}
}
