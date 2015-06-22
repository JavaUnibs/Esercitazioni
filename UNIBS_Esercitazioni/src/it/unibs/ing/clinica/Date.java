package it.unibs.ing.clinica;
import java.time.*;

public class Date {
	

	public static int indiceGiorno (LocalDate data){
		return data.getDayOfWeek().getValue()-1;
	}

	
	public static int indiceOra (LocalTime ora){
		int ore=ora.getHour()-8;
		int minuti= ora.getMinute();
		if (minuti==0) return ore*2;
		else return ore*2 + 1;	
	}
	
	public static LocalDate incrementoGiorno(LocalDate data, int incr){
		return data.plusDays(incr);
	}
	
	public static LocalTime incrementoOra(LocalTime ora, int incr){
		return ora.plusMinutes(incr*30);
	}
}
