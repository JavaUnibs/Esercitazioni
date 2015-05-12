package it.unibs.ing.archivioCD;

public class Brano {

	public String titolo;
	public int min, sec;
	
	public Brano (String _titolo, int _min, int _sec){
		
		titolo = _titolo;
		min = _min;
		sec = _sec;
		
	}
	
	/**
	 * Metodo per restituire il titolo del brano
	 * @return titolo
	 */
	
	public String getTitolo(){
		return titolo;
	}
	
	/**
	 * Metodo per la restituzione dei parametri del brano
	 * 
	 * @return output
	 */
	
	public void branoOutput() {
		
		String output = String.format ("%s [%02d:%02d]", titolo, min, sec);
		System.out.println(output);
		
	}
	
	/**
	 * Metodo toString per il brano
	 */
	
	public String toString(){
		
		String output = String.format ("%s [%02d:%02d]", titolo, min, sec);
		return output;
	}
}
