package it.unibs.ing.prova;

import java.util.Scanner;
import java.util.Random;

public class Utility {

	private static Scanner in = new Scanner(System.in);
	private static Random ran = new Random();

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

	public static double doppio() {

		double input = in.nextDouble();
		return input;

	}

	/**
	 * Metodo per la creazione di numeri random
	 */

	public static int ranInt() {

		int input = ran.nextInt();
		return input;
	}

	/**
	 * Metodo per la creazione di numeri double
	 */

	public static double ranDouble() {

		double input = ran.nextDouble();
		return input;
	}
	
	public static void menu(String ...strings ) {
		for (String a: strings) System.out.println(a);
		
	}
		
}
