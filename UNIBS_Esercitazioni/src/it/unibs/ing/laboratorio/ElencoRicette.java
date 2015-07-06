package it.unibs.ing.laboratorio;
import java.util.*;

public class ElencoRicette {
	
	private ArrayList<Ricetta> elencoPrimi =new ArrayList<Ricetta>();
	private ArrayList<Ricetta> elencoSecondi = new ArrayList<Ricetta>();
	
	public void inserisciRicetta(Ricetta ricetta){
		if(ricetta.getClasse()==Classifica.Primo)
		elencoPrimi.add(ricetta);
		else elencoSecondi.add(ricetta);
	}
	
	public void visualizzazione(){
		for(Ricetta ricetta: elencoPrimi){
			System.out.println(ricetta.toString());
			System.out.println("-------");
		}
		for(Ricetta ricetta: elencoSecondi){
			System.out.println(ricetta.toString());
			System.out.println("-------");
		}
		
	}
	
	public ArrayList<Ricetta> getElencoPrimi(){
		return elencoPrimi;
	}
	
	public ArrayList<Ricetta> getElencoSecondi(){
		return elencoSecondi;
	}
}
