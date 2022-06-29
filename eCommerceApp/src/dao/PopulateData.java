package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Product;
import model.Review;
import model.User;


public class PopulateData {

	public static Map<String, User> listOfUsers = new HashMap<String, User>();
	public static List<Product> listOfProducts = new ArrayList<Product>();
	
	static {
		
		//............................................. Populate review .............................................
		
		
		List<Review> listOfiPadReview = new ArrayList<Review>();
		Review iPadReview1 = new Review(4, "iPadReview 1");
		Review iPadReview2 = new Review(3, "iPadReview 2");
		listOfiPadReview.add(iPadReview1);
		listOfiPadReview.add(iPadReview2);
		
		
		List<Review> listOfSamsungTVReview = new ArrayList<Review>();
		Review samsungTVReview1 = new Review(4, "samsungTVReview 1");
		listOfSamsungTVReview.add(samsungTVReview1);
		
		
		//............................................. Populate product .............................................

		
		Product iPad = new Product(101, "Apple iPad", 800, "Capacity: 64GB, Camera: 12MP, Weight: 460g", listOfiPadReview);
		Product samsungTV = new Product(102, "Samsung TV", 3100, "4K TV", listOfSamsungTVReview);
		Product keyboard = new Product(103, "Logitech keyboard", 60, "Mechanical keys", null);
		
		listOfProducts.add(iPad);
		listOfProducts.add(samsungTV);
		listOfProducts.add(keyboard);
		
		
		//............................................. Populate users .............................................

		
		List<Product> fannyPurchase = new ArrayList<Product>();
		fannyPurchase.add(iPad);
		User fanny = new User("Fanny", "123", "Favourite color", "yellow", fannyPurchase);
		
		
		List<Product> andrewPurchase = new ArrayList<Product>();
		andrewPurchase.add(iPad);
		andrewPurchase.add(samsungTV);
		User andrew = new User("Andrew", "pwd456", "Pet name", "max", andrewPurchase);

		
		listOfUsers.put("Fanny", fanny);
		listOfUsers.put("Andrew", andrew);
		
	}
	
	
	//............................................. addNewUserToUserList() .............................................

	public static boolean addNewUserToUserList(User obj)	{
		listOfUsers.put(obj.getUsername(), obj);
		return true;
	}
		
	//............................................. retrieveUsers() .............................................

	public static Map<String, User> retrieveUsers()	{
		return listOfUsers;
	}
	
	//............................................. retrieveSingleUser() .............................................

	public static User retrieveSingleUser(String username)	{
		return listOfUsers.get(username);
	}

	//............................................. retrieveUsers() .............................................

	public static List<Product> retrieveProducts()	{
		return listOfProducts;
	}
	
	//............................................. retrieveSingleProduct() .............................................

	public static Product retrieveSingleProduct(int id)	{
		
		for(Product p: listOfProducts)	{
			if(p.getProductId() == id)	{
				return p;
			}
		}
		return null;
	}

	//............................................. retrieveReviewsUsingProductId() .............................................

	public static List<Review> retrieveReviewsUsingProductId(int id)	{
		
		for(Product p: listOfProducts)	{
			if(p.getProductId() == id)	{
				List<Review> reviewsFound = p.getListOfProductReview();
				return reviewsFound;
			}
		}
		return null;
	}
}
