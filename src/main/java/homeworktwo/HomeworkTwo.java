package homeworktwo;

public class HomeworkTwo {

    public static void main(String[] args) {

    }

    // Задание 1
    static void arrayOne(int[]arr){

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1){
                arr[i] = 0;
            }else{
                arr[i] = 1;
            }
        }
    }

    // Задание 2
    static void arrayTwo(int[]arr){

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
    }

    // Задание 3
    static void arrayThree(int[]arr){

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 6) {
                arr[i] = arr[i] * 2;
            };
        }
    }

    // Задание 4
    static void fillDiagonally(int[][]arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i][arr.length - i - 1] = 1;
        }
    }

    // Задание 5
    static void minMaxValue(int[]arr){

        int MaxValue = arr.length;

        for (int i = 0; i < arr.length; i++) {
            int currVal = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (currVal > arr[j] && currVal > MaxValue){
                    MaxValue = currVal;
                }
            }
        }

        int MinValue = arr.length;
        for (int i = 0; i < arr.length; i++) {
            int currVal = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (currVal < arr[j] && currVal < MinValue){
                    MinValue = currVal;
                }
            }
        }

    }

    // Задание 6
    static boolean checkBalance(int[]arr){
        boolean result = false;
        for (int i = 1; i < arr.length - 1; i++) {
            int sumLeft = 0;
            for (int j = 0; j < i; j++) {
                sumLeft = sumLeft + arr[j];
            }

            int sumRight = 0;
            for (int j = arr.length - 1; j >= i ; j--) {
                sumRight = sumRight + arr[j];
            }

            if (sumLeft == sumRight){
                result = true;
                break;
            }
        }
        return result;
    }

    // Задание 7
    static void moveElements(int[]arr, int n){

        while (n != 0) {
            if (n > 0){
                int buffer = arr[0];
                for (int i = 1; i < arr.length; i++) {
                    arr[i-1] = arr[i];
                }
                arr[arr.length-1] = buffer;
                n--;
            }else{
                int buffer = arr[arr.length - 1];
                for (int i = arr.length - 2; i >= 0; i--) {
                    arr[i+1] = arr[i];
                }
                arr[0] = buffer;
                n++;
            }
        }
    }
}
