package edu.gordon.atm;

import edu.gordon.banking.Money;

public interface CashDispenser {
	
	public void setInitialCash(Money initialCash);
	
	 public boolean checkCashOnHand(Money amount);
	 
	 public void dispenseCash(Money amount);

}
