package it.unibs.ing.laboratorio;
import java.util.*;

enum Classifica{
	Primo, Secondo
}
public class Ricetta {

	private String nome;
	private String descrizione;
	private Classifica classe;
	private ArrayList<Quantità> elencoQuantità= new ArrayList<Quantità>();
	
	Ricetta(String _nome, String _descrizione, String _classe, ArrayList<Quantità> elenco){
		nome=_nome;
		descrizione=_descrizione;
		for(Quantità quantità:elenco){
			elencoQuantità.add(quantità);
		}
	    
		if(_classe.equals("Primo")) classe=Classifica.Primo;
		else classe=Classifica.Secondo;
		
	}
	
	public int calorieTot(){
		int totale=0;
	
		for(Quantità quantità:elencoQuantità){
			totale+=quantità.calorieTot();
		}
		return totale;
	}
	
	public String toString(){
		return "Nome:"+nome+"/n"
				+"Descrizione: "+descrizione+"/n"
				+"Calorie: "+calorieTot()+"/n";
	}
	
	public Classifica getClasse(){
		return classe;
	}
	
	public String getNome(){
	    return nome;
	}
	
}
