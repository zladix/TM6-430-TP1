package ca.etsmtl.log430.test;
import static org.junit.Assert.*;
import org.junit.*;

import edu.gordon.atm.physical.ATM;
import edu.gordon.banking.Balances;
import edu.gordon.banking.Card;
import edu.gordon.banking.Message;
import edu.gordon.banking.Money;
import edu.gordon.banking.Status;
import edu.gordon.simulation.SimulatedBank;

/**
 * Unit test for simple App.
 */
public class DepositTest {
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
	    public void depositTest() {
	      SimulatedBank simBank = new SimulatedBank();
	      
	      Message m = new Message(1, myCard, 42, 123, -1, 1, money);
	      balance.setBalances(new Money(0), new Money(0));
	      
	     Status status = simBank.handleMessage(m, balance);
	     
	     assertEquals(true,status.isSuccess());
	    }
	  
	    @Test
	    public void depositInvalidCard(){
	        SimulatedBank simBank = new SimulatedBank();
		      
		      Message m = new Message(1, new Card(0), 42, 123, -1, 1, money);
		      balance.setBalances(new Money(0), new Money(0));
		      
		     Status status = simBank.handleMessage(m, balance);
		    
		     assertEquals(false,status.isSuccess());
	  }
	    
	    
	    @Test
	    public void completeDepositTest() {
	      SimulatedBank simBank = new SimulatedBank();
	      
	      Message m = new Message(2, myCard, 42, 123, -1, 1, money);
	      balance.setBalances(new Money(0), new Money(0));
	      
	     Status status = simBank.handleMessage(m, balance);
	     
	     assertTrue(new Money(1020).toString().equals(balance.getTotal().toString()));
	     assertEquals(true,status.isSuccess());
	    }
	    
	    
	    @Test
	    public void completeDepositInvalidCardTest(){
	        SimulatedBank simBank = new SimulatedBank();
		      
		      Message m = new Message(2, new Card(0), 42, 123, -1, 1, money);
		      balance.setBalances(new Money(0), new Money(0));
		      
		     Status status = simBank.handleMessage(m, balance);
		    
		     assertEquals(false,status.isSuccess());
	  }
	    
	    
	    
}
