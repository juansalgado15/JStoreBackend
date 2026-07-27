package com.jstore.mapper;

import com.jstore.dto.response.ProductResponseDTO;
import com.jstore.entity.Product;

/**
 * Mapper encargado de convertir entidades Product a DTOs.
 *
 * @author Juan Salgado
 * @version 1.0
 */
public class ProductMapper {


    /**
     * Convierte una entidad Product en ProductResponseDTO.
     *
     * @param product entidad producto.
     * @return DTO de respuesta.
     */
    public static ProductResponseDTO toDTO(Product product) {

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