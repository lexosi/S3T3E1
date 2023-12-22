package s3t3e1.GardenShop.infrastructure.cli.menu;

import s3t3e1.GardenShop.application.service.AddProductService;
import s3t3e1.GardenShop.infrastructure.adapter.repository.TxtGardenShopRepository;

public class RemoveProdStock {

	public static void removeProductFromStock() {
		
		TxtGardenShopRepository repository = new TxtGardenShopRepository();
		AddProductService addProductService = new AddProductService(repository);
		RemoveProductService.Product(product);
//		TxtGardenShopRepository.removeProduct(prodType);
	}
	
}
