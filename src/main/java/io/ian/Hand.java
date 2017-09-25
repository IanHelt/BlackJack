package io.ian;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards = new ArrayList<Card>();

    public Hand() {

    }

    public void draw(Deck deck){
        Card newCard = deck.getCard();
        this.cards.add(newCard);
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }
}
