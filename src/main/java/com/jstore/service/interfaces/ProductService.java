package com.jstore.service.interfaces;

import com.jstore.dto.request.ProductRequestDTO;
import com.jstore.dto.response.ProductResponseDTO;

import java.util.List;

/**
 * Define las operaciones de negocio para la gestión de productos.
 *
 * @author Juan Salgado
 * @version 1.0
 */
public interface ProductService {

    /**
     * Obtiene todos los productos registrados.
     *
     * @return lista de productos.
     */
    List<ProductResponseDTO> findAll();

    /**
     * Busca un producto por su identificador.
     *
     * @param id identificador del producto.
     * @return producto encontrado.
     */
    ProductResponseDTO findById(Long id);

    /**
     * Registra un nuevo producto.
     *
     * @param request datos del producto.
     * @return producto creado.
     */
    ProductResponseDTO save(ProductRequestDTO request);

    /**
     * Actualiza un producto existente.
     *
     * @param id identificador del producto.
     * @param request nuevos datos.
     * @return producto actualizado.
     */
    ProductResponseDTO update(Long id, ProductRequestDTO request);

    /**
     * Elimina un producto.
     *
     * @param id identificador del producto.
     */
    void delete(Long id);
}