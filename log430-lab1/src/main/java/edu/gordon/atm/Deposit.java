/* * ATM Example system - file Deposit.java    * * copyright (c) 2001 - Russell C. Bjork * */ package edu.gordon.atm;import edu.gordon.banking.AccountInformation;import edu.gordon.banking.Card;import edu.gordon.banking.Message;import edu.gordon.banking.Money;import edu.gordon.banking.Receipt;import edu.gordon.banking.Status;/** Representation for a deposit transaction */public class Deposit extends Transaction{    /** Constructor     *     *  @param edu.gordon.atm the ATM used to communicate with customer     *  @param session the session in which the transaction is being performed     *  @param card the customer's card     *  @param pin the PIN entered by the customer     */    public Deposit(ATM atm, Session session, Card card, int pin)    {        super(atm, session, card, pin);    }        /** Get specifics for the transaction from the customer     *     *  @return message to bank for initiating this transaction     *  @exception CustomerConsole.Cancelled if customer cancelled this transaction     */    protected Message getSpecificsFromCustomer() throws sCustomerConsole.Cancelled    {        to = atm.getCustomerConsole().readMenuChoice(            "Account to deposit to",            AccountInformation.ACCOUNT_NAMES);        amount = atm.getCustomerConsole().readAmount("Amount to deposit");                return new Message(Message.INITIATE_DEPOSIT,                           card, pin, serialNumber, -1, to, amount);    }        /** Complete an approved transaction     *     *  @return receipt to be printed for this transaction     *  @exception CustomerConsole.Cancelled if customer cancelled or      *             transaction timed out     */    protected Receipt completeTransaction() throws sCustomerConsole.Cancelled    {        atm.getEnvelopeAcceptor().acceptEnvelope();        Status status = atm.getNetworkToBank().sendMessage(            new Message(Message.COMPLETE_DEPOSIT,                        card, pin, serialNumber, -1, to, amount),             balances);                    return new Receipt(this.atm.getID(),this.atm.getBankName(),this.atm.getPlace(), this.card, this.getSerialNumber(), this.balances) {            {                detailsPortion = new String[2];                detailsPortion[0] = "DEPOSIT TO: " +                                     AccountInformation.ACCOUNT_ABBREVIATIONS[to];                detailsPortion[1] = "AMOUNT: " + amount.toString();            }        };    }        /** Account to deposit to     */     private int to;        /** Amount of money to deposit     */    private Money amount;            }