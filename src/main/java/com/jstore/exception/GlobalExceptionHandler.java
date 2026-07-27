package com.jstore.exception;

import com.jstore.dto.error.ErrorResponseDTO;
import com.jstore.dto.error.ValidationErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Manejador global de excepciones de la aplicación.
 *
 * @author Juan Salgado
 * @version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * Maneja recursos no encontrados.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFound(
            ResourceNotFoundException exception) {


        ErrorResponseDTO error =
                new ErrorResponseDTO(
                        LocalDateTime.now(),
                        HttpStatus.NOT_FOUND.value(),
                        exception.getMessage()
                );


        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }


    /**
     * Maneja errores de validación de los DTO.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponseDTO> handleValidationErrors(
            MethodArgumentNotValidException exception) {


        Map<String, String> errors = new HashMap<>();


        exception.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.put(
                                error.getField(),
                                error.getDefaultMessage()
                        )
                );


        ValidationErrorResponseDTO response =
                new ValidationErrorResponseDTO(
                        LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.value(),
                        errors
                );


        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

}