package com.example.cincuentazo.model.card;

/**
 * Valor de una carta: A, 2 a 10, J, Q y K.
 * <p>
 * Cada valor guarda lo que suma a la mesa y el símbolo que se usa
 * en el nombre de la imagen. El As guarda 1 como valor base; si vale
 * 10 o 1 lo decide {@link Card#getValueFor(int)}.
 *
 * @author Santiago Ruiz Vanegas
 * @version 1.0
 */
public enum Rank {
    /** As: 1 o 10 según la suma de la mesa. */
    ACE(1, "A"),
    /** Dos. */
    TWO(2, "2"),
    /** Tres. */
    THREE(3, "3"),
    /** Cuatro. */
    FOUR(4, "4"),
    /** Cinco. */
    FIVE(5, "5"),
    /** Seis. */
    SIX(6, "6"),
    /** Siete. */
    SEVEN(7, "7"),
    /** Ocho. */
    EIGHT(8, "8"),
    /** Nueve: no suma ni resta. */
    NINE(0, "9"),
    /** Diez. */
    TEN(10, "10"),
    /** Jota: resta 10. */
    JACK(-10, "J"),
    /** Reina: resta 10. */
    QUEEN(-10, "Q"),
    /** Rey: resta 10. */
    KING(-10, "K");

    /** Lo que suma a la mesa (para el As es el valor mínimo, 1). */
    private final int value;

    /** Símbolo de la carta, ej. "A", "10" o "Q". */
    private final String symbol;

    /**
     * Crea un valor de carta.
     *
     * @param value  lo que suma a la mesa
     * @param symbol símbolo que se usa en el nombre de la imagen
     */
    Rank(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    /**
     * Devuelve lo que suma esta carta a la mesa.
     *
     * @return valor base (el As devuelve 1)
     */
    public int getValue() {
        return value;
    }

    /**
     * Devuelve el símbolo de la carta.
     *
     * @return símbolo, ej. "A", "10" o "Q"
     */
    public String getSymbol() {
        return symbol;
    }
}
