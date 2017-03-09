package ca.etsmtl.log430.test;
import static org.junit.Assert.*;
import org.junit.*;

import edu.gordon.banking.Balances;
import edu.gordon.banking.Card;
import edu.gordon.banking.Message;
import edu.gordon.banking.Money;
import edu.gordon.banking.SimulatedBank;
import edu.gordon.banking.Status;

/**
 * Unit test for simple App.
 */
public class WitdrawTest {
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
	    public void witdrawTest() {
	      SimulatedBank simBank = new SimulatedBank();
	      
	      Message m = new Message(0, myCard, 42, 123, 1, -1, money);
	      balance.setBalances(new Money(0), new Money(0));
	      
	     Status status = simBank.handleMessage(m, balance);
	     
	     assertEquals(true,status.isSuccess());
	     assertTrue(new Money(980).toString().equals(balance.getTotal().toString()));
	    }
	    
	    @Test
	    public void witdrawNegativeBalance() {
	      SimulatedBank simBank = new SimulatedBank();
	      
	      Message m = new Message(0, myCard, 42, 123, 1, -1, new Money(1000000));
	      balance.setBalances(new Money(0), new Money(0));
	      
	     Status status = simBank.handleMessage(m, balance);
	    
	     assertEquals(false,status.isSuccess());
	    }
	    
	    @Test
	    public void witdrawInvalidCard(){
	        SimulatedBank simBank = new SimulatedBank();
		      
		      Message m = new Message(0, new Card(0), 42, 123, 1, -1, new Money(1000000));
		      balance.setBalances(new Money(0), new Money(0));
		      
		     Status status = simBank.handleMessage(m, balance);
		    
		     assertEquals(false,status.isSuccess());
	    	
	    }
	    
}
