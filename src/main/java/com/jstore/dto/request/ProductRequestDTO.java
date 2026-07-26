package com.jstore.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * DTO utilizado para registrar y actualizar productos.
 *
 * Contiene las validaciones de entrada de datos.
 *
 * @author Juan Salgado
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestDTO {

    /**
     * Nombre del producto.
     */
    @NotBlank(message = "El nombre es obligatorio.")
    @Size(min = 3, max = 100,
            message = "El nombre debe tener entre 3 y 100 caracteres.")
    private String name;

    /**
     * Descripción del producto.
     */
    @Size(max = 500,
            message = "La descripción no puede superar los 500 caracteres.")
    private String description;

    /**
     * Precio.
     */
    @NotNull(message = "El precio es obligatorio.")
    @Positive(message = "El precio debe ser mayor que cero.")
    private BigDecimal price;

    /**
     * Cantidad en inventario.
     */
    @NotNull(message = "El stock es obligatorio.")
    @Min(value = 0,
            message = "El stock no puede ser negativo.")
    private Integer stock;

    /**
     * Estado del producto.
     */
    @NotNull(message = "Debe indicar si el producto está activo.")
    private Boolean active;

}
