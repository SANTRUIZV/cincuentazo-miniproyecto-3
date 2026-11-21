package com.example.cincuentazo.model.deck;

import com.example.cincuentazo.model.card.Card;
import com.example.cincuentazo.model.exceptions.InvalidCardPlayException;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Mesa donde se juegan las cartas. Usa un {@link Stack}.
 *
 * @author Santiago Ruiz Vanegas
 * @version 1.0
 */
public class Table {

    private final Stack<Card> cards = new Stack<>();
    private int sum;

    /** El As inicial vale 1. Pendiente. */
    public void placeInitialCard(Card card) {
    }

    /** Pendiente. */
    public void play(Card card) throws InvalidCardPlayException {
    }

    public Card getTopCard() {
        return cards.isEmpty() ? null : cards.peek();
    }

    public int getSum() {
        return sum;
    }

    /** Para rellenar el mazo. Pendiente. */
    public List<Card> takeAllButTop() {
        return new ArrayList<>();
    }
}
