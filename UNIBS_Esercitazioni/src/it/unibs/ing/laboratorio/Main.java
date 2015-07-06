package it.unibs.ing.laboratorio;
import java.util.*;
import it.unibs.ing.myutility.*;
public class Main {
	
	static final String[] MENU= {"Inserisci una nuovo ingrediente", "Inserisci una nuova ricetta", "Visualizza ingredienti", "Visualizza ricette", "Componi menu"};
			
			
	public static void main(String[] args) {
		
		Menu elenco= new Menu(MENU);
		ElencoIngredienti elencoIngredienti= new ElencoIngredienti();
		ElencoRicette elencoRicette= new ElencoRicette();
		
		while(true){
			int scelta=elenco.stampaMenu();
			
			switch(scelta){
			        case 1:{
				    String nome=LeggiInput.riga("Inserisci il nome dell'ingrediente:");
				    int calorie=LeggiInput.intero("Inserirne le calorie:");
				    elencoIngredienti.inserisciIngrediente(new Ingrediente(nome, calorie));
			        }
			        break;
			        case 2:{
			        String nome=LeggiInput.riga("Inserisci il nome della ricetta:");
			        String descrizione=LeggiInput.riga("Inserisci la descrizione della ricetta:");
			        String classe=LeggiInput.stringa("Il piatto è un primo o un secondo?");
			        ArrayList<Quantità> temp= new ArrayList<Quantità>();
			        boolean valore2=false;
			        	while(!valore2){
			        		int quantità;
			        		Ingrediente ingrediente=elencoIngredienti.cercaIngrediente(LeggiInput.riga("Inserisci un ingrediente:"));
			        		if (ingrediente!=null) {
			        			quantità=LeggiInput.intero("Inserirne le quantità:");
			        			temp.add(new Quantità(ingrediente, quantità));
			        			
			        		}
			        		valore2=LeggiInput.doppiaScelta("Inserire un altro ingrediente?");
			        	}
			        	
			        elencoRicette.inserisciRicetta(new Ricetta(nome, descrizione, classe, temp));
			        }
			        break;
			        case 3:{
			        	elencoIngredienti.visualizzazione();
			        }
			        break;
			        case 4:{
			        	elencoRicette.visualizzazione();
			        }
			        break;
			        case 5:{
			        	int calorieMax=LeggiInput.intero("Inserire le calorie massime di questo menu:");
			        	boolean valore3=false;
			        	for(Ricetta primo: elencoRicette.getElencoPrimi()){
			        		for(Ricetta secondo: elencoRicette.getElencoSecondi()){
			        			if(primo.calorieTot()+secondo.calorieTot()<=calorieMax) {
			        			System.out.println(primo.getNome()+"/n"+secondo.getNome());
			        			valore3=true;
			        			break;
			        			}
			        			if (valore3) break;
			        		}
			        	}
			        }
			        break;
			        case 0: return;
			}
			
	    }
		

   }

}
