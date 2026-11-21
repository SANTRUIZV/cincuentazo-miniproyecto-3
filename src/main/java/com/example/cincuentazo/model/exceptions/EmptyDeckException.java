package com.example.cincuentazo.model.exceptions;

/**
 * Excepción propia y <b>no marcada</b> (unchecked): hereda de {@link RuntimeException}.
 * <p>
 * La lanza {@code Deck.draw} cuando se intenta tomar una carta del mazo vacío.
 * El compilador no obliga a atraparla, porque si el juego rellena el mazo
 * a tiempo nunca debería pasar; {@code Game} la atrapa solo como respaldo.
 *
 * @author Santiago Ruiz Vanegas
 * @version 1.0
 */
public class EmptyDeckException extends RuntimeException {

    /**
     * Crea la excepción con el mensaje por defecto.
     */
    public EmptyDeckException() {
        super("El mazo está vacío");
    }

    /**
     * Crea la excepción con un mensaje propio.
     *
     * @param message mensaje para mostrar
     */
    public EmptyDeckException(String message) {
        super(message);
    }
}
