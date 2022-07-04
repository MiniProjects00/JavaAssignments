package my_pkg;
import org.springframework.stereotype.Component;

@Component
public interface Payment {

	public int doPayment(int amount);
}
