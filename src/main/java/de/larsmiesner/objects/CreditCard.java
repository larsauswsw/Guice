package de.larsmiesner.objects;


public class CreditCard {

	private String number;

	public void setNumber(String number) {
		this.number = number;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

	private int cvc;

	public boolean isValid() {
		if (number != null && number.length() == 16 && cvc > 0 && cvc < 1000) {
			return true;

		}
		return false;
	}

}
