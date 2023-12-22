package s3t3e1.GardenShop.application.port.out;

import s3t3e1.GardenShop.domain.GardenShop;

public interface GardenShopRepository {
	
    GardenShop save(GardenShop gardenShop);
    GardenShop findByName(String name);
    void delete(GardenShop gardenShop);
    
}
