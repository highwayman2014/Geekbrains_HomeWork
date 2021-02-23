package homeworkthree;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class HomeworkThree {

    private static String[] words;
    private static String password;
    private static int lastTry;
    private static Scanner scan;

    public static void main(String[] args) {

        initialization();
        boolean result = false;
        for (int currentTry = 0; currentTry < lastTry ; currentTry++) {
            printVariables();
            result = round(currentTry);
            if (result){
                System.out.println("Пароль введен успешно");
                break;
            }
        }
        if (!result){
            System.out.println("Превышено число попыток взлома");
        }

    }

    private static void initialization(){

        scan = new Scanner(System.in);

        lastTry = 7;

        System.out.println("GEEKBRAINS INDUSTRIES (TM) TERMLINK PROTOCOL");
        System.out.println("Введите пароль");

        words = new String[]{"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random random = new Random();
        password = words[random.nextInt(words.length)];

    }

    private static boolean round(int currentTry){
        String invitation;
        int leftTry = lastTry - currentTry;
        switch (leftTry){
            case 4:
            case 3:
            case 2:
                invitation = leftTry + " попытки осталось:";
                break;
            case 1:
                invitation = leftTry + " попытка осталась:";
                break;
            default:
                invitation = leftTry + " попыток осталось:";
                break;
        }

        System.out.println();
        System.out.println(invitation);
        String input = scan.nextLine();
        input = input.toLowerCase(Locale.ROOT);
        //scan.nextLine();
        if (input.equals(password)){
            return true;
        }

        String output = new String();
        for (int i = 0; i < password.length(); i++) {
            if (i>= input.length()){
                break;
            }

            char currentPasswordSymbol = password.charAt(i);
            char currentInputSymbol = input.charAt(i);
            if (currentPasswordSymbol == currentInputSymbol){
                output = output + currentPasswordSymbol;
            }else{
                output = output + "#";
            }
        }
        for (int i = 0; i < 15; i++) {
            output = output + "#";
        }
        System.out.println(output);

        return false;
    }

    private static void printVariables(){
        System.out.println();
        String printStr = "";
        for (String word:words) {
            if (!printStr.isEmpty()){
                printStr = printStr + ", ";
            }
            printStr = printStr + word;
            if (printStr.length() > 40){
                System.out.println(printStr);
                printStr = "";
            }
        }
        if (!printStr.isEmpty()){
            System.out.println(printStr);
        }
    }
}
