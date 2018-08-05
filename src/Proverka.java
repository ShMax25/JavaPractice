////import java.util.Scanner;
////
////public class Proverka {
////    public static void main (String[] args){
////        Scanner input =new Scanner(System.in);
////        System.out.print("Enter:");
////        int key = input.nextInt();
////
////
////
////        String finish = "asdsaqasf";
////        String group = "";
////
////
////
////
////        String temp = "";
////        for (char leter : finish.toCharArray()){
////            temp = temp + leter;
////            if (temp.length()%key == 0) {
////                group = group + temp + " ";
////                temp = "";
////            }
//////            else if (){
//////                int extraLeter = temp.length()/key;
//////                group = group + temp;
//////                for (int i = 0;  i == extraLeter; i++){
//////                    group = group + "x";
//////                }
//////            }
////        }
////        if (finish.length()%key != 0){
////            int result = finish.length()%key;
////            String extra = "x";
////            group = group+finish.substring(finish.length() - result);
////            for (int i = 0; i < (key-result); i++){
////                group = group + extra;
////            }
////        }
////
////
////
////
////        System.out.println(group);
////    }
////}
////
////
//import java.awt.*;
//import java.util.*;
////import java.io.*;
//
//public class Proverka {
//    public static void main(String[] args) {
//        System.out.println("Methods of encrypting and decrypting text");
//
//        Scanner input = new Scanner(System.in);
//        System.out.print("Write text: ");
//        String text = input.nextLine();
//
//        //Part 1 - Normalize Text
//        System.out.println(text = normalizeText(text));
//
//        //Part 2 - Caesar Cipher
//        System.out.print("Enter shift value: ");
//        int shiftValue = input.nextInt();
//        System.out.println(caesarify(text, shiftValue));
//
//        //Part 3 - Code Groups
//        System.out.print("Enter size to make code groups: ");
//        int groupSize = input.nextInt();
//        String codeGroupedString = groupify(text, groupSize);
//
//        //Part 4 - Putting it all together
//        System.out.println("Encrypting string... ");
//        String cypherText = encryptString(text,shiftValue,groupSize);
//        System.out.println(cypherText);
//
//        //Part 5 - Hacker Problem - Decrypt
//        ungroupify(codeGroupedString);
//        System.out.println("Decrypting string...");
//        String plainText = decryptString(cypherText,shiftValue);
//        System.out.println(plainText);
//    }
//
//    public static String normalizeText(String t){
//        String temp = "";
//
//        //Removes all the spaces from your text
//        // & Remove any punctuation (. , : ; ’ ” ! ? ( ) )
//        temp = t.replaceAll("[\\s.,:;'!?()\"]", "");
//
//        //Turn all lower-case letters into upper-case letters
//        temp = temp.toUpperCase();
//        return temp;
//    }
//
//    public static String caesarify(String t, int sValue){
//        String temp = shiftAlphabet(sValue);
//        //Encrypting normalized text to encrypted key
//        temp = t.replace(t,temp);
//        return temp;
//    }
//
//    public static String shiftAlphabet(int shift) {
//        int start = 0;
//        if (shift < 0) {
//            start = (int) 'Z' + shift + 1;
//        } else {
//            start = 'A' + shift;
//        }
//        String result = "";
//        char currChar = (char) start;
//
//        for(; currChar <= 'Z'; ++currChar) {
//            result = result + currChar;
//        }
//        if(result.length() < 26) {
//            for(currChar = 'A'; result.length() < 26; ++currChar) {
//                result = result + currChar;
//            }
//        }
//        return result;
//    }
//
//    public static String groupify(String t, int n){
//        //Break the string according to given number of group size
//        String temp = "";
//        int count = 0;
//        for(int i = 0; i < t.length(); i++) {
//            if (i % n == 0 && i != 0) {     //It means if iterator value and number of letters value is same
//                temp = temp + " ";
//            }
//            temp = temp + t.charAt(i);
//        }
//        //For loop to know how many x's are needed
//        //Count from last space till last index
//        for(int i = temp.lastIndexOf(" ")+1; i < temp.length(); i++) {
//            ++count;
//        }
//        //Append x's at the last
//        for(int i = n - count; i > 0; i--){
//            temp += "x";
//        }
//        return temp;
//    }
//
//    public static String encryptString(String t, int sValue, int n)
//    {
//        String temp = "";
//        temp = normalizeText(t);
//        temp = caesarify(t,sValue);
//        temp = groupify(t,n);
//
//        return temp;
//    }
//
//    public static String ungroupify(String groupedStr){
//        String temp = groupedStr.replaceAll("[\\sx]", "");
//        return temp;
//    }
//
//    public static String decryptString(String t, int sValue){
//        return ungroupify(t);
//    }
//}

