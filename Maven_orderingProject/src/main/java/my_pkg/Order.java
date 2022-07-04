package my_pkg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Order {
	
	
	@Value("${order.productName}")
	private String productName;
	
	@Autowired
	@Qualifier(value="cashOnDelivery")
	private Payment modeOfPayment;
	
	@Value("${order.grossAmount}")
	private int grossOrderAmount;
	
	
	private int finalOrderAmount;
	
	public Order() {
		super();
	}

	public Order(String productName, Payment modeOfPayment, int grossOrderAmount, int finalOrderAmount) {
		super();
		this.productName = productName;
		this.modeOfPayment = modeOfPayment;
		this.grossOrderAmount = grossOrderAmount;
		this.finalOrderAmount = finalOrderAmount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Payment getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(Payment modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public int getGrossOrderAmount() {
		return grossOrderAmount;
	}

	public void setGrossOrderAmount(int grossOrderAmount) {
		this.grossOrderAmount = grossOrderAmount;
	}

	public int getFinalOrderAmount() {
		return finalOrderAmount;
	}

	public void setFinalOrderAmount(int finalOrderAmount) {
		this.finalOrderAmount = finalOrderAmount;
	}

	@Override
	public String toString() {
		return "Order [productName=" + productName + ", modeOfPayment=" + modeOfPayment + ", grossOrderAmount="
				+ grossOrderAmount + ", finalOrderAmount=" + finalOrderAmount + "]";
	}
	
}
