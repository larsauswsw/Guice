package de.larsmiesner.objects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCard {

	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getCvc() {
		return cvc;
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
