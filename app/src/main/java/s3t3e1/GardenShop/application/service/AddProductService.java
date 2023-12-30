package s3t3e1.GardenShop.application.service;

import java.io.FileWriter;
import java.io.IOException;

import s3t3e1.GardenShop.application.port.in.AddProduct;
import s3t3e1.GardenShop.application.port.out.ProductRepository;
import s3t3e1.GardenShop.domain.Product;

public class AddProductService implements AddProduct {

	private final ProductRepository repository;
	private String filePath = "GardenShop.txt";

	public AddProductService(ProductRepository repository) {
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
