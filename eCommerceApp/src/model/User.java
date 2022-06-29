package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dao.PopulateData;
import servlets.GetAllUsersServlet;

public class User implements Serializable, Comparable<User>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static GetAllUsersServlet getAllUSersServlet = new GetAllUsersServlet();
	
	private String username;
	private String password;
	private String securityQuestion;
	private String securityQuestionAnswer;
	private List<Product> purchasedProducts;
	
	//.......................................... Constructor ...................................
	
	public User() {}

	public User(String username, String password, String securityQuestion, String securityQuestionAnswer) {
		super();
		this.username = username;
		this.password = password;
		this.securityQuestion = securityQuestion;
		this.securityQuestionAnswer = securityQuestionAnswer;
		
		List<Product> listOfPurchasedProduct = new ArrayList<Product>();
		setPurchasedProducts(listOfPurchasedProduct);
	}
	
	public User(String username, String password, String securityQuestion,
			String securityQuestionAnswer, List<Product> purchasedProducts) {
		super();
		this.username = username;
		this.password = password;
		this.securityQuestion = securityQuestion;
		this.securityQuestionAnswer = securityQuestionAnswer;
		this.purchasedProducts = purchasedProducts;
	}

	//....................................... Getters / Setters .................................

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityQuestionAnswer() {
		return securityQuestionAnswer;
	}

	public void setSecurityQuestionAnswer(String securityQuestionAnswer) {
		this.securityQuestionAnswer = securityQuestionAnswer;
	}

	public List<Product> getPurchasedProducts() {
		return purchasedProducts;
	}

	public void setPurchasedProducts(List<Product> purchasedProducts) {
		this.purchasedProducts = purchasedProducts;
	}

	//.......................................... toString() ...................................

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", securityQuestion=" + securityQuestion
				+ ", securityQuestionAnswer=" + securityQuestionAnswer
				+ ", purchasedProducts=" + purchasedProducts + "]\n";
	}
	
	//.......................................... hashCode() ...................................


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime
				* result
				+ ((purchasedProducts == null) ? 0 : purchasedProducts
						.hashCode());
		result = prime
				* result
				+ ((securityQuestion == null) ? 0 : securityQuestion.hashCode());
		result = prime
				* result
				+ ((securityQuestionAnswer == null) ? 0
						: securityQuestionAnswer.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	//.......................................... equals() ...................................

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (purchasedProducts == null) {
			if (other.purchasedProducts != null)
				return false;
		} else if (!purchasedProducts.equals(other.purchasedProducts))
			return false;
		if (securityQuestion == null) {
			if (other.securityQuestion != null)
				return false;
		} else if (!securityQuestion.equals(other.securityQuestion))
			return false;
		if (securityQuestionAnswer == null) {
			if (other.securityQuestionAnswer != null)
				return false;
		} else if (!securityQuestionAnswer.equals(other.securityQuestionAnswer))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	//.......................................... compareTo() ...................................

	@Override
	public int compareTo(User u) {
		String u1 = this.getUsername();
		String u2 = u.getUsername();
		
		return u1.compareTo(u2);
	}
	
	//.......................................... addNewUser() ...................................
	
	public boolean addNewUser()	{
		System.out.println("User: Inside addUser()");
		
		User user = new User();
		user.username = this.username;
		user.password = this.password;
		user.securityQuestion = this.securityQuestion;
		user.securityQuestionAnswer = this.securityQuestionAnswer;
		user.purchasedProducts = null;
		
		boolean status = PopulateData.addNewUserToUserList(user);
		//System.out.println(this);
		return status;
	}
	
}




