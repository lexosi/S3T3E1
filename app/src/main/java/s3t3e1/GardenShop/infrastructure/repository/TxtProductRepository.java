package s3t3e1.GardenShop.infrastructure.repository;

import java.io.FileWriter;
import java.io.IOException;

import s3t3e1.GardenShop.application.port.out.ProductRepository;
import s3t3e1.GardenShop.domain.GardenShop;
import s3t3e1.GardenShop.domain.Product;

public class TxtProductRepository implements ProductRepository {

	private String filePath = "data/GardenShopProducts.txt";
	
	public TxtProductRepository(String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public Product save(Product product) {
		try (FileWriter writer = new FileWriter(filePath, true)) {
			writer.write(product.toString() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public Product findProdById(GardenShop gardenShop, int prodId) {
		Product product = gardenShop.findKeys().stream()
				.filter(p -> p.getId() == prodId)
				.findFirst()
				.orElse(null);

		return product;
	}

	@Override
	public void delete(GardenShop gardenShop, int prodId, int quantity) {
		
		
	}

	/* PRODUCT REPOSITORY (shop stock) 
	@Override
	public Product save(Product product) {
		try (FileWriter writer = new FileWriter(filePath, true)) {
			writer.write(product.toString() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public Product findProdById(GardenShop gardenShop, int prodId) {
		Product product = gardenShop.findKeys().stream()
				.filter(p -> p.getId() == prodId)
				.findFirst()
				.orElse(null);

		return product;
	}

	@Override
	public void delete(GardenShop gardenShop, int prodId, int quantity) {
		Product prodFound = findProdById(gardenShop, prodId);
		if (prodFound != null) {
			gardenShop.getGardenProducts().remove(prodFound, quantity);
		} else {
			System.out.println("Sorry, we can't delete this product. It doesn't exist in our shop's stock");
		}
	}
*/
}
