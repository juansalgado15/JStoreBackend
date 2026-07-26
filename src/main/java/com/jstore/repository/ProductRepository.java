package com.jstore.repository;

import com.jstore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la gestión de productos.
 * Proporciona operaciones CRUD sobre la entidad Product.
 *
 * @author Juan Salgado
 * @version 0.1.0
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
