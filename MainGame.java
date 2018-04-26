import java.util.Scanner;
import java.util.Arrays;

class MainGame {

    static GamePiece[][] gameTable = new GamePiece[][] {new GamePiece[4], new GamePiece[4], new GamePiece[4], new GamePiece[4]};
    static int[] gameColumnLengths = new int[4];
    static int playersMoveCounter = 0;

    public static void main(String[] args) {
        getUserInput();
    }

    static void getUserInput() {
        int columnNumber = 1;

        System.out.println("Vali tulp (1, 2, 3, 4), vajuta vastavat klahvi: ");

        while (columnNumber > 0 && columnNumber < 5) {
            Scanner sc = new Scanner(System.in);
            columnNumber = sc.nextInt();
            generateGamePiece(columnNumber);
            // System.out.println(Arrays.deepToString(gameTable));
            System.out.println(printGameTable());
        }
    }

    static void generateGamePiece(int columnNumber) {
        switch (columnNumber) {
            case 1: addPieceToColumn(0, determinePlayerTurn()); break;   
            case 2: addPieceToColumn(1, determinePlayerTurn()); break;   
            case 3: addPieceToColumn(2, determinePlayerTurn()); break;   
            case 4: addPieceToColumn(3, determinePlayerTurn()); break;   
        }
    }

    static void addPieceToColumn(int columnNumberIndex, int determinePlayer) {
        if (gameColumnLengths[columnNumberIndex] < 4) {
            int piecesInColumn = gameColumnLengths[columnNumberIndex];
            if (determinePlayer == 0) {
                gameTable[columnNumberIndex][piecesInColumn] = new GamePiece('x');
            } else {
                gameTable[columnNumberIndex][piecesInColumn] = new GamePiece('o');
            }
            gameColumnLengths[columnNumberIndex] = ++gameColumnLengths[columnNumberIndex];
        } else {
            System.out.println("Tulbas on juba maksimaalne nuppude arv, vali muu tulp: ");
        }
    }

    static int determinePlayerTurn() {
        int determinePlayer = playersMoveCounter % 2;
        playersMoveCounter++;
        return determinePlayer;
    }

    static String printGameTable() {
        String gameTableString = "";
        for (int i = 3; i > 0; i--) {
            gameTableString = gameTableString +
                "| " + (gameTable[0][i] == null ? ' ' : gameTable[0][i].playerPiece) + " " +
                "| " + (gameTable[1][i] == null ? ' ' : gameTable[1][i].playerPiece) + " " +
                "| " + (gameTable[2][i] == null ? ' ' : gameTable[2][i].playerPiece) + " " +
                "| " + (gameTable[3][i] == null ? ' ' : gameTable[3][i].playerPiece) + " |\n";
        }
        String bottomRow = "" +
                "|_" + (gameTable[0][0] == null ? ' ' : gameTable[0][0].playerPiece) + "_" +
                "|_" + (gameTable[1][0] == null ? ' ' : gameTable[1][0].playerPiece) + "_" +
                "|_" + (gameTable[2][0] == null ? ' ' : gameTable[2][0].playerPiece) + "_" +
                "|_" + (gameTable[3][0] == null ? ' ' : gameTable[3][0].playerPiece) + "_|\n";
        return gameTableString + bottomRow;
    }
}