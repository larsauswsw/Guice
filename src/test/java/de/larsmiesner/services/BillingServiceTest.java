package de.larsmiesner.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;

import de.larsmiesner.objects.CreditCard;
import de.larsmiesner.Status;
import de.larsmiesner.objects.Order;
import de.larsmiesner.objects.OrderElement;
import de.larsmiesner.objects.Recipt;
import de.larsmiesner.services.BillingService;

public class BillingServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSuccessfullOrder(){
		Order testOrder = setupOrder();
		CreditCard testCard = new CreditCard();
		testCard.setNumber("5493365801128630");
		testCard.setCvc(999);
		
		
		BillingService t = new BillingService();
		Recipt recipt = t.chargeOrder(testCard, testOrder);
		
		assertNotNull(recipt);
		assertEquals(Status.SUCCESS, recipt.getStatus());
		
	}
	
	@Test
	public void testOrderWithWrongCreditCardNumber(){
		Order testOrder = setupOrder();
		CreditCard testCard = new CreditCard();
		testCard.setNumber("XXXXXXX");
		testCard.setCvc(987);
		
		BillingService t = new BillingService();
		Recipt recipt = t.chargeOrder(testCard, testOrder);
		
		assertNotNull(recipt);
		assertEquals(Status.ERROR, recipt.getStatus());
		
	}
	
	@Test
	public void testOrderWithWrongCreditCardNumberCVC(){
		Order testOrder = setupOrder();
		CreditCard testCard = new CreditCard();
		testCard.setNumber("XXXXXXX");
		testCard.setCvc(0);
		
		BillingService t = new BillingService();
		Recipt recipt = t.chargeOrder(testCard, testOrder);
		
		assertNotNull(recipt);
		assertEquals(Status.ERROR, recipt.getStatus());
		
	}
	
	@Test
	public void testOrderWithNoCreditCardNumberAndWrongCVC(){
		Order testOrder = setupOrder();
		CreditCard testCard = new CreditCard();
		testCard.setCvc(0);
		
		BillingService t = new BillingService();
		Recipt recipt = t.chargeOrder(testCard, testOrder);
		
		assertNotNull(recipt);
		assertEquals(Status.ERROR, recipt.getStatus());
		
	}
	
	@Test
	public void testOrderWithNoCreditCardNumberAndWrongCVC2(){
		Order testOrder = setupOrder();
		CreditCard testCard = new CreditCard();
		testCard.setNumber("5493365801128630");
		testCard.setCvc(1000);
		
		BillingService t = new BillingService();
		Recipt recipt = t.chargeOrder(testCard, testOrder);
		
		assertNotNull(recipt);
		assertEquals(Status.ERROR, recipt.getStatus());
		
	}
	
	@Test
	public void testOrderWithWrongCreditCardNumberAndWorngCVC(){
		Order testOrder = setupOrder();
		CreditCard testCard = new CreditCard();
		testCard.setNumber("5493365801128630");
		testCard.setCvc(0);
		
		BillingService t = new BillingService();
		Recipt recipt = t.chargeOrder(testCard, testOrder);
		
		assertNotNull(recipt);
		assertEquals(Status.ERROR, recipt.getStatus());
		
	}

	private Order setupOrder() {
		Order testOrder = new Order();
		OrderElement pizza = new OrderElement();
		pizza.setPrice(7.5);
		pizza.setProductName("Pizza 4 Jahreszeiten");
		OrderElement noodles = new OrderElement();
		noodles.setPrice(6.5);
		noodles.setProductName("Penne Spinat");
		testOrder.addOrderElement(noodles);
		testOrder.addOrderElement(pizza);
		return testOrder;
	} 
	
	// Mocking
	// BillingService t = mock(BillingService.class);
	// when(t.chargeOrder(testCard, testOrder)).thenReturn(new Recipt());

}
