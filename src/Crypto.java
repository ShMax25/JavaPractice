import java.util.Scanner;

public class Crypto {
    public static void main(String[] arg) {
        greatings();


    }
    public static void greatings (){
        System.out.println("##############################################################");
        Scanner input = new Scanner(System.in);
        System.out.print("Hi Caesar !!! Please enter a message which you want to encrypt: ");
        String text = input.nextLine();
        System.out.println("--------------------------------------------------------------");
        System.out.print("Please enter the Key:");
        int key = input.nextInt();
        System.out.println("--------------------------------------------------------------");
        System.out.print("Enter group length:");
        int groupLength = input.nextInt();
        System.out.println("--------------------------------------------------------------");

        cryptoString(text, key, groupLength);


    }

    public static void cryptoString (String text, int key, int groupLength) {
        String pureText = normalizeText(text);
        String encryptedText = caesarify(pureText, key);
        groupify(encryptedText, groupLength);
    }

    public static String normalizeText(String text) {

       String pureLetters = text.replaceAll("[^A-Za-z]+", "");
       pureLetters = pureLetters.toUpperCase();
       return pureLetters;
    }

    public static String caesarify(String text, int key) {

        char[] textArray = text.toCharArray();
        String finish = "";
        for (char letter : textArray) {

            int begining = 0;
            if (key < 0) {
                begining = (int) letter + key + 1;
            } else {
                begining = letter + key;
            }
            char newChar = (char) begining;
            finish = finish + newChar;


        }

        System.out.println(finish);
        return finish;

    }

    public static void groupify (String finish, int groupLength){

        String group = "";

        String temp = "";
        for (char leter : finish.toCharArray()){
            temp = temp + leter;
            if (temp.length()%groupLength == 0) {
                group = group + temp + " ";
                temp = "";
            }
        }
        if (finish.length() % groupLength != 0){
            int result = finish.length() % groupLength;
            String extra = "x";
            group = group+finish.substring(finish.length() - result);
            for (int i = 0; i < (groupLength - result); i++){
                group = group + extra;
            }

        }

        System.out.println(group);


    }


}