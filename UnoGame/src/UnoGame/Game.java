package UnoGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private Card current; // the current card on the play
    private GroupOfCards deck; // the deck of the createPlayers
    private ArrayList<Card> cardpile; //when players throw card, it piles up here. Also, creates a new deck if the current deck is empty
    private int disadv; // when wildcards stack up the penalty stacks up. If a player is unable to counter the current wildcard on play, player is penalised "disadvantage" number of cards
    private Scanner input;
    private ArrayList<Player> players;
    private int numOfPlayers;
    private int pick; // players pick

    /**
     * Constructor
     *
     * @param numOfPlayers
     */
    public Game(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
        deck = new GroupOfCards();
        disadv = 0;
        current = getStartingCard();
        cardpile = new ArrayList<Card>();
        players = new ArrayList<Player>();
        cardpile.add(current);
        input = new Scanner(System.in);
        for (int i = 1; i <= numOfPlayers; i++) {
            players.add(new Player("Player " + i));
        }
        dispenseCards(players);
        deck.shuffle();
    }

    
    /**
     * The main method calls this method to start a createPlayers.
     */
    public void createPlayers() {
        while (!gameOver(players)) {
            for (int i = 0; i < numOfPlayers; i++) {
                playGame(players.get(i));
            }
        }
    }

    
    /**
     * The application uses this method to play Uno createPlayers.
     * The main method calls the createPlayers() method and then the createPlayers() method uses playGame() method to play the createPlayers after creating players.
     
     * @param player 
     */
    public void playGame(Player player) {

        System.out.println(player + ", It is your turn\nThe current card on play is:\n" + current);

        
        showBoard(player);
    

        if (current.isSpecial()) {
            disadv += current.getCardNum();
            Card pick;
            if (!canOverride(player)) {
                System.out.println("You don't have a card to override the current special card, so you are penalised");
                for (int i = 0; i < disadv; i++) {
                    if (deck.isDeckEmpty()) {
                        deck = new GroupOfCards(cardpile);
                    }
                    pick = deck.getTopCard();
                    player.pickCard(pick);
                    System.out.println("You picked: \n" + pick);
                    pause();
                }
                disadv = 0;
                current = deck.getTopCard();
                System.out.println("The new current card is: \n" + current);
            }

        }

        if (!hasSameColour(player) && !hasSameValue(player) && !hasSpecial(player)) {
            Card pick = null;
            System.out.println("You don't have a valid card to play for now. Pick a card from the deck!");
            while (!hasSameColour(player) && !hasSameValue(player) && !hasSpecial(player)) {
                pick = deck.getTopCard();
                player.pickCard(pick);
                System.out.println("You picked:\n" + pick);
            }

            System.out.println("You have a new card");
            pause();
            System.out.println("Your cards: ");
            player.showCards();
        }

        System.out.println("Choose a card:");
        pick = input.nextInt() - 1;

        while (!isValidChoice(player, pick)) {
            System.out.println("Wrong Card! Please pick again!");
            pick = input.nextInt() - 1;
        }

        Card play = player.throwCard(pick);

        player.sayUno();
        current = play;
        cardpile.add(current);
    }

    /**
     * Distribute cards to the players. Each player will have 7 cards.
     */
    private void dispenseCards(ArrayList<Player> players) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < numOfPlayers; j++) {
                players.get(j).pickCard(deck.getTopCard());
            }
        }
    }

    
    /**
     *This method checks whether the user has special cards or not
     * @param player
     * @return true if the user has a special card
     */
    private boolean hasSpecial(Player player) {
        for (Card card : player.PlayerCards()) {
            if (card.isSpecial()) {
                return true;
            }
        }
        return false;
    }

    
    /**
     * This method check if the user chose a valid card or not 
     * @param player
     * @param choice
     * @return return true if the user chose a valid card
     */
    private boolean isValidChoice(Player player, int choice) {

        if (choice <= player.PlayerCards().size()) {
            if (player.PlayerCards().get(choice).getCardColour().equals(current.getCardColour()) || player.PlayerCards().get(choice).getCardNum() == current.getCardNum() || player.PlayerCards().get(choice).isSpecial()) {
                return true;
            }
        }
        return false;
    }

    
    /**
     * This method asks the user to press enter to proceed.
     */
    private void pause() {
        System.out.println("Press Enter to Continue");
        input.nextLine();
    }

    /**
     * This method checks whether the player throws the same colour of the card
     * as the current card on the floor or not.
     *
     * @param player
     * @return if the colour is different, it returns false
     */
    private boolean hasSameColour(Player player) {
        for (Card c : player.PlayerCards()) {
            if (c.getCardColour().equals(current.getCardColour())) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks whether the player throws the same value of the card
     * as the current card on the floor or not.
     *
     * @param player
     * @return if the value is different, it returns false
     */
    private boolean hasSameValue(Player player) {
        for (Card c : player.PlayerCards()) {
            if (c.getCardNum() == current.getCardNum()) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method confirms that if the player has valid wild card to play
     *
     * @param player
     * @return If the player doesn't have the same or greater value of special
     * card, it returns false
     */
    private boolean canOverride(Player player) {
        for (Card card : player.PlayerCards()) {
            if (card.isSpecial()) {
                if (card.getCardNum() >= current.getCardNum()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * pick the starting card. If the starting card is a special card, pick the
     * card again.
     *
     * @return starting card
     */
    private Card getStartingCard() {

        Card startingCard = deck.pick();
        while (startingCard.isSpecial()) {
            deck.shuffle();
            startingCard = deck.pick();
        }

        startingCard = deck.getTopCard();
        return startingCard;
    }

    public boolean gameOver(ArrayList<Player> players) {
        boolean over = false;
        for (int i = 0; i < numOfPlayers; i++) {
            if (players.get(i).hasWon()) {
                over = true;
            }
        }
        return over;
    }

    /**
     * Show player's cards
     *
     * @param player
     */
    public void showBoard(Player player) {
        player.showCards();
    }


}
