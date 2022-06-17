package OrderingApp;

import java.io.Serializable;
import java.time.LocalDate;

//model
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String category;
	private int orderCost;
	private LocalDate dateOfOrder;
	private String action;
	
	
	//.......................... constructors ..........................
	
	
	public Order() {}
	
	public Order(String username, String category, int orderCost, LocalDate dateOfOrder, String action) {
		super();
		this.username = username;
		this.category = category;
		this.orderCost = orderCost;
		this.dateOfOrder = dateOfOrder;
		this.action = action;
	}
	
	
	//.......................... getters / setters ..........................

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(int orderCost) {
		this.orderCost = orderCost;
	}

	public LocalDate getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(LocalDate dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	
	//............................... toString() ...............................

	
	@Override
	public String toString() {
		return "\nOrder [username=" + username + ", category=" + category + ", orderCost=" + orderCost + ", dateOfOrder="
				+ dateOfOrder + ", action=" + action + "]\n";
	}
	
	
	//............................... hashCode() ...............................

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((dateOfOrder == null) ? 0 : dateOfOrder.hashCode());
		result = prime * result + orderCost;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	
	
	//................................ equals() ................................

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (dateOfOrder == null) {
			if (other.dateOfOrder != null)
				return false;
		} else if (!dateOfOrder.equals(other.dateOfOrder))
			return false;
		if (orderCost != other.orderCost)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}
