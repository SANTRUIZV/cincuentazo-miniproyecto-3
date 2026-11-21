package com.example.cincuentazo.model.card;

import java.util.ArrayList;
import java.util.List;

/**
 * Fábrica de cartas (patrón Factory Method, creacional).
 * <p>
 * Es el único lugar donde se crean cartas. Así nadie hace
 * {@code new Card(...)} regado por el código y, si la forma de crear
 * una carta cambia, solo se cambia aquí.
 *
 * @author Santiago Ruiz Vanegas
 * @version 1.0
 */
public final class CardFactory {

    /** No se crean instancias: todos los métodos son estáticos. */
    private CardFactory() {
    }

    /**
     * Crea una carta.
     *
     * @param rank valor de la carta
     * @param suit palo de la carta
     * @return carta nueva
     * @throws IllegalArgumentException si el valor o el palo son null
     */
    public static Card createCard(Rank rank, Suit suit) {
        if (rank == null || suit == null) {
            throw new IllegalArgumentException("El valor y el palo de la carta no pueden ser null");
        }
        return new Card(rank, suit);
    }

    /**
     * Crea las 52 cartas de la baraja: 4 palos por 13 valores.
     * Las cartas quedan en orden; para barajarlas se usa {@code Deck.shuffle()}.
     *
     * @return lista con las 52 cartas
     */
    public static List<Card> createFullDeck() {
        List<Card> cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(createCard(rank, suit));
            }
        }
        return cards;
    }
}
