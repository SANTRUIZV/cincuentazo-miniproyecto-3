package com.example.cincuentazo.model.exceptions;

/**
 * Excepción no marcada: se lanza cuando se intenta tomar una carta del mazo vacío.
 *
 * @author Santiago Ruiz Vanegas
 * @version 1.0
 */
public class EmptyDeckException extends RuntimeException {

    public EmptyDeckException() {
        super("El mazo está vacío");
    }
}
