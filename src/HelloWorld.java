import java.util.Scanner;

/*
This how I start my
practice in Java
 */

public class HelloWorld {
    public static void main (String[] args) {
        myFirstMethod();
        mySecondMethod();
        calculation();
        learningScaner();
    }

    public static void myFirstMethod () {
        System.out.println("Hello  World");
    }

    public static void mySecondMethod () {
        int one = 1;
        int two = 2;
        int result = one + two;
        System.out.println(result);
    }

    public static void calculation() {
        int a = 8;
        double b = 5.0;
        double c = b;
        a = a + 1;
        b = a / b;
        c = 23 % 24;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public static void learningScaner() {

        Scanner input = new Scanner(System.in);
        String age = input.next();
        System.out.println(age);
        Double vartest = input.nextDouble();
        System.out.println(vartest);
    }

}
