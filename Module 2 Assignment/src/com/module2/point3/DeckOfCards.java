package com.module2.point3;


import java.util.Collections;
import java.util.Comparator;
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
    public LinkedList<Card> dealHand() {
        LinkedList<Card> hand = new LinkedList<>();
        for (int i = 0; i < 7; i++) {
            hand.add(deck.pop());
        }
        return hand;
    }

    // Comparator for sorting by suits
    static class SortBySuit implements Comparator<Card> {
        @Override
        public int compare(Card card1, Card card2) {
            return card1.getSuit().compareTo(card2.getSuit());
        }
    }

    // Comparator for sorting by face card or not
    static class SortByFaceCard implements Comparator<Card> {
        @Override
        public int compare(Card card1, Card card2) {
            if (card1.isFaceCard() && !card2.isFaceCard()) {
                return -1; // card1 is a face card but card2 is not, so card1 comes first
            } else if (!card1.isFaceCard() && card2.isFaceCard()) {
                return 1; // card1 is not a face card but card2 is, so card2 comes first
            } else {
                return 0; // both cards are either face cards or not, so maintain the current order
            }
        }
    }
}
