package com.jstore.service.impl;

import com.jstore.dto.request.ProductRequestDTO;
import com.jstore.dto.response.ProductResponseDTO;
import com.jstore.entity.Product;
import com.jstore.repository.ProductRepository;
import com.jstore.service.interfaces.ProductService;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación de la lógica de negocio para la gestión de productos.
 *
 * @author Juan Salgado
 * @version 1.0
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


    /**
     * Obtiene todos los productos.
     *
     * @return lista de productos.
     */
    @Override
    public List<ProductResponseDTO> findAll() {

        return productRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }


    /**
     * Busca un producto por ID.
     *
     * @param id identificador del producto.
     * @return producto encontrado.
     */
    @Override
    public ProductResponseDTO findById(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Producto no encontrado."));

        return mapToDTO(product);
    }


    /**
     * Registra un producto nuevo.
     *
     * @param request datos del producto.
     * @return producto creado.
     */
    @Override
    public ProductResponseDTO save(ProductRequestDTO request) {

        Product product = mapToEntity(request);

        Product savedProduct = productRepository.save(product);

        return mapToDTO(savedProduct);
    }


    /**
     * Actualiza un producto existente.
     *
     * @param id identificador del producto.
     * @param request nuevos datos.
     * @return producto actualizado.
     */
    @Override
    public ProductResponseDTO update(Long id, ProductRequestDTO request) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Producto no encontrado."));

        existingProduct.setName(request.getName());
        existingProduct.setDescription(request.getDescription());
        existingProduct.setPrice(request.getPrice());
        existingProduct.setStock(request.getStock());
        existingProduct.setActive(request.getActive());

        Product updatedProduct = productRepository.save(existingProduct);

        return mapToDTO(updatedProduct);
    }


    /**
     * Elimina un producto por ID.
     *
     * @param id identificador del producto.
     */
    @Override
    public void delete(Long id) {

        productRepository.deleteById(id);
    }


    /**
     * Convierte un DTO de entrada a entidad.
     */
    private Product mapToEntity(ProductRequestDTO request) {

        Product product = new Product();

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setActive(request.getActive());

        return product;
    }


    /**
     * Convierte una entidad a DTO de respuesta.
     */
    private ProductResponseDTO mapToDTO(Product product) {

        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .active(product.getActive())
                .createdAt(product.getCreatedAt())
                .build();
    }
}