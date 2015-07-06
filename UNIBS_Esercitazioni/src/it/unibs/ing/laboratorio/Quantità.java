package it.unibs.ing.laboratorio;

public class Quantit� {
	
	private Ingrediente ingrediente;
	private int quantit�;
	
	Quantit�(Ingrediente _ingrediente, int _quantit�){
		ingrediente=_ingrediente;
		quantit�=_quantit�;
	}
	
	public int calorieTot(){
		return quantit�*ingrediente.getCalorie();
	}

}
