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
        int userSlot = acceptUserSlot();
        System.out.println("You selected slot: " + userSlot);
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
                    System.out.println("Invalid! Enter number between 1 and 9.");
                }
            }
            else
            {
                System.out.println("Invalid input! Enter a number.");
                sc.next(); // clear wrong input
            }
        }
    }
}