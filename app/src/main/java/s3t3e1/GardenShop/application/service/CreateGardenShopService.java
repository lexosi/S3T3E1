package s3t3e1.GardenShop.application.service;

import s3t3e1.GardenShop.application.port.in.CreateGardenShop;
import s3t3e1.GardenShop.application.port.out.GardenShopRepository;
import s3t3e1.GardenShop.application.utilities.Input_sc;
import s3t3e1.GardenShop.domain.GardenShop;

public class CreateGardenShopService implements CreateGardenShop {

private final GardenShopRepository repository;
	
	public CreateGardenShopService(GardenShopRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public GardenShop createGardenShop(String name) {
		GardenShop gardenShop;
		if(gardenShop.getName() == null || !gardenShop.getName().equalsIgnoreCase(name)) {
			String shopName = Input_sc.enterStr("Enter the name of the Garden Shop:");
			gardenShop = new GardenShop(shopName);
			repository.save(gardenShop);
			return gardenShop;
		} else {
				System.out.println("This Garden Shop it already exists");
			return null;
		}
		
	}
	
	
}
