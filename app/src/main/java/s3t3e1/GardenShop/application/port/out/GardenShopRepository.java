package s3t3e1.GardenShop.application.port.out;

import java.util.List;

import s3t3e1.GardenShop.domain.GardenShop;

public interface GardenShopRepository {
	
    GardenShop save(GardenShop gardenShop);
    GardenShop findByName(List<GardenShop> shops, String name);
    void delete(List<GardenShop> shops, GardenShop gardenShop);
    
}
