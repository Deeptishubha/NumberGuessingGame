package com.basics;
import java.util.*;
public class NumberGuessingGame {

    // the guessing game logic
    public static boolean checkGuess(Scanner sc,int maxAttempts){
        int number=(int)((Math.random())*100) +1;
        int attempts=0;
        System.out.println("I have selected a number between 1 to 100.Can you guess it?");
        System.out.println("You have " +maxAttempts+" attempts. Good luck!");
        System.out.println("------------------------------------------------------------------------------");
        do {
            System.out.println("Guess your number:");
            if(sc.hasNextInt()){
                int guessNumber=sc.nextInt();
                attempts++;
                if(guessNumber == number){
                    System.out.println("WOO HOO! CORRECT NUMBER");
                    System.out.println("GAME OVER");
                    System.out.println("-----------------------------------------------------------------------");
                    return true;//won = true
                }
                else if (guessNumber > number) {
                    System.out.println("Too high! Try again.");
                }
                else {
                    System.out.println("Too low! Try again.");
                }
                System.out.println("Attempts left ="+ (maxAttempts-attempts));}
            else {
                System.out.println("That is not a number.Try again.");
                sc.next();//clear the buffer
            }
        }while ( attempts<maxAttempts);

        System.out.println("Sorry! Out of attempts.The number was : "+number);
        return false;//won = false
    }

    //selecting the difficulty level of the code
    public static int difficultyLevel(Scanner sc){
        System.out.println("Select the level you want to play:\n1.Easy -10 attempts \n2.Hard -5 attempts");
        String level= sc.next().toLowerCase();
        if(level.equals("1") || level.startsWith("e")){
            System.out.println("You have selected the easy level.");
            return 10;
        } else if (level.equals("2") || level.startsWith("h")) {
            System.out.println("You have selected the hard level.");
            return 5;
        }
        else {
            System.out.println("Invalid choice.Level set to default.");
            return 7;
        }


        //the main
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean playAgain=true;
        int totalWins=0;
        System.out.println("WELCOME TO THE NUMBER GUESSING GAME");
        System.out.println("--------------------------------------------------------------------");
        while (playAgain) {
            int maxAttempts = difficultyLevel(sc);//calling the difficulty level method
            boolean won = checkGuess(sc, maxAttempts);//calling the guessing method
            if (won)
                totalWins++;

            System.out.println("Total wins : " + totalWins);
            System.out.println("Do you want to play again? yes/no");
            String response = sc.next().toLowerCase(Locale.ROOT);
            if (response.startsWith("n")) {
                playAgain = false;
            }
        }
        System.out.println("THANK YOU FOR PLAYING");
        System.out.println("----------------------------------------------------------------------------");

        sc.close();
    }}

