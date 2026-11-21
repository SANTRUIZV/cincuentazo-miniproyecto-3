package com.example.cincuentazo.model.deck;

import com.example.cincuentazo.model.card.Card;
import com.example.cincuentazo.model.card.CardFactory;
import com.example.cincuentazo.model.exceptions.EmptyDeckException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * Mazo de cartas boca abajo.
 * <p>
 * Usa un {@link Deque} (cola doble) porque se necesita trabajar por los dos
 * extremos: las cartas se toman del frente ({@link #draw()}) y las cartas de
 * un jugador eliminado o de la mesa se agregan al final
 * ({@link #addToBottom(List)}, {@link #refillFrom(List)}).
 *
 * @author Santiago Ruiz Vanegas
 * @version 1.0
 */
public class Deck {

    /** Cartas del mazo. El frente es la carta de arriba. */
    private final Deque<Card> cards;

    /**
     * Crea el mazo con las 52 cartas en orden. Para jugar hay que llamar a {@link #shuffle()}.
     */
    public Deck() {
        this(CardFactory.createFullDeck());
    }

    /**
     * Crea un mazo con las cartas dadas, en ese orden (la primera queda arriba).
     * Sirve para las pruebas, cuando se necesita saber qué carta sale.
     *
     * @param initialCards cartas del mazo
     * @throws IllegalArgumentException si la lista es null
     */
    public Deck(List<Card> initialCards) {
        if (initialCards == null) {
            throw new IllegalArgumentException("La lista de cartas no puede ser null");
        }
        cards = new ArrayDeque<>(initialCards);
    }

    /**
     * Baraja las cartas del mazo.
     */
    public void shuffle() {
        List<Card> list = new ArrayList<>(cards);
        Collections.shuffle(list);
        cards.clear();
        cards.addAll(list);
    }

    /**
     * Toma la carta de arriba del mazo.
     *
     * @return carta de arriba
     * @throws EmptyDeckException si el mazo está vacío
     */
    public Card draw() {
        if (cards.isEmpty()) {
            throw new EmptyDeckException();
        }
        return cards.pollFirst();
    }

    /**
     * Agrega cartas al final del mazo, en el mismo orden.
     * Se usa con la mano de un jugador eliminado.
     *
     * @param newCards cartas que se agregan
     * @throws IllegalArgumentException si la lista es null
     */
    public void addToBottom(List<Card> newCards) {
        if (newCards == null) {
            throw new IllegalArgumentException("La lista de cartas no puede ser null");
        }
        for (Card card : newCards) {
            cards.addLast(card);
        }
    }

    /**
     * Rellena el mazo con las cartas de la mesa: las baraja y las pone al final.
     * <p>
     * Pase lo que pase, en el {@code finally} se vacía la lista recibida, para
     * que esas cartas no queden repetidas en otro lugar del juego.
     *
     * @param tableCards cartas de la mesa (todas menos la de arriba)
     * @throws IllegalArgumentException si la lista es null
     */
    public void refillFrom(List<Card> tableCards) {
        if (tableCards == null) {
            throw new IllegalArgumentException("La lista de cartas no puede ser null");
        }
        try {
            List<Card> shuffled = new ArrayList<>(tableCards);
            Collections.shuffle(shuffled);
            addToBottom(shuffled);
        } finally {
            tableCards.clear();
        }
    }

    /**
     * Indica si el mazo no tiene cartas.
     *
     * @return true si está vacío
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    /**
     * Devuelve cuántas cartas tiene el mazo.
     *
     * @return número de cartas
     */
    public int size() {
        return cards.size();
    }
}
