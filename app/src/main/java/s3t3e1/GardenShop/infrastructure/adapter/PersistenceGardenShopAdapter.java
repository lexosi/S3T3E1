package s3t3e1.GardenShop.infrastructure.adapter;

import s3t3e1.GardenShop.application.port.out.GardenShopRepository;
import s3t3e1.GardenShop.domain.Product;

public class PersistenceGardenShopAdapter implements s3t3e1.GardenShop.application.port.out.PersistenceGardenShopPort {

    private final GardenShopRepository GardenShoprepository;

    public PersistenceGardenShopAdapter(GardenShopRepository GardenShoprepository) {
        this.GardenShoprepository = GardenShoprepository;
    }

    @Override
    public void addProduct(Product product) {
        GardenShoprepository.addProduct(product);
    }

}
