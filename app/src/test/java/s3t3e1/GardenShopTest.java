package s3t3e1;

import org.junit.jupiter.api.Test;

import s3t3e1.GardenShop.domain.GardenShop;

import static org.junit.jupiter.api.Assertions.*;

class GardenShopTest {

    @Test
    void testConstructorAndGetterMethods() {
        // Crear una instancia de GardenShop
        GardenShop gardenShop = new GardenShop("Test Shop");

        // Comprobar que el ID de la tienda es 0 (asumiendo que esta es la primera
        // tienda que se crea)
        assertEquals(0, gardenShop.shopId());

        // Comprobar que el nombre de la tienda es "Test Shop"
        assertEquals("Test Shop", gardenShop.getName());

        // Comprobar que el tipo de producto es null (asumiendo que no se estableció en
        // el constructor)
        assertNull(gardenShop.getProdType());

        // Comprobar que gardenProducts es un HashMap vacío
        assertTrue(gardenShop.getGardenProducts().isEmpty());
    }
}