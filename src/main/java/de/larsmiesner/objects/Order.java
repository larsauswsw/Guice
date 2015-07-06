package de.larsmiesner.objects;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private List<OrderElement> orderElements = new ArrayList<OrderElement>();

	public List<OrderElement> getOrderPositions() {
		return orderElements;
	}

	
	public void addOrderElement(OrderElement orderElement) {
		orderElements.add(orderElement);
	}
	

}
