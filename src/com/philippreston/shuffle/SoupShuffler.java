package com.philippreston.shuffle;

import java.util.Random;

public class SoupShuffler implements Shuffler {
    @Override
    public Deck shuffle(Deck deck) {
        Deck new_deck = new Deck();
        Random rand = new Random();

        while (deck.size() > 0) {
            int index = rand.nextInt(deck.size());

            Card card = deck.pop(index);

            new_deck.add(card);
        }

        return new_deck;
    }
}
