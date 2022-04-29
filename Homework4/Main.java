package Homework4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static char keepGoing;
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

        tournament.setUpMatches();

        while(tournament.getMatchesNumber() > 0 ) {
            tournament.round();
            System.out.println("Press enter to continue play");
            //keepGoing = input.next().charAt(0);
            input.nextLine();
            System.out.println("----------------------------------------------------------------------------");
        }
        System.out.println("Players moving to next round: ");
        tournament.displayRemainingPlayers();

    }


}
