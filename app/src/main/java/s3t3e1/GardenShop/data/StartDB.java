package s3t3e1.GardenShop.data;

import java.util.List;

import s3t3e1.GardenShop.domain.Decoration;
import s3t3e1.GardenShop.domain.Flower;
import s3t3e1.GardenShop.domain.GardenShop;
import s3t3e1.GardenShop.domain.Product;
import s3t3e1.GardenShop.domain.TcktProdLine;
import s3t3e1.GardenShop.domain.Ticket;
import s3t3e1.GardenShop.domain.Tree;
import s3t3e1.GardenShop.domain.enums.Colours;
import s3t3e1.GardenShop.domain.enums.ProductType;

public class StartDB {

	public static void loadData(List<GardenShop> shops) {
		
		GardenShop gardenSh = new GardenShop("Sunshine Garden");
		
		Product prod1 = new Tree(ProductType.TREE, 52.35d, "Oak", 30);
		gardenSh.setGardenProducts(prod1, 2);
		
		gardenSh.setGardenProducts(new Tree(ProductType.TREE, 12.5d, "Pine", 12), 1);
		gardenSh.setGardenProducts(new Tree(ProductType.TREE, 35.0d, "Maple", 22), 2);
		gardenSh.setGardenProducts(new Flower(ProductType.FLOWER, 43.4d, "Rose", Colours.RED), 17);
		gardenSh.setGardenProducts(new Flower(ProductType.FLOWER, 22.5d, "Tulip", Colours.YELLOW), 10);
		gardenSh.setGardenProducts(new Decoration(ProductType.DECORATION, 9.75d, "Pot", true), 4);
		gardenSh.setGardenProducts(new Decoration(ProductType.DECORATION, 130.95d, "Mini sculpture", false), 3);
		
		TcktProdLine tcktProdLine1 = new TcktProdLine(1, prod1);
		Ticket ticket1 = new Ticket("Sunshine Garden", tcktProdLine1);
	}
	
	
	
}
