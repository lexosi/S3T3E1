package s3t3e1.GardenShop.application.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import s3t3e1.GardenShop.application.port.in.AddProduct;
import s3t3e1.GardenShop.domain.GardenShop;
import s3t3e1.GardenShop.domain.Product;
import s3t3e1.GardenShop.domain.enums.ProductType;
import s3t3e1.GardenShop.infrastructure.adapter.repository.TxtGardenShopRepository;

public class AddProductService implements AddProduct {

	private final TxtGardenShopRepository repository;
	private String filePath = "GardenShop.txt";

	public AddProductService(TxtGardenShopRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void addProduct(Product product) {

		String prod = product.toString();

		try (FileWriter writer = new FileWriter(filePath, true)){
			writer.write(prod.toString() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		repository.save(product); 
	}


}
