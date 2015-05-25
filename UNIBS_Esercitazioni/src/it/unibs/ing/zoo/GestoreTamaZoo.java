import it.unibs.ing.myutility.*;

public class GestoreTamaZoo {

	// QUI SERVIRANNO UN PO' DI COSTANTI DI VARIO TIPO

	private static final String messaggio = "Inserire il numero di Tamagotchi da creare";
	private static final String messaggio1 = "Inserire nome Tamagotchi";

	public static String nome = null;
	public static double felicita, sazieta;

	public static final double MAX_FELICITA = 100, MIN_FELICITA = 0,
			MAX_SAZIETA = 100, MIN_SAZIETA = 0;
	public static final int MIN_SCELTA = 1, MAX_SCELTA = 3;
	public static final double FELICITA_GORDO = 100, FELICITA_TRISTE = 10;

	// DEFINIRE UN ATTRIBUTO static DI TIPO TamaZoo

	public static void main(String[] args) 
	{
	
		int numeroTamagotchi = LeggiInput.intero(messaggio); // richiedere il numero all'utente
		
		TamaZoo tamazoo = new TamaZoo(); 
		
		for (int i =1; i<=numeroTamagotchi; i++)
		{
			// creare ad ogni iterazione un nuovo Tamagotchi (usando l'apposito metodo)
			nome = LeggiInput.stringa(messaggio);
			
			int scelta = RandomValues.ranIntLimite(MIN_SCELTA, MAX_SCELTA);
			
			switch(scelta){
			//Tamabase
			case 1: { felicita = RandomValues.ranDouble(MIN_FELICITA, MAX_FELICITA);
					sazieta = RandomValues.ranDouble(MIN_SAZIETA, MAX_SAZIETA);
					Tamagotchi tamag = new Tamagotchi(nome, felicita, sazieta);
					tamazoo.inserisci(tamag);
					
			}break;
			
			//Tamagordo
			case 2: {
					felicita = FELICITA_GORDO;
					sazieta = RandomValues.ranDouble(MIN_SAZIETA, MAX_SAZIETA);
					Tamagotchi tamag = new TamaGordo(nome, felicita, sazieta );
					tamazoo.add(tamag);
					
			}break;
			
			//Tamatriste
			case 3: {
						felicita = FELICITA_TRISTE;
						sazieta = RandomValues.ranLimitiDouble(MIN_SAZIETA, MAX_SAZIETA);
						tamazoo.add(tamag);
			}
				
			}break;
			
			// e inserirlo nello zoo (usando l'apposito metodo della classe TamaZoo)
		}
		
		MyMenu principale= // creare un menu con le scelte a disposizione dell'utente
		
    boolean fine = false;
		
		do 
		{
		 int voceSelezionata = principale.scegli();
			
	     switch ( voceSelezionata ) 
	      {
			   // i casi da gestire sono la somministrazione 
				 // di biscotti e carezze. In entrambi i casi si estrae un numero casuale e 
				 // si invoca l'apposito metodo per la somministrazione nella classe TamaZoo
					
			   case 0:
				   fine = true;
				 break;
			    default:
				   // MESSAGGIO DI ERRORE
				 break;
			}//switch
		 
	     
	     // controllare se nello zoo c'e' almeno un Tamagotchi vivo
			// in caso contrario bisogna terminare il programma
	     
		} while ( !fine );
		 
		

	}

	public static Tamagotchi creaTamagotchi()
	{
		String nome = // chiedere il nome all'utente
		int affetto = // estrarre a caso il valore iniziale di affetto 
		int sazieta = // estrarre a caso il valore iniziale di sazieta'
		// restituire un nuovo Tamagotchi
	}
}
