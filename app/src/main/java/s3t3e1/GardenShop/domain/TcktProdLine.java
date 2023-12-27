package s3t3e1.GardenShop.domain;

/* Attributes that we want to see in each product line in ticket. Saved in List<TcktProdLine> prodLines */

public class TcktProdLine {

	private int numLine;
	private static int numLineNext;
	private int prodQtyTicket;
	private String prodName;
	private double priceXunit;
	private double priceXprod;
	
	private Product product;
	
	public TcktProdLine(int prodQtyTicket, String prodName, double priceXunit, double priceXprod) {
		this.numLine = TcktProdLine.numLineNext;
		TcktProdLine.numLineNext++;
		this.prodQtyTicket = prodQtyTicket;
		this.prodName = prodName;
		this.priceXunit = priceXunit;
		this.priceXprod = priceXprod;
	}
	
	public TcktProdLine(int prodQtyTicket, Product product) {
		this.numLine = TcktProdLine.numLineNext;
		TcktProdLine.numLineNext++;
		this.prodQtyTicket = prodQtyTicket;
		this.product = product;
	}
	
	public int getNumLine() {
		return numLine;
	}
	public int getProdQtyTicket() {
		return prodQtyTicket;
	}
	public String getProdName() {
		return prodName;
	}
	public double getPriceXunit() {
		return priceXunit;
	}
	public double getPriceXprod() {
		return priceXprod;
	}
	
	
	public void setProdQtyTicket(int prodQtyTicket) {
		this.prodQtyTicket = prodQtyTicket;
	}
	public void setProdName(Product product) {
		this.prodName = product.getName();
	}
	public void setPriceXunit(Product product) {
		this.priceXunit = product.getPrice();
	}
	public void setPriceXprod(double priceXunit) {
		this.priceXprod = (this.priceXunit * this.prodQtyTicket);
	}
	
	
	@Override
	public String toString() {
		return String.format("Quantity %d Product %s Price/unit %.2f Total %.2f %n", this.prodQtyTicket, this.prodName, this.priceXunit, this.priceXprod);
//		return String.format("Quantity %d Product %s Price/unit %.2f Total %.2f %n", this.prodQtyTicket, this.product.getName(), this.product.getPrice(), (this.product.getPrice() * this.prodQtyTicket));
	}
}
