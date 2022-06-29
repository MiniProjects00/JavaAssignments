package model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Account")
public class Account {
	
	
	@Id
	private int accountId;

	
	private String accountType;
	
	
	@Embedded
	 @AttributeOverrides({
         @AttributeOverride(name = "insuranceId", column = @Column(name = "medicalInsuranceId")),
         @AttributeOverride(name = "insuredPerson", column = @Column(name = "medicalInsuredPerson")),
         @AttributeOverride(name = "paymentType", column = @Column(name = "medicalPaymentType")),
         @AttributeOverride(name = "insuredAmount", column = @Column(name = "medicalInsuredAmount"))
	 })
	private Insurance medicalInsurance;
	
	
	
	@Embedded
	 @AttributeOverrides({
        @AttributeOverride(name = "insuranceId", column = @Column(name = "carInsuranceId")),
        @AttributeOverride(name = "insuredPerson", column = @Column(name = "carInsuredPerson")),
        @AttributeOverride(name = "paymentType", column = @Column(name = "carPaymentType")),
        @AttributeOverride(name = "insuredAmount", column = @Column(name = "carInsuredAmount"))
	 })
	private Insurance carInsurance;

	
	
	@Embedded
	 @AttributeOverrides({
        @AttributeOverride(name = "insuranceId", column = @Column(name = "healthInsuranceId")),
        @AttributeOverride(name = "insuredPerson", column = @Column(name = "healthInsuredPerson")),
        @AttributeOverride(name = "paymentType", column = @Column(name = "healthPaymentType")),
        @AttributeOverride(name = "insuredAmount", column = @Column(name = "healthInsuredAmount"))
	 })
	private Insurance healthInsurance;

	
	@ElementCollection
	List<Transactions> allTransactions;

	
	//................................... Constructor ...................................
	
	
	public Account() {
		super();
	}

	public Account(int accountId, String accountType, Insurance medicalInsurance, Insurance carInsurance,
			Insurance healthInsurance, List<Transactions> allTransactions) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.medicalInsurance = medicalInsurance;
		this.carInsurance = carInsurance;
		this.healthInsurance = healthInsurance;
		this.allTransactions = allTransactions;
	}

	
	//................................. Getter / Setter .................................


	public int getAccountId() {
		return accountId;
	}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Insurance getMedicalInsurance() {
		return medicalInsurance;
	}


	public void setMedicalInsurance(Insurance medicalInsurance) {
		this.medicalInsurance = medicalInsurance;
	}


	public Insurance getCarInsurance() {
		return carInsurance;
	}


	public void setCarInsurance(Insurance carInsurance) {
		this.carInsurance = carInsurance;
	}

	
	public Insurance getHealthInsurance() {
		return healthInsurance;
	}

	
	public void setHealthInsurance(Insurance healthInsurance) {
		this.healthInsurance = healthInsurance;
	}


	public List<Transactions> getAllTransactions() {
		return allTransactions;
	}


	public void setAllTransaction(List<Transactions> allTransactions) {
		this.allTransactions = allTransactions;
	}

	
	//................................... toString() ...................................

	
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountType=" + accountType + ", medicalInsurance=" 
				+ medicalInsurance + ", carInsurance=" + carInsurance + ", healthInsurance="
				+ healthInsurance + ", allTransactions=" + allTransactions + "]";
	}
	
}
