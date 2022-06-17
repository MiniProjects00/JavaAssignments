package OrderingApp;

import java.io.FileNotFoundException;
import java.util.*;


public class MyMain {
	
	static List<Order> listOfAllOrders = new ArrayList<Order>();
	static ImplementService implClass = new ImplementService();
	static Scanner in = new Scanner(System.in);
	static Scanner inStr = new Scanner(System.in);
	
	
	public static void main(String[] args)	{
		
		MyMain myMain = new MyMain();
		
		while(true) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println(".......... Menu ............");
			System.out.println();
			System.out.println("1. Get all orders by category");
			System.out.println("2. Get total orders cost");
			System.out.println("3. Get all cancelled orders");
			System.out.println("4. Create orders mapped by user");
			System.out.println("5. Filter orders based on action");
			System.out.println("6. Get orders based on order value");
			System.out.println("7. Generate PDF report");
			System.out.println("0. Exit");
			System.out.println();
			System.out.println("............................");
			System.out.println();
			System.out.println();
			System.out.println("Enter an option:");
			int choice = in.nextInt();
			System.out.println();
			System.out.println();
			
			switch(choice)	{
				
				case 1: myMain.executeGetAllOrdersByCategory();
						break;
				
				case 2: myMain.executeGetTotalOrderCost();
						break;
				
				case 3: myMain.executeGetAllCanceledOrder();
						break;
						
				case 4: myMain.executeCreateOrderMapByUser();
						break;	
				
				case 5: myMain.executeFilterOrders();
						break;	
				
				case 6: myMain.executeGetOrdersBasedOnOrderValue();
						break;
						
				case 7: myMain.executeGeneratePDFReports();
						break;
						
				case 0: System.exit(0);
				
				default:	System.out.println("Please select an available option!");
				
			}//switch
		}//while
	} //main
		
		
		//..........................static: populateOrdersIntoList()..............................
	
	
	static	{
		
		try {
			listOfAllOrders = implClass.populateOrdersIntoList();
			System.out.println(listOfAllOrders);
		} 
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//..........................execute: getAllCanceledOrder()..............................

	
	public void executeGetAllCanceledOrder()	{
		
		List<Order> ordersCancelled = implClass.getAllCanceledOrder();
		System.out.println(ordersCancelled);			
	
	}

	
	//..........................execute: getOrdersBasedOnOrderValue()..............................
	
	
	public void executeGetOrdersBasedOnOrderValue()	{

		List<Order> orderedByValue = implClass.getOrdersBasedOnOrderValue();
		System.out.println(orderedByValue);

	}
	
	
	//..........................execute: getAllOrdersByCategory()..............................
	
	
	public void executeGetAllOrdersByCategory()	{

		System.out.println("Enter a category:");
		String queryCategory = inStr.nextLine();
		
		try {
			List<Order> ordersBasedOnCategory = implClass.getAllOrdersByCategory(queryCategory);
			System.out.println(ordersBasedOnCategory);
		} 
		
		catch (InvalidCategryException e) {
			e.printStackTrace();
		}
		
	}	
	
	
	//..........................execute: getTotalOrderCost()..............................
	
	
	public void executeGetTotalOrderCost()	{

		System.out.println("Enter a category:");
		String queryCategory = inStr.nextLine();
		
		try {
			int totalCost = implClass.getTotalOrderCost(queryCategory);
			System.out.println(totalCost);
		} 
		
		catch (InvalidCategryException e) {
			e.printStackTrace();
		}
		
	}	
	
	
	//..........................execute: createOrderMapByUser()..............................

	
	public void executeCreateOrderMapByUser()	{

		Map<String, List<Order>> orderUserMapping = implClass.createOrderMapByUser();
		System.out.println(orderUserMapping);

	}
	
	
	//..........................execute: filterOrders()..............................
	
	
	public void executeFilterOrders()	{

		System.out.println("Enter action:");
		String queryAction = inStr.nextLine();
		
		List<Order> ordersBasedOnAction = implClass.filterOrders(queryAction);
		System.out.println(ordersBasedOnAction);
		
	}
	
	
	//..........................execute: generatePDFReports()..............................

	
	public void executeGeneratePDFReports()	{

		boolean success = implClass.generatePDFReports();
		System.out.println("Success: " + success);

	}
	
}
