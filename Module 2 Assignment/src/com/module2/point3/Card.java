package com.module2.point3;

class Card {
    private final Suit suit;
    private final int value;

    public Card(Suit suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public boolean isFaceCard() {
        return value >= 11 && value <= 13; // Face cards have values 11, 12, and 13 (Jack, Queen, King)
    }

    public String toString() {
        String valueStr = switch (value) {
            case 1 -> "Ace";
            case 11 -> "Jack";
            case 12 -> "Queen";
            case 13 -> "King";
            default -> String.valueOf(value);
        };
        return valueStr + " of " + suit;
    }
}
