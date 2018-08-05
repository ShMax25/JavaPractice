import java.text.DecimalFormat;
import java.util.Scanner;


public class TripPlaner {
    public static void main(String[] args){

        greatings();
        stars();
        timeAndMoney();
        stars();
        timeDifferenc();
        stars();
        countryArea();
        stars();
    }

    public static void greatings() {

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("Nice to meet you "+name+", where are you travelling to?");
        String destination = input.next();
        System.out.println("Great! "+destination+" sounds like a great trip");

    }

    public static void stars() {
        System.out.println("*********************************************************");
        System.out.println();
    }

    public static void timeAndMoney () {

        int hours = 24;
        int minutes = 60;

        Scanner input = new Scanner(System.in);
        System.out.print("How many days are you going to spend travelling?");
        int days = input.nextInt();
        System.out.print("How much money, in USD, are you planning to spend on your trip?");
        int money = input.nextInt();
        System.out.print("What is the three letter currency symbol for your travel destination?");
        String currency = input.next();
        System.out.print("How many "+currency+" are there in USD?");
        Double conversion = input.nextDouble();
        System.out.println();
        System.out.println("If you are travelling for "+days+" days that is the same as "+(days*hours)+" hours or "+(days*hours*minutes)+" minutes");
        System.out.println("If you are going to spend $"+money+" USD that means per day you can spend up to $"+(money/(double)days)+" USD");
        System.out.println("Your total budget in "+currency+" is "+(money*conversion)+" "+currency+", which per day is "+(((money*conversion)/days))+" "+currency);

    }

    public static void timeDifferenc() {

        int noon = 12;
        int midnight = 24;
        int hours = 24;

        Scanner input = new Scanner(System.in);
        System.out.print("What is the difference, in hours, between your home and your destination?");
        int timediff = input.nextInt();
        System.out.println("It means that when it is midnight at home it will be "+(midnight+timediff)%hours+":00 in your travel destination and when it is noon at home it will be "+(noon+timediff)%hours+":00");
    }

    public static void countryArea() {

        double divider = 2.59000259;

        Scanner input = new Scanner(System.in);
        System.out.print("What is the square area of your destination country in km?");
        int area = input.nextInt();
        System.out.println("In miles2 that is "+((int)(area/divider))*100/(double)100);
    }

    public static void howFar () {

    }

}
