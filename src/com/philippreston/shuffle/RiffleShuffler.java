package com.philippreston.shuffle;

import java.util.Random;

public class RiffleShuffler implements Shuffler {
    @Override
    public Deck shuffle(Deck deck) {
        Deck deck_half = new Deck();
        Deck final_deck = new Deck();
        Random rand = new Random();

        // Add roughly half of the cards to extra half
        int split_index = rand.nextInt(deck.size()/5) + (deck.size()/5*2);
        for (int i = 0; i < split_index; i++) {
            deck_half.add(deck.pop());
        }

        // Start with original deck and alternate between halves until done
        while (deck.size() > 0 || deck_half.size() > 0) {
            int left_count = Math.min(rand.nextInt(4) + 1, deck.size());
            int right_count = Math.min(rand.nextInt(4) + 1, deck_half.size());

            for (int i = 0; i < left_count; i++) {
                final_deck.add(deck.pop());
            }
            for (int i = 0; i < right_count; i++) {
                final_deck.add(deck_half.pop());
            }
        }

        return final_deck;
    }
}
