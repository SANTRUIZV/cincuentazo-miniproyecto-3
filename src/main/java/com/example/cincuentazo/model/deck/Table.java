package com.example.cincuentazo.model.deck;

import com.example.cincuentazo.model.card.Card;
import com.example.cincuentazo.model.exceptions.InvalidCardPlayException;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Mesa donde se juegan las cartas.
 * <p>
 * Usa un {@link Stack} (pila) porque la única carta que importa es la
 * última que se jugó: {@code push} al jugar y {@code peek} para ver la carta
 * visible. También guarda la suma actual de la mesa.
 *
 * @author Santiago Ruiz Vanegas
 * @version 1.0
 */
public class Table {

    /** Cartas jugadas. La de arriba es la visible. */
    private final Stack<Card> cards;

    /** Suma actual de la mesa. */
    private int sum;

    /**
     * Crea una mesa vacía con suma 0.
     */
    public Table() {
        cards = new Stack<>();
        sum = 0;
    }

    /**
     * Pone la carta inicial y la suma arranca con su valor.
     * <p>
     * Aquí el As vale 1, no 10. La suma inicial puede ser 0 (un 9),
     * 1 (un As) o -10 (J, Q, K). Si la mesa tenía cartas, se borran.
     *
     * @param card carta inicial
     * @throws IllegalArgumentException si la carta es null
     */
    public void placeInitialCard(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("La carta inicial no puede ser null");
        }
        cards.clear();
        cards.push(card);
        sum = card.getRank().getValue();
    }

    /**
     * Juega una carta encima de la mesa y actualiza la suma.
     *
     * @param card carta que se juega
     * @throws InvalidCardPlayException si la carta hace que la suma pase de 50
     * @throws IllegalArgumentException si la carta es null
     */
    public void play(Card card) throws InvalidCardPlayException {
        if (card == null) {
            throw new IllegalArgumentException("La carta no puede ser null");
        }
        if (!card.canBePlayedOn(sum)) {
            throw new InvalidCardPlayException(card, sum);
        }
        sum += card.getValueFor(sum);
        cards.push(card);
    }

    /**
     * Devuelve la carta visible de la mesa.
     *
     * @return última carta jugada, o null si la mesa está vacía
     */
    public Card getTopCard() {
        return cards.isEmpty() ? null : cards.peek();
    }

    /**
     * Devuelve la suma actual de la mesa.
     *
     * @return suma
     */
    public int getSum() {
        return sum;
    }

    /**
     * Devuelve cuántas cartas hay en la mesa.
     *
     * @return número de cartas
     */
    public int size() {
        return cards.size();
    }

    /**
     * Quita todas las cartas de la mesa menos la de arriba, para rellenar el mazo.
     * La suma no cambia.
     *
     * @return cartas que se quitaron (puede estar vacía)
     */
    public List<Card> takeAllButTop() {
        List<Card> taken = new ArrayList<>();
        if (cards.isEmpty()) {
            return taken;
        }
        Card top = cards.pop();
        taken.addAll(cards);
        cards.clear();
        cards.push(top);
        return taken;
    }
}
