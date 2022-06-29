import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Account;
import model.Insurance;
import model.Transactions;


public class MyMain {

	
	public static void main(String[] args) {

		Session hibernate = HibernateUtils.getHibernateLink();
		Transaction t1 = hibernate.beginTransaction();
		
		
		//................................................. Create account ..................................................
		
		
		Insurance medicalInsurance_Kate = new Insurance(701, "Daughter", "credit", 20000);
		Insurance carInsurance_Kate = new Insurance(403, "Husband", "credit", 800);
		Insurance healthInsurance_Kate = new Insurance(288, "Kate", "cheque", 50000);
		
		
		Transactions medical2022 = new Transactions(1, "medical", 20000, "2020-12-28", true);
		Transactions car2022 = new Transactions(2, "car", 800, "2022-03-16", true);
		Transactions health2022 = new Transactions(3, "health", 50000, "2022-03-16", true);
				
		List<Transactions> allTransactions_kate = new ArrayList<Transactions>();
		allTransactions_kate.add(medical2022);
		allTransactions_kate.add(car2022);
		allTransactions_kate.add(health2022);

		
		Account kate = new Account(904, "Personal", medicalInsurance_Kate, carInsurance_Kate, healthInsurance_Kate, allTransactions_kate);
		hibernate.save(kate);		
		
		
		//............................................. Update health insurance .............................................

/*		
		Account retrievedAcc = (Account) hibernate.get(Account.class, 904);
		retrievedAcc.getHealthInsurance().setPaymentType("credit");
		
		
		//............................................. Update medical insurance ............................................
		
		
		retrievedAcc.getMedicalInsurance().setInsuredPerson("Brother");
		
		
		//.............................................. Update car insurance ..............................................
		
		
		retrievedAcc.getCarInsurance().setInsuredAmount(1000);
		
		
		//................................................. Add transactions ................................................

		
		Transactions trans = new Transactions(4, "car", 1000, "2022-08-11", false);
		retrievedAcc.getAllTransactions().add(trans);
		
		
		//............................................... View transactions .................................................
		
		
		List<Transactions> allTransactions = retrievedAcc.getAllTransactions();
		System.out.println(allTransactions);
		
*/		
		//................................................. Delete account ..................................................

/*		
		Account retrievedAcc = (Account) hibernate.get(Account.class, 904);
		hibernate.delete(retrievedAcc);
*/		
		
		t1.commit();
		
		hibernate.close();
		System.out.println("Hibernate session closed");
		System.exit(0);
	
	}
}
