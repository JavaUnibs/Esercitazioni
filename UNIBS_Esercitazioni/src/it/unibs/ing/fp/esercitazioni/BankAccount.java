package it.unibs.ing.fp.esercitazioni;

public class BankAccount {
	
	private final static double DEFAULT_BALANCE = 0.0; 
	
	private String owner;
	private double balance;
	
	public BankAccount(String _owner)
	{
		balance = DEFAULT_BALANCE;
		
    }
	
	public BankAccount (String _owner, double _balance)
	{
		owner = _owner;
		balance = _balance;
	}
	
	public void deposit (double conto)
	{
		balance += conto;
	}

	public double withdraw (double conto)
	{
		if ( balance < conto ) return 0;
		else return (balance -= conto);
		
	}
	
	
}
		
		
		
	