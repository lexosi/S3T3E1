package s3t3e1.GardenShop.application.service;

import s3t3e1.GardenShop.application.port.in.RemoveProduct;
import s3t3e1.GardenShop.application.port.out.ProductRepository;
import s3t3e1.GardenShop.domain.Product;
import s3t3e1.GardenShop.domain.enums.ProductType;
import s3t3e1.GardenShop.infrastructure.adapter.repository.TxtGardenShopRepository;

public class RemoveProductService implements RemoveProduct {

	private final ProductRepository repository;
	private String filePath = "GardenShop.txt";
	
	public RemoveProductService(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public void removeProduct(Product product) {
		
		String prod = product.toString();
		
		
		repository.removeProduct(product);	
	}

}
