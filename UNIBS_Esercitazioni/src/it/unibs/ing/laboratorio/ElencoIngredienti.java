package it.unibs.ing.laboratorio;
import java.util.*;

public class ElencoIngredienti {
	
	private ArrayList<Ingrediente> elenco = new ArrayList<Ingrediente>();
	
	public void inserisciIngrediente(Ingrediente ingrediente){
		elenco.add(ingrediente);
	}
    
	public Ingrediente cercaIngrediente(String nome){
		for(Ingrediente ingrediente: elenco){
			if (ingrediente.getNome().equals(nome)) return ingrediente;
		}
		System.out.println("Ingrediente non trovato");
		return null;
	}
	
	public void visualizzazione(){
		for(Ingrediente ingrediente: elenco){
			System.out.println(ingrediente.toString());
			System.out.println("-------");
		}
	}
	
	public ArrayList<Ingrediente> getElencoIngredienti(){
		return elenco;
	}
}
