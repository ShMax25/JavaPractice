import java.util.Scanner;
import java.util.Random;

public class OddsAndEvens {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random number = new Random();

        System.out.println("Let's play a game called \"Odds and Evens\".");
        System.out.print("What is your name? ");
        String name = input.next();
        System.out.print("Hi " + name + ", which do you choose? (O)dds or (E)vens?");
        String choose = input.next();

        if (choose.equals("o")) {
            System.out.println(name + " has picked odds! The computer will be evens.");
        } else if (choose.equals("e")) {
            System.out.println(name + " has picked evens! The computer will be odds.");
        } else {
            System.out.print("Please enter \"O\" or \"E\"" );
        }

        lines();

        System.out.print("How many \"fingers\" do you put out?");
        int userFingers = input.nextInt();
        int compFingers = number.nextInt(6);
        System.out.println("The Computer plays " + compFingers + " \"fingers\"");
        lines();
        gameLogic(userFingers, compFingers, name, choose);


    }

    public static void lines() {
        System.out.println("----------------------------------------------------------");
    }


    public static void gameLogic(int userFingers, int compFingers, String name, String choose) {
        int sum = compFingers + userFingers;
        System.out.println(userFingers + " + " + compFingers + " = " + sum);
        if (sum % 2 == 0) {
            System.out.println(sum + " is ...even!");
            if (choose.equals("e")) {
                System.out.print("That means " + name + " wins!");
            } else {
                System.out.print("That means Computer wins!");
            }

        } else {
            System.out.println(sum + " is ...odd!");
            if (choose.equals("o")) {
                System.out.print("That means " + name + " wins!");
            } else {
                System.out.print("That means Computer wins!");
            }
            lines();
        }


    }
}