package s3t3e1.GardenShop.application.service;

import s3t3e1.GardenShop.domain.Product;
import s3t3e1.GardenShop.infrastructure.adapter.repository.TxtGardenShopRepository;

public class ProductManagementService {
    private final TxtGardenShopRepository repository;

    public ProductManagementService(TxtGardenShopRepository repository) {
        this.repository = repository;
    }

    public void addProduct(Product product) {
        // Implementar la lógica para agregar un producto
    }

    public void deleteProduct(Product product) {
        // Implementar la lógica para eliminar un producto
    }

    public void updateProduct(Product product) {
        // Implementar la lógica para actualizar un producto
    }

    public Product findProductByName(String name) {
        // Implementar la lógica para buscar un producto por nombre
        return null;
    }
}