package com.module2.point2;


import java.util.Collections;
import java.util.LinkedList;

public class DeckOfCards {
    private LinkedList<Card> deck;

    public DeckOfCards() {
        this.deck = new LinkedList<>();
        createDeck();
        shuffleDeck();
    }

    // Create a deck of cards
    private void createDeck() {
        for (Suit suit : Suit.values()) {
            for (int value = 1; value <= 13; value++) {
                deck.add(new Card(suit, value));
            }
        }
    }

    // Shuffle the deck
    private void shuffleDeck() {
        Collections.shuffle(deck);
    }

    // Deal a hand of seven cards
    public LinkedList<Card> deal() {
        LinkedList<Card> hand = new LinkedList<>();
        for (int i = 0; i < 7; i++) {
            hand.add(deck.pop());
        }
        return hand;
    }
}
