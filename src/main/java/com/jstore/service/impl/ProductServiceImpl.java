package com.jstore.service.impl;

import com.jstore.entity.Product;
import com.jstore.repository.ProductRepository;
import com.jstore.service.interfaces.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación de la lógica de negocio para la gestión de productos.
 *
 * @author Juan Salgado
 * @version 0.1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    /**
     * Constructor para la inyección de dependencias.
     *
     * @param productRepository repositorio de productos.
     */
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado."));

        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStock(product.getStock());
        existingProduct.setActive(product.getActive());

        return productRepository.save(existingProduct);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
