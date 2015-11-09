package it.unibs.pajc.lib.refle;

public class MySingleton {
	private static MySingleton instance;
	
	private MySingleton() {	}
	
	public static MySingleton getInstance() {
		if(instance == null)
			instance = new MySingleton();
		
		return instance;
	}
}

