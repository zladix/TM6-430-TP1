/* * ATM Example system - file EnvelopeAcceptor.java * * copyright (c) 2001 - Russell C. Bjork * */ package edu.gordon.atm;import edu.gordon.simulation.Simulation;/** Manager for the ATM's envelope acceptor.  In a real ATM, this would  *  manage a physical device; in this edu.gordon.simulation,  it uses classes  *  in package edu.gordon.simulation to simulate the device. */ public class EnvelopeAcceptor{    /** Constructor     *     *  @param log the log in which to record receiving an envelope     */    public EnvelopeAcceptor(Log log)    {        this.log = log;    }        /** Accept an envelope from customer.     *     *  @exception CustomerConsole.Cancelled if operation timed out or the     *             customer cancelled it     */    public void acceptEnvelope() throws CustomerConsole.Cancelled    {        boolean inserted = Simulation.getInstance().acceptEnvelope();        if (inserted)            log.logEnvelopeAccepted();        else            throw new CustomerConsole.Cancelled();    }        /** Log in which to record receiving an envelope     */    private Log log;}