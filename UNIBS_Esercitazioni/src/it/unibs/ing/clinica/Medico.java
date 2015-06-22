package it.unibs.ing.clinica;

public class Medico extends Utente{
	
	public String tipo, areaCompetenza, codiceAlbo;
	
	Medico(String _nome, String _cognome, String _dataNascita, String _luogoNascita, String _sesso, String _numTelefono, String _codiceFiscale, String _codiceAlbo, String _tipo){
		super(_nome, _cognome, _dataNascita, _luogoNascita, _sesso, _numTelefono, _codiceFiscale);
		tipo=_tipo;
		codiceAlbo=_codiceAlbo;
	}
	
	Medico(String _nome, String _cognome, String _dataNascita, String _luogoNascita, String _sesso, String _numTelefono, String _codiceFiscale, String _codiceAlbo, String _tipo, String _areaCompetenza){
		super(_nome, _cognome, _dataNascita, _luogoNascita, _sesso, _numTelefono, _codiceFiscale);
		tipo=_tipo;
		codiceAlbo=_codiceAlbo;
		areaCompetenza=_areaCompetenza;
	}
	
	public void modificaDatiMedico(String campo, String input){
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
		case "codice albo": codiceAlbo=input;
		break;
		case "tipo": tipo=input;
		break;
		case "area di competenza": areaCompetenza=input;
		break;
		}
		}





}
