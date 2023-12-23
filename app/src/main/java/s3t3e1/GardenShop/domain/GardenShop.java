package s3t3e1.GardenShop.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import s3t3e1.GardenShop.domain.enums.ProductType;

public class GardenShop {

	private int shopId;
	private static int shopIdNext;
	private String name;
	private ProductType prodType;
	private HashMap<Product, Integer> gardenProducts; 
	private double totalShopStockValue;
	
	public GardenShop(String name) {
		this.shopId = GardenShop.shopIdNext;
		GardenShop.shopIdNext++;
		this.name = name;
		this.gardenProducts = new HashMap<Product, Integer>();
	}
	
	public int shopId() {
		return shopId;
	}
	public String getName() {
		return name;
	}
	public ProductType getProdType() {
		return prodType;
	}
	public HashMap<Product, Integer> getGardenProducts() {
		return gardenProducts;
	}
	public double getTotalShopStockValue() {
		return totalShopStockValue;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	public void setProductType(ProductType prodType) {
		this.prodType = prodType;
	}
	public void setGardenProducts(Product product, int quantity) {
		this.gardenProducts.put(product, quantity);
	}
	public void setTotalShopStockValue(double totalShopStockValue) {
		this.totalShopStockValue = totalShopStockValue;
	}

	//methods
	public int getProductQuantity(Product product) {
		return this.gardenProducts.getOrDefault(product, 0);
	}
	
	public void calculateTotalShopStockValue(){
		double totalShopValue = 0;
		if(!gardenProducts.isEmpty()) {
			totalShopValue = gardenProducts.stream().mapToDouble(gardenProducts.getPrice()).sum();
			setTotalShopStockValue(totalShopValue);
		} else {
			System.out.println("The shop doesn't have a stock yet");
		}
	}

	@Override
	public String toString() {
		return "Shop: " + this.name + "with a value of " + this.totalShopStockValue + "€";
	}
	
}
