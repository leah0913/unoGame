package UnoGame;

import java.util.ArrayList;
import java.util.Collections;

public class GroupOfCards {

    private ArrayList<Card> deck;

    /**
     * The constructor creates a new deck of cards. 4 colours : red, blue,
     * green, yellow two of the same card : 1~9, draw2, draw4 one card : 0
     */
    public GroupOfCards() {
        deck = new ArrayList<Card>();
        int[] num = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 0};
        int[] specialNum = {2, 2, 4, 4}; //special cards: 2 is draw two, 4 is draw four
        String[] colours = {"red", "blu", "grn", "ylw"};

        // Adding number cards to the deck
        for (String colour : colours) {
            for (int i : num) {
                deck.add(new Card(i, colour));
            }
        }

        // Adding special cards to the deck
        for (int i : specialNum) {
            deck.add(new Card(i));
        }
    }

    /**
     * Constructor for creating new deck using thrown cards
     *
     * @param thrownCards
     */
    public GroupOfCards(ArrayList<Card> thrownCards) {
        deck = thrownCards;
    }

    /**
     * method to shuffle the deck
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    
    /**
     * Check out if the deck is empty or not.
     *
     * @return true if the deck is empty
     */
    public boolean isDeckEmpty() {
        if (deck.size() > 0) {
            return false;
        }
        return true;
    }

    /**
     * Method to get a card from the deck
     *
     * @return topmost card
     */
    public Card getTopCard() {
        return deck.remove(deck.size() - 1);
    }

    /**
     * Get the card to check out what the number
     *
     * @return
     */
    public Card pick() {
        return deck.get(deck.size() - 1);
    }

    public String toString() {
        String deck = "";
        for (Card card : this.deck) {
            deck = deck + card + " ";
        }
        return deck;
    }

}
