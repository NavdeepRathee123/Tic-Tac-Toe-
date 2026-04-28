import java.util.Random;
import java.util.Scanner;
public class E1
{
    public static void main(String[] args)
    {
        char[][] board = new char[3][3];
        initializeBoard(board);
        printBoard(board);
        tossToDecide();
        int row, col;
        while (true)
        {
            int userSlot = acceptUserSlot();
            int[] pos = convertSlotToIndex(userSlot);
            row = pos[0];
            col = pos[1];
            if (isValidMove(board, row, col))
            {
                placeMove(board, row, col, 'X');
                break;
            }
            else
            {
                System.out.println("Invalid move! Try again.");
            }
        }
        printBoard(board);
        computerMove(board);
        printBoard(board);
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
        System.out.println("\nTic-Tac-Toe Board:");

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
        }
        else
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
    public static int acceptUserSlot()
    {
        Scanner sc = new Scanner(System.in);
        int slot;
        while (true)
        {
            System.out.print("Enter a slot number (1-9): ");
            if (sc.hasNextInt())
            {
                slot = sc.nextInt();
                if (slot >= 1 && slot <= 9)
                {
                    return slot;
                }
                else
                {
                    System.out.println("Invalid! Enter 1–9.");
                }
            }
            else
            {
                System.out.println("Invalid input!");
                sc.next();
            }
        }
    }
    public static int[] convertSlotToIndex(int slot)
    {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }
    public static boolean isValidMove(char[][] board, int row, int col)
    {
        if (row < 0 || row > 2 || col < 0 || col > 2)
        {
            return false;
        }
        if (board[row][col] == '-')
        {
            return true;
        }
        return false;
    }
    public static void placeMove(char[][] board, int row, int col, char symbol)
    {
        board[row][col] = symbol;
    }
    public static void computerMove(char[][] board)
    {
        Random random = new Random();
        int row, col;
        while (true)
        {
            int slot = random.nextInt(9) + 1;
            int[] pos = convertSlotToIndex(slot);
            row = pos[0];
            col = pos[1];
            if (isValidMove(board, row, col))
            {
                placeMove(board, row, col, 'O');
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }
}