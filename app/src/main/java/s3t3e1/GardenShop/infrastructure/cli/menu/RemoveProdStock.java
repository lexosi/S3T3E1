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
		
		if(indexProdFound != -1) {
//			prodFound = gardenShop. //pass the index of the product
			gardenShop.getGardenProducts().remove(prodFound, quantity);
		}
		
		
		
		TxtGardenShopRepository repository = new TxtGardenShopRepository();
		RemoveProductService removeProductService = new RemoveProductService(repository);
		removeProductService.removeProduct(product);
//		TxtGardenShopRepository.removeProduct(product);
	}
	
	public static int findProdById(GardenShop gardenShop, int prodId) {
		
		Set<Product> allStockProducts = new HashSet<Product>();
		int prodIndex = -1;
		int actualId, prodIdInStockHM;
		
		allStockProducts = gardenShop.findKeys();
		
//		int prodIdInStockHM = gardenShop.getProductId(product);
//		Iterator<Product> it = allStockProducts.iterator();
//		if(prodId == prodIdInStockHM) {
//			
//		}
		
		Iterator<Product> it = allStockProducts.iterator();
		while(it.hasNext()) {
//			System.out.println(it.next());
			actualId = it.next().getId();
			if(actualId == prodId) {
				prodIndex =  ; // get index of the product
			}
		}
		return prodIndex;
	}
}
