import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

public class MazeRunnerMax {
   public static Maze myMap = new Maze();
   public static Scanner reader = new Scanner(System.in);
   public static int userSteps = 0;

   public static void main (String[] args){
       intro();
       userMove();

   }

   public static void intro(){
       System.out.println("#### Welcome to Maze Runner 2.0 ####");
       System.out.println("Here is your local position");
       myMap.printMap();
   }

   public static String userMove () {
       while (!myMap.didIWin()) {
           System.out.println(userSteps);
           System.out.print("Where would you like to move? (R, L, U, D)");
           String direction = reader.next();
           userSteps++;
           if (direction.equalsIgnoreCase("R")) {
               if (myMap.canIMoveRight() == true) {
                   myMap.moveRight();
               } else {
                   if (myMap.isThereAPit(direction) == false){
                       System.out.println("Sorry, you’ve hit a wall.");
                   } else {
                       navigatePit(direction);
                   }
               }
           } else if (direction.equalsIgnoreCase("L")) {
               if (myMap.canIMoveLeft() == true) {
                   myMap.moveLeft();
               } else {
                   if (myMap.isThereAPit(direction) == false) {
                       System.out.println("Sorry, you’ve hit a wall.");
                   } else {
                       navigatePit(direction);
                   }
               }
           } else if (direction.equalsIgnoreCase("U")) {
               if (myMap.canIMoveUp() == true) {
                   myMap.moveUp();
               } else {
                   if (myMap.isThereAPit(direction) == false) {
                       System.out.println("Sorry, you’ve hit a wall.");
                   } else {
                       navigatePit(direction);
                   }
               }
           } else if (direction.equalsIgnoreCase("D")) {
               if (myMap.canIMoveDown() == true) {
                   myMap.moveDown();
               } else {
                   if (myMap.isThereAPit(direction) == false) {
                       System.out.println("Sorry, you’ve hit a wall.");
                   } else {
                       navigatePit(direction);
                   }
               }
           }
           if (userSteps == 100 && myMap.didIWin() == true) {
               movesMessage(userSteps);
               System.out.println("You was very close");
           } else if (userSteps == 100 && myMap.didIWin() == false){
               System.out.println("GAME OVER");
               System.out.println("You died here");
               myMap.printMap();
               break;
           } else if (myMap.didIWin() == true) {
               System.out.println("Congrats !!!!");
           }
           movesMessage(userSteps);
           myMap.printMap();
       }
       return "";
   }

   public static void movesMessage (int moves) {
       switch (moves){
           case 20:
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
       }
   }

   public static void navigatePit (String direction) {
       if (myMap.isThereAPit(direction) == true){
           System.out.print("Watch out! There's a pit ahead, jump it?");
           String decision = reader.next();
           if (decision.equalsIgnoreCase("y")){
               myMap.jumpOverPit(direction);
           } else return;

       }


   }

}
