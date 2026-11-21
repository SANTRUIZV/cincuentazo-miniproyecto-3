package com.example.cincuentazo.model.card;

/**
 * Carta de la baraja francesa.
 *
 * @author Santiago Ruiz Vanegas
 * @version 1.0
 */
public class Card {

    /** Suma máxima que puede tener la mesa. */
    public static final int MAX_SUM = 50;

    private final Rank rank;
    private final Suit suit;

    Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    /** Valor que suma esta carta con la suma actual. Pendiente. */
    public int getValueFor(int currentSum) {
        return 0;
    }

    /** true si se puede jugar sin pasar de 50. Pendiente. */
    public boolean canBePlayedOn(int currentSum) {
        return false;
    }

    /** Nombre del archivo de la imagen, ej. "QH.png". Pendiente. */
    public String getImageName() {
        return "";
    }
}
