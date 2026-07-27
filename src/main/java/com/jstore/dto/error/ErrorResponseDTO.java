package com.jstore.dto.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * DTO utilizado para respuestas de error de la API.
 *
 * @author Juan Salgado
 * @version 1.0
 */
@Getter
@AllArgsConstructor
public class ErrorResponseDTO {

    private LocalDateTime timestamp;

    private int status;

    private String message;
}
