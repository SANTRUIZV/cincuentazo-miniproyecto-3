package com.example.cincuentazo.model.card;

/**
 * Palo de una carta.
 * <p>
 * Cada palo guarda la letra que se usa en el nombre de la imagen
 * y su nombre en español para mostrarlo en pantalla.
 *
 * @author Santiago Ruiz Vanegas
 * @version 1.0
 */
public enum Suit {
    /** Picas. */
    SPADES("S", "picas"),
    /** Corazones. */
    HEARTS("H", "corazones"),
    /** Diamantes. */
    DIAMONDS("D", "diamantes"),
    /** Tréboles. */
    CLUBS("C", "tréboles");

    /** Letra del palo en el nombre de la imagen, ej. "H". */
    private final String letter;

    /** Nombre del palo en español. */
    private final String spanishName;

    /**
     * Crea un palo.
     *
     * @param letter      letra que se usa en el nombre de la imagen
     * @param spanishName nombre en español
     */
    Suit(String letter, String spanishName) {
        this.letter = letter;
        this.spanishName = spanishName;
    }

    /**
     * Devuelve la letra del palo.
     *
     * @return letra, ej. "H" para corazones
     */
    public String getLetter() {
        return letter;
    }

    /**
     * Devuelve el nombre del palo en español.
     *
     * @return nombre, ej. "corazones"
     */
    public String getSpanishName() {
        return spanishName;
    }
}
