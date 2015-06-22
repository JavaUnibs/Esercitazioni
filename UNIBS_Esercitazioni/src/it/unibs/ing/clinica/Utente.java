package it.unibs.ing.clinica;
import it.unibs.ing.myutility.*;

public class Utente {

	public String nome, cognome, dataNascita, luogoNascita, sesso, codiceFiscale, numTelefono;
	
	
	Utente(String _nome, String _cognome, String _dataNascita, String _luogoNascita, String _sesso, String _numTelefono, String _codiceFiscale) {
		nome=_nome;
		cognome=_cognome;
		dataNascita=_dataNascita;
		luogoNascita=_luogoNascita;
		sesso=_sesso;
		numTelefono=_numTelefono;
		while(!verificaCodice(_codiceFiscale)) {
		_codiceFiscale=LeggiInput.stringa("Codice Fiscale non valido, inserire quello corretto");
		}
		codiceFiscale=_codiceFiscale;
	}
	public void modificaDatiUtente(String campo, String input){
		campo.toLowerCase();
		switch (campo){
		case "nome": nome=input;
		break;
        case "cognome": cognome=input;
		break;
		case "data di nascita": dataNascita=input;
		break;
		case "luogo di nascita": luogoNascita=input;
		break;
		case "sesso": sesso=input;
		break;
		case "numero di telefono": numTelefono=input;
		break;
		case "codice fiscale": codiceFiscale=input;
		break;
		}
		}
	
	
	public static boolean verificaCodice(String codiceFiscale){
		if(codiceFiscale.length()==16){
			int i=0;
			String lettere=codiceFiscale.substring(0, 6)+codiceFiscale.substring(8, 9)+
			codiceFiscale.substring(8, 9)+codiceFiscale.substring(11, 12)+codiceFiscale.substring(15, 16);
			String cifre=codiceFiscale.substring(6, 8)+codiceFiscale.substring(9, 11)+codiceFiscale.substring(12, 15);
			lettere.toUpperCase();
			if(cifre.charAt(i)<48||codiceFiscale.charAt(i)>57) return false;
			if(lettere.charAt(i)<65||codiceFiscale.charAt(i)>90) return false;	
			return true;
			}
		else return false;
		
	}
	

}

  
