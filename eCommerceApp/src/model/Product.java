package model;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable, Comparable<Product>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int productId;
	private String name;
	private int price;
	private String description;
	private List<Review> listOfProductReview;
	
	//............................... Constructor ...............................
	
	public Product() {}
	

	public Product(int productId, String name, int price, String description,
			List<Review> listOfProductReview) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.listOfProductReview = listOfProductReview;
	}


	//............................ Getters / Setters ............................

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Review> getListOfProductReview() {
		return listOfProductReview;
	}

	public void setListOfProductReview(List<Review> listOfProductReview) {
		this.listOfProductReview = listOfProductReview;
	}
	
	//............................... toString() ...............................

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name
				+ ", price=" + price + ", description=" + description
				+ listOfProductReview + "]";
	}
	
	
	//............................... compareTo ...............................

	@Override
	public int compareTo(Product obj) {
		return this.productId - obj.getProductId();
	}
	
	//............................... hashCode() ...............................

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime
				* result
				+ ((listOfProductReview == null) ? 0 : listOfProductReview
						.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		result = prime * result + productId;
		return result;
	}
	
	//............................... equals() ...............................

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (listOfProductReview == null) {
			if (other.listOfProductReview != null)
				return false;
		} else if (!listOfProductReview.equals(other.listOfProductReview))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		if (productId != other.productId)
			return false;
		return true;
	}
	
	//............................... addProduct() ...............................

	public boolean addProduct() {
		return true;
	}
}