import java.util.*;

public class Proverka {
    public static Maze myMap = new Maze();
    public static int userSteps = 0;

    public static void main(String[] args) {
        //Part 1 - Let the user solve the maze

        intro();

        // Returns true if the mentioned space is free, false if there is a wall
        while (myMap.didIWin() == false) {
            //Part 2
            String userDirection = userMove();
            //Part 3 – Watch out for pits
            if (userDirection.equals("R") || userDirection.equals("L") || userDirection.equals("U") || userDirection.equals("D"))
                navigatePit(userDirection);
        }
        if (myMap.didIWin() == true) {
            System.out.print("Congratulations, you made it out alive!");
            System.out.println("and you did it in " + Proverka.userSteps + " moves");
        }
    }

    public static void intro() {
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position:");
        myMap.printMap();
    }

    public static void movesMessage(int moves) {
        switch (moves) {
            case 50:
                System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
                break;
            case 75:
                System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
                break;
            case 90:
                System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
                break;
            case 100:
                System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
                break;
            case 101:
                System.out.println("Sorry, but you didn't escape in time- you lose!");
                System.exit(0);
                break;
            default:
                //System.out.println("TOTAL MOVES: " + moves);
                break;
        }
    }

    public static String userMove() {
        Scanner input = new Scanner(System.in);
        String direction = "";
        do {
            if (Proverka.userSteps != 101) {
                System.out.print("Where would you like to move? (R, L, U, D)    ");
                direction = input.next();
            }

            if (direction.equals("R") || direction.equals("L") || direction.equals("U") || direction.equals("D")) {
                //Part 2 – Move Limit
                movesMessage(++Proverka.userSteps);

                if (myMap.canIMoveRight() == true && direction.equals("R")) {
                    myMap.moveRight();
                } else if (myMap.canIMoveLeft() == true && direction.equals("L")) {
                    myMap.moveLeft();
                } else if (myMap.canIMoveUp() == true && direction.equals("U")) {
                    myMap.moveUp();
                } else if (myMap.canIMoveDown() == true && direction.equals("D")) {
                    myMap.moveDown();
                } else {
                    if (Proverka.userSteps != 101) {
                        System.out.println("Sorry, you've hit a wall.");
                        System.out.print("Where would you like to move? (R, L, U, D)    ");
                        direction = input.next();
                        //Part 2 – Move Limit
                        movesMessage(++Proverka.userSteps);
                    }
                }

                myMap.printMap();
                break;
            }
        } while (direction.matches("[RLUD]") == false);

        return direction;
    }

    public static void navigatePit(String userDirection) {
        Scanner input = new Scanner(System.in);
        if (myMap.isThereAPit(userDirection) == true) {
            System.out.print("Watch out! There's a pit ahead, jump it?  ");
            String jump = input.next();
            if (jump.equalsIgnoreCase("yes") || jump.equalsIgnoreCase("y"))
                myMap.jumpOverPit(userDirection);
            else {
                System.out.println("Sorry, but you didn't jump- you lose!");
                System.exit(0);
            }
        } else {
            System.out.println("Sorry, you've hit a wall.");
        }
    }
}