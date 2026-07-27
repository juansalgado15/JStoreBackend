package com.jstore.dto.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * DTO utilizado para respuestas de errores de validación.
 *
 * @author Juan Salgado
 * @version 1.0
 */
@Getter
@AllArgsConstructor
public class ValidationErrorResponseDTO {

    private LocalDateTime timestamp;

    private int status;

    private Map<String, String> errors;
}
