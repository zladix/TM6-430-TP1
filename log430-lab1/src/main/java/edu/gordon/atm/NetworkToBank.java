package edu.gordon.atm;

import edu.gordon.banking.Balances;
import edu.gordon.banking.Message;
import edu.gordon.banking.Status;

public interface NetworkToBank {

	 public void openConnection();
	 
	  public void closeConnection();
	   
	  public Status sendMessage(Message message, Balances balances);
	  
}
