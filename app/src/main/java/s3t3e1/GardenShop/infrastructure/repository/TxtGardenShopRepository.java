package s3t3e1.GardenShop.infrastructure.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import s3t3e1.GardenShop.application.port.out.GardenShopRepository;
import s3t3e1.GardenShop.domain.GardenShop;

public class TxtGardenShopRepository implements GardenShopRepository {

	private String filePath = "GardenShop.txt";
	
	public TxtGardenShopRepository(String filePath) {
		this.filePath = filePath;
	}
	
	/* GARDEN SHOP REPOSITORY */
	@Override
	public GardenShop save(GardenShop gardenShop) {
		try (FileWriter writer = new FileWriter(filePath, true)) {
			writer.write(gardenShop.toString() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return gardenShop;
	}

	@Override
	public GardenShop findByName(List<GardenShop> shops, String name) {
		GardenShop shop = shops.stream()
				.filter(s -> s.getName().equals(name))
				.findFirst()
				.orElse(null);
		return shop.get();
	}

	@Override
	public void delete(GardenShop gardenShop) {
		List<GardenShop> inFileShops = new ArrayList<GardenShop>();
		File file = new File(filePath);
		
		// Read all shops into a list
		try(Scanner scanner = new Scanner(file)) {
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				GardenShop gs = convertLineToGardenShop(line);
				inFileShops.add(gs);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Remove the shop from the list
		inFileShops.removeIf(gs -> gs.getName().equalsIgnoreCase(gardenShop.getName()));
		
		// Clear the file
		try (PrintWriter writer = new PrintWriter(file)) {
			writer.print("");
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Write the remaining tickets back into the file
		try(FileWriter writer = new FileWriter(filePath, true)) {
			for(GardenShop gs : inFileShops) {
				writer.write(gs.toString() + "\n");
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private GardenShop convertLineToGardenShop(String line) {
		return null;
	}
	
	/*
	public void delete(List<GardenShop> shops, GardenShop gardenShop) {
		GardenShop shop = findByName(shops, gardenShop.getName());
		if (shop != null) {
			shops.remove(shop);
			System.out.println("The shop " + shop.getName() + " has been successfully removed from the database.");
		} else {
			System.out.println("This shop doesn't exist in our shops' database");
		}
	}
	*/
}
