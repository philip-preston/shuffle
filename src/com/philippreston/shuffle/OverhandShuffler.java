package com.philippreston.shuffle;

import java.util.Random;

public class OverhandShuffler implements Shuffler {
    @Override
    public Deck shuffle(Deck deck) {
        Deck new_deck = new Deck();
        Random rand = new Random();

        while (deck.size() > 0) {
            int chunk_size = Math.min((rand.nextInt(4) + 1), deck.size());
            int card_position = deck.size() - chunk_size;

            for(int i = 0; i < chunk_size; i++) {
                new_deck.add(deck.pop(card_position));
            }
        }

        return new_deck;
    }
}
