package my_pkg;

import org.springframework.stereotype.Component;

@Component
public class CashOnDelivery implements Payment{


	@Override
	public int doPayment(int amount) {
		
		int deliveryFee = 5;
		return (amount + deliveryFee);
	}

	@Override
	public String toString() {
		return "CashOnDelivery";
	}
}
