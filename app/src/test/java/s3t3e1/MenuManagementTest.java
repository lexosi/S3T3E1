package s3t3e1;
import org.junit.jupiter.api.Test;

import s3t3e1.GardenShop.domain.GardenShop;
import s3t3e1.GardenShop.domain.Product;
import s3t3e1.GardenShop.domain.enums.ProductType;
import s3t3e1.GardenShop.infrastructure.cli.menu.MenuManagement;

import s3t3e1.GardenShop.domain.GardenShop;

import s3t3e1.GardenShop.domain.GardenShop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

class MenuManagementTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void showAllStock() {
        // Create a mock GardenShop
        GardenShop gardenShop = mock(GardenShop.class);

        // Create some mock products
        Product treeProduct = mock(Product.class);
        when(treeProduct.getProdType()).thenReturn(ProductType.TREE);

        Product flowerProduct = mock(Product.class);
        when(flowerProduct.getProdType()).thenReturn(ProductType.FLOWER);

        Product decorationProduct = mock(Product.class);
        when(decorationProduct.getProdType()).thenReturn(ProductType.DECORATION);

        // When gardenShop.findKeys() is called, return a list containing the mock products
        when(gardenShop.findKeys()).thenReturn(Arrays.asList(treeProduct, flowerProduct, decorationProduct));

        // Call the method under test
        MenuManagement.showAllStock(gardenShop);

        // Check that the console output contains the expected strings
        String output = outContent.toString();
        assertTrue(output.contains("Tree Stock: [" + treeProduct.toString() + "]"));
        assertTrue(output.contains("Flower Stock: [" + flowerProduct.toString() + "]"));
        assertTrue(output.contains("Decoration Stock: [" + decorationProduct.toString() + "]"));
    }
}