package com.jstore.service.impl;

import com.jstore.dto.request.ProductRequestDTO;
import com.jstore.dto.response.ProductResponseDTO;
import com.jstore.entity.Product;
import com.jstore.exception.ResourceNotFoundException;
import com.jstore.mapper.ProductMapper;
import com.jstore.repository.ProductRepository;
import com.jstore.service.interfaces.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación de la lógica de negocio para productos.
 *
 * @author Juan Salgado
 * @version 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;


    /**
     * Constructor para inyección de dependencias.
     *
     * @param productRepository repositorio de productos.
     */
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    /**
     * Obtiene todos los productos registrados.
     *
     * @return lista de productos en formato DTO.
     */
    @Override
    public List<ProductResponseDTO> findAll() {

        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toDTO)
                .toList();
    }



    /**
     * Busca un producto por su identificador.
     *
     * @param id identificador del producto.
     * @return producto encontrado.
     */
    @Override
    public ProductResponseDTO findById(Long id) {


        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Producto no encontrado con id: " + id
                        )
                );


        return ProductMapper.toDTO(product);
    }



    /**
     * Guarda un nuevo producto.
     *
     * @param request datos del producto.
     * @return producto creado.
     */
    @Override
    public ProductResponseDTO save(ProductRequestDTO request) {


        Product product = new Product();


        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setActive(request.getActive());


        Product savedProduct = productRepository.save(product);


        return ProductMapper.toDTO(savedProduct);
    }



    /**
     * Actualiza un producto existente.
     *
     * @param id identificador del producto.
     * @param request nuevos datos.
     * @return producto actualizado.
     */
    @Override
    public ProductResponseDTO update(
            Long id,
            ProductRequestDTO request) {


        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Producto no encontrado con id: " + id
                        )
                );


        existingProduct.setName(request.getName());
        existingProduct.setDescription(request.getDescription());
        existingProduct.setPrice(request.getPrice());
        existingProduct.setStock(request.getStock());
        existingProduct.setActive(request.getActive());


        Product updatedProduct =
                productRepository.save(existingProduct);


        return ProductMapper.toDTO(updatedProduct);
    }



    /**
     * Elimina un producto existente.
     *
     * @param id identificador del producto.
     */
    @Override
    public void delete(Long id) {


        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Producto no encontrado con id: " + id
                        )
                );


        productRepository.delete(product);
    }

}