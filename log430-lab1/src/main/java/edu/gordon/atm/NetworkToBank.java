package edu.gordon.atm;

import edu.gordon.banking.Balances;
import edu.gordon.banking.Message;
import edu.gordon.banking.Status;

public interface NetworkToBank {

	 public void openConnection();
	 
	 public void closeConnection();
	 

	    /** Send a message to bank
	     *
	     *  @param message the message to send
	     *  @param balances (out) balances in customer's account as reported
	     *         by bank
	     *  @return status code returned by bank
	     */
	  public Status sendMessage(Message message, Balances balances);
}
