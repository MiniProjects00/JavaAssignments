package model;

import javax.persistence.Embeddable;

@Embeddable
public class Insurance {
	
	
	private int insuranceId;
	private String insuredPerson;
	private String paymentType; //credit card, cheque
	private int insuredAmount;
	
	//................................... Constructor ...................................

	
	public Insurance() {
		super();
	}


	public Insurance(int insuranceId, String insuredPerson, String paymentType, int insuredAmount) {
		super();
		this.insuranceId = insuranceId;
		this.insuredPerson = insuredPerson;
		this.paymentType = paymentType;
		this.insuredAmount = insuredAmount;
	}

	
	//................................. Getter / Setter ..................................


	public int getInsuranceId() {
		return insuranceId;
	}


	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}


	public String getInsuredPerson() {
		return insuredPerson;
	}


	public void setInsuredPerson(String insuredPerson) {
		this.insuredPerson = insuredPerson;
	}


	public String getPaymentType() {
		return paymentType;
	}


	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}


	public int getInsuredAmount() {
		return insuredAmount;
	}


	public void setInsuredAmount(int insuredAmount) {
		this.insuredAmount = insuredAmount;
	}

	//................................... toString() ...................................

	@Override
	public String toString() {
		return "Insurance [insuranceId=" + insuranceId + ", insuredPerson=" + insuredPerson + ", paymentType="
				+ paymentType + ", insuredAmount=" + insuredAmount + "]";
	}

}
