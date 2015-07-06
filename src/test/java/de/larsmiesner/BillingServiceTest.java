package de.larsmiesner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import de.larsmiesner.BillingService;
import de.larsmiesner.objects.CreditCard;
import de.larsmiesner.objects.Order;
import de.larsmiesner.objects.OrderElement;
import de.larsmiesner.objects.Recipt;

public class BillingServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSuccessfullOrder(){
		Order testOrder = new Order();
		OrderElement pizza = new OrderElement();
		pizza.setPrice(7.5);
		pizza.setProductName("Pizza 4 Jahreszeiten");
		OrderElement noodles = new OrderElement();
		noodles.setPrice(6.5);
		noodles.setProductName("Penne Spinat");
		
		testOrder.addOrderElement(pizza);
		testOrder.addOrderElement(noodles);
		
		CreditCard testCard = new CreditCard();
		
		BillingService t = new BillingService();
		Recipt recipt = t.chargeOrder(testCard, testOrder);
		
		assertNotNull(recipt);
		assertEquals(Status.SUCCESS, recipt.getStatus());
		
		
		
	} 

}
