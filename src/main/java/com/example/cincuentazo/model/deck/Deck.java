package com.example.cincuentazo.model.deck;

import com.example.cincuentazo.model.card.Card;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Mazo de cartas boca abajo. Usa un {@link Deque}.
 *
 * @author Santiago Ruiz Vanegas
 * @version 1.0
 */
public class Deck {

    private final Deque<Card> cards = new ArrayDeque<>();

    public void shuffle() {
    }

    /** Lanza EmptyDeckException si está vacío. Pendiente. */
    public Card draw() {
        return null;
    }

    /** Cartas del jugador eliminado. Pendiente. */
    public void addToBottom(List<Card> newCards) {
    }

    /** Cartas de la mesa, las baraja. Pendiente. */
    public void refillFrom(List<Card> tableCards) {
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int size() {
        return cards.size();
    }
}
