package Homework4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        int numberOfPlayers = 8;

        ///Create a scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 8 player names: ");

        for(int i = 0; i < numberOfPlayers; i++) {
            Player player = new Player();
            player.setName(input.next());
           players.add(player);
        }

        input.nextLine();

        Tournament tournament = new Tournament(players);
        tournament.displayPlayers();
        tournament.setNumOfGames();
        tournament.setUpMatches();

        do {
            while (tournament.getMatchesNumber() > 0) {
                tournament.round();
                System.out.print("Press enter to continue play");
                input.nextLine();
                System.out.println("----------------------------------------------------------------------------");
            }
            //SETTING UP NEW ROUND----------------
            tournament.displayRemainingPlayers();
            tournament.increaseRoundNumber();
            tournament.setNumOfGames();
            tournament.setUpMatches();
            //------------------------------------

        }while(tournament.getNumberofGames() > 0);
        //END OF DO- WHILE LOOP

    }//END OF MAIN METHOD

}//END OF MAIN CLASS
