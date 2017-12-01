import java.util.Random;

/*
 *
 * Soccer Standings Simulator
 *
 * Match.java
 *
 * Created by PDiasG
 * garci455@purdue.edu
 *
 * Last modified on 12/01/2017
 *
 */

/*
 *
 * Match class, contains method to simulate a match
 *
 */

public class Match {
    //initialize both teams and their goals count
    private Team teamHome;
    private Team teamAway;

    private int goalsHome;
    private int goalsAway;

    private boolean played;

    private Random rand = new Random(System.currentTimeMillis()); //Random object

    //constructor for Match
    public Match (Team teamHome, Team teamAway) {
        this.teamHome = teamHome;
        this.teamAway = teamAway;
        this.goalsHome = 0;
        this.goalsAway = 0;
        this.played = false;
    } //end of constructor

    //getters
    public boolean isPlayed() {
        return this.played;
    } //end of getters

    //setters
    public void setScore() {
        int randHome = rand.nextInt(100);
        int randAway = rand.nextInt(100);

        if (randHome >= 0 && randHome < 15) this.goalsHome = 0; //15% of chance of scoring 0 goal
        else if (randHome >= 15 && randHome < 35) this.goalsHome = 1; //20% of chance of scoring 1 goal
        else if (randHome >= 35 && randHome < 55) this.goalsHome = 2; //20% of chance of scoring 2 goals
        else if (randHome >= 55 && randHome < 75) this.goalsHome = 3; //20% of chance of scoring 3 goals
        else if (randHome >= 75 && randHome < 90) this.goalsHome = 4; //15% of chance of scoring 4 goals
        else if (randHome >= 90 && randHome < 95) this.goalsHome = 5; //5% of chance of scoring 5 goals
        else if (randHome >= 95 && randHome < 99) this.goalsHome = 6; //4% of chance of scoring 6 goals
        else if (randHome == 99) this.goalsHome = 7; //1% of chance of scoring 7 goals

        if (randAway >= 0 && randAway < 15) this.goalsAway = 0; //15% of chance of scoring 0 goal
        else if (randAway >= 15 && randAway < 35) this.goalsAway = 1; //20% of chance of scoring 1 goal
        else if (randAway >= 35 && randAway < 55) this.goalsAway = 2; //20% of chance of scoring 2 goals
        else if (randAway >= 55 && randAway < 75) this.goalsAway = 3; //20% of chance of scoring 3 goals
        else if (randAway >= 75 && randAway < 90) this.goalsAway = 4; //15% of chance of scoring 4 goals
        else if (randAway >= 90 && randAway < 95) this.goalsAway = 5; //5% of chance of scoring 5 goals
        else if (randAway >= 95 && randAway < 99) this.goalsAway = 6; //4% of chance of scoring 6 goals
        else if (randAway == 99) this.goalsAway = 7; //1% of chance of scoring 7 goals
    }//end of setters

    //print match
    public void printFutureMatch() {
        System.out.println(this.teamHome.getName() + " x " + this.teamAway.getName());
    }

    public void printCompletedMatch() {
        System.out.println(this.teamHome.getName() + " " + this.goalsHome + "x" + this.goalsAway + " "
                + this.teamAway.getName());
    } //end of print match methods

    public Team[] simulate(){
        Team[] teams = new Team[2];

        setScore();

        if (this.goalsHome > this.goalsAway) { //home team is winner
            this.teamHome.setGamesPlayed();
            this.teamHome.setVictory();
            this.teamHome.setGoalsScored(this.goalsHome);
            this.teamHome.setGoalsConceded(this.goalsAway);
            this.teamHome.setGoalsDifference();

            this.teamAway.setGamesPlayed();
            this.teamAway.setDefeats();
            this.teamAway.setGoalsScored(this.goalsAway);
            this.teamAway.setGoalsConceded(this.goalsHome);
            this.teamAway.setGoalsDifference();
        }//end of if
        else if (this.goalsHome < this.goalsAway) { //away team is winner
            this.teamHome.setGamesPlayed();
            this.teamHome.setDefeats();
            this.teamHome.setGoalsScored(this.goalsHome);
            this.teamHome.setGoalsConceded(this.goalsAway);
            this.teamHome.setGoalsDifference();

            this.teamAway.setGamesPlayed();
            this.teamAway.setVictory();
            this.teamAway.setGoalsScored(this.goalsAway);
            this.teamAway.setGoalsConceded(this.goalsHome);
            this.teamAway.setGoalsDifference();
        }//enf of else if
        else if (this.goalsHome == this.goalsAway) { //draw
            this.teamHome.setGamesPlayed();
            this.teamHome.setDraws();
            this.teamHome.setGoalsScored(this.goalsHome);
            this.teamHome.setGoalsConceded(this.goalsAway);
            this.teamHome.setGoalsDifference();

            this.teamAway.setGamesPlayed();
            this.teamAway.setDraws();
            this.teamAway.setGoalsScored(this.goalsAway);
            this.teamAway.setGoalsConceded(this.goalsHome);
            this.teamAway.setGoalsDifference();
        } //end of else if

        teams[0] = teamHome;
        teams[1] = teamAway;

        this.played = true;

        return teams;
    }//end of simulate
}
