package com.example.cincuentazo;

import com.example.cincuentazo.model.card.Card;
import com.example.cincuentazo.model.card.CardFactory;
import com.example.cincuentazo.model.card.Rank;
import com.example.cincuentazo.model.card.Suit;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Pruebas unitarias de {@link Card} y {@link CardFactory}.
 *
 * @author Santiago Ruiz Vanegas
 * @version 1.0
 */
class CardTest {

    /**
     * Atajo para crear una carta de corazones.
     *
     * @param rank valor de la carta
     * @return carta de corazones con ese valor
     */
    private Card card(Rank rank) {
        return CardFactory.createCard(rank, Suit.HEARTS);
    }

    @Test
    void numberCardsAddTheirNumber() {
        assertEquals(2, card(Rank.TWO).getValueFor(0));
        assertEquals(5, card(Rank.FIVE).getValueFor(0));
        assertEquals(8, card(Rank.EIGHT).getValueFor(0));
        assertEquals(10, card(Rank.TEN).getValueFor(0));
    }

    @Test
    void nineIsWorthZero() {
        assertEquals(0, card(Rank.NINE).getValueFor(0));
        assertEquals(0, card(Rank.NINE).getValueFor(50));
    }

    @Test
    void figuresSubtractTen() {
        assertEquals(-10, card(Rank.JACK).getValueFor(30));
        assertEquals(-10, card(Rank.QUEEN).getValueFor(30));
        assertEquals(-10, card(Rank.KING).getValueFor(30));
    }

    @Test
    void aceIsWorthTenWhenItFits() {
        assertEquals(10, card(Rank.ACE).getValueFor(0));
        assertEquals(10, card(Rank.ACE).getValueFor(40));
    }

    @Test
    void aceIsWorthOneWhenTenDoesNotFit() {
        assertEquals(1, card(Rank.ACE).getValueFor(41));
        assertEquals(1, card(Rank.ACE).getValueFor(49));
    }

    @Test
    void canBePlayedOnRespectsTheLimit() {
        assertTrue(card(Rank.FIVE).canBePlayedOn(45));
        assertFalse(card(Rank.SIX).canBePlayedOn(45));
        assertTrue(card(Rank.TEN).canBePlayedOn(40));
        assertFalse(card(Rank.TEN).canBePlayedOn(41));
    }

    @Test
    void nineAndFiguresCanAlwaysBePlayedAtFifty() {
        assertTrue(card(Rank.NINE).canBePlayedOn(50));
        assertTrue(card(Rank.KING).canBePlayedOn(50));
        assertFalse(card(Rank.TWO).canBePlayedOn(50));
    }

    @Test
    void aceCanBePlayedUntilFortyNine() {
        assertTrue(card(Rank.ACE).canBePlayedOn(49));
        assertFalse(card(Rank.ACE).canBePlayedOn(50));
    }

    @Test
    void imageNameUsesSymbolAndSuitLetter() {
        assertEquals("QH.png", card(Rank.QUEEN).getImageName());
        assertEquals("AS.png", CardFactory.createCard(Rank.ACE, Suit.SPADES).getImageName());
        assertEquals("10D.png", CardFactory.createCard(Rank.TEN, Suit.DIAMONDS).getImageName());
    }

    @Test
    void cardsWithSameRankAndSuitAreEqual() {
        assertEquals(card(Rank.SEVEN), card(Rank.SEVEN));
        assertNotEquals(card(Rank.SEVEN), CardFactory.createCard(Rank.SEVEN, Suit.CLUBS));
    }

    @Test
    void fullDeckHasFiftyTwoDifferentCards() {
        List<Card> deck = CardFactory.createFullDeck();
        assertEquals(52, deck.size());
        assertEquals(52, new HashSet<>(deck).size());
    }

    @Test
    void factoryRejectsNull() {
        assertThrows(IllegalArgumentException.class, () -> CardFactory.createCard(null, Suit.HEARTS));
        assertThrows(IllegalArgumentException.class, () -> CardFactory.createCard(Rank.ACE, null));
    }
}
