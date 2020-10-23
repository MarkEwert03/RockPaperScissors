//Mark Ewert :)
//Oct 20, 2020

import java.util.Scanner;
import java.util.InputMismatchException;

class Game{
    //Variables
    static Scanner sc = new Scanner(System.in);
    static String myObj = "", CPUObj = "";
    static int myChoice = 0, CPUChoice = 0;
    static final int ROCK = 1, PAPER = 2, SCISSORS = 3;
    static final int WIN = 1, TIE = 2, LOSE = 3;
    static int wins = 0, ties = 0, losses = 0;
    static String response = "Y";
    static int outcome = 0;

    public static void main(String[] args){
        System.out.println("RPS 1.0");
        System.out.println("*******************************************");
        System.out.println("Good luck, human...");
        System.out.println("");
        while (response.equals("Y")){
            loop();
        }
        System.out.println("Good Game! Thanks for playing");
        System.out.println("*******************************************");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Ties: " + ties);
    }

    public static void loop(){
        human();
        computer();
        System.out.print("You threw " + myObj + "! ");
        System.out.println("I threw " + CPUObj + "!");
        decision();
        result();
    }

    public static void human(){
        System.out.print("What do you throw? ");
        System.out.print("[1] Rock, [2] Paper, [3] Scissors ");

        try {
            myChoice = sc.nextInt();
            if (myChoice == ROCK) myObj = "rock";
            else if (myChoice == PAPER) myObj = "paper";
            else if (myChoice == SCISSORS) myObj = "scissors";
            else human();
        } catch (InputMismatchException ime){
            sc.next();
            human();
        }

    }

    public static void computer(){
        CPUChoice = (int)(Math.random()*3)+1;
        if (CPUChoice == ROCK) CPUObj = "rock";
        else if (CPUChoice == PAPER) CPUObj = "paper";
        else if (CPUChoice == SCISSORS) CPUObj = "scissors";
    }

    public static void decision(){
        //WIN refers to the computer winning
        if (myChoice == ROCK && CPUChoice == SCISSORS) outcome = LOSE;
        else if (myChoice == ROCK && CPUChoice == PAPER) outcome = WIN;
        else if (myChoice == PAPER && CPUChoice == ROCK) outcome = LOSE;
        else if (myChoice == PAPER && CPUChoice == SCISSORS) outcome = WIN;
        else if (myChoice == SCISSORS && CPUChoice == PAPER) outcome = LOSE;
        else if (myChoice == SCISSORS && CPUChoice == ROCK) outcome = WIN;
        else if (myChoice == CPUChoice) outcome = TIE;
        else System.out.println("Something went wrong chief...");

    }

    public static void result(){
        if (outcome == WIN) {
            wins++;
            System.out.println("I win! You are noy a challange for me...");
        }
        else if (outcome == TIE) {
            ties++;
            System.out.println("A draw... pretty good, human! I demand a rematch...");
        }
        else if (outcome == LOSE) {
            losses++;
            System.out.println("Whaaa??... You beat me? RAGE!");
        }
        System.out.println("");
        response = "";
        while (!response.equals("Y") && !response.equals("N")){
            System.out.print("Play again? [Y,N] ");
            response = sc.next().toUpperCase();
        }
        System.out.println("");
    }
}