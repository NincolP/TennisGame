package Homework4;

public class Player {

    private String name;
    private int score = 0;



    private int points;

    public Player() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }



   /* public void setScore(int s) {
        score += s;
    }*/

    public void setPointsAndScore() {
        points++;
        if (points == 1)
            score = 15;
        else if (points == 2)
            score = 30;
        else if (points == 3)
            score = 40;
    }


    public int getPoints () {
       return points;
    }








}