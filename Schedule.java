import java.util.ArrayList;

/*
 *
 * Soccer Standings Simulator
 *
 * Championship.java
 *
 * Created by PDiasG
 * garci455@purdue.edu
 *
 * Last modified on 12/5/2017
 *
 */

/*
 *
 * Championship class, contains main method to run the Soccer Standings Simulator
 *
 */

public class Schedule {
    private Match[][] schedule;
    private Team[] teams;

    //constructor for Schedule
    public Schedule(int numRounds, int matchesPerRound, Team[] teams) {
        this.schedule = new Match[numRounds][matchesPerRound];
        this.teams = teams;
    } //end fo constructor

    //getter
    public Match getMatch(int week, int pos) {
        return this.schedule[week-1][pos];
    }

    //add match to schedule array
    public void addMatch(Match match, int week, int pos) {
        this.schedule[week][pos] = match;
    } //end of add match

    public void generateSchedule(int teamsNum) {
        //add matches to schedule using Round robin tournament system
        //TODO this only works for an even number of teams, try to fix so it works with an odd number of teams as well
        //TODO check if Round robin system is implemented as efficiently as possible
            int teamHome = 0;
            int teamAway = teamsNum - 1;
            int teamHomeM1 = teamsNum - 1;
            int teamAwayM1 = teamsNum - 1;
            for (int i = 0; i < this.schedule.length; i++) {
                for (int j = 0; j < this.schedule[i].length; j++) {
                    addMatch((new Match(teams[j == 0 ? 0 : teamHome], teams[teamAway])), i, j);
                    teamHome++;
                    if (teamHome > (teamsNum - 1)) teamHome = 1;
                    teamAway--;
                    if (teamAway < 1) teamAway = teamsNum - 1;
                } //end of for
                teamHome = --teamHomeM1;
                teamAway = --teamAwayM1;
            }//end of for
    }

    //print schedule
    public void printSchedule(int week) {
        for (int i = 0; i < schedule[week - 1].length; i++) {
            System.out.print("Match #" + (i+1) + ": ");
            if (schedule[week-1][i].isPlayed())
                schedule[week-1][i].printCompletedMatch();
            else
                schedule[week-1][i].printFutureMatch();
        } //end for
    } //end print Schedule
}
