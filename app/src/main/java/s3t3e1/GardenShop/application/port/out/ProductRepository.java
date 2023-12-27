package s3t3e1.GardenShop.application.port.out;

import s3t3e1.GardenShop.domain.GardenShop;
import s3t3e1.GardenShop.domain.Product;

public interface ProductRepository {
	
	Product save(Product product);
	Product findProdById(GardenShop gardenShop, int prodId);
	void delete(GardenShop gardenShop, int prodId, int quantity);
}
