package it.unibs.ing.clinica;
import java.util.*;
import java.time.*;

public class Slot {
	
	private LocalTime ora;
	
/**
 * Il costruttore necessita di un'orario in ingresso, corrispondente alla riga in cui si trova l'oggetto( per comodità di reperimento)
 * @param _ora 
 * @author Andrea Ferrari
 */
	Slot(LocalTime _ora){
		ora=_ora;
	}

	ArrayList<Giorno> giorni = new ArrayList<Giorno>();

/**
 * Aggiunge all'elenco un nuovo oggetto di tipo Giorno.	
 * @param giorno
 * @author Andrea Ferrari
 */
	public void aggiungiGiorno(Giorno giorno){
		giorni.add(giorno);
	}
	
	/**
	 * Restituisce la variabile ora.
	 * @return
	 * @author Andrea Ferrari
	 */
	public LocalTime getOra(){
		return ora;
	}
	
/**
* Confronta due classi Giorno e verifica se possiedono lo stesso medico e la stessa data.
* @param giorno  il primo giorno da confrontare
* @param giorno2 il secondo giorno da confrontare
* @return        vero o falso
* @author Andrea Ferrari
*/
	public boolean confrontaDisp(Giorno giorno, Giorno giorno2){
		if(giorno.getMedico()==giorno2.getMedico()&giorno.getData().equals(giorno2.getData())) return true;
		else return false;
	}

/**
 * Inserisce un oggetto di tipo Giorno all'elenco verificando che non ne sia già presente uno uguale.
 * @param giorno2 il giorno da inserire eventualmente
 * @author Andrea Ferrari
 */
	public void ciclaElencoIns(Giorno giorno2){
		boolean valore=true;
		for(Giorno giorno: giorni){
			if(confrontaDisp(giorno, giorno2)) {valore=false; break;}
		}
		if(valore) aggiungiGiorno(giorno2);
	}

/**
 * Cancella un oggetto di tipo Giorno dall'elenco se è uguale a quello inserito.
 * @param giorno2 il giorno uguale a quello da cancellare
 * @author Andrea Ferrari
 */
   public void ciclaElencoDel(Giorno giorno2){
	   for(int i=0;i<giorni.size();i++){
		   if(confrontaDisp(giorni.get(i), giorno2)) giorni.remove(i);
	   }
   }
/**
 * Verifica quali sono i giorni dell'elenco potenzialmente adatti per una visita  tramite i campi inseriti e li restituisce in un ArrayList.	   
 * @param data            la data della visita
 * @param tipoVisita      la tipologia (generica o specialistica)
 * @param areaCompetenza
 * @return                la lista di giorni adatti alla visita
 * @author Andrea Ferrari
 */
   public ArrayList<Giorno> verificaDisp(LocalDate data, String tipoVisita, String areaCompetenza){
	   ArrayList<Giorno> elencoTemp = new ArrayList<Giorno>();
	   tipoVisita.toLowerCase();
	   areaCompetenza.toLowerCase();
	   if(tipoVisita.equals("generica")) tipoVisita="generico"; else tipoVisita="specialista";
	   
	   for(Giorno giorno: giorni){
		   if(giorno.getData().equals(data)&giorno.getVisita()==null&giorno.getMedico().datoUguale(tipoVisita)&giorno.getMedico().datoUguale(areaCompetenza))
			elencoTemp.add(giorno);  
	   }
	   return elencoTemp;
   }
/**
 * Restituisce la data maggiore nell'elenco di Giorni.	
 * @return
 */
   public LocalDate massimaData(){
	   LocalDate data= giorni.get(0).getData();
	   for(Giorno giorno: giorni){
		   if (giorno.getData().isAfter(data)) data=giorno.getData();
	   }
	   
	   return data;
   }
	
}
