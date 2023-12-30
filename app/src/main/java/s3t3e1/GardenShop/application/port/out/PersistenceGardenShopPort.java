package s3t3e1.GardenShop.application.port.out;

import s3t3e1.GardenShop.domain.Product;

public interface PersistenceGardenShopPort {

    void addProduct(Product product);
}
