package io.ian;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

        Random rng = new Random();
        private ArrayList<Card> cards = new ArrayList<Card>();
        private String[] suits = {"Spades", "Clubs", "Hearts", "Diamonds"};
        private ArrayList<Integer> deckIndex = new ArrayList<Integer>();
        private int deckSize = 0;

        public Deck() {
            for (String suit : suits) {
                for (int i = 1; i <= 13; i++) {
                    cards.add(new Card(i, suit));
                    deckSize++;
                }
            }
            for (int i = 0; i < 52; i++) {
                deckIndex.add(i);
            }
        }

    public Card getCard() {

        int chosenCardIndex = rng.nextInt(this.cards.size());
        Card drawnCard = this.cards.get(chosenCardIndex);
        int cardValue = this.cards.get(chosenCardIndex).getFaceValue();
        String suitValue = this.cards.get(chosenCardIndex).getSuit();
        if (this.deckIndex.contains(chosenCardIndex)) {
            this.deckIndex.remove(this.deckIndex.indexOf(chosenCardIndex));
        }
            if (cardValue == 1) {
                System.out.println("Ace of " + suitValue);
            } else if (cardValue == 11) {
                System.out.println("Jack of " + suitValue);
            } else if (cardValue == 12) {
                System.out.println("Queen of " + suitValue);
            } else if (cardValue == 13) {
                System.out.println("King of " + suitValue);
            } else if (this.deckIndex.isEmpty()) {
                System.out.println("Deck is empty");
                return null;
            } else {
                System.out.println(cardValue + " of " + suitValue);
            }
            return drawnCard;
        }
    }

