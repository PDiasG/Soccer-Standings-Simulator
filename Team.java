/*
 *
 * Soccer Standings Simulator
 *
 * Team.java
 *
 * Created by PDiasG
 * garci455@purdue.edu
 *
 * Last modified on 11/30/2017
 *
 */

/*
 *
 * Team class, contains the methods for creating and managing a team
 *
 */

public class Team {
    private String name;
    private int points;
    private int victories;
    private int draws;
    private int defeats;
    private int gamesPlayed;
    private int goalsScored;
    private int goalsConceded;
    private int goalsDifference;

    //constructor for Team
    public Team(String name) {
        if (name.length() >= 10) { //limit the name length to 10 for formatting purposes
            this.name = name.substring(0, 10);
        } else {
            this.name = name;
        } //end of if else
        this.points = 0;
        this.victories = 0;
        this.draws = 0;
        this.defeats = 0;
        this.gamesPlayed = 0;
        this.goalsScored = 0;
        this.goalsConceded = 0;
        this.goalsDifference = 0;
    } //end of constructor

    //getters
    public String getName() {
        return this.name;
    }

    public int getVictories() {
        return this.victories;
    }

    public int getDraws() {
        return this.draws;
    }

    public int getDefeats() {
        return this.defeats;
    }

    public int getPoints() {
        return this.points;
    }

    public int getGamesPlayed() {
        return this.gamesPlayed;
    }

    public int getGoalsScored() {
        return this.goalsScored;
    }

    public int getGoalsConceded() {
        return this.goalsConceded;
    }

    public int getGoalsDifference() {
        return this.goalsDifference;
    }
    //end of getters

    //setters
    public void setVictory() {
        this.points += 3;
        this.victories += 1;
    }

    public void setDraws() {
        this.points += 1;
        this.draws += 1;
    }

    public void setDefeats() {
        this.points += 0;
        this.defeats += 1;
    }

    public void setGamesPlayed() {
        this.gamesPlayed += 1;
    }

    public void setGoalsScored(int goals) {
        this.goalsScored += goals;
    }

    public void setGoalsConceded(int goals) {
        this.goalsConceded += goals;
    }

    public void setGoalsDifference() {
        this.goalsDifference = this.goalsScored - this.goalsConceded;
    }
    //end of setters
}
