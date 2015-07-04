package it.unibs.ing.clinica;
import it.unibs.ing.myutility.LeggiInput;

import java.time.*;
import java.util.*;

public class Agenda {
	Slot[][] settimana = new Slot[20][6];
	
	
/**
 * Il costruttore riempie automaticamente l'array bidimensionale settimana con delle classi Slot, 
 * ciascuna delle quali con il proprio orario.
 * 
 * @author Andrea Ferrari
 */
	Agenda(){
		LocalTime temp= LocalTime.of(8, 00);
		int i,j;
		for(i=0;i<6;i++){
			for (j=0;j<20;j++){
				settimana[j][i]=new Slot(Date.incrementoOra(temp, j));
			}
		}
	}

	
/**
 * Inserisce un medico nell'intervallo di giorni e di orari voluti, a meno che esso non sia già presente.
 * @param medico          il medico da inserire
 * @param giornoIniziale  il primo giorno dell'intervallo
 * @param giornoFinale    l'ultimo giorno dell'intervallo
 * @param oraIniziale     la prima ora dell'intervallo
 * @param oraFinale       l'ultima ora dell'intervallo
 * @author Andrea Ferrari
 */
	public void inserimentoDisp (Medico medico, LocalDate giornoIniziale, LocalDate giornoFinale, LocalTime oraIniziale, LocalTime oraFinale){
		int data1, data2=Date.indiceGiorno(giornoFinale), ora1, ora2=Date.indiceOra(oraFinale), cont=0;
		
		for(data1=Date.indiceGiorno(giornoIniziale);data1<=data2;data1++){
			for (ora1=Date.indiceOra(oraIniziale);ora1<=ora2;ora1++){
				Giorno temp=new Giorno(medico, Date.incrementoGiorno(giornoIniziale, cont));
				settimana[ora1][data1].ciclaElencoIns(temp);
				}
			cont++;
		}
	}
	
/**
 * Inserisce un medico nei giorni specifici e nell'intervallo di orari voluti, a meno che esso non sia già presente.	
 * @param medico      il medico da inserire
 * @param oraIniziale la prima ora dell'intervallo 
 * @param oraFinale   l'ultima ora dell'intervallo
 * @param giorniVari  array variabile dei giorni scelti
 * @author Andrea Ferrari
 */
	public void inserimentoDisp(Medico medico, LocalTime oraIniziale, LocalTime oraFinale, LocalDate... giorniVari){
		int i, ora1, ora2=Date.indiceOra(oraFinale), data;
		
		for(i=0;i<giorniVari.length;i++){
			data=Date.indiceGiorno(giorniVari[i]);
			for (ora1=Date.indiceOra(oraIniziale);ora1<=ora2;ora1++){
				Giorno temp= new Giorno(medico, giorniVari[i]);
				settimana[ora1][data].ciclaElencoIns(temp);
			}
		  }
		}
	
/**
 * Inserisce un medico nel giorno e nell'intervallo di orari voluto, a meno che non sia già presente.
 * @param medico      il medico da inserire
 * @param giorno      il giorno scelto
 * @param oraIniziale la prima ora dell'intervallo
 * @param oraFinale   l'ultima ora dell'intervallo
 * @author Andrea Ferrari
 */
	public void inserimentoDisp(Medico medico, LocalDate giorno, LocalTime oraIniziale, LocalTime oraFinale){
		int ora1, ora2=Date.indiceOra(oraFinale);
		
		for (ora1=Date.indiceOra(oraIniziale);ora1<=ora2;ora1++){
			Giorno temp= new Giorno(medico, giorno);
			settimana[ora1][Date.indiceGiorno(giorno)].ciclaElencoIns(temp);
		}
	}
	
/**
 * Stampa gli orari di visita di un medico in formato giorno-mese-anno-orario, in ordine cronologico ascendente.
 * @param medico il medico di cui si vogliono vedere gli orari di visita
 * @author Andrea Ferrari
 */
	public void orariVisita(Medico medico){
	Set<LocalDateTime> orari = new TreeSet<LocalDateTime>();
	
		for(int i=0;i<6;i++){
			for(int j=0;j<20;j++){
				for(Giorno giorno: settimana[j][i].giorni){
					if(giorno.getMedico()==medico) orari.add(LocalDateTime.of(giorno.getData(), settimana[j][i].getOra()));
				}
			}
		}
		
		if(orari.isEmpty()) {System.out.println("Questo medico non è disponibile in nessuna data."); return;}
		Iterator<LocalDateTime> iterator=orari.iterator();
		System.out.println("Orari disponibili:");
	    while(iterator.hasNext()) System.out.println(iterator.next());
	    
	    }
	
/**
 * Stampa i medici disponibili nella data e orario scelti.
 * @param data il giorno scelto
 * @param ora  l'orario scelto
 * @author Andrea Ferrari
 */
	public void mediciDisponibili(LocalDate data, LocalTime ora){
		int i=Date.indiceGiorno(data), k=Date.indiceOra(ora);
		System.out.println("Medici disponibili:");
		for(Giorno giorno: settimana[k][i].giorni){
			if(giorno.getData().equals(data)) System.out.println(giorno.getMedico().toString());
		}
	}
	
/**
* Cancella un medico nell'intervallo di giorni e di orari voluti (cancella anche le visite correlate).
* @param medico          il medico da cancellare
* @param giornoIniziale  il primo giorno dell'intervallo
* @param giornoFinale    l'ultimo giorno dell'intervallo
* @param oraIniziale     la prima ora dell'intervallo
* @param oraFinale       l'ultima ora dell'intervallo
* @author Andrea Ferrari
*/
	public void cancellaDisp(Medico medico, LocalDate giornoIniziale, LocalDate giornoFinale, LocalTime oraIniziale, LocalTime oraFinale){
		int data1, data2=Date.indiceGiorno(giornoFinale), ora1, ora2=Date.indiceOra(oraFinale), cont=0;
		
		for(data1=Date.indiceGiorno(giornoIniziale);data1<=data2;data1++){
			for (ora1=Date.indiceOra(oraIniziale);ora1<=ora2;ora1++){
				Giorno temp=new Giorno(medico, Date.incrementoGiorno(giornoIniziale, cont));
				settimana[ora1][data1].ciclaElencoDel(temp);	
			}
			cont++;
		}
	}
	
/**
* Cancella un medico nei giorni specifici e nell'intervallo di orari voluti (cancella anche le visite ad esso correlate).	
* @param medico      il medico da cancellare
* @param oraIniziale la prima ora dell'intervallo 
* @param oraFinale   l'ultima ora dell'intervallo
* @param giorniVari  array variabile dei giorni scelti
* @author Andrea Ferrari
*/
	public void cancellaDisp(Medico medico, LocalTime oraIniziale, LocalTime oraFinale, LocalDate... giorniVari){
		int i, ora1, ora2=Date.indiceOra(oraFinale), data;
		
		for(i=0;i<giorniVari.length;i++){
			data=Date.indiceGiorno(giorniVari[i]);
			for (ora1=Date.indiceOra(oraIniziale);ora1<=ora2;ora1++){
				Giorno temp= new Giorno(medico, giorniVari[i]);
				settimana[ora1][data].ciclaElencoDel(temp);	
				}
			}
		}	

/**
* Cancella un medico nel giorno e nell'intervallo di orari voluto (cancella anche le visite ad esso correlate).
* @param medico      il medico da cancellare
* @param giorno      il giorno scelto
* @param oraIniziale la prima ora dell'intervallo
* @param oraFinale   l'ultima ora dell'intervallo
* @author Andrea Ferrari
*/
	public void cancellaDisp(Medico medico, LocalDate giorno, LocalTime oraIniziale, LocalTime oraFinale){
		int ora1, ora2=Date.indiceOra(oraFinale), data=Date.indiceGiorno(giorno);
		
		for (ora1=Date.indiceOra(oraIniziale);ora1<=ora2;ora1++){
			Giorno temp= new Giorno(medico, giorno);
			settimana[ora1][data].ciclaElencoDel(temp);
			}
			}

/**
 * Restituisce la visita corrispondente	al medico, alla data e all'orario scelti..
 * @param medico il medico scelto
 * @param data il giorno scelto
 * @param ora  l'orario scelto
 * @return     la visita corrispondente
 * @author Andrea Ferrari
 */
   public Giorno specificaVisita(Medico medico, LocalDate data, LocalTime ora){
	   Giorno nullo=null;
	   int i=Date.indiceGiorno(data), k=Date.indiceOra(ora);
	   for(Giorno giorno: settimana[k][i].giorni){
		   if(giorno.getData().equals(data)&giorno.getVisita()!=null) return giorno;
	   }
	   return nullo;
   }

/**
 * Restituisce la data maggiore di disponibilità di tutto il calendario.
 * @return
 * @author Andrea Ferrari
 */
   public LocalDate massimaData(){
	LocalDate data=settimana[0][0].massimaData();
	   for(int i=0;i<6;i++){
		   for (int j=0;j<20;j++){
			   if(settimana[j][i].massimaData().isAfter(data)) data=settimana[j][i].massimaData();
		   }
	   }
	   return data;
	   }
   
   
/**
 * Verifica se nella data e ora inseriti ci sono uno o più medici adatti alle caratteristiche della visita. Se non ci sono, stampa 
 * la prossima data e ora in cui ve n'è uno adatto.
 * @param utente         l'utente che vuole fissare la visita
 * @param motivoVisita   il motivo per la prenotazione della visita
 * @param data           la data specificata
 * @param ora            l'ora specificata
 * @param tipoVisita     la tipologia della visita
 * @author Andrea Ferrari
 */
   public void inserimentoVisita(Utente utente, String motivoVisita, LocalDate data, LocalTime ora, String tipoVisita){
	   int scelta, ora1=Date.indiceOra(ora), data1=Date.indiceGiorno(data), i, j;
	   String areaCompetenza="";
	   if(tipoVisita.toLowerCase().equals("specialistica")) areaCompetenza=LeggiInput.stringa("Inserire l'area di competenza richiesta");
	   
	   ArrayList<Giorno> elencoTemp= settimana[ora1][data1].verificaDisp(data, tipoVisita, areaCompetenza);
	   System.out.println("Medici disponibili il "+data.toString()+" alle "+settimana[ora1][data1].getOra().toString()+" :");
	   if(elencoTemp.size()==0) System.out.println("Nessun medico disponibile in questa data.");
	   else {
		   for(Giorno giorno: elencoTemp){
	       System.out.println(giorno.getMedico().toString());
	   }
	   scelta=LeggiInput.intero("Scegliere un medico tramite un numero")-1;
	   elencoTemp.get(scelta).setUtente(utente);
	   elencoTemp.get(scelta).setStato(statoVisita.Prenotata);
	   elencoTemp.get(scelta).setVisita(new Visita(motivoVisita, tipoVisita, areaCompetenza));
	   return;
	   }
	   
	   //Questo ciclo finisce i restanti orari del giorno in cerca del prossimo giorno adatto alla visita
	   for(ora1=Date.indiceOra(ora);ora1<20;ora1++){
		   elencoTemp=settimana[ora1][data1].verificaDisp(data, tipoVisita, areaCompetenza);   
	       if (elencoTemp.size()>0){
	       System.out.println("Prossima data disponibile: "+elencoTemp.get(0).getData().toString()+" alle "+settimana[ora1][data1].getOra().toString());  
	    	return;  
	     }
	   }
	   
	   //Questo ciclo finisce i restanti giorni della settimana in cerca del prossimo giorno adatto alla visita
	   int cont=1;
	   for(data1=Date.indiceGiorno(data)+1;data1<6;data1++){
	       for(ora1=0;ora1<20;ora1++){
	       elencoTemp=settimana[ora1][data1].verificaDisp(Date.incrementoGiorno(data, cont), tipoVisita, areaCompetenza);   
	       if (elencoTemp.size()>0){
	       System.out.println("Prossima data disponibile: "+elencoTemp.get(0).getData().toString()+" alle "+settimana[ora1][data1].getOra().toString());  
	    	return;  
	       }
	     }
	       cont++;
	   }
	   
	   LocalDate maxData=massimaData();
	   //Questo ciclo cerca un nuovo giorno disponibile fino alla massima data di disponibilità in tutto il calendario.
	   while(data.isBefore(maxData)||data.isEqual(maxData)){
	       if(data.getDayOfWeek().getValue()==6) cont+=2; else if(data.getDayOfWeek().getValue()==7) cont++;
		   for(i=0;i<6;i++){
		   for(j=0;j<20;j++){
		   elencoTemp=settimana[j][i].verificaDisp(Date.incrementoGiorno(data, cont), tipoVisita, areaCompetenza);
		   if (elencoTemp.size()>0){
		    System.out.println("Prossima data disponibile: "+elencoTemp.get(0).getData().toString()+" alle "+settimana[j][i].getOra().toString());  
		    return; 
		   }
	      }
		   cont++;
	    }   
	   }
      }
     
   
   
/**
 * Restituisce gli oggetti Giorno contententi le visite fissate dall'utente inserito.
 * @param utente   l'utente di cui cercare le visite
 * @return         gli oggetti Giorno in cui vi è la visita
 * @author Andrea Ferrari
 */
   public ArrayList<Giorno> visiteUtente(Utente utente){
	   ArrayList<Giorno> elencoTemp = new ArrayList<Giorno>();
	   for(int i=0;i<6;i++){
		   for(int j=0;j<20;j++){
			   elencoTemp.addAll(settimana[j][i].visiteUtenteSlot(utente));
		   }
	   }
	   return elencoTemp;
   }

/**
* Restituisce gli oggetti Giorno contenenti le visite a cura del medico inserito.
* @param utente   il medico di cui cercare le visite
* @return         gli oggetti Giorno in cui vi è la visita
* @author Andrea Ferrari
*/
   public ArrayList<Giorno> visiteMedico(Medico medico){
   	   ArrayList<Giorno> elencoTemp = new ArrayList<Giorno>();
   	   for(int i=0;i<6;i++){
   		   for(int j=0;j<20;j++){
   			   elencoTemp.addAll(settimana[j][i].visiteMedicoSlot(medico));
   		   }
   	   }
   	   return elencoTemp;
      }   
/**
 * Restituisce gli oggetti Giorno contenenti le visite del tipo e area di competenza inseriti.      
 * @param tipoVisita
 * @return
 */
  public ArrayList<Giorno> visiteTipo(String tipoVisita){
	  ArrayList<Giorno> elencoTemp = new ArrayList<Giorno>();
	  String areaCompetenza="";
	  if(tipoVisita.toLowerCase().equals("specialistica")) areaCompetenza=LeggiInput.stringa("Inserire l'area di competenza richiesta");
	  for(int i=0;i<6;i++){
  		   for(int j=0;j<20;j++){
  			   elencoTemp.addAll(settimana[j][i].visiteTipoSlot(tipoVisita, areaCompetenza));
  		   }
  	   }
  	   return elencoTemp;
      }
/**
 * Stampa il numero di visite prenotate, concluse e totali.  
 */
  public void statisticheVisite(){
	 int[] array;
	 int prenotate=0, concluse=0;
	 for(int i=0;i<6;i++){
		 for(int j=0;j<20;j++){
			 array=settimana[j][i].numVisite();
			 prenotate+=array[0];
			 concluse+=array[1];
		 }
	 }
	 System.out.println("Visite totali: "+(prenotate+concluse));
	 System.out.println("Visite prenotate: "+prenotate);
	 System.out.println("Visite concluse: "+concluse);
	 
  }
/**
 * Stampa il numero di visite totali, prenotate e concluse suddivise per tipo.
 */
  public void statisticheVisiteTipo(){
	  int[] array;
	  int prenotateGeneriche=0,  prenotateSpecialistiche=0, concluseGeneriche=0, concluseSpecialistiche=0;
		 for(int i=0;i<6;i++){
			 for(int j=0;j<20;j++){
			array=settimana[j][i].numVisiteTipo();
			prenotateGeneriche+=array[0];
			prenotateSpecialistiche+=array[1];
			concluseGeneriche+=array[2];
			concluseSpecialistiche+=array[3];
		 }	 
	  }
	  System.out.println("Visite totali generiche: "+(prenotateGeneriche+prenotateSpecialistiche));
	  System.out.println("Visite totali specialistiche: "+(concluseGeneriche+concluseSpecialistiche));
	  System.out.println("Visite prenotate generiche: "+prenotateGeneriche);
	  System.out.println("Visite prenotate specialistiche: "+prenotateSpecialistiche);
	  System.out.println("Visite concluse generiche: "+concluseGeneriche);
	  System.out.println("Visite concluse specialistiche: "+concluseSpecialistiche);
  }

/**
 * Stampa i numeri di visite prenotate e concluse suddivise per area di competenza.
 * @param elencoAree un arraylist di stringhe contenente tutte le aree di competenza dei medici della clinica.
 */
  public void statisticheVisiteArea(ArrayList<String> elencoAree){
	  int[][] contatore=new int[2][elencoAree.size()];
	  int[][] contatoreSlot;
	  for(int i=0;i<6;i++){
		  for(int j=0;j<20;j++){
			contatoreSlot=settimana[j][i].numVisiteArea(elencoAree);
			for(int x=0;x<contatore.length;x++){
				for(int y=0;y<2;y++){
					contatore[y][x]+=contatoreSlot[y][x];
				}
			}
		}
	  }
	  
	  for(int x=0;x<contatore.length;x++){
		  for(int y=0;y<2;y++){
			  if(y==0)System.out.println("Visite prenotate di "+elencoAree.get(x)+": "+contatore[y][x]);
			  else System.out.println("Visite concluse di "+elencoAree.get(x)+": "+contatore[y][x]);
			  System.out.println("----");
		  }
	  }
  }

/**
 * Stampa le aree di competenza con il minor e il maggior numero di visite.
 * @param elencoAree un arraylist di stringhe contenente tutte le aree di competenza dei medici della clinica.
 */
  public void statisticheVisiteAreaMinMax(ArrayList<String> elencoAree){
	  int[] contatore=new int[elencoAree.size()];
	  int[][] contatoreSlot;
	  for(int i=0;i<6;i++){
		  for(int j=0;j<20;j++){
			contatoreSlot=settimana[j][i].numVisiteArea(elencoAree);
			for(int x=0;x<contatore.length;x++){
				for(int y=0;y<2;y++){
					contatore[x]+=contatoreSlot[y][x];
				}
			}
		}
	  }
      int posizioneMax=0, posizioneMin=0, max=contatore[0], min=contatore[0];
	  for(int x=0;x<contatore.length;x++){
		 if(contatore[x]>max) {
			 max=contatore[x];
			 posizioneMax=x;
		 }
		 else
		 if(contatore[x]<min){
			 min=contatore[x];
			 posizioneMin=x;
		 }
		 
	  }
	  
	  System.out.println("Area di competenza con più visite: "+elencoAree.get(posizioneMax));
	  System.out.println("Area di competenza con meno visite: "+elencoAree.get(posizioneMin));
  
   }
      
/**
 * Stampa il numero di visite assegnate ad ogni medico della clinica.   
 * @param elencoMedici un arraylist di classi Medico contenente tutti i medici della clinica.
 */
   public void statisticheVisiteMedici(ArrayList<Medico> elencoMedici){
	   int[] contatore=new int[elencoMedici.size()];
	   int x=0;
	   for(Medico medico: elencoMedici){
		   contatore[x]=visiteMedico(medico).size();
		   System.out.println(medico.toStringNomeCognome());
		   System.out.println("Visite assegnate: "+contatore[x]);
		   x++;
		   
		   }
	   }
 

}	



