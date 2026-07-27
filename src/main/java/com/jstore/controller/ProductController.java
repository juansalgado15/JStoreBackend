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


    /**
     * Constructor para inyección de dependencia.
     *
     * @param productService servicio de productos.
     */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    /**
     * Obtiene todos los productos.
     *
     * @return lista de productos.
     */
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {

        return ResponseEntity.ok(productService.findAll());
    }


    /**
     * Obtiene un producto por su ID.
     *
     * @param id identificador del producto.
     * @return producto encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(
            @PathVariable Long id) {

        return ResponseEntity.ok(productService.findById(id));
    }


    /**
     * Registra un nuevo producto.
     *
     * @param request datos del producto.
     * @return producto creado.
     */
    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(
            @Valid @RequestBody ProductRequestDTO request) {

        ProductResponseDTO savedProduct =
                productService.save(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedProduct);
    }


    /**
     * Actualiza un producto existente.
     *
     * @param id identificador del producto.
     * @param request nuevos datos.
     * @return producto actualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequestDTO request) {

        ProductResponseDTO updatedProduct =
                productService.update(id, request);

        return ResponseEntity.ok(updatedProduct);
    }


    /**
     * Elimina un producto.
     *
     * @param id identificador del producto.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable Long id) {

        productService.delete(id);

        return ResponseEntity.noContent().build();
    }
}