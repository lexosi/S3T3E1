package s3t3e1.GardenShop.domain;

import java.util.HashMap;

import s3t3e1.GardenShop.domain.enums.ProductType;

public class GardenShop {

	private static String name;
	private ProductType prodType;
	private HashMap<ProductType, Product> gardenStock;
	
	public GardenShop(String name) {
		this.name = name;
		this.gardenStock = new HashMap<ProductType, Product>();
	}
	
	public static String getName() {
		return name;
	}
	public ProductType getProdType() {
		return prodType;
	}
	public HashMap<ProductType, Product> getGardenStock(){
		return gardenStock;
	}
	
}
