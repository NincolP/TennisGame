package Homework4;

import java.sql.SQLOutput;

public class Game {

    private Player playerOne = new Player();
    private Player playerTwo = new Player();

    boolean playerOneLeadsByTwo;
    boolean playerTwoLeadsByTwo;

    boolean advantagePone;
    boolean advantagePTwo;

    boolean gameCompletedFlag;

   public Game () {

   }

    public boolean clearLead () {
       if(playerOneLeadsByTwo || playerTwoLeadsByTwo)
           return true;
       else
           return false;
    }

    public void displayScore() {

       if(playerOne.getPoints() >= 3 && playerTwo.getPoints() >= 3 && (playerOne.getPoints() == playerTwo.getPoints())) {
            System.out.println("Deuce");
        }

       else if(playerOne.getPoints() > 3 && playerOneLeadsByTwo) {
           System.out.println("Game goes to player 1");
       }

       else if(playerTwo.getPoints() > 3 && playerTwoLeadsByTwo) {
           System.out.println("Game goes to player 2");
       }

       else if( playerOne.getPoints() <= 3 && playerTwo.getPoints() <= 3 ) {
           System.out.print(playerOne.getScore() + "/");
           System.out.println(playerTwo.getScore());
           if(playerOne.getPoints() == 3 && playerTwo.getPoints() == 2) {
               System.out.println("Player One Advantage");
           }
           else if(playerTwo.getPoints() == 3 && playerOne.getPoints() == 2) {
               System.out.println("Player Two Advantage");
           }
       }

        else if (playerOne.getPoints() > 3 && advantagePone) {
           System.out.println("Player One Advantage");
       }
        else if (playerTwo.getPoints() > 3 && advantagePTwo) {
           System.out.println("Player two advantage");
       }
        
    }

    public Player getOne() {
        return playerOne;
    }

    public void setOne(Player one) {
        this.playerOne = one;
    }

    public Player getTwo() {
        return playerTwo;
    }

    public void setTwo(Player two) {
        this.playerTwo = two;
    }


    public void pointWinner(int num) {
        if(num % 2 == 0) {
            playerOne.setPointsAndScore();
        }
        else {
            playerTwo.setPointsAndScore();
        }
    }

    public void displayGamePlayers(){
        System.out.println("Game Players");
        System.out.print(playerOne.getName() + " VS " + playerTwo.getName());
        System.out.println();

    }

    public void setGameCompletedFlag() {
            gameCompletedFlag = true;
    }

    public boolean getGameCompletedFlag() {
       return gameCompletedFlag;
    }

    public void roundGamePlay ( ) {
       displayGamePlayers();
       System.out.print("Previous Score: ");
       displayScore();
       int random = (int )(Math.random() * 50 + 1);
       pointWinner(random);

        if(playerOne.getPoints() - playerTwo.getPoints() == 2)
            playerOneLeadsByTwo = true;
        else if (playerTwo.getPoints() - playerOne.getPoints() == 2)
            playerTwoLeadsByTwo = true;
        else if(playerOne.getPoints() - playerTwo.getPoints() == 1)
            advantagePone = true;
        else if(playerTwo.getPoints() - playerOne.getPoints() ==1)
            advantagePTwo = true;


       System.out.print("New Score: ");
       displayScore();
       System.out.println();




    }





}
