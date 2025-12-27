package com.inventory.product;

import java.util.List;

/**
 * Service interface for Product operations
 */
public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product getProductBySku(String sku);

    Product getProductByBarcode(String barcode);

    List<Product> getProductsByCategory(String category);

    List<Product> searchProductsByName(String name);

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);
}
