package com.philippreston.shuffle;

import java.util.ArrayList;
import java.util.Iterator;

public class Deck {
    protected ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    public Deck(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Deck add(Card card) {
        this.cards.add(card);

        return this;
    }

    public ArrayList<Card> all() {
        return this.cards;
    }

    public Card get(int index) {
        return this.cards.get(index);
    }

    public Card pop() {
        return this.pop(0);
    }
    public Card pop(int index) {
        Card card = this.get(index);

        this.remove(card);

        return card;
    }

    public void print() {
        Iterator<Card> iterator = this.cards.iterator();

        while (iterator.hasNext()) {
            Card card = iterator.next();
            System.out.println(card.name());
        }
    }

    public Deck remove(Card card) {
        this.cards.remove(card);

        return this;
    }

    public Deck reverse() {
        for (int i = 0; i < this.size()/2; i++) {
            int compliment_i = this.size()-i-1;
            Card swap = this.cards.get(i);

            this.cards.set(i, this.cards.get(compliment_i));
            this.cards.set(compliment_i, swap);
        }

        return this;
    }

    public int size() {
        return this.cards.size();
    }
}
