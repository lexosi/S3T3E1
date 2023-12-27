package s3t3e1.GardenShop.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Ticket {

//	private(String int?? LocalDateTime) ticketDate;
	private int ticketID;
	private static int ticketIDNext;
	List<TcktProdLine> prodLines; // save product lines in ticket
	private double totalAmount;
	private double totalSaleAmount;
	List<Ticket> registeredSales = new ArrayList<Ticket>(); // guardar id del ticket
	
	List<Product> products;
	HashMap<Integer, Product> ticketLines;	// guardar les linies per imprimir el ticket
	
	
	public Ticket(double totalAmount, double totalSaleAmount) {
		this.ticketID = Ticket.ticketIDNext;
		Ticket.ticketIDNext++;
		this.totalAmount = totalAmount;
		this.totalSaleAmount = totalSaleAmount;
		this.products = new ArrayList<Product>();
		this.ticketLines = new HashMap<Integer, Product>();
		
		this.prodLines = new ArrayList<TcktProdLine>();
	}
	
	
	public int getTicketID() {
		return this.ticketID;
	}
	public List<TcktProdLine> getProdLines() {
		return this.prodLines;
	}
	public double getTotalAmount() {
		return this.totalAmount;
	}
	public double totalSaleAmount() {
		return this.totalSaleAmount;
	}
	public List<Product> getProducts() {
		return this.products;
	} 
	public List<Ticket> getRegisteredSales(){
		return this.registeredSales;
	}
	
	
	public void setProdLines(List<TcktProdLine> prodLines) {
		this.prodLines = prodLines;
	}
	public void setTotalSaleAmount(double totalSaleAmount) {
		this.totalSaleAmount = totalSaleAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public void setRegisteredSales(List<Ticket> registeredSales) {
		this.registeredSales = registeredSales;
	}
	
	
	public void addProd(int prodQuantity, Product product) {
//		products.add(product.getName(), product.getPrice(), prodQuantity);
		ticketLines.put(prodQuantity, product);
//		setTotalAmount(calculateTotalAmount());
	}
	public double calculateTotalAmount() {
		double subtotal = 0;
		subtotal = products.stream().mapToDouble(Product::getPrice).sum();
		subtotal = prodLines.stream().mapToDouble(TcktProdLine::getPriceXunit).sum();
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
