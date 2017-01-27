package ca.etsmtl.log430.test;
import static org.junit.Assert.*;
import org.junit.*;

import edu.gordon.atm.ATM;
import edu.gordon.banking.Balances;
import edu.gordon.banking.Card;
import edu.gordon.banking.Message;
import edu.gordon.banking.Money;
import edu.gordon.banking.Status;
import edu.gordon.simulation.SimulatedBank;

/**
 * Unit test for simple App.
 */
public class InquiryTest {
	    static Card myCard;
	    static Money money;
	    static Balances balance;
	    
	    @BeforeClass
	    public static void initialise(){
	        myCard = new Card(1);
	        money = new Money(20);
	        balance = new Balances();
	    }
	    
	    @Test
	    public void inquiryTest() {
	      SimulatedBank simBank = new SimulatedBank();
	      
	      Message m = new Message(4, myCard, 42, 123, 1, 2, null);
	      balance.setBalances(new Money(0), new Money(0));
	      
	     Status status = simBank.handleMessage(m, balance);
	    
	     assertEquals(true,status.isSuccess());
	    }
	  
	    @Test
	    public void depositInvalidCard(){
	        SimulatedBank simBank = new SimulatedBank();
		      
		      Message m = new Message(1, new Card(0), 42, 123, 1, 2, null);
		      balance.setBalances(new Money(0), new Money(0));
		      
		     Status status = simBank.handleMessage(m, balance);
		    
		     assertEquals(false,status.isSuccess());
	  }
	    
}
