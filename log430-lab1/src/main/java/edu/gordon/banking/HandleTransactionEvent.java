package edu.gordon.banking;

public class HandleTransactionEvent {
    public Balances balances;
    public Status status;
    public Message message;
    
   public HandleTransactionEvent(Balances b, Message m){
      this.balances = b;
      this.message = m;
      this.status = null;
   }
   
   
   /** Representation for status of a transaction that succeeded
    */
   private static class Success extends Status
   {
       public boolean isSuccess()
       {
           return true;
       }
       
       public boolean isInvalidPIN()
       {
           return false;
       }
       
       public String getMessage()
       {
           return null;
       }
   }
   
   /** Representation for status of a transaction that failed (for reason other than
    *  invalid PIN)
    */
   private static class Failure extends Status
   {
       /** Constructor
        *
        *  @param message description of the failure
        */
       public Failure(String message)
       {
           this.message = message;
       }
       
       public boolean isSuccess()
       {
           return false;
       }
       
       public boolean isInvalidPIN()
       {
           return false;
       }
       
       public String getMessage()
       {
           return message;
       }
       
       private String message;
   }

   

}
