package homeworkone;

public class HomeworkOne {

    byte type_byte = 127;
    short type_short = -15150;
    int type_int = 25;
    long type_long = 500000000000L;
    float type_float = -25.3f;
    double type_double = 256.88;
    char type_char = '*';
    boolean type_boolean = false;

    public static void main(String[] args) {

        // Задание 3
        float a = 2f;
        float b = 10.5f;
        float c = 16f;
        float d = -2f;
        float Item3Result = item_3_func(a, b, c, d);
        System.out.println("Задание 3: " + a + " * (" + b + " + (" + c + " / " + d + ")) = " + Item3Result);

        // Задание 4
        // Результат Истина
        boolean Item4Result = item_4_func((int)a, (int)b);
        System.out.println("Задание 4: " + (int)a + " + " + (int)b + " >=10 и <=20 - " + Item4Result);

        // Результат Ложь
        Item4Result = item_4_func((int)b, (int)c);
        System.out.println("Задание 4: " + (int)b + " + " + (int)c + " >=10 и <=20 - " + Item4Result);

        // Задание 5
        item_5_func((int)a);
        item_5_func((int)d);

        // Задание 6
        boolean Item6Result = item_6_func((int)a);
        System.out.println("Задание 6: " + (int)a + " - " + Item6Result);

        Item6Result = item_6_func((int)d);
        System.out.println("Задание 6: " + (int)d + " - " + Item6Result);

        // Задание 7
        String name = "Медвед";
        item_7_func(name);

        // Задание 8
        YearIsALeap(2021);
        YearIsALeap(2000);
        YearIsALeap(1996);
        YearIsALeap(1990);
    }

    // Задание 3
    public static float item_3_func(float a, float b, float c, float d){
        return a * (b + (c / d));
    }

    // Задание 4
    public static boolean item_4_func(int a, int b){
        return a + b >= 10 && a + b <= 20;
    }

    // Задание 5
    public static void item_5_func(int a) {
        if (a < 0){
            System.out.println("Задание 5: " + a + " - отрицательное число");
        }else{
            System.out.println("Задание 5: " + a + " - положительное число");
        }
    }

    // Задание 6
    public static boolean item_6_func(int a) {
        if (a < 0){
            return true;
        }else{
            return false;
        }
    }

    // Задание 7
    public static void item_7_func(String name){
        System.out.println("Задание 7: Привет, " + name);
    }

    // Задание 8
    public static void YearIsALeap(int year_number){
        String result;
        if(year_number % 4 == 0 && (year_number % 100 != 0 || year_number % 400 == 0)){
            result = "високосный год";
        }else{
            result = "невисокосный год";
        }

        System.out.println("Задание 8: " + year_number + " - " + result);

    }
}
