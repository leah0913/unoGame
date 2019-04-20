package UnoGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private ArrayList<Card> playercards;
    private String playerID;

    /**
     * A constructor that allows you to set the player 
     * Player has cards
     *
     * @input payerID
     * @param name the unique ID to assign to this player.
     */
    public Player(String playerID) {

        playercards = new ArrayList<Card>();
        this.playerID = playerID;

    }

    /**
     * This method checks how many cards the player has
     *
     * @return the number of cards that the player has
     */
    public int numOfCards() {
        return playercards.size();
    }

    /**
     * This method is for checking player's cards
     *
     * @return cardShape ArrayList
     */
    public ArrayList<Card> PlayerCards() {
        return playercards;
    }

    /**
     * Player gets a cardShape from the deck
     *
     * @param card
     */
    public void pickCard(Card card) {
        playercards.add(card);
    }

    /**
     * player throw a cardShape
     *
     * @param position
     * @return
     */
    public Card throwCard(int position) {
        return playercards.remove(position);
    }

    
    
    /**
     * Players say “Uno” whenever there is only one cardShape left on their hands.
     */
    public void sayUno() {
        Scanner input = new Scanner(System.in);

        if (playercards.size() == 1) {
            System.out.println("Uno!");
            System.out.println("Press Enter to Continue!");
            input.nextLine();
        }
    }

    
    
    /**
     * Method to checkout if one of the players has won or not
     *
     * @return false if all players have at least one cardShape on their hands
     */
    public boolean hasWon() {
        if (playercards.size() == 0) {
            return true;
        }
        return false;
    }

    
    /**
     * This method shows player's cards        
     */
    public void showCards() {

        String[] cardShape = {" ----- ", "|     |", "|     |", " ----- "};
        String card = "";
        int k=1;
        
        for (int i = 0; i < cardShape.length; i++) {          
            for (int j = 0; j < playercards.size(); j++) {                
                if (!playercards.get(j).isSpecial()) {                    
                    if (i == 0) {
                        card = card + " #. "+k + "   "; 
                    } else if (i == 1) {
                        card = card + "| " + playercards.get(j).getCardColour() + " |" + " ";
                    } else if (i == 2) {
                        card = card + "|  " + playercards.get(j).getCardNum() + "  |" + " ";
                    } else {
                        card = card + cardShape[i] + " ";
                    }
                } else if (playercards.get(j).isSpecial()) {
                    if (i == 0) {
                        card = card + " #. "+k+"   "; 
                    } else if (i == 1) {
                        card = card + "| " + "+" + playercards.get(j).getCardNum() + "  |" + " ";
                    } else {
                        card = card + cardShape[i] + " ";
                    }
                }         
                k++; 
            }
            card += "\n";            
        }
        System.out.print(card);
        
        
    }

    
    public String toString() {
        return this.playerID;
    }

}
