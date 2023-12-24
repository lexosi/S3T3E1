package s3t3e1.GardenShop.infrastructure.cli.menu;

import java.util.*;

import s3t3e1.GardenShop.domain.GardenShop;
import s3t3e1.GardenShop.domain.Product;
import s3t3e1.GardenShop.domain.enums.ProductType;

public class MenuManagement {

	//Show the stock of all products
	public static void showAllStock(GardenShop gardenShop) {
//		Set<Product> allStockProducts = gardenShop.findKeys();
//		List<Product> treeStock = new ArrayList<Product>();
//		List<Product> flowerStock = new ArrayList<Product>();
//		List<Product> decorationStock = new ArrayList<Product>();
		ProductType prodType;
		
		// Print all products with mixed prodType
		gardenShop.findKeys().forEach(System.out::println);
//		products -> prodType 
		gardenShop.findKeys().stream()
			.forEach(p-> p.getProdType()); // 
		
		List<Product> sortedStock = new ArrayList<Product>();
		gardenShop.findKeys().stream()		
			.forEach(p -> p.getProdType().TREE);
		List<Product>allStockProducts = gardenShop.getProducts();
		(prodType)
		
//		public GardenShop findByName(List<GardenShop> shops, String name) {
//			GardenShop shop = shops.stream()
//					.filter(s -> s.getName().equals(name))
//					.findFirst()
//					.orElse(null);
//			return shop.get();
////		}
		
//		Iterator<Product> it = allStockProducts.iterator();
//		while(it.hasNext()) {
//			prodType = it.next().getProdType();
//			if(prodType == ProductType.TREE) {
//				treeStock.add(it.next());
//			} else if(prodType == ProductType.FLOWER) {
//				flowerStock.add(it.next());
//			} else {
//				decorationStock.add(it.next());
//			}
		//		}

	}

	//Show stock quantities
	public static void showStockQuantities(GardenShop gardenShop) {
		Map<Product, Integer> allStock = new HashMap<Product, Integer>();
		allStock = gardenShop.getGardenProducts();
		for(Map.Entry<Product, Integer> entry : allStock.entrySet()) {
			System.out.println("Product: " + entry.getKey() + "Quantity: " + entry.getValue());
		}
	}

	// Calculate Total Shop Stock value / Show total value of the Garden shop
	public static void calculateTotalShopStockValue(GardenShop gardenShop){
		double totalShopValue = 0;

		if(!gardenShop.getGardenProducts().isEmpty()) {
			totalShopValue = gardenShop.findKeys().stream().mapToDouble(Product::getPrice).sum();
			gardenShop.setTotalShopStockValue(totalShopValue);
			System.out.println("The total stock value of the shop is " + totalShopValue + "€");
		} else {
			System.out.println("The shop doesn't have a stock yet");
		}
	}
	//Show total amount made from sales
	public static void showTotalAmountFromSales(GardenShop gardenShop) {
		double totalAmountSales = 0;
		totalAmountSales = gardenShop.findKeys().stream().mapToDouble(Product::getPrice).sum();

		System.out.println("The Total Amount of the " + gardenShop.getName() + " is " + totalAmountSales + "€");
	}

}