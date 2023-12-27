package s3t3e1.GardenShop.application.service;

import java.io.FileWriter;
import java.io.IOException;

import s3t3e1.GardenShop.application.port.in.CreateGardenShop;
import s3t3e1.GardenShop.application.port.out.GardenShopRepository;
import s3t3e1.GardenShop.application.utilities.Input_sc;
import s3t3e1.GardenShop.domain.GardenShop;

public class CreateGardenShopService implements CreateGardenShop {

	private final GardenShopRepository repository;
	private String filePath = "GardenShop.txt";
	
	public CreateGardenShopService(GardenShopRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void createGardenShop(String name) {
		
		GardenShop gardenShop = new GardenShop(name);
		
//		try (FileWriter writer = new FileWriter(filePath, true)) {
//			writer.write("Garden Shop: " +  name + "\n");
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
		
		repository.save(gardenShop);
	}
	
	
}
