package Event;

import com.google.common.eventbus.Subscribe;

import edu.gordon.atm.ATM;

public class ATMEventSubcriber {
		private ATM atm;
		
		public ATMEventSubcriber(ATM atm){
			this.atm = atm;
		}
		
	   @Subscribe
	    public void ATMEvent(CardInsertedEvent e) {
	    		atm.cardInserted();
	    }
	   
	   @Subscribe
	    public void ATMEvent(PowerOnEvent e) {
	    		atm.switchOn();
	    }
	   
	   @Subscribe
	    public void ATMEvent(PowerOffEvent e) {
				atm.switchOn();
	    }
	   
}
