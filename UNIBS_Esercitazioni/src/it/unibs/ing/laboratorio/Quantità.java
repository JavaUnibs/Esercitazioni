package it.unibs.ing.laboratorio;

public class Quantità {
	
	private Ingrediente ingrediente;
	private int quantità;
	
	Quantità(Ingrediente _ingrediente, int _quantità){
		ingrediente=_ingrediente;
		quantità=_quantità;
	}
	
	public int calorieTot(){
		return quantità*ingrediente.getCalorie();
	}

}
