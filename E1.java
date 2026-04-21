import java.util.Random;
public class E1
{
    public static void main(String[] args) 
    {
        char[][] board = new char[3][3];
        initializeBoard(board);
        printBoard(board);
        tossToDecide();
    }
    public static void initializeBoard(char[][] board) 
    {
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                board[i][j] = '-';
            }
        }
    }
    public static void printBoard(char[][] board) 
    {
        System.out.println("Tic-Tac-Toe Board:");
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void tossToDecide() 
    {
        Random random = new Random();
        int toss = random.nextInt(2);
        char userSymbol;
        char computerSymbol;
        String currentPlayer;
        if (toss == 0) 
        {
            userSymbol = 'X';
            computerSymbol = 'O';
            currentPlayer = "User";
        } else 
        {
            userSymbol = 'O';
            computerSymbol = 'X';
            currentPlayer = "Computer";
        }
        System.out.println("\nToss Result:");
        System.out.println("User Symbol: " + userSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);
        System.out.println("First Turn: " + currentPlayer);
    }
}