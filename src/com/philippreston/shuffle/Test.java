package com.philippreston.shuffle;

public class Test {
    public static void main(String[] args) {
        Deck deck = new Deck();

        for (int i = 0; i < 52; i++) {
            deck.add(new Card("" + i));
        }
        deck.print();

        Shuffler riffle_shuffler = new RiffleShuffler();
        Shuffler deal_shuffler = new DealShuffler();
        Deck shuffled = new Deck(deck.all());

        shuffled = riffle_shuffler.shuffle(shuffled);
        shuffled = deal_shuffler.shuffle(shuffled);
        shuffled = riffle_shuffler.shuffle(shuffled);

        System.out.println("------------------");
        shuffled.print();
    }
}
