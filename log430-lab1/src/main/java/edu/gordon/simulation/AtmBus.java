package edu.gordon.simulation;

import com.google.common.eventbus.EventBus;

public class AtmBus
{	
	private static AtmBus instance = null;
	public static EventBus atmBus = new EventBus();;
	/** Constructeur privé */
	private AtmBus()
	{
	}
 
	/** Point d'accès pour l'instance unique du singleton */
	public static AtmBus getInstance()
	{	return instance;
	}
}