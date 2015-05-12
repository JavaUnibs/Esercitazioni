package it.unibs.ing.myutility;

public class FormatOutput {
	
	/**
	 * Metodo per la stampa di un menu con in ingresso la stringa dei suoi
	 * valori
	 * 
	 * @param arrayStrings
	 */

	public static void menu(String[] arrayStrings) {
		for (String a : arrayStrings)
			System.out.println(a);

	}
	
	public static String removeCh (String s , int index) {
		if ((index > s.length()-1) || (index < 0)) return null;
		String c = s.substring(0,index) + s.substring(index+1 , s.length());
		return c;
		}
		}



