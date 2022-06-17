package OrderingApp;

import java.util.List;
import java.util.Map;

public interface IOrderService {
	
	public List<Order> getAllOrdersByCategory(String category)throws InvalidCategryException;
	public int getTotalOrderCost(String category)throws InvalidCategryException;
	public List<Order> getAllCanceledOrder();
	public Map<String, List<Order>> createOrderMapByUser();
	public List<Order> filterOrders(String action); 
	public List<Order> getOrdersBasedOnOrderValue();
	public boolean generatePDFReports(); 

	
}
