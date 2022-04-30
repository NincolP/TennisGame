package Homework4;

import java.util.ArrayList;

public class Tournament {

    private ArrayList<Player> players = new ArrayList<>();

    private ArrayList<Game> matches = new ArrayList<>();



    //private Game game;
    private int round = 1;
    private int numOfGames;



    public Tournament(ArrayList<Player> players) {
        this.players.addAll(players);
    }

    public void displayPlayers() {
        for (Player player : players) {
            System.out.println(player.getName());
        }
    }

    //SELECT TWO PLAYERS PER MATCH RANDOMLY
   public void setUpMatches() {
       for(int i = 0; i < numOfGames; i ++) {
           System.out.println();
           Game game = new Game();
           game.setOne(selectTwoRandom());
           game.setTwo(selectTwoRandom());
           matches.add(game);
       }
       //RESET SCORES AND POINTS FOR NEW ROUND
       for (Player player : players) {
           player.resetScore();
       }
   }
   //------------------------------------------

    public void round () {
        System.out.println("Round " + round);
        for(int i = 0; i < matches.size(); i++) {

            matches.get(i).roundGamePlay();

            if(matches.get(i).playerOneLeadsByTwo ) {
                String winner = matches.get(i).getOne().getName();
                System.out.println("P1 " + winner + " wins");
                System.out.println();
                //Add winner player to finalist of the round
                players.add(matches.get(i).getOne());
                matches.remove(i);
                break;
            }

            else if (matches.get(i).playerTwoLeadsByTwo ){
                String winner = matches.get(i).getTwo().getName();
                System.out.println("P2 " + winner + " wins");
                System.out.println();
                //Add winner player to finalist of the round
                players.add(matches.get(i).getTwo());
                matches.remove(i);
                break;
            }
        }
    }

    public int getMatchesNumber() {
        return matches.size();
    }

    public Player selectTwoRandom() {

        Player player = new Player();

        if(players.size() <= 2) {
            player.setName(players.get(0).getName());
            players.remove(players.get(0));
            return player;
        }
        else {
            int random = (int) (Math.random() * (players.size() - 1) + 1);
            player.setName(players.get(random).getName());
            players.remove(random);
            return player;
        }

    }

    public void displayRemainingPlayers () {
        if(players.size() == 1) {
            System.out.println("***** " +players.get(0).getName() + " has won the tournament *****");
        }

        else {
            System.out.println("Players moving to next round: ");
            for (Player player : players) {
                System.out.println(player.getName());
            }
        }
    }

    public int getNumberofGames () {
        return numOfGames;
    }

    public void setNumOfGames () {
        numOfGames = players.size() / 2;
    }

    public void increaseRoundNumber (){
        round++;
    }

}
