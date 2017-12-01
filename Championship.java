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

        Team[] teams = new Team[size]; //initialize teams array

        for (int i = 0; i < size; i++) { //input for the team's name
            System.out.println("What is team #" + (i + 1) + " name?");
            Team t = new Team(input.nextLine());
            teams[i] = t;
        } //end of for

        Standings myStandings = new Standings(size, teams); //initialize the standings

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
                    break;
                case 2: //simulate next round
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
