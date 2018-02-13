package com.philippreston.shuffle;

import java.util.ArrayList;
import java.util.Random;

public class DealShuffler implements Shuffler {
    @Override
    public Deck shuffle(Deck deck) {
        Deck final_deck = new Deck();
        Random rand = new Random();
        int num_piles = rand.nextInt(4) + 4;
        ArrayList<Deck> piles = new ArrayList<Deck>();

        for (int i = 0; i < num_piles; i++) {
            piles.add(new Deck());
        }

        int deck_index = 0;
        while (deck.size() > 0) {
            piles.get(deck_index).add(deck.pop(deck.size() - 1));

            deck_index++;
            if (deck_index >= num_piles) {
                deck_index = 0;
            }
        }


        while (piles.size() > 0) {
            int pile_index = rand.nextInt(piles.size());
            Deck pile = piles.get(pile_index);

            while (pile.size() > 0) {
                final_deck.add(pile.pop());
            }

            piles.remove(pile);
        }

        return final_deck;
    }
}
