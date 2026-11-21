package com.example.cincuentazo.model.card;

import java.util.Objects;

/**
 * Carta de la baraja francesa.
 * <p>
 * Es inmutable: el valor y el palo no cambian después de creada.
 * El constructor no es público; las cartas se crean con {@link CardFactory}.
 *
 * @author Santiago Ruiz Vanegas
 * @version 1.0
 */
public class Card {

    /** Suma máxima que puede tener la mesa. */
    public static final int MAX_SUM = 50;

    /** Valor de la carta (A, 2..10, J, Q, K). */
    private final Rank rank;

    /** Palo de la carta. */
    private final Suit suit;

    /**
     * Crea una carta. Solo lo usa {@link CardFactory}.
     *
     * @param rank valor de la carta
     * @param suit palo de la carta
     */
    Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Devuelve el valor de la carta.
     *
     * @return valor (A, 2..10, J, Q, K)
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Devuelve el palo de la carta.
     *
     * @return palo
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Calcula lo que suma esta carta si se juega sobre la suma actual.
     * <p>
     * El As vale 10 si {@code currentSum + 10 <= 50}; si no, vale 1.
     * Las demás cartas siempre valen lo mismo (ver {@link Rank}).
     *
     * @param currentSum suma actual de la mesa
     * @return valor que se le suma a la mesa
     */
    public int getValueFor(int currentSum) {
        if (rank == Rank.ACE && currentSum + 10 <= MAX_SUM) {
            return 10;
        }
        return rank.getValue();
    }

    /**
     * Indica si la carta se puede jugar sin que la mesa pase de 50.
     *
     * @param currentSum suma actual de la mesa
     * @return true si {@code currentSum + valor <= 50}
     */
    public boolean canBePlayedOn(int currentSum) {
        return currentSum + getValueFor(currentSum) <= MAX_SUM;
    }

    /**
     * Devuelve el nombre del archivo de la imagen de la carta.
     * Es el símbolo del valor seguido de la letra del palo.
     *
     * @return nombre del archivo, ej. "QH.png" o "10S.png"
     */
    public String getImageName() {
        return rank.getSymbol() + suit.getLetter() + ".png";
    }

    /**
     * Dos cartas son iguales si tienen el mismo valor y el mismo palo.
     *
     * @param o objeto a comparar
     * @return true si es la misma carta
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Card)) {
            return false;
        }
        Card other = (Card) o;
        return rank == other.rank && suit == other.suit;
    }

    /**
     * Código hash calculado con el valor y el palo.
     *
     * @return código hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }

    /**
     * Texto de la carta para mostrar en pantalla.
     *
     * @return texto, ej. "Q de corazones"
     */
    @Override
    public String toString() {
        return rank.getSymbol() + " de " + suit.getSpanishName();
    }
}
