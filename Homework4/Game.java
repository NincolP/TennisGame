package Homework4;
public class Game {
    private Player playerOne = new Player();
    private Player playerTwo = new Player();
    boolean playerOneLeadsByTwo = false;
    boolean playerTwoLeadsByTwo = false;
    boolean advantagePone = false;
    boolean advantagePTwo = false;
    public Game () {
   }
    public void displayScore() {

       //PLAYERS ARE TIED WHEN SCORE IS 40 OR MORE-------------------------------------------------------------------
       if( (playerOne.getPoints() == playerTwo.getPoints()) && (playerOne.getPoints() >= 3)
               && (playerTwo.getPoints() >= 3)  ){
           System.out.println("---Deuce---");
            //System.out.println("Deuce");
            advantagePone = false;
            advantagePTwo = false;
        }
       //------------------------------------------------------------------------------------------------------------

       //ONE OF THE PLAYERS IS 40 AND LEADS BY TWO. DISPLAY SCORE AND SET LEAD BY TWO FLAG---------------------------
       else if (playerOne.getPoints() == 3 && (playerOne.getPoints() - playerTwo.getPoints() >= 2)) {
           System.out.print(playerOne.getScore() + "/");
           System.out.println(playerTwo.getScore());
           playerOneLeadsByTwo = true;
       }

       else if(playerTwo.getPoints() == 3 && (playerTwo.getPoints() - playerOne.getPoints() >= 2) ){
            System.out.print(playerOne.getScore() + "/");
            System.out.println(playerTwo.getScore());
            playerTwoLeadsByTwo = true;
        }
       //------------------------------------------------------------------------------------------------------------

       //ONE PLAYER IS 40 AND HAS ONE POINT ADVANTAGE----------------------------------------------------------------
       else if (playerOne.getPoints() == 3 && (playerOne.getPoints() - playerTwo.getPoints() == 1)) {
           System.out.print(playerOne.getScore() + "/");
           System.out.println(playerTwo.getScore());
           System.out.println("Player One Advantage");
           advantagePone = true;
       }

       else if(playerTwo.getPoints() == 3 && (playerTwo.getPoints() - playerOne.getPoints() == 1) ){
           System.out.print(playerOne.getScore() + "/");
           System.out.println(playerTwo.getScore());
           System.out.println("Player two advantage");
           advantagePTwo = true;
       }
       //------------------------------------------------------------------------------------------------------------
       //WINNING BY TWO POINTS WHEN PLAYER SCORE IS MORE THAN 40 POINTS
       else if( (playerOne.getPoints() > 3) && (playerOne.getPoints() - playerTwo.getPoints() == 2)) {
           System.out.println("Game goes to player 1.");
           advantagePone = false;
           advantagePTwo = false;
           playerOneLeadsByTwo = true;
       }

       else if( (playerTwo.getPoints() > 3) && (playerTwo.getPoints() - playerOne.getPoints() == 2) ){
           System.out.println("Game goes to player 2.");
           advantagePone = false;
           advantagePTwo = false;
           playerTwoLeadsByTwo = true;
       }
       //------------------------------------------------------------------------------------------------------------

       //UNDER 40 POINTS SCORING-------------------------------------------------------------------------------------
       else if( playerOne.getPoints() < 3 && playerTwo.getPoints() < 3) {
           System.out.print(playerOne.getScore() + "/");
           System.out.println(playerTwo.getScore());
       }
       //----------------------------------------------------------------------------------------------------------------

       //MORE THAN 40 POINTS AND ONE POINT ADVANTAGE---------------------------------------------------------------------
        else if (playerOne.getPoints() > 3 && (playerOne.getPoints() - playerTwo.getPoints() == 1)) {
           System.out.println("Player One Advantage");
           advantagePone = true;
       }
        else if (playerTwo.getPoints() > 3 && (playerTwo.getPoints() - playerOne.getPoints() == 1)) {
           System.out.println("Player two advantage");
           advantagePTwo = true;
       }
        //-----------------------------------------------------------------------------------------------------------
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
        System.out.println(playerOne.getName() + " VS " + playerTwo.getName());
        System.out.println(playerOne.getName() + " Serving");
        //System.out.println();
    }

    public void roundGamePlay ( ) {
       displayGamePlayers();
       System.out.print("Previous Score: ");
       displayScore();
       int random = (int)(Math.random() * 50 + 1);
       pointWinner(random);
       System.out.print("New Score: ");
       displayScore();
       System.out.println();
    }//END OF ROUND GAME PLAY METHOD

}//END OF GAME CLASS
