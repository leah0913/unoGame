package UnoGame;

import java.util.Scanner;

public class PlayUno {

    /**
     * This main method is the starting point of Uno createPlayers.
     * @param args 
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("How many players?");
        int numOfPlayers = input.nextInt();
        
        Game game = new Game(numOfPlayers);

        game.createPlayers();

    }

}
