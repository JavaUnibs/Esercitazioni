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
}
