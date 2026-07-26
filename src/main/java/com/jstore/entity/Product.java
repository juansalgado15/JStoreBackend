package com.jstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entidad que representa un producto dentro del catálogo de JS Store.
 *
 * @author Juan Salgado
 * @version 0.1.0
 */
@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    /**
     * Identificador único del producto.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del producto.
     */
    @Column(nullable = false, length = 100)
    private String name;

    /**
     * Descripción del producto.
     */
    @Column(length = 500)
    private String description;

    /**
     * Precio del producto.
     */
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    /**
     * Cantidad disponible en inventario.
     */
    @Column(nullable = false)
    private Integer stock;

    /**
     * Estado del producto.
     */
    @Column(nullable = false)
    private Boolean active;

    /**
     * Fecha de creación del registro.
     */
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}