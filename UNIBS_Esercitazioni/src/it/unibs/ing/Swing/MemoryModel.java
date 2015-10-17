package it.unibs.ing.Swing;

public class MemoryModel {
	private Double memory=null;
	
	public void setMemory(Double value){
		memory=value;
		
	}
	
	public Double getMemory(){
		return memory;
	}
	
	public void clearMemory(){
		memory=null;
	}
	
	public boolean isEmpty(){
		if (memory==null) return true;
		return false;
	}
	
	
	
	}

