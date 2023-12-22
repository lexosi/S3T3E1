package s3t3e1.GardenShop.infrastructure.cli;

import java.util.ArrayList;
import java.util.List;

import s3t3e1.GardenShop.application.port.out.GardenShopRepository;
import s3t3e1.GardenShop.application.service.CreateGardenShopService;
import s3t3e1.GardenShop.application.utilities.Input_sc;
import s3t3e1.GardenShop.domain.Decoration;
import s3t3e1.GardenShop.domain.Flower;
import s3t3e1.GardenShop.domain.GardenShop;
import s3t3e1.GardenShop.domain.Product;
import s3t3e1.GardenShop.domain.Tree;
import s3t3e1.GardenShop.domain.enums.Colours;
import s3t3e1.GardenShop.domain.enums.ProductType;
import s3t3e1.GardenShop.infrastructure.adapter.repository.TxtGardenShopRepository;

public class Menu {
    static List<GardenShop> shops = new ArrayList<GardenShop>();
//	static List<Product> shopProducts = new ArrayList<Product>();
	
	GardenShop gardenShop;
	CreateGardenShopService service;
	GardenShopRepository repository;
//	TxtGardenShopRepository txtGardenRepo;
//	TxtTicketRepository txtTicketRepo;
	
	public Menu() {
		gardenShop = new GardenShop("Bcn Garden");
		service = new CreateGardenShopService(repository);
//		txtGardenRepo = new TxtGardenShopRepository();
//		txtTicketRepo = new TxtTicketRepository();
	}
	
	//menu
	public void start() {
		menuStart();
	}
	
	public void menuStart() {
		boolean quit = false;
		do {
			switch(showMenu()) {
			case 0 -> quit = true;
			case 1 -> service.createGardenShop(name);
			case 2 -> addProductToStock();
//			case 2 -> TxtGardenShopRepository.addProduct(prodType);
//			case 3 -> ;
			case 4 -> TxtGardenShopRepository.removeProduct(prodType);
//			case 5 -> ;
			case 6 -> gardenShop.calculateTotalShopStockValue();
//			case 7 -> ;
//			case 8 -> ;
//			case 9 -> ;
			default -> System.out.println("Error! Please enter a number between 0 and 9");
			}
		} while(!quit);
	}
		
	
	public static int showMenu() {
		byte option = Input_sc.enterByte("GARDEN SHOP APP MENU\n"
				+ "Choose one of the following options (enter its number)\n"
				+ "1. Create new Garden Shop\n"
				+ "2. Add Tree, Flower or Decoration to the shop's stock\n"
				+ "3. Show the stock of all products\n"
				+ "4. Remove Tree, Flower or Decoration from the shop's stock\n"
				+ "5. Show stock quantities\n"
				+ "6. Show total value of the Garden shop\n"
				+ "7. Create sale's tickets with multiple objects\n"
				+ "8. Show old sale tickets\n"
				+ "9. Show total amount made from sales\n"
				+ "0. Quit the app");
		return option;
	}
	
	public void addProductToStock() {
		
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
			choseColour(do-while);
			color = Input_sc.enterStr("Enter the flower's colour\n"
					+ "(Red, Blue, Green, Pink, Yellow, Orange, Purple):");
			colour = Colours.valueOf(color.toUpperCase());
			
			product = new Flower(prodType, price, name, colour);
			gardenShop.setGardenProducts(product);
			break;
		case 3:
			prodType = ProductType.DECORATION;
			choseMaterial();
			product = new Decoration(prodType, price, name, material);
			gardenShop.setGardenProducts(product);
		}
		
		TxtGardenShopRepository.addProduct(product);
	}

}
