package s3t3e1.GardenShop.infrastructure.adapter.repository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import s3t3e1.GardenShop.application.port.in.AddProduct;
import s3t3e1.GardenShop.application.port.out.GardenShopRepository;
import s3t3e1.GardenShop.application.port.out.ProductRepository;
import s3t3e1.GardenShop.domain.GardenShop;
import s3t3e1.GardenShop.domain.Product;
import s3t3e1.GardenShop.domain.enums.ProductType;

public class TxtGardenShopRepository implements ProductRepository, GardenShopRepository {


	private String filePath = "GardenShop.txt";

	/* PRODUCT REPOSITORY */
	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findProdById(GardenShop gardenShop, int prodId) {
		gardenShop.findKeys().forEach(System.out::println);
		return null;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	/* GARDEN SHOP REPOSITORY */
	@Override
	public GardenShop save(GardenShop gardenShop) {
		try (FileWriter writer = new FileWriter(filePath, true)) {
			writer.write(gardenShop.toString() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return gardenShop;
	}

	@Override
	public GardenShop findByName(List<GardenShop> shops, String name) {
		GardenShop shop = shops.stream()
				.filter(s -> s.getName().equals(name))
				.findFirst()
				.orElse(null);
		return shop.get();
	}

	@Override
	public void delete(List<GardenShop> shops, GardenShop gardenShop) {
		GardenShop shop = findByName(shops, gardenShop.getName());
		if (shop != null) {
			shops.remove(shop);
			System.out.println("The shop " + shop.getName() + " has been successfully removed from the database.");
		} else {
			System.out.println("This shop doesn't exist in our shops' database");
		}
	}

}

