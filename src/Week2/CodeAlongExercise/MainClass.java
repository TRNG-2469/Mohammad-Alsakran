package Week2.CodeAlongExercise;

import week2.Wedensday.CodeAlongExercise.Service.ProductService;
import week2.Wedensday.CodeAlongExercise.Service.ProductServiceImpl;
import week2.Wedensday.CodeAlongExercise.model.product;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        ProductService productService = new ProductServiceImpl();

        // Create
        product newProduct = new product(1, "Test Product", 9);
        productService.createProduct(newProduct);
        System.out.println("Created product");

        // FindAll
        List<product> allProducts = productService.findAll();
        System.out.println("All products: " + allProducts);

        // FindById
        product found = productService.findById(1);
        System.out.println("Found by ID: " + found);

        // Update
        product updated = new product(3, "Updated keyboard Name", 12);
        productService.updateProduct(updated);
        System.out.println("Updated product");

        // Verify update
        System.out.println("After update: " + productService.findById(3));

        // Delete
        productService.deleteProduct(5);
        System.out.println("Deleted product");

        // Verify delete
        System.out.println("After delete: " + productService.findById(5));
    }
}