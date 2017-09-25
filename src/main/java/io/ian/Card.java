package io.ian;

public class Card {

    private int faceValue;
    private String suit;

    public Card(int faceValue, String suit) {
        this.faceValue = faceValue;
        this.suit = suit;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public String getSuit() {
        return suit;
    }
}
