package com.philippreston.shuffle;

public class Test {
    public static void main(String[] args) {
        Deck deck = new Deck();

        for (int i = 0; i < 52; i++) {
            deck.add(new Card("" + i));
        }
        deck.print();

        Shuffler shuffler = new OverhandShuffler();
        Deck shuffled = new Deck(deck.all());

        for (int i = 0; i < 500; i++) {
            shuffled = shuffler.shuffle(shuffled);
        }

        System.out.println("------------------");
        shuffled.print();
    }
}
