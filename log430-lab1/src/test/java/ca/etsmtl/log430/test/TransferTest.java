package ca.etsmtl.log430.test;
import static org.junit.Assert.*;
import org.junit.*;

import edu.gordon.atm.ATM;
import edu.gordon.atm.Session;
import edu.gordon.atm.physical.CustomerConsole;
import edu.gordon.atm.transaction.*;
import edu.gordon.banking.*;
import edu.gordon.simulation.SimulatedBank;
import edu.gordon.simulation.Simulation;

public class TransferTest {
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
	public void transferInvalidAccountName() {
		SimulatedBank simBank = new SimulatedBank();
	      myCard = new Card(0);
	      Message m = new Message(3, myCard, 42, 123, 0, 1, money);
	      balance.setBalances(new Money(100), new Money(100));
	      
	     Status status = simBank.handleMessage(m, balance);
	    
	     assertEquals(false,status.isSuccess());
	}
	
	@Test
	public void transferSameAccount() {
		SimulatedBank simBank = new SimulatedBank();
	      
	      Message m = new Message(3, myCard, 42, 123, 1, 1, money);
	      balance.setBalances(new Money(100), new Money(100));
	      
	     Status status = simBank.handleMessage(m, balance);
	    
	     assertEquals(false,status.isSuccess());
	}
	
	@Test
	public void transferBalanceInsufficient() {
		SimulatedBank simBank = new SimulatedBank();
	      
	      Message m = new Message(3, myCard, 42, 123, 1, 2, new Money(2000));
	      balance.setBalances(new Money(100), new Money(100));
	      
	     Status status = simBank.handleMessage(m, balance);
	    
	     assertEquals(false,status.isSuccess());
	}
	
	@Test
	public void transferSuccess() {
		SimulatedBank simBank = new SimulatedBank();
	      
	      Message m = new Message(3, myCard, 42, 123, 0, 1, money);
	      balance.setBalances(new Money(100), new Money(100));
	      
	     Status status = simBank.handleMessage(m, balance);
	     System.out.println(balance.getTotal());
	    
	     assertEquals(true,status.isSuccess());	
	     assertTrue(new Money(1020).toString().equals(balance.getTotal().toString()));
	}

}
