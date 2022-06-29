package model;

import javax.persistence.Embeddable;

@Embeddable
public class Transactions {
	
	
	private int transactionsId;
	private String transactionsType;
	private int amount;
	private String date;
	private boolean status;
	
	
	//................................... Constructor ...................................

	
	public Transactions() {
		super();
	}

	
	public Transactions(int transactionsId, String transactionsType, int amount, String date, boolean status) {
		super();
		this.transactionsId = transactionsId;
		this.transactionsType = transactionsType;
		this.amount = amount;
		this.date = date;
		this.status = status;
	}

	
	//................................. Getter / Setter ..................................


	public int getTransactionsId() {
		return transactionsId;
	}


	public void setTransactionsId(int transactionsId) {
		this.transactionsId = transactionsId;
	}


	public String getTransactionsType() {
		return transactionsType;
	}


	public void setTransactionsType(String transactionsType) {
		this.transactionsType = transactionsType;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}

	
	//................................... toString() ...................................


	@Override
	public String toString() {
		return "Transactions [transactionsId=" + transactionsId + ", transactionsType=" + transactionsType + ", amount="
				+ amount + ", date=" + date + ", status=" + status + "]";
	}
	
}
