package it.unibs.ing.clinica;
import java.io.Serializable;
import java.time.*;

public class Date implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static int MEZZORA=30;
	
/**
 * Restituisce in base al giorno della settimana della data scelta un indice numerico, da lunedì(0) a venerdì(5).
 * @param data la data scelta
 * @return     l'indice corrispondente 
 * @author Andrea Ferrari
 */
	public static int indiceGiorno (LocalDate data){
		return data.getDayOfWeek().getValue()-1;
	}
/**
 * Restituisce in base all'ora scelta un indice numerico, dalle 8:00(0) alle 17:30(19).
 * @param ora l'orario scelto
 * @return    l'indice corrispondente 
 * @author Andrea Ferrari
 */
	
	public static int indiceOra (LocalTime ora){
		int ore=ora.getHour()-8;
		int minuti= ora.getMinute();
		if (minuti==0) return ore*2;
		else return ore*2 + 1;	
	}
/**
 * Incrementa una data scelta di un tot di giorni.
 * @param data  la data scelta
 * @param incr  il numero di giorni da aggiungere
 * @return      la data risultante
 * @author Andrea Ferrari
 */
	public static LocalDate incrementoGiorno(LocalDate data, int incr){
		return data.plusDays(incr);
	}

/**
 * Incrementa un'ora scelta di un tot di mezz'ore.
 * @param ora  l'ora scelta
 * @param incr il numero di mezz'ore da aggiungere
 * @return     l'ora risultante
 * @author Andrea Ferrari
 */	
	public static LocalTime incrementoOra(LocalTime ora, int incr){
		return ora.plusMinutes(incr*MEZZORA);
	}
	
/**
 * Controlla che tra i due giorni inseriti vi sia un intervallo di massimo 6 giorni lavorativi. 
 * @param giornoInizio il giorno iniziale
 * @param giornoFine   il giorno finale
 * @return boolean
 * @author Ferro
 */
	public static boolean controlloIntervallo(LocalDate giornoInizio, LocalDate giornoFine){
	   int cont=0;
	   while(Date.incrementoGiorno(giornoInizio, cont).isBefore(giornoFine)||Date.incrementoGiorno(giornoInizio, cont).isEqual(giornoFine)){
		    if(incrementoGiorno(giornoInizio, cont).getDayOfWeek().getValue()==7) return false;
		    cont++;
	   }
	   return true;
   }
 /**
  * Controlla che in un array di giorni non vi sia domenica  
  * @param array l'array contenente i giorni
  * @return boolean
  * @author Ferro
  */
	public static boolean controlloElencoGiorni(LocalDate []array){
	   for(int i=0;i<array.length;i++){
		   if(array[i].getDayOfWeek().getValue()==7) return false;
	   }
	   return true;
   }
/**
 * Controlla che gli orari iniziale e finale siano corretti(min. 8:00 max. 17:30)   
 * @param ora1 l'orario iniziale
 * @param ora2 l'orario finale
 * @return boolean
 * @author Andrea Ferrari
 */
	public static boolean controlloOrari(LocalTime ora1, LocalTime ora2){
	   if(ora1.getMinute()!=0&ora1.getMinute()!=30) return false;
	   if(ora2.getMinute()!=0&ora2.getMinute()!=30) return false;
	   if(ora1.isBefore(LocalTime.of(8, 0))||ora2.isAfter(LocalTime.of(17, 30))) return false;
	   if(ora1.isAfter(ora2)||ora2.isBefore(ora1)) return false;
	   return true;
   }
}
