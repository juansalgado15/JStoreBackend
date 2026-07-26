package com.jstore.service.interfaces;

import com.jstore.entity.Product;

import java.util.List;
import java.util.Optional;

/**
 * Define las operaciones de negocio para la gestión de productos.
 *
 * @author Juan Salgado
 * @version 0.1.0
 */
public interface ProductService {

    /**
     * Obtiene la lista de todos los productos.
     *
     * @return lista de productos.
     */
    List<Product> findAll();

    /**
     * Busca un producto por su identificador.
     *
     * @param id identificador del producto.
     * @return producto encontrado.
     */
    Optional<Product> findById(Long id);

    /**
     * Registra un nuevo producto.
     *
     * @param product producto a guardar.
     * @return producto registrado.
     */
    Product save(Product product);

    /**
     * Actualiza un producto existente.
     *
     * @param id identificador del producto.
     * @param product datos actualizados.
     * @return producto actualizado.
     */
    Product update(Long id, Product product);

    /**
     * Elimina un producto por su identificador.
     *
     * @param id identificador del producto.
     */
    void delete(Long id);
}
