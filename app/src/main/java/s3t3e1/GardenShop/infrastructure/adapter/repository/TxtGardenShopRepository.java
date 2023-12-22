package s3t3e1.GardenShop.infrastructure.adapter.repository;

import java.io.FileWriter;
import java.io.IOException;

import s3t3e1.GardenShop.application.port.in.AddProduct;
import s3t3e1.GardenShop.application.port.out.GardenShopRepository;
import s3t3e1.GardenShop.domain.GardenShop;
import s3t3e1.GardenShop.domain.enums.ProductType;

public class TxtGardenShopRepository implements AddProduct, GardenShopRepository {

	private String filePath = "GardenShop.txt";
	
	@Override
	public void addProduct(ProductType prodType) {
		String prod = prodType.toString();
		
		try (FileWriter writer = new FileWriter(filePath, true)){
			writer.write(prod.toString() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		String variable;
		switch(prodType) {
		case T:
			variable = "Tree";
			break;
		case F:
			break;
		case D:
			break;
		}
		try(FileWriter writer = new FileWriter(filePath, true)) {
			writer.write(variable.toString() + "\n");
		}
		*/
	}

	@Override
	public GardenShop save(GardenShop gardenShop) {
		
		return null;
	}

	@Override
	public GardenShop findByName(String name) {
		
		return null;
	}

	@Override
	public void delete(GardenShop gardenShop) {
		
		
	}
}
