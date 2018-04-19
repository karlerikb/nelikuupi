import java.util.Scanner;
import java.util.Arrays;

class MainGame {
    static char[] row4Chars = new char[] {' ', ' ', ' ', ' '};
    static char[] row3Chars = new char[] {' ', ' ', ' ', ' '};
    static char[] row2Chars = new char[] {' ', ' ', ' ', ' '};
    static char[] row1Chars = new char[] {'_', '_', '_', '_'};

    int[] row4Ints = new int[] {0, 0, 0, 0};
    int[] row3Ints = new int[] {0, 0, 0, 0};
    int[] row2Ints = new int[] {0, 0, 0, 0};
    int[] row1Ints = new int[] {0, 0, 0, 0};

    public static void main(String[] args) {
        MainGame mg = new MainGame();
        mg.getInput();
    }

    void getInput() {
        // instructions
        System.out.println("Sisesta tulp: ");

        // input scanner
        int i = 0;
        while (i < 5) {
            Scanner sc = new Scanner(System.in);
            i = sc.nextInt();
            printGameTable(i);
        }
    }

    void printGameTable(int column) {
        String row1 = "", row2 = "", row3 = "", row4 = "";
        System.out.println("printGameTable: " + Arrays.toString(row1Ints));
        System.out.println("row1Ints[column]: " + row1Ints[column]);

        if (row1Ints[column] != 0) {
            row4 = "|   |   |   |   |";
            row3 = "|   |   |   |   |";
            row2 = "|   |   |   |   |";
            System.out.println(Arrays.toString(row1Chars));
            row1 = returnGameRow1(column);
            System.out.println(Arrays.toString(row1Chars));
            System.out.println("row1");
            row1Ints[column] = 1;
        } else if (row2Ints[column] != 0) {
            row4 = "|   |   |   |   |";
            row3 = "|   |   |   |   |";
            row2 = returnGameRow2(column);
            row1 = returnGameRow1(column);
            System.out.println("row2");
            row2Ints[column] = 1;
        } else if (row3Ints[column] != 0) {
            row4 = "|   |   |   |   |";
            row3 = returnGameRow3(column);
            row2 = returnGameRow2(column);
            row1 = returnGameRow1(column);
            System.out.println("row3");
            row3Ints[column] = 1;
        } else {
            row4 = returnGameRow4(column);
            row3 = returnGameRow3(column);
            row2 = returnGameRow2(column);
            row1 = returnGameRow1(column);
            System.out.println("row4");
            row4Ints[column] = 1;
            System.out.println("row4Ints[column]: " + row4Ints[column]);
        }
        
        System.out.println();
        System.out.println(row4 + "\n" + row3 + "\n" + row2 + "\n" + row1);
        System.out.println();
    }

    String returnGameRow1(int column) {
        switch(column) {
            case 1: row1Chars[0] = 'x'; break;
            case 2: row1Chars[1] = 'x'; break;
            case 3: row1Chars[2] = 'x'; break;
            case 4: row1Chars[3] = 'x'; break;
        }

        String column1 = "|_" + row1Chars[0] + "_";
        String column2 = "|_" + row1Chars[1] + "_";
        String column3 = "|_" + row1Chars[2] + "_";
        String column4 = "|_" + row1Chars[3] + "_|";
        return column1 + column2 + column3 + column4;
    }

    String returnGameRow2(int column) {
        switch(column) {
            case 1: row2Chars[0] = 'x'; break;
            case 2: row2Chars[1] = 'x'; break;
            case 3: row2Chars[2] = 'x'; break;
            case 4: row2Chars[3] = 'x'; break;
        }

        String column1 = "|_" + row2Chars[0] + "_";
        String column2 = "|_" + row2Chars[1] + "_";
        String column3 = "|_" + row2Chars[2] + "_";
        String column4 = "|_" + row2Chars[3] + "_|";
        return column1 + column2 + column3 + column4;
    }

    String returnGameRow3(int column) {
        switch(column) {
            case 1: row3Chars[0] = 'x'; break;
            case 2: row3Chars[1] = 'x'; break;
            case 3: row3Chars[2] = 'x'; break;
            case 4: row3Chars[3] = 'x'; break;
        }

        String column1 = "|_" + row3Chars[0] + "_";
        String column2 = "|_" + row3Chars[1] + "_";
        String column3 = "|_" + row3Chars[2] + "_";
        String column4 = "|_" + row3Chars[3] + "_|";
        return column1 + column2 + column3 + column4;
    }

    String returnGameRow4(int column) {
        switch(column) {
            case 1: row4Chars[0] = 'x'; break;
            case 2: row4Chars[1] = 'x'; break;
            case 3: row4Chars[2] = 'x'; break;
            case 4: row4Chars[3] = 'x'; break;
        }

        String column1 = "|_" + row4Chars[0] + "_";
        String column2 = "|_" + row4Chars[1] + "_";
        String column3 = "|_" + row4Chars[2] + "_";
        String column4 = "|_" + row4Chars[3] + "_|";
        return column1 + column2 + column3 + column4;
    }
}