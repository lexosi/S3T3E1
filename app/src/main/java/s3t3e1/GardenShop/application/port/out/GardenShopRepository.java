package s3t3e1.GardenShop.application.port.out;

import java.util.List;

import s3t3e1.GardenShop.domain.GardenShop;
import s3t3e1.GardenShop.domain.Product;

public interface GardenShopRepository {
	
    void addProduct(Product product);
    GardenShop save(GardenShop gardenShop);
    GardenShop findByName(List<GardenShop> shops, String name);
    void delete(GardenShop gardenShop);
//    void delete(List<GardenShop> shops, GardenShop gardenShop);
    
}
