package de.larsmiesner.services;

import de.larsmiesner.Status;
import de.larsmiesner.objects.CreditCard;
import de.larsmiesner.objects.Order;
import de.larsmiesner.objects.Recipt;

public class BillingService {
	
	public Recipt chargeOrder (CreditCard card, Order order) {
		Recipt recipt = new Recipt();
		
		if (card.isValid()) {
			recipt.setStatus(Status.SUCCESS);
		} else {
			recipt.setStatus(Status.ERROR);
		}
		
		
		return recipt;
	}
	
	
	

}
