import java.util.Random;
import java.util.Scanner;
public class E1
{
    public static void main(String[] args)
    {
        char[][] board = new char[3][3];
        char userSymbol = 'X';
        char computerSymbol = 'O';
        boolean userTurn = true;

        initializeBoard(board);

        while (true)
        {
            printBoard(board);

            if (userTurn)
            {
                int row, col;

                while (true)
                {
                    int userSlot = acceptUserSlot();
                    int[] pos = convertSlotToIndex(userSlot);

                    row = pos[0];
                    col = pos[1];

                    if (isValidMove(board, row, col))
                    {
                        placeMove(board, row, col, userSymbol);
                        break;
                    }
                    else
                    {
                        System.out.println("Invalid move! Try again.");
                    }
                }

                if (checkWin(board, userSymbol))
                {
                    printBoard(board);
                    System.out.println("User wins!");
                    break;
                }
            }
            else
            {
                computerMove(board, computerSymbol);

                if (checkWin(board, computerSymbol))
                {
                    printBoard(board);
                    System.out.println("Computer wins!");
                    break;
                }
            }

            if (isBoardFull(board))
            {
                printBoard(board);
                System.out.println("It's a draw!");
                break;
            }

            userTurn = !userTurn;
        }
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

        return board[row][col] == '-';
    }
    public static void placeMove(char[][] board, int row, int col, char symbol)
    {
        board[row][col] = symbol;
    }
    public static void computerMove(char[][] board, char symbol)
    {
        Random random = new Random();
        while (true)
        {
            int slot = random.nextInt(9) + 1;
            int[] pos = convertSlotToIndex(slot);
            int row = pos[0];
            int col = pos[1];
            if (isValidMove(board, row, col))
            {
                placeMove(board, row, col, symbol);
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }
    public static boolean checkWin(char[][] board, char symbol)
    {
        for (int i = 0; i < 3; i++)
        {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol)
                return true;
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)
                return true;
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
            return true;

        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)
            return true;

        return false;
    }
    public static boolean isBoardFull(char[][] board)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board[i][j] == '-')
                {
                    return false;
                }
            }
        }
        return true;
    }
}