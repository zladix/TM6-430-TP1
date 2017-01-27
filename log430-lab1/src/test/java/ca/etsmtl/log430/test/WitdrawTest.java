package ca.etsmtl.log430.test;
import static org.junit.Assert.*;
import org.junit.*;

import edu.gordon.atm.ATM;
import edu.gordon.atm.Session;
import edu.gordon.atm.physical.CustomerConsole;
import edu.gordon.atm.transaction.Deposit;
import edu.gordon.atm.transaction.Transaction;
import edu.gordon.atm.transaction.Transaction.CardRetained;
import edu.gordon.atm.transaction.Withdrawal;
import edu.gordon.banking.Balances;
import edu.gordon.banking.Card;
import edu.gordon.banking.Message;
import edu.gordon.banking.Money;
import edu.gordon.banking.Status;
import edu.gordon.simulation.SimulatedBank;
import edu.gordon.simulation.Simulation;

/**
 * Unit test for simple App.
 */
public class WitdrawTest {
		static ATM theATM;
	    static Card myCard;
	    static Money money;
	    static Balances balance;
	    
	    @BeforeClass
	    public static void initialise(){
	        theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
	                null /* We're not really talking to a bank! */);
	        myCard = new Card(1);
	        money = new Money(20);
	        balance = new Balances();
	    }
	    
	    @Test
	    public void depositTest() {
	      SimulatedBank simBank = new SimulatedBank();
	      
	      Message m = new Message(0, myCard, 42, 123, 1, -1, money);
	      balance.setBalances(new Money(100), new Money(100));
	      
	     Status status = simBank.handleMessage(m, balance);
	    
	     assertEquals(true,status.isSuccess());
	    }
	    
	    
	    
	    
}
