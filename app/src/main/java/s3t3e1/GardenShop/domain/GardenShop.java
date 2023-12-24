package s3t3e1.GardenShop.domain;

import java.util.*;

import s3t3e1.GardenShop.domain.enums.ProductType;

public class GardenShop {

	private int shopId;
	private static int shopIdNext;
	private String name;
	private ProductType prodType;
//	private List<Product> products;
	private HashMap<Product, Integer> gardenProducts;  // hashmap <products, integer>
	private double totalShopStockValue;  
	
	public GardenShop(String name) {
		this.shopId = GardenShop.shopIdNext;
		GardenShop.shopIdNext++;
		this.name = name;
//		this.products = new ArrayList<Product>();
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
//	public List<Product> getProducts(){
//		return products;
//	}
	public HashMap<Product, Integer> getGardenProducts() {
		return gardenProducts;
	}
	public double getTotalShopStockValue() {
		return totalShopStockValue;
	}
//	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setProductType(ProductType prodType) {
		this.prodType = prodType;
	}
//	public void setProducts(List<Product> products) {
//		this.products = products;
//	}
	public void setGardenProducts(Product product, int quantity) {
		this.gardenProducts.put(product, quantity);
	}
	public void setTotalShopStockValue(double totalShopStockValue) {
		this.totalShopStockValue = totalShopStockValue;
	}

	//Methods to get keys and values of the HashMap gardenProducts
		//Get keys (Product)
	public List<Product> findKeys() {
		Set<Product> findKeys = gardenProducts.keySet();
		List<Product> allStockProducts = new ArrayList<Product>();
		allStockProducts.addAll(findKeys);
		return allStockProducts;
	}
		//Get values (Quantity)
	public Collection<Integer> findValues() {
		Collection<Integer> findValues = gardenProducts.values();
		return findValues;
	}

	//methods
	public int getProductQuantity(Product product) {
		return this.gardenProducts.getOrDefault(product, 0);
	}
	public int getProductId(Product product) {
		return this.gardenProducts.get(product.getId());
	}

	@Override
	public String toString() {
		return "Shop: " + this.name + "with a value of " + this.totalShopStockValue + "€";
	}

	public GardenShop get() {
		return null;
	}

}
