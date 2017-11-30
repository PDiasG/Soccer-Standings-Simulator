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
 * Last modified on 11/30/2017
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

        int size = input.nextInt(); //input for Championship's size
        input.nextLine(); //remove remaining "\n" from the buffer

        Team[] teams = new Team[size]; //initialize teams array

        for (int i = 0; i < size; i++) { //input for the team's name
            System.out.println("What is team #" + (i + 1) + " name?");
            Team t = new Team(input.nextLine());
            teams[i] = t;
        } //end of for

        Standings myStandings = new Standings(size, teams); //initialize the standings


    } //end of main method
}
