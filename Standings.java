/*
 *
 * Soccer Standings Simulator
 *
 * Standings.java
 *
 * Created by PDiasG
 * garci455@purdue.edu
 *
 * Last modified on 12/5/2017
 *
 */

/*
 *
 * Standing class, contains the methods for creating, organizing and print the Championship standing
 *
 */

public class Standings {
    private int size;
    private Team[] teamList;

    //constructor for Standings
    public Standings(int size, Team[] teamList) {
        this.size = size;
        this.teamList = teamList;
    } //end of constructor

    //order team list according to each team's points earned
    private void orderTeamList() {
        //TODO check for tie-breaking criteria
        Team temporaryTeam;

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (this.teamList[j] != null && this.teamList[j + 1] != null && this.teamList[j].getPoints() > this.teamList[j + 1].getPoints()) {
                    temporaryTeam = this.teamList[j];
                    this.teamList[j] = this.teamList[j + 1];
                    this.teamList[j + 1] = temporaryTeam;
                } //end of if
            } //end of for
        } //end of for
    }//end of orderTeamList method

    //print formatted Championship standings
    public void printStandings() {
        orderTeamList(); //order the teams before printing

        System.out.println("    Team       MP   W   D   L   GF  GA  GD  Pts"); //print header of table

        for (int i = size - 1; i >= 0; i--) { //print every teams current stats
                                              //the last index of teamList contains the team with more points
                System.out.printf("%2d. %-10s %3d %3d %3d %3d %3d %3d %3d %3d\n", size - i, this.teamList[i].getName(),
                    this.teamList[i].getGamesPlayed(), this.teamList[i].getVictories(),
                    this.teamList[i].getDraws(), this.teamList[i].getDefeats(),
                    this.teamList[i].getGoalsScored(), this.teamList[i].getGoalsConceded(),
                    this.teamList[i].getGoalsDifference(), this.teamList[i].getPoints());
        } //end of for
    } //end of printStandings method
}
