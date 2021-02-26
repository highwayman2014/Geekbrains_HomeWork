package homeworkfour;

import java.util.Scanner;
import java.util.Arrays;

public class HomeworkFour {

    private static char [][] map;
    private static final int SIZE = 5;
    private static final int SUCCESS_SCORE = 4;
    private static final char EMPTY_DOT = '•';
    private static final char X_DOT = 'X';
    private static final char O_DOT = 'O';
    private static Scanner sc;

    public static void main(String[] args) {

        initMap();
        printMap();
        while (true) {
            int[] currentCoordinates = humanTurn();
            printMap();
            System.out.println();
            if (checkWin(X_DOT, currentCoordinates)) {
                System.out.println("You win");
                break;
            }
            if (checkDraw()) {
                System.out.println("Draw");
                break;
            }
            currentCoordinates = computerTurn();
            printMap();
            System.out.println();
            if (checkWin(O_DOT, currentCoordinates)) {
                System.out.println("You lose");
                break;
            }
            if (checkDraw()) {
                System.out.println("Draw");
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {
            }
        }
    }

    private static boolean checkDraw() {
        for (char[] chars : map) {
            for (char aChar : chars) {
                if (aChar == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkWin(char c, int[]coordinates) {

        return chekHorizontal(c, coordinates, map, false) == SUCCESS_SCORE
                || chekVertical(c, coordinates, map, false) == SUCCESS_SCORE
                || chekDiagonals(c, coordinates, map, false) == SUCCESS_SCORE;

    }

    /*
    Проверяет возможную победу по горизонали после хода игрока
     */
    private static int chekHorizontal(char c, int[] coordinates, char[][] field, boolean checkProfit) {
        int row = coordinates[0];
        int score = 0;
        for (int i = 0; i < field[0].length; i++) {
            if (field[row][i] == c){
                score++;
                if(score == SUCCESS_SCORE){
                    return score;
                }
            }else if(checkProfit){
                if(field[row][i] != EMPTY_DOT){
                    score = 0;
                }
                continue;
            }else {
                score = 0;
            }
        }
        return score;
    }

    /*
    Проверяет возможную победу по вертикали после хода игрока
     */
    private static int chekVertical(char c, int[] coordinates, char[][] field, boolean checkProfit) {
        int col = coordinates[1];
        int score = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[i][col] == c){
                score++;
                if(score == SUCCESS_SCORE){
                    return score;
                }
            }else if(checkProfit){
                if(field[i][col] != EMPTY_DOT){
                    score = 0;
                }
                continue;
            }else {
                score = 0;
            }
        }
        return score;
    }

    /*
    Проверяет возможную победу по диагоналям после хода игрока
     */
    private static int chekDiagonals(char c, int[] coordinates, char[][] field, boolean checkProfit) {
        int row = coordinates[0];
        int col = coordinates[1];

        return Math.max(checkDiagonal(c, row, col, 1, field, checkProfit), checkDiagonal(c, row, col, -1, field, checkProfit));

    }

    /*
        direct = 1 - проверка диагонали слева-направо
        direct = -1 - проверка диагонали справа-налево
     */
    private static int checkDiagonal(char c, int row, int col, int direct, char[][] field, boolean checkProfit) {
        int score = 0;
        int currentRow = row;
        int currentCol = col;

        if (direct == 1){
            while (currentRow > 0 && currentCol > 0){
                currentRow--;
                currentCol--;
            }
            if(Math.abs(currentRow - currentCol) > field.length - SUCCESS_SCORE){
                return score;
            }
            while (currentRow < field.length && currentCol < field[0].length){
                if(field[currentRow][currentCol] == c){
                    score++;
                    if(score == SUCCESS_SCORE){
                        return score;
                    }
                }else if(checkProfit){
                    if(field[currentRow][currentCol] != EMPTY_DOT){
                        score = 0;
                    }
                    currentRow++;
                    currentCol++;
                    continue;
                }else {
                    score = 0;
                }
                currentRow++;
                currentCol++;
            }
        }else if(direct == -1){
            while (currentRow > 0 && currentCol < field[0].length - 1){
                currentRow--;
                currentCol++;
            }
            if(Math.abs(currentRow - (currentCol - SUCCESS_SCORE)) > field.length - SUCCESS_SCORE){
                return score;
            }
            while (currentRow < field.length && currentCol >= 0){
                if(field[currentRow][currentCol] == c){
                    score++;
                    if(score == SUCCESS_SCORE){
                        return score;
                    }
                }else if(checkProfit){
                    if(field[currentRow][currentCol] != EMPTY_DOT){
                        score = 0;
                    }
                    currentRow++;
                    currentCol--;
                    continue;
                }else {
                    score = 0;
                }
                currentRow++;
                currentCol--;
            }
        }
        return score;
    }

    private static int[] computerTurn() {

        // Найдем все имеющиеся ходы компьютера
        int [][] computerDots = findDotsOnField(O_DOT);
        // Определим выгоду от хода вокруг каждой точки компьютера
        int[] computerСoordinates = defineMaxProfit(computerDots, O_DOT);

        // Повторим то же самое для точек игрока
        int [][] humanDots = findDotsOnField(X_DOT);
        int[] humanСoordinates = defineMaxProfit(humanDots, X_DOT);

        // Определим лучий ход: продолжить свою цепочку, либо сбить цепочку игрока
        if (computerСoordinates[2] >= humanСoordinates[2]){
            map[computerСoordinates[0]][computerСoordinates[1]] = O_DOT;
            return new int[]{computerСoordinates[0], computerСoordinates[1]};
        }else{
            map[humanСoordinates[0]][humanСoordinates[1]] = O_DOT;
            return new int[]{humanСoordinates[0], humanСoordinates[1]};
        }

    }

    private static int[] humanTurn() {
        int xCoordinate = -1;
        int yCoordinate = -1;
        do {
            System.out.println("Введите координаты в формате x y");
            if (sc.hasNextInt()) {
                xCoordinate = sc.nextInt() - 1;
            }
            if (sc.hasNextInt()) {
                yCoordinate = sc.nextInt() - 1;
            }
            sc.nextLine();
        } while (!isValidCell(xCoordinate, yCoordinate));
        map[yCoordinate][xCoordinate] = X_DOT;
        return new int[]{yCoordinate, xCoordinate};
    }

    private static boolean isValidCell(int x, int y) {
        if (x < 0 || y < 0 || x > map.length - 1 || y > map.length - 1) {
            return false;
        }
        return map[y][x] == EMPTY_DOT;
    }

    private static void printMap() {

        System.out.print("  ");
        for (int i = 1; i <= map.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        int rowNumber = 1;
        for (char[] chars : map) {
            System.out.print(rowNumber + " ");
            rowNumber++;
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    private static void initMap() {
        sc = new Scanner(System.in);
        map = new char[SIZE][SIZE];
        for (char[] chars : map) {
            Arrays.fill(chars, EMPTY_DOT);
        }

    }

    /*
        Возращает список координат найденных на поле точек
        с - искомый символ
    */
    private static int[][] findDotsOnField(char c){

        int[][] listCoordinates = new int[SIZE*SIZE][2];
        int counter = 0;
        int currentRow = 0;
        for (char[]rows:map) {
            int currentCol = 0;
            for (char currentDot:rows) {
                if(currentDot == c){
                    listCoordinates[counter][0] = currentRow;
                    listCoordinates[counter][1] = currentCol;
                    counter++;
                }
                currentCol++;
            }
            currentRow++;
        }
        while (counter < listCoordinates.length){
            listCoordinates[counter][0] = -1;
            counter++;
        }

        return listCoordinates;
    }

    private static int[] defineMaxProfit(int[][]currentDots, char c){

        int[] result = new int[3];
        int profit = 0;
        for (int i = 0; i < currentDots.length; i++) {
            if (currentDots[i][0] == -1){
                break;
            }

            int currentRow = currentDots[i][0];
            int currentCol = currentDots[i][1];

            for (int j = -1; j <= 1 ; j++) {
                if (currentRow + j < 0 || currentRow + j >= map.length){
                    continue;
                }
                for (int k = -1; k <= 1; k++) {
                    if (currentCol + k < 0 || currentCol + k >= map[0].length){
                        continue;
                    }
                    if (map[currentRow + j][currentCol + k] != EMPTY_DOT){
                        continue;
                    }
                    if (currentRow + j == currentRow && currentCol + k == currentCol){
                        continue;
                    }
                    int currentProfit = defineProfit(currentRow + j, currentCol + k, c);
                    if (currentProfit > profit){
                        profit = currentProfit;
                        result[0] = currentRow + j;
                        result[1] = currentCol + k;
                        result[2] = profit;
                    }
                }
            }
        }
        return result;
    }

    private static int defineProfit(int row, int col, char c){

        char[][] field = new char[map.length][map.length];
        for (int i = 0; i < map.length; i++) {
            field[i] = Arrays.copyOf(map[i], map[i].length);
        }
        field[row][col] = c;

        int score = 0;
        int scoreHorizontal = chekHorizontal(c,new int[]{row, col}, field, true);
        score = Math.max(score, scoreHorizontal);
        int scoreVertical = chekVertical(c, new int[]{row, col}, field, true);
        score = Math.max(score, scoreVertical);
        int scoreDiagonals = chekDiagonals(c, new int[]{row, col}, field, true);
        score = Math.max(score, scoreDiagonals);

        return score;
    }

}
