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
		for(Giorno giorno: giorni){
			if(confrontaDisp(giorno, giorno2)) return;
		}
		aggiungiGiorno(giorno2);
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
	   if(tipoVisita.toLowerCase().equals("generica")) tipoVisita="Generico"; else tipoVisita="Specialista";
	   
	   for(Giorno giorno: giorni){
		   if(giorno.getData().equals(data)&giorno.getVisita()==null&giorno.getMedico().datoUguale(tipoVisita)&giorno.getMedico().datoUguale(areaCompetenza))
			elencoTemp.add(giorno);  
	   }
	   return elencoTemp;
   }
/**
 * Restituisce la data maggiore nell'elenco di Giorni.	
 * @return
 * @author Andrea Ferrari
 */
   public LocalDate massimaData(){
	   LocalDate data= giorni.get(0).getData();
	   for(Giorno giorno: giorni){
		   if (giorno.getData().isAfter(data)) data=giorno.getData();
	   }
	   
	   return data;
   }
/**
 * Restituisce un arraylist contenente i giorni di questo slot con visite fissate dall'utente inserito.   
 * @param utente l'utente di cui cercare le visite
 * @return       
 * @author Andrea Ferrari
 */
   public ArrayList<Giorno> visiteUtenteSlot(Utente utente){
	   ArrayList<Giorno> temp= new ArrayList<Giorno>();
	   for(Giorno giorno: giorni){
		   if(giorno.getUtente()==utente) temp.add(giorno);
	   }
	   return temp;
   }
   
   
/**
* Restituisce un arraylist contenente i giorni di questo slot con visite a cura del medico inserito.   
* @param medico il medico di cui cercare le visite
* @return       
* @author Andrea Ferrari
*/
   public ArrayList<Giorno> visiteMedicoSlot(Medico medico){
   	   ArrayList<Giorno> temp= new ArrayList<Giorno>();
   	   for(Giorno giorno: giorni){
   		   if(giorno.getMedico()==medico) temp.add(giorno);
   	   }
   	   return temp;
      }
/**
 * Restituisce un arraylist contenente i giorni di questi slot con visite del tipo e area di competenza inseriti.      
 * @param tipoVisita
 * @param areaCompetenza
 * @return
 */
   public ArrayList<Giorno> visiteTipoSlot(String tipoVisita, String areaCompetenza){
	   ArrayList<Giorno> temp= new ArrayList<Giorno>();
	   for(Giorno giorno: giorni){
   		   if(giorno.getVisita().getTipo().equals(tipoVisita)&giorno.getVisita().getAreaComp().equals(areaCompetenza)) temp.add(giorno);
   	   }
	   return temp;
   }
/**
 * Restituisce un array in cui il primo elemento è il numero di visite prenotate e il secondo il numero di visite concluse nello Slot.   
 * @return
 */
   public int[] numVisite(){
	   int prenotate=0, concluse=0;
	   for(Giorno giorno: giorni){
		   if(giorno.getStato().equals(statoVisita.Prenotata)) prenotate++;
		   if(giorno.getStato().equals(statoVisita.Conclusa)) concluse++;   
	   }
	   int[] contatore= {prenotate, concluse};
	   return contatore;
    }
/**
 * Restituisce un array in cui il primo elemento è il numero di visite prenotate generiche, il secondo di prenotate specialistiche,
 * il terzo di concluse generiche, il quarto di concluse specialistiche.
 * @return
 */
  public int[] numVisiteTipo(){
	  int prenotateGeneriche=0, prenotateSpecialistiche=0, concluseGeneriche=0, concluseSpecialistiche=0;
	  for(Giorno giorno: giorni){
		  if(giorno.getStato().equals(statoVisita.Prenotata)){
			  if(giorno.getVisita().getTipo().toLowerCase().equals("generica")) prenotateGeneriche++; else prenotateSpecialistiche++;
		  }
		  
		  if(giorno.getStato().equals(statoVisita.Conclusa)){
			  if(giorno.getVisita().getTipo().toLowerCase().equals("generica")) concluseGeneriche++; else concluseSpecialistiche++;
		  }
		  
	  }
	  
	  int[] contatore= {prenotateGeneriche, prenotateSpecialistiche, concluseGeneriche, concluseSpecialistiche};
	  return contatore;
  }
  
/**
 *Restituisce un array bidimensionale, dove la prima riga rappresenta le visite prenotate, la seconda quelle concluse, e le colonne l'appartenenza ad un area di competenza specifica.   
 * @param elencoAree un arrayList contenente tutti le aree di competenza dei medici della clinica.
 * @return
 */
  public int[][] numVisiteArea(ArrayList<String> elencoAree){
	  int[][] contatore= new int[2][elencoAree.size()];
	  for(Giorno giorno: giorni){
		  for(int i=0;i<elencoAree.size();i++){
			  if(giorno.getVisita().getAreaComp().equals(elencoAree.get(i))&giorno.getStato().equals(statoVisita.Prenotata)) { contatore[0][i]++; break;}
			  if(giorno.getVisita().getAreaComp().equals(elencoAree.get(i))&giorno.getStato().equals(statoVisita.Conclusa)) { contatore[1][i]++; break; }
		  }
	  }
	  return contatore;
  }
  
  

}
