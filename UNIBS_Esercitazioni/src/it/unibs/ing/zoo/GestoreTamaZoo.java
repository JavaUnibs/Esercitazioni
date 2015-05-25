public class GestoreTamaZoo 
{

	// QUI SERVIRANNO UN PO' DI COSTANTI DI VARIO TIPO	
	
	// DEFINIRE UN ATTRIBUTO static DI TIPO TamaZoo
	
		
	public static void main(String[] args) 
	{
	
		int numeroTamagotchi = // richiedere il numero all'utente
		
		for (int i =1; i<=numeroTamagotchi; i++)
		{
			// creare ad ogni iterazione un nuovo Tamagotchi (usando l'apposito metodo)
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

