package Homework4;

public class Player {

    private String name;
    private int score;

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

    public void resetScore() {
        score = 0;
        points = 0;
    }

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
