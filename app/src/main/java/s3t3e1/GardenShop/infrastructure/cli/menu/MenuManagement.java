package s3t3e1.GardenShop.infrastructure.cli.menu;

import java.util.*;

import s3t3e1.GardenShop.domain.GardenShop;
import s3t3e1.GardenShop.domain.Product;
import s3t3e1.GardenShop.domain.enums.ProductType;

public class MenuManagement {

	//Show the stock of all products
	public static void showAllStock(GardenShop gardenShop) {
		Set<Product> allStockProducts = gardenShop.findKeys();
		List<Product> treeStock = new ArrayList<Product>();
		List<Product> flowerStock = new ArrayList<Product>();
		List<Product> decorationStock = new ArrayList<Product>();
		ProductType prodType;
		
		Iterator<Product> it = allStockProducts.iterator();
		while(it.hasNext()) {
			prodType = it.next().getProdType();
			if(prodType == ProductType.TREE) {
				treeStock.add(it.next());
			} else if(prodType == ProductType.FLOWER) {
				flowerStock.add(it.next());
			} else {
				decorationStock.add(it.next());
			}
		}
		
	}

	//Show stock quantities
	public static void showStockQuantities(GardenShop gardenShop) {
//		Collection<Integer> allStockQuantity = gardenShop.findValues();
		Map<Product, Integer> allStock = new HashMap<Product, Integer>();
		allStock = gardenShop.getGardenProducts();
		for(Map.Entry<Product, Integer> entry : allStock.entrySet()) {
			System.out.println("Product: " + entry.getKey() + "Quantity: " + entry.getValue());
		}
	}
	
	//Show total amount made from sales
	public static void showTotalAmountFromSales() {
		
	}
}