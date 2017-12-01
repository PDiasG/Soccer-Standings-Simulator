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
 * Last modified on 12/01/2017
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

    public void generateSchedule() {
        //generate a list with all matches
        ArrayList<Match> allMatches = new ArrayList<>();
        for (int i = 0; i < this.teams.length; i++) {
            for (int j = i + 1; j < this.teams.length; j++) {
                allMatches.add(new Match(teams[i], teams[j]));
            }//end of for
        }//end of for

        //add matches to schedule
        //TODO generate algorithm  to add as many matches as you need to
        addMatch(allMatches.get(0), 0, 0);
        addMatch(allMatches.get(1), 1, 0);
        addMatch(allMatches.get(2), 2, 0);
    }

    //print schedule
    public void printSchedule(int week) {
        for (int i = 0; i < schedule[week - 1].length; i++) {
            System.out.print("Match #" + i+1 + ": ");
            if (schedule[week-1][i].isPlayed())
                schedule[week-1][i].printCompletedMatch();
            else
                schedule[week-1][i].printFutureMatch();
        } //end for
    } //end print Schedule
}
