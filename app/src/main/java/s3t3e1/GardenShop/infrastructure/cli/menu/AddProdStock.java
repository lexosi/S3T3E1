package s3t3e1.GardenShop.infrastructure.cli.menu;

import s3t3e1.GardenShop.application.service.AddProductService;
import s3t3e1.GardenShop.application.utilities.Input_sc;
import s3t3e1.GardenShop.domain.Decoration;
import s3t3e1.GardenShop.domain.Flower;
import s3t3e1.GardenShop.domain.GardenShop;
import s3t3e1.GardenShop.domain.Product;
import s3t3e1.GardenShop.domain.Tree;
import s3t3e1.GardenShop.domain.enums.Colours;
import s3t3e1.GardenShop.domain.enums.ProductType;
import s3t3e1.GardenShop.infrastructure.adapter.repository.TxtGardenShopRepository;

public class AddProdStock {

	public static void addProductToStock(GardenShop gardenShop) {
		
		byte prodTypeOption;
		ProductType prodType;
		Product product;
		double price, height;
		String name, color;
		int quantity;
		Colours colour;
		boolean material; // Boolean - Materials material ??
		String mat;
		
		prodTypeOption = Input_sc.enterByte("Which type of product do you want to add to the shop:\n"
				+ "1. Tree\n"
				+ "2. Flower\n"
				+ "3. Decoration");
		price = Input_sc.enterDouble("Enter the price of the product:");
		name = Input_sc.enterStr("Enter the name of the product:");
		quantity = Input_sc.enterInt("Enter the quantity:");  
		
		switch(prodTypeOption) {
		case 1:
			prodType = ProductType.TREE;
			height = Input_sc.enterDouble("Enter tree's height:"); 
			
			product = new Tree(prodType, price, name, height);
			gardenShop.setGardenProducts(product);
			break;
		case 2:
			prodType = ProductType.FLOWER;
//			choseColour(do-while);
			color = Input_sc.enterStr("Enter the flower's colour\n"
					+ "(Red, Blue, Green, Pink, Yellow, Orange, Purple):");
			colour = Colours.valueOf(color.toUpperCase());
			
			product = new Flower(prodType, price, name, colour);
			gardenShop.setGardenProducts(product);
			break;
		case 3:
			prodType = ProductType.DECORATION;
//			choseMaterial();
			product = new Decoration(prodType, price, name, material);
			gardenShop.setGardenProducts(product);
		}
		TxtGardenShopRepository repository = new TxtGardenShopRepository();
		AddProductService addProductService = new AddProductService(repository);
		addProductService.addProduct(product);
//		TxtGardenShopRepository.addProduct(product);
	}
}
