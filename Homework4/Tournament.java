package Homework4;


import java.util.ArrayList;

public class Tournament {

    private ArrayList<Player> players = new ArrayList<>();

    private ArrayList<Game> matches = new ArrayList<>();

    private Game game;
    private int round = 1;

    private int numOfGames = 4;

    boolean endOfGame;


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

   }
   //------------------------------------------

    public void round () {
        //boolean thereIsAWinner = false;
        //System.out.println();
        System.out.println("Round " + round);

        for(int i = 0; i < matches.size(); i++) {



            matches.get(i).roundGamePlay();


            if(matches.get(i).getOne().getPoints() >= 3 && matches.get(i).playerOneLeadsByTwo) {
                //thereIsAWinner = true;
                String winner = matches.get(i).getOne().getName();

                System.out.println("P1 " + winner + " wins");
                System.out.println();

                //Add winner player to finalist of the round
                players.add(matches.get(i).getOne());
                matches.get(i).setGameCompletedFlag();


            }

            else if (matches.get(i).getTwo().getPoints() >= 3 && matches.get(i).playerTwoLeadsByTwo){
                //thereIsAWinner = true;
                String winner = matches.get(i).getTwo().getName();

                System.out.println("P2 " + winner + " wins");
                System.out.println();

                players.add(matches.get(i).getTwo());
                matches.get(i).setGameCompletedFlag();

            }


            if(matches.get(i).getGameCompletedFlag()) {
                matches.remove(i);
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
        for(int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).getName());
        }
    }

    public int getNumberofGames () {
        return numOfGames;
    }

}
