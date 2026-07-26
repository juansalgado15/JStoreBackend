package com.jstore.controller;

import com.jstore.entity.Product;
import com.jstore.service.interfaces.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de productos.
 *
 * @author Juan Salgado
 * @version 0.1.0
 */
@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Obtiene todos los productos.
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    /**
     * Obtiene un producto por su ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {

        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Registra un nuevo producto.
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {

        Product savedProduct = productService.save(product);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedProduct);
    }

    /**
     * Actualiza un producto existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @RequestBody Product product) {

        Product updatedProduct = productService.update(id, product);

        return ResponseEntity.ok(updatedProduct);
    }

    /**
     * Elimina un producto.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {

        productService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
