package model;

import java.io.Serializable;

public class Review implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rating;
	private String reviewDescription;
	
	//.................................. Constructor ..................................
	
	public Review() {}
	
	public Review(int rating, String reviewDescription) {
		super();
		this.rating = rating;
		this.reviewDescription = reviewDescription;
	}
	
	//.................................. Getters / Setters ..................................

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReviewDescription() {
		return reviewDescription;
	}

	public void setReviewDescription(String reviewDescription) {
		this.reviewDescription = reviewDescription;
	}
	
	//.................................. toString() ..................................

	@Override
	public String toString() {
		return "Review [rating=" + rating + ", reviewDescription="
				+ reviewDescription + "]";
	}
	
	//.................................. hashCode() ..................................

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rating;
		result = prime
				* result
				+ ((reviewDescription == null) ? 0 : reviewDescription
						.hashCode());
		return result;
	}
	
	//.................................. equals() ..................................

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (rating != other.rating)
			return false;
		if (reviewDescription == null) {
			if (other.reviewDescription != null)
				return false;
		} else if (!reviewDescription.equals(other.reviewDescription))
			return false;
		return true;
	}
	
	//.................................. addReview() ..................................

	public boolean addReview()	{
		return true;
	}
}
