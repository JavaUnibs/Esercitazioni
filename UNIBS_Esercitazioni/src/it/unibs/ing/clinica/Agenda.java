package it.unibs.ing.clinica;
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
 * Confronta due classi Giorno e verifica se possiedono lo stesso medico e la stessa data.
 * @param giorno  il primo giorno da confrontare
 * @param giorno2 il secondo giorno da confrontare
 * @return        vero o falso
 * @author Andrea Ferrari
 */
	public boolean confrontaDisp(Giorno giorno, Giorno giorno2){
		if(giorno.medico==giorno2.medico&giorno.data.equals(giorno2.data)) return true;
		else return false;
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
		boolean valore=false;
		
		for(data1=Date.indiceGiorno(giornoIniziale);data1<=data2;data1++){
			for (ora1=Date.indiceOra(oraIniziale);ora1<=ora2;ora1++){
				Giorno temp=new Giorno(medico, Date.incrementoGiorno(giornoIniziale, cont));
				for(Giorno giorno: settimana[ora1][data1].giorni){
					if(!confrontaDisp(giorno, temp)) valore=true;
				}
				if(!valore) settimana[ora1][data1].aggiungiGiorno(temp);
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
		boolean valore=false;
		
		for(i=0;i<giorniVari.length;i++){
			data=Date.indiceGiorno(giorniVari[i]);
			for (ora1=Date.indiceOra(oraIniziale);ora1<=ora2;ora1++){
				Giorno temp= new Giorno(medico, giorniVari[i]);
				for(Giorno giorno: settimana[ora1][data].giorni){
					if(!confrontaDisp(giorno, temp)) valore=true;
				}
				if(!valore) settimana[ora1][data].aggiungiGiorno(temp);
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
		boolean valore=false;
		
		for (ora1=Date.indiceOra(oraIniziale);ora1<=ora2;ora1++){
			Giorno temp= new Giorno(medico, giorno);
			for(Giorno giorno2: settimana[ora1][Date.indiceGiorno(giorno)].giorni){
				if(!confrontaDisp(giorno2, temp)) valore=true;
			}
			if(!valore) settimana[ora1][Date.indiceGiorno(giorno)].aggiungiGiorno(temp);
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
					if(giorno.medico==medico) orari.add(LocalDateTime.of(giorno.data, settimana[j][i].ora));
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
			if(giorno.data.equals(data)) System.out.println(giorno.medico.toString());
		}
	}
/**
 * Restituisce la visita corrispondente	al medico, alla data e all'orario scelti.
 * @param medico il medico scelto
 * @param data il giorno scelto
 * @param ora  l'orario scelto
 * @return     la visita corrispondente
 * @author Andrea Ferrari
 */
   public Visita selezionaVisita(Medico medico, LocalDate data, LocalTime ora){
	   Visita nullo=null;
	   int i=Date.indiceGiorno(data), k=Date.indiceOra(ora);
	   for(Giorno giorno: settimana[k][i].giorni){
		   if(giorno.data.equals(data)&giorno.visita!=null) return giorno.visita;
	   }
	   return nullo;
   }
		
	
	
	}
	
	



		



