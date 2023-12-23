package s3t3e1.GardenShop.application.service;

import s3t3e1.GardenShop.application.port.in.RemoveProduct;
import s3t3e1.GardenShop.domain.Product;
import s3t3e1.GardenShop.domain.enums.ProductType;
import s3t3e1.GardenShop.infrastructure.adapter.repository.TxtGardenShopRepository;

public class RemoveProductService implements RemoveProduct {

	private final TxtGardenShopRepository repository;
	 
	public RemoveProductService(TxtGardenShopRepository repository) {
		this.repository = repository;
	}

	@Override
	public void removeProduct(Product product) {
		
		
		
		repository.removeProduct(product);	
	}

}
