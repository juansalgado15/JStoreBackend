package com.jstore.exception;

/**
 * Excepción personalizada para recursos no encontrados.
 *
 * @author Juan Salgado
 * @version 1.0
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}