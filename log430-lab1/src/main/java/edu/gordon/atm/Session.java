/* * ATM Example system - file Session.java * * copyright (c) 2001 - Russell C. Bjork * */ package edu.gordon.atm;import edu.gordon.banking.Card;/** Representation for one ATM session serving a single customer. */public class Session{    /** Constructor     *     *  @param edu.gordon.atm the ATM on which the session is performed     */    public Session(ATM atm)    {        this.atm = atm;                state = READING_CARD_STATE;    }    /** Perform the Session Use Case     */    public void performSession()    {        Card card = null;        Transaction currentTransaction = null;                while (state != FINAL_STATE)        {            switch(state)            {                case READING_CARD_STATE:                                                    card = atm.getCardReader().readCard();                                        if (card != null)                        state = READING_PIN_STATE;                    else                    {                        atm.getCustomerConsole().display("Unable to read card");                        state = EJECTING_CARD_STATE;                    }                    break;                                    case READING_PIN_STATE:                                    try                    {                        pin = atm.getCustomerConsole().readPIN(                            "Please enter your PIN\n" +                            "Then press ENTER");                        state = CHOOSING_TRANSACTION_STATE;                    }                    catch(CustomerConsole.Cancelled e)                    {                        state = EJECTING_CARD_STATE;                    }                    break;                                case CHOOSING_TRANSACTION_STATE:                                    try                    {                        currentTransaction =                             Transaction.makeTransaction(atm, this, card, pin);                        state = PERFORMING_TRANSACTION_STATE;                    }                    catch(CustomerConsole.Cancelled e)                    {                        state = EJECTING_CARD_STATE;                    }                    break;                                    case PERFORMING_TRANSACTION_STATE:                                    try                    {                        boolean doAgain =                             currentTransaction.performTransaction();                        if (doAgain)                            state = CHOOSING_TRANSACTION_STATE;                        else                            state = EJECTING_CARD_STATE;                    }                    catch(Transaction.CardRetained e)                    {                        state = FINAL_STATE;                    }                    break;                                    case EJECTING_CARD_STATE:                                    atm.getCardReader().ejectCard();                    state = FINAL_STATE;                    break;            }        }    }        /** Change the pin recorded for the customer (if invalid pin extension     *  was performed by a transaction     *     *  @param pin the newly entered pin     */    public void setPIN(int pin)    {        this.pin = pin;    }        // Instance variables    /** The ATM on which the session is performed     */    private ATM atm;        /** The PIN entered (or re-entered) by the customer     */    private int pin;    /** The current state of the session     */    private int state;        // Possible values for state        /** Reading the customer's card     */    private static final int READING_CARD_STATE = 1;        /** Asking the customer to enter a PIN     */    private static final int READING_PIN_STATE = 2;        /** Asking the customer to choose a transaction type     */    private static final int CHOOSING_TRANSACTION_STATE = 3;        /** Peforming a transaction     */    private static final int PERFORMING_TRANSACTION_STATE = 4;        /** Ejecting the customer's card     */    private static final int EJECTING_CARD_STATE = 5;        /** Session finished     */    private static final int FINAL_STATE = 6;    }