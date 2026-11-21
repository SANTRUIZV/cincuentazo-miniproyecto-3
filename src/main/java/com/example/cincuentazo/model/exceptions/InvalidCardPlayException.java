package com.example.cincuentazo.model.exceptions;

import com.example.cincuentazo.model.card.Card;

/**
 * Excepción propia y <b>marcada</b> (checked): hereda de {@link Exception}.
 * <p>
 * La lanza {@code Table.play} cuando una carta hace que la mesa pase de 50.
 * Al ser marcada, el compilador obliga a quien juega una carta a
 * atraparla con {@code try/catch} o a declararla con {@code throws}.
 *
 * @author Santiago Ruiz Vanegas
 * @version 1.0
 */
public class InvalidCardPlayException extends Exception {

    /**
     * Crea la excepción con un mensaje.
     *
     * @param message mensaje para mostrar
     */
    public InvalidCardPlayException(String message) {
        super(message);
    }

    /**
     * Crea la excepción con un mensaje armado con la carta y la suma.
     *
     * @param card       carta que se intentó jugar
     * @param currentSum suma de la mesa en ese momento
     */
    public InvalidCardPlayException(Card card, int currentSum) {
        super("La carta " + card + " pasa de " + Card.MAX_SUM
                + " (suma actual: " + currentSum + ")");
    }
}
