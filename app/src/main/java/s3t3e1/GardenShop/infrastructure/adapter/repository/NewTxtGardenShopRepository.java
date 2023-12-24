package s3t3e1.GardenShop.infrastructure.adapter.repository;

import java.util.List;
import java.util.Optional;

import s3t3e1.GardenShop.application.port.out.GardenShopRepository;
import s3t3e1.GardenShop.application.port.out.ProductRepository;
import s3t3e1.GardenShop.domain.GardenShop;
import s3t3e1.GardenShop.domain.Product;

public class NewTxtGardenShopRepository {

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
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void delete() {
			// TODO Auto-generated method stub
			
		}
		
		/* GARDEN SHOP REPOSITORY */
		@Override
		public GardenShop save(GardenShop gardenShop) {
			return null; // guardar botiga
		}

		@Override
		public GardenShop findByName(List<GardenShop> shops, String name) {
			Optional<GardenShop> shop = shops.stream()
					.filter(s -> s.getName().equals(name))
					.findFirst()
					.orElse(null);
			return shop.get();
		}

		@Override
		public void delete(List<GardenShop> shops, GardenShop gardenShop) {
			GardenShop shop = findByName(shops, gardenShop.getName());
			if(shop != null) {
				shops.remove(shop);
			} else {
				System.out.println("This shop doesn't exist in our shops' database");
			}
		}

		

		

		
}
