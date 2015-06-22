package clinica;
import java.util.*;
import java.time.*;

public class Slot {
	LocalTime ora;
	Slot(LocalTime _ora){
		ora=_ora;
	}

	ArrayList<Giorno> giorni = new ArrayList<Giorno>();
	
	public void aggiungiGiorno(Giorno giorno){
		giorni.add(giorno);
	}
}
