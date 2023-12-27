package s3t3e1.GardenShop.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Ticket {

	private String gShName;
//	private(String/int?? LocalDateTime) ticketDate;
	private int ticketID;
	private static int ticketIDNext;
	private TcktProdLine tcktProdLine;
	List<TcktProdLine> prodLines  = new ArrayList<TcktProdLine>(); // save product lines in ticket
	private double totalAmount; // subtotal (sum of all products)
	private double totalSaleAmount;	// total ticket amount (with tax applied)
	
	// Old Tickets history
	List<Ticket> registeredSales = new ArrayList<Ticket>();  
	
	
	public Ticket(String gShName, TcktProdLine tcktProdLine) {
		this.gShName = gShName;
		this.ticketID = Ticket.ticketIDNext;
		Ticket.ticketIDNext++;
		this.tcktProdLine = tcktProdLine;
		this.totalAmount = 0;
		this.totalSaleAmount= 0;
	}
	
	public Ticket(String gShName, List<TcktProdLine> prodLines) {
		this.gShName = gShName;
		this.ticketID = Ticket.ticketIDNext;
		Ticket.ticketIDNext++;
		this.prodLines = prodLines;
		this.totalAmount = 0;
		this.totalSaleAmount= 0;
	}
	
	
	public String getGShName() {
		return this.gShName;
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
	public List<Ticket> getRegisteredSales(){
		return this.registeredSales;
	}
	
	
	public void setGShName(String gShName) {
		this.gShName = gShName;
	}
	public void setProdLines(TcktProdLine tcktProdLine) {
		this.prodLines.add(tcktProdLine);
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public void setTotalSaleAmount(double totalSaleAmount) {
		this.totalSaleAmount = totalSaleAmount;
	}
	public void setRegisteredSales(Ticket ticket) {
		this.registeredSales.add(ticket);
	}
	
	
	public void addProdToTicket(int prodQuantity, Product product) {
		TcktProdLine tcktProdLine = new TcktProdLine(prodQuantity, product);
		setProdLines(tcktProdLine);
		
		calculateTotalAmount();
	}
	
	public double calculateTotalAmount() {
		double subtotal = 0;
		subtotal = prodLines.stream().mapToDouble(TcktProdLine::getPriceXunit).sum();
		setTotalAmount(subtotal);
		
		calculateTotalAmountWTax();
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
		return  "Shop name: " + this.gShName + "\n"
				+ "Sale num: " + this.ticketID + "\n"
				+ "Quantity\tDescription\tPrice/Unit\tTotal\n"
				+ this.prodLines + "\n"
				+ "Subtotal:\t\t\t" + this.calculateTotalAmount() + "€\n"
				+ "Total price(with 21% tax)\t" + this.calculateTotalAmountWTax() + "€";
	}
}
