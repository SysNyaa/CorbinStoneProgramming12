package com.module2.point2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        DeckOfCards deckOfCards = new DeckOfCards();
        LinkedList<Card> hand = deckOfCards.deal();

        // Show hand
        System.out.println("Hand of Seven Cards:");
        for (Card card : hand) {
            System.out.println(card);
        }
    }
}
