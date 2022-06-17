package OrderingApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;



public class ImplementService implements IOrderService {

	static List<Order> finalList = new ArrayList<Order>();
	
	
	//...............................populateOrdersIntoList()...................................
	

	public List<Order> populateOrdersIntoList() throws FileNotFoundException	{
		
		File file = new File("//Users//Min/Desktop//WkSpace//JavaExamples//Order.csv");

		Scanner in = new Scanner(file);
		
		String header = in .nextLine();
		
		while(in.hasNext())	{
			
			String data = in.next();
			String[] dataArr = data.split(",");
			
			Order order = new Order();
			
			order.setUsername(dataArr[0]);
			order.setCategory(dataArr[1]);
			
			int orderAmt = Integer.parseInt(dataArr[2]);
			order.setOrderCost(orderAmt);
			
			
			//... Format LocalDate
			
			String dateStr = dataArr[3];
			
			int indexOfFirstUnderscore = dateStr.indexOf("-");
			String subStr = (String) dateStr.subSequence(0, indexOfFirstUnderscore);
			if((subStr.length()) == 1)	{
				dateStr = "0" + dateStr;
			}
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
			LocalDate date = LocalDate.parse(dateStr, formatter);
			    
			order.setDateOfOrder(date);
			
			//... End format localDate
			
			order.setAction(dataArr[4]);
			
			finalList.add(order);
			
		}
		
		in.close();
		
		return finalList;
		
	}
	
	
	//...............................getAllOrdersByCategory()...................................
	
	
	//return the list of orders based on category (Order.csv)
	
	@Override
	public List<Order> getAllOrdersByCategory(String category) throws InvalidCategryException {

		List<Order> ordersByCategory = new ArrayList<Order>();
			
		for(Order order : finalList)	{
			String orderCategory = order.getCategory();
			
			if(orderCategory.equalsIgnoreCase(category))	{
				ordersByCategory.add(order);
			}
		}
		
		return ordersByCategory;
		
	}
	
	
	//...............................getTotalOrderCost()...................................

	
	//return the total value of the order based on category and action should be only delivered
	
	@Override
	public int getTotalOrderCost(String category) throws InvalidCategryException {
		
		int totalCost = 0;
		
		for(Order order : finalList)	{
			String orderCategory = order.getCategory();
			
			if(orderCategory.equalsIgnoreCase(category))	{
				String action = order.getAction();
				if(action.equals("delivered"))	{
					totalCost = totalCost + order.getOrderCost();
				}
			}
		}
		
		return totalCost;
		
	}
	
	
	//...............................getAllCanceledOrder()...................................
	
	
	//returns all the cancel orders.
	
	@Override
	public List<Order> getAllCanceledOrder() {
		
		List<Order> ordersCancelled = new ArrayList<Order>();
		
		for(Order order : finalList)	{
			String action = order.getAction();
			
			if(action.equals("cancelled"))	{
				ordersCancelled.add(order);
			}
		}
		return ordersCancelled;
		
	}
	
	
	//...............................createOrderMapByUser()...................................

	
	/* Business stake holders are interested to view orders based on category, so store order
	   in the form of Map , where key is username , value is List of orders */
	
	@Override
	public Map<String, List<Order>> createOrderMapByUser() {
		
		Map<String, List<Order>> orderUserMapping = new HashMap<>();
		
		for(Order order : finalList)	{
			String username = order.getUsername();
			
			//Mapping does not contain username
			if(!orderUserMapping.containsKey(username))	{
				List<Order> ordersPerUsername = new ArrayList<>();
				ordersPerUsername.add(order);
				orderUserMapping.put(username, ordersPerUsername);
			}
			
			else	{
				List<Order> ordersPerUsername = orderUserMapping.get(username);
				ordersPerUsername.add(order);
				orderUserMapping.put(username, ordersPerUsername);
			}
		}
		return orderUserMapping;
		
	}
	
	
	//...............................filterOrders()...................................

	
	//Filter order based on action.
	
	@Override
	public List<Order> filterOrders(String action) {

			
		List<Order> getOrdersByAction = new ArrayList<Order>();
		
		for(Order order : finalList)	{
			String orderAction = order.getAction();
			
			if(orderAction.equalsIgnoreCase(action))	{
				getOrdersByAction.add(order);
			}
		}
		
	return getOrdersByAction;
	
	}
	
	
	//...............................getOrdersBasedOnOrderValue()...................................

	
	//sort the orders based on order cost 
	
	@Override
	public List<Order> getOrdersBasedOnOrderValue() {

		List<Order> sortedBasedOnOrderCost = new ArrayList<Order>();
		
		sortedBasedOnOrderCost.addAll(finalList);
		
		Collections.sort(sortedBasedOnOrderCost, new Comparator<Order>() {

			@Override
			public int compare(Order o1, Order o2) {
				
				int orderCost1 = o1.getOrderCost();
				int orderCost2 = o2.getOrderCost();
				
				return orderCost1-orderCost2;
			}
		});

		return sortedBasedOnOrderCost;
		
	}
	
	//...............................generatePDFReports()...................................

	
	/* method will count the number of orders based on cash payment, online payment and
	   unpaid orders, delivered or cancelled */
	
	@Override
	public boolean generatePDFReports() {


		//No. of orders delivered
		List<Order> ordersDelivered =  filterOrders("delivered");
		int numOfOrdersDelivered = ordersDelivered.size();
		
		
		//No. of orders cancelled
		List<Order> orderscancelled =  filterOrders("cancelled");
		int numOfOrderscancelled = orderscancelled.size();		
		
		
		
		//https://pdfbox.apache.org/1.8/cookbook/documentcreation.html
		//https://www.tutorialkart.com/pdfbox/create-write-text-pdf-file-using-pdfbox/
		
		try {
			PDDocument doc = new PDDocument();
			PDPage page = new PDPage();
			doc.addPage(page);
			
			PDPageContentStream inputStream = new PDPageContentStream(doc, page);
			PDFont font = PDType1Font.TIMES_ROMAN;
			inputStream.beginText();
			inputStream.setFont(font, 14);
			inputStream.newLineAtOffset(50, 700);
			
			//set new line to be x units below current line
			inputStream.setLeading(18);
			
			//"data.showText" -> Doesn't allow "\n"
			inputStream.newLine();
			inputStream.showText("Orders Report");
			inputStream.newLine();
			inputStream.newLine();
			inputStream.showText("Orders delivered: " + numOfOrdersDelivered);
			inputStream.newLine();
			inputStream.showText("Orders cancelled: " + numOfOrderscancelled);
			inputStream.newLine();
			inputStream.endText();
			inputStream.close();
		
			doc.save("//Users//Min/Desktop//WkSpace//JavaExamples//pdfReport.pdf");
			return true;
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
		
	