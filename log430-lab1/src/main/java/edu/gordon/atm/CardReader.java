package edu.gordon.atm;

import edu.gordon.banking.Card;

public interface CardReader {
	
	public Card readCard();
	
	public void ejectCard();
	
	public void retainCard();
	
}
