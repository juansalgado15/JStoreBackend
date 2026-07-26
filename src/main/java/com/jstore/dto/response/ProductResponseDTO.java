package com.jstore.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO utilizado para responder información de productos.
 *
 * @author Juan Salgado
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDTO {

    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer stock;

    private Boolean active;

    private LocalDateTime createdAt;

}
