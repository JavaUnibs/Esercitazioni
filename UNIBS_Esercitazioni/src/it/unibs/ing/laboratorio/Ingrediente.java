package it.unibs.ing.laboratorio;

public class Ingrediente {
	
	private String nome;
	private int calorie;
	
	Ingrediente(String _nome, int _calorie){
		nome=_nome;
		calorie=_calorie;
	}
	
	public String getNome(){
		return nome;
	}

	public int getCalorie(){
		return calorie;
	}
	
	public String toString(){
		return "Nome: "+nome+"/n"
				+"Calorie: "+calorie+"/n";
	}
}
