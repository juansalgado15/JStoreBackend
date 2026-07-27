package com.jstore.controller;

import com.jstore.dto.request.ProductRequestDTO;
import com.jstore.dto.response.ProductResponseDTO;
import com.jstore.service.interfaces.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de productos.
 *
 * @author Juan Salgado
 * @version 1.0
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
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {

        return ResponseEntity.ok(
                productService.findAll()
        );
    }


    /**
     * Obtiene un producto por ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                productService.findById(id)
        );
    }


    /**
     * Crea un producto.
     */
    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(
            @Valid @RequestBody ProductRequestDTO request) {


        ProductResponseDTO response =
                productService.save(request);


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }


    /**
     * Actualiza un producto.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequestDTO request) {


        ProductResponseDTO response =
                productService.update(id, request);


        return ResponseEntity.ok(response);
    }


    /**
     * Elimina un producto.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable Long id) {


        productService.delete(id);

        return ResponseEntity.noContent().build();
    }
}