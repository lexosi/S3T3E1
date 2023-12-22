package s3t3e1.GardenShop.domain;

import s3t3e1.GardenShop.domain.enums.ProductType;

public class Tree extends Product {
	
	private double height;
	
	public Tree(ProductType prodType, double price, String name, double height) {
		super(prodType, price, name);
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return (super.toString() +
				"\nHeight: " + height);
	}

}
