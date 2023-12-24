package s3t3e1.GardenShop.infrastructure.cli.menu;

import java.util.*;

import s3t3e1.GardenShop.application.service.RemoveProductService;
import s3t3e1.GardenShop.application.utilities.Input_sc;
import s3t3e1.GardenShop.domain.GardenShop;
import s3t3e1.GardenShop.domain.Product;
import s3t3e1.GardenShop.infrastructure.adapter.repository.TxtGardenShopRepository;

public class RemoveProdStock {

	public static void removeProductFromStock(GardenShop gardenShop) {

		int prodId, quantity, indexProdFound;
		Product prodFound;
		Product product = null;

		prodId = Input_sc.enterInt("Enter the ID of the product you want to remove:");
		quantity = Input_sc.enterInt("Enter how many items of this product you want to remove:");

		indexProdFound = findProdById(gardenShop, prodId);

		if (indexProdFound != -1) {
			prodFound = gardenShop.findKeys().get(indexProdFound);
			gardenShop.getGardenProducts().remove(prodFound, quantity);
		}

		TxtGardenShopRepository repository = new TxtGardenShopRepository();
		RemoveProductService removeProductService = new RemoveProductService(repository);
		removeProductService.removeProduct(product);
		// TxtGardenShopRepository.removeProduct(product);
	}

	public static int findProdById(GardenShop gardenShop, int prodId) {
		// products product ->id

		gardenShop.findKeys().stream().filter(p -> p.getId() == prodId);

		for (Product product : gardenShop.findKeys()) {
			if (product.getId() == prodId) {
				return gardenShop.findKeys().indexOf(product);
			}
		}
		return -1;
	}
}
