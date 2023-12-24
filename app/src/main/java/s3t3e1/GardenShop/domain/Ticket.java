package s3t3e1.GardenShop.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Ticket {

	private int ticketID;
	private static int ticketIDNext;
	private double totalAmount;
	private double totalSaleAmount;
	List<Product> products;
	List<Ticket> registeredSales = new ArrayList<Ticket>(); // guardar id del ticket
//	private(String int?? LocalDateTime) ticketDate;
	HashMap<Integer, Product> ticketLines;	// guardar les linies per imprimir el ticket
	
	public Ticket(int ticketID, double totalAmount, double totalSaleAmount) {
		this.ticketID = Ticket.ticketIDNext;
		Ticket.ticketIDNext++;
		this.totalAmount = totalAmount;
		this.totalSaleAmount = totalSaleAmount;
		this.products = new ArrayList<Product>();
		this.ticketLines = new HashMap<Integer, Product>();
	}
	
	public int getTicketID() {
		return this.ticketID;
	}
	public double getTotalAmount() {
		return this.totalAmount;
	}
	public List<Product> getProducts() {
		return this.products;
	} 
	public List<Ticket> getRegisteredSales(){
		return this.registeredSales;
	}
	public void setTotalSaleAmount(double totalSaleAmount) {
		this.totalSaleAmount = totalSaleAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public void addProd(int prodQuantity, Product product) {
//		products.add(product.getName(), product.getPrice(), prodQuantity);
		ticketLines.put(prodQuantity, product);
//		setTotalAmount(calculateTotalAmount());
	}
	public double calculateTotalAmount() {
		double subtotal = 0;
		subtotal = products.stream().mapToDouble(Product::getPrice).sum();
		setTotalAmount(subtotal);
		return subtotal;
	}
	
	public double calculateTotalAmountWTax() {
		double subtotal = getTotalAmount();	
		double tax = 0.21d;
		double totalAmountWTax = 0;
		
		totalAmountWTax = subtotal + (subtotal * tax); 
		setTotalSaleAmount(totalAmountWTax);
		return totalAmountWTax;
	}
	public void showTicketHistory() {
		if(!registeredSales.isEmpty()) {
			System.out.println("Ticket history:");
			registeredSales.forEach(System.out::println);
		} else {
			System.out.println("There is no ticket in our database yet");
		}
		
	}
	@Override
	public String toString() {
		return  GardenShop.getName() + "\n"
				+ "Sale num: " + this.ticketID + "\n"
				+ "Quantity		Description\n"
				+ this.ticketLines + "\n"
				+ "Subtotal: " + this.calculateTotalAmount() + "€\n"
				+ "Total price(with 21% tax): " + this.calculateTotalAmountWTax() + "€";
	}
}
