package io.ian;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = 100;
        System.out.println("welcome to gamble town");
        while (true) {
            System.out.println("you currently have $" + money);
            if (money < 10) {
                System.out.println("You do not have enough money to continue playing");
                        break;
                    }
            System.out.println("Start a new game?");
            System.out.println("1 - Yes");
            System.out.println("2 - No");
            Integer userChoice = scanner.nextInt();
            if (userChoice == 2) {
                System.out.println("cya fam");
                        break;
            } else if (userChoice == 1) {
                int myTotal = 0;
                int dealerTotal = 0;
                Deck deck = new Deck();
                Hand myHand = new Hand();
                Hand dealerHand = new Hand();
                int aceCounter = 0;
                int dealerAceCounter = 0;
                Boolean dealerDraw = false;
                while (true) {
                    if (myTotal > 21) {
                        System.out.println("Bust!");
                        money = money - 10;
                        break;
                    }
                    if (dealerTotal > 21) {
                        System.out.println("You win!");
                        money = money + 10;
                        break;
                    }
                    if (dealerTotal >= myTotal && myTotal != 0 && dealerTotal < 22) {
                        System.out.println("House wins");
                        money = money - 10;
                        break;
                    }
                    if (dealerDraw) {
                        if (dealerTotal < myTotal) {
                            dealerHand.draw(deck);
                        }
                        dealerTotal = 0;
                        for (Card card : dealerHand.getCards()) {
                            int cardValue = card.getFaceValue();
                            if (card.getFaceValue() == 1) {
                                dealerAceCounter++;
                                cardValue = 11;
                            }
                            if (card.getFaceValue() == 11 ||
                                    card.getFaceValue() == 12 ||
                                    card.getFaceValue() == 13) {
                                cardValue = 10;
                            }
                            if (dealerAceCounter > 0 && (dealerTotal + cardValue) > 21) {
                                cardValue = 1;
                                dealerAceCounter--;
                            }
                            dealerTotal += cardValue;
                        }
                        System.out.println(dealerTotal);
                    } else if (!dealerDraw) {
                        if (myHand.getCards().isEmpty()) {
                            System.out.println("Initial Draw");
                            for (int i = 0; i < 2; i++) {
                                myHand.draw(deck);
                            }
                        } else {
                            System.out.println("Draw or stand?");
                            System.out.println("1 - Draw");
                            System.out.println("2 - Stand");
                            Integer drawChoice = scanner.nextInt();
                            if (drawChoice == 1) {
                                myHand.draw(deck);
                            } else if (drawChoice == 2) {
                                dealerDraw = true;
                            }
                        }
                        myTotal = 0;
                        for (Card card : myHand.getCards()) {
                            int cardValue = card.getFaceValue();
                            if (card.getFaceValue() == 1) {
                                aceCounter++;
                                cardValue = 11;
                            }
                            if (card.getFaceValue() == 11 ||
                                    card.getFaceValue() == 12 ||
                                    card.getFaceValue() == 13) {
                                            cardValue = 10;
                            }
                            if (aceCounter > 0 && (myTotal + cardValue) > 21) {
                                cardValue = 1;
                                aceCounter--;
                            }
                            myTotal += cardValue;
                        }
                        if (myTotal == 21 && myHand.getCards().size() == 2) {
                            System.out.println("Blackjack!");
                            money = money + 15;
                            break;
                        }
                        System.out.println(myTotal);
                    }
                }
            }else if (userChoice > 2 || userChoice < 1){
                System.out.println("Invalid input, try again");
                    }
                }
            }
        }



