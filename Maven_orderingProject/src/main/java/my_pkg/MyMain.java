package my_pkg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyMain {

	public static void main(String[] args) {
		
		ApplicationContext spring = new ClassPathXmlApplicationContext("SpringConfig.xml");
		
		Order order = (Order)spring.getBean("order");
		
		int productPrice = order.getGrossOrderAmount();
		Payment paymentType = order.getModeOfPayment();
		int finalAmount = paymentType.doPayment(productPrice);
		
		order.setFinalOrderAmount(finalAmount);
		
		System.out.println(order);
		
		//Close "spring"
		ConfigurableApplicationContext cac = (ConfigurableApplicationContext) spring;
		cac.close();
		
	}
}
