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
import s3t3e1.GardenShop.infrastructure.cli.menu.AddProdStock;
import s3t3e1.GardenShop.infrastructure.cli.menu.MenuManagement;
import s3t3e1.GardenShop.infrastructure.cli.menu.RemoveProdStock;

public class Menu {
	
    static List<GardenShop> shops = new ArrayList<GardenShop>();
    GardenShop gardenShop;
	CreateGardenShopService service;
	GardenShopRepository repository;
//	TxtGardenShopRepository txtGardenRepo;
//	TxtTicketRepository txtTicketRepo;
	
	public Menu() {
//		gardenShop = new GardenShop("Bcn Garden");
		service = new CreateGardenShopService(repository);
//		txtGardenRepo = new TxtGardenShopRepository();
//		txtTicketRepo = new TxtTicketRepository();
	}
	  
	//menu
	public void startApp() {
		//service.createGardenShop(name);
		String name;
		if(shops.isEmpty()) {
			name = Input_sc.enterStr("Enter the name of your Garden Shop to start the app");
			gardenShop = new GardenShop(name);
			shops.add(gardenShop);
		}
		System.out.println("Welcome to the Garden Shop App Menu");
	}
	//menu 2nd screen
	public void start() {
		//service.createGardenShop(name);
		menuStart();
	}
	
	public void menuStart() {
		boolean quit = false;
		
		do {
			switch(showMenu()) {
			case 0 -> quit = true;
			case 1 -> AddProdStock.addProductToStock(gardenShop);
			case 2 -> RemoveProdStock.removeProductFromStock(gardenShop);
			case 3 -> MenuManagement.showAllStock(gardenShop);
			case 4 -> MenuManagement.showStockQuantities(gardenShop);
			case 5 -> MenuManagement.calculateTotalShopStockValue(gardenShop);
			case 6 -> CreateInvoice.createTicket();
			case 7 -> Ticket.showTicketHistory();
			case 8 -> MenuManagement.showTotalAmountFromSales(gardenShop);
			default -> System.out.println("Error! Please enter a number between 0 and 8");
			}
		} while(!quit);
	}
		
	
	public static byte showMenu() {
		byte option = Input_sc.enterByte("GARDEN SHOP APP MENU\n"
				+ "Choose one of the following options (enter its number)\n"
				+ "1. Add Tree, Flower or Decoration to the shop's stock\n"
				+ "2. Remove Tree, Flower or Decoration from the shop's stock\n"
				+ "3. Show the stock of all products\n"
				+ "4. Show stock quantities\n"
				+ "5. Show total value of the Garden shop\n"
				+ "6. Create sale's ticket with multiple objects\n"
				+ "7. Show old sale's tickets\n"
				+ "8. Show total amount made from sales\n"
				+ "0. Quit the app");
		return option;
	}
	
	

	
}
