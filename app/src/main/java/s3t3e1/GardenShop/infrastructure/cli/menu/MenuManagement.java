package s3t3e1.GardenShop.infrastructure.cli.menu;

import java.util.*;

import s3t3e1.GardenShop.domain.GardenShop;
import s3t3e1.GardenShop.domain.Product;
import s3t3e1.GardenShop.domain.enums.ProductType;

public class MenuManagement {

	//Show the stock of all products
	public static void showAllStock(GardenShop gardenShop) {
		List<Product> allStockProducts = gardenShop.findKeys();

		List<Product> treeStock = allStockProducts.stream()
				.filter(p -> p.getProdType() == ProductType.TREE)
				.toList();

		List<Product> flowerStock = allStockProducts.stream()
				.filter(p -> p.getProdType() == ProductType.FLOWER)
				.toList();

		List<Product> decorationStock = allStockProducts.stream()
				.filter(p -> p.getProdType() == ProductType.DECORATION)
				.toList();

		System.out.println("Tree Stock: " + treeStock);
		System.out.println("Flower Stock: " + flowerStock);
		System.out.println("Decoration Stock: " + decorationStock);
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