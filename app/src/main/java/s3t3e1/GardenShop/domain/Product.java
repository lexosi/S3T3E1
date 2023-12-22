package s3t3e1.GardenShop.domain;

import java.util.concurrent.atomic.AtomicInteger;

import s3t3e1.GardenShop.domain.enums.ProductType;



abstract class Product {
	
	private int id; 
	private ProductType prodType; // add prod type
	private double price;
	private String name;
	private static AtomicInteger ai = new AtomicInteger(0);
	
	public Product(ProductType prodType, double price, String name) {
		this.prodType = prodType;
		this.price = price;
		this.name = name;
		this.id = ai.incrementAndGet();
	}
	
	//getters & setters
	public int getId() {
		return id;
	}
	
	public ProductType getProdType() {
		return this.prodType;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return ("ID: " + id +
				"\nProduct Type: " + this.prodType +
				"\nName: " + this.name +
				"\nPrice" + this.price);
	}
	
	
	

}