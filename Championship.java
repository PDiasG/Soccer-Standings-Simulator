import java.util.Scanner;

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

public class Championship {
    //main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //initialize Scanner

        System.out.println("Welcome to Soccer Standings Simulator");
        System.out.println("What is your new Championship name?");

        String name = input.nextLine(); //input for Championship's name

        System.out.println("How many teams are there in " + name + "?");

        int size; //initialize championship size

        while (true) //check if the input for size is a number greater than 0
            try {
                size = Integer.parseInt(input.nextLine()); //input for Championship's size
                if (size > 0)
                    break;
                else
                    System.out.println("Invalid input: number of teams must be greater than 0");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: number of teams must be a number");
            }

        int numRounds = size%2 == 0? size - 1: size; //initialize number of rounds
        int matchesPerRound = size%2 == 0? size/2:(size - 1)/2; //initialize number of matches per rounds
        int week = 1; //initialize week count

        Team[] teams = new Team[size]; //initialize teams array

        for (int i = 0; i < size; i++) { //input for the team's name
            System.out.println("What is team #" + (i + 1) + " name?");
            Team t = new Team(input.nextLine());
            teams[i] = t;
        } //end of for

        Standings myStandings = new Standings(size, teams); //initialize the standings
        Schedule mySchedule = new Schedule(numRounds, matchesPerRound, teams); //initialize the schedule

        mySchedule.generateSchedule(size); // generate schedule

        System.out.println("The Championship is ready to begin!");
        System.out.println("-----------------------------------");

        int choice = 0; //initialize main loop control

        //main loop
        while (choice != 4) {
            //print player options
            System.out.println("What would you like to do next?");
            System.out.println("1. See schedule");
            System.out.println("2. Simulate next round");
            System.out.println("3. See standings");
            System.out.println("4. Exit");
            //end of options

            try {
                choice = Integer.parseInt(input.nextLine()); //input for player's choice
            }
            catch (NumberFormatException e) {
                choice = -1;
            } //check if the input is actually a number

            //perform different actions accordingly to the players choice
            switch (choice) {
                case 1: //see schedule
                    String c; //menu navigator for schedule
                    int weekExhibit = week > numRounds? numRounds:week;
                    do {
                        System.out.println("Week " + weekExhibit + "/" + numRounds); //print schedule
                        mySchedule.printSchedule(weekExhibit);                       //print schedule
                        do { //input for menu navigator
                            System.out.println("[N]ext week \n[P]revious week\n[B]ack");
                            c = input.nextLine();
                        } while(!c.equalsIgnoreCase("N") && !c.equalsIgnoreCase("P") && !c.equalsIgnoreCase("B"));
                        switch (c) {
                            case "N": case "n":
                                if (weekExhibit < numRounds)
                                    weekExhibit += 1;
                                break;
                            case "P": case "p":
                                if (weekExhibit > 1)
                                    weekExhibit -= 1;
                                break;
                        }
                    } while (!c.equalsIgnoreCase("B"));
                    break;
                case 2: //simulate next round
                    if (week <= numRounds) {
                        Team[] tempTeams; //temporary array to store the teams that are playing
                        int j;
                        for (int i = 0; i < matchesPerRound; i++) { //iterate through every game of the round
                            tempTeams = mySchedule.getMatch(week, i).simulate(); //simulate the game
                            for (j = 0; j < size; j++) { //checks for the position of home team
                                if (teams[j].getName().equals(mySchedule.getMatch(week, i).getTeamHome().getName())) {
                                    break;
                                }//end of if
                            }//end of for
                            teams[j] = tempTeams[0];
                            for (j = 0; j < size; j++) { //checks for the position of away team
                                if (teams[j].getName().equals(mySchedule.getMatch(week, i).getTeamAway().getName())) {
                                    break;
                                }//end of if
                            }//end of for
                            teams[j] = tempTeams[1];
                        }//end of for
                        week++; //advance week
                    }
                    break;
                case 3: //print standings
                    myStandings.printStandings();
                    break;
                case 4: //exit the game
                    break;
                default: //number out of bound
                    System.out.println("Option chosen is invalid! Please enter a number between 1 and 4");
                    break;
            } //end of switch

            System.out.println(); //break a line after every iteration

        } //end of main loop

    } //end of main method
}
