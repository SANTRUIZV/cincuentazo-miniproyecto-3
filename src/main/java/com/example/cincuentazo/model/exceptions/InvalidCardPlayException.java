package com.example.cincuentazo.model.exceptions;

/**
 * Excepción marcada: se lanza cuando una carta hace pasar la mesa de 50.
 *
 * @author Santiago Ruiz Vanegas
 * @version 1.0
 */
public class InvalidCardPlayException extends Exception {

    public InvalidCardPlayException(String message) {
        super(message);
    }
}
