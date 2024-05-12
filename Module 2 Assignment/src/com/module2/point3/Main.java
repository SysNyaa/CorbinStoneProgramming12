package com.module2.point3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        DeckOfCards deckOfCards = new DeckOfCards();
        LinkedList<Card> hand = deckOfCards.dealHand();

        // Show hand
        System.out.println("Hand of Seven Cards:");
        for (Card card : hand) {
            System.out.println(card);
        }

        // Sorting hand by suits
        hand.sort(new DeckOfCards.SortBySuit());
        System.out.println("\nSorted Hand by Suits:");
        for (Card card : hand) {
            System.out.println(card);
        }

        // Sort hand by face card or not
        hand.sort(new DeckOfCards.SortByFaceCard());
        System.out.println("\nSorted Hand by Face Card or Not:");
        for (Card card : hand) {
            System.out.println(card);
        }
    }
}
