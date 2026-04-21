import java.util.Scanner;
class TicTacToe {
    private char[] board;
    private Scanner scanner;
    public TicTacToe() 
    {
        board = new char[9];
        scanner = new Scanner(System.in);
        for (int i = 0; i < 9; i++) 
        {
            board[i] = ' ';
        }
    }
    public void displayBoard() 
    {
        System.out.println();
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("--+---+--");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("--+---+--");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }
    public int getUserSlot() 
    {
        int slot;
        while (true) 
        {
            System.out.print("Enter a slot number (1-9): ");
            if (scanner.hasNextInt()) 
            {
                slot = scanner.nextInt();
                if (slot >= 1 && slot <= 9) 
                {
                    return slot - 1;
                } else 
                {
                    System.out.println("❌ Enter number between 1 and 9.");
                }
            } else 
            {
                System.out.println("❌ Invalid input! Enter integer.");
                scanner.next();
            }
        }
    }
    public void makeMove(char player) {
        int index;
        while (true) 
        {
            index = getUserSlot();
            if (board[index] == ' ') 
            {
                board[index] = player;
                break;
            } else 
            {
                System.out.println("❌ Slot already occupied! Try again.");
            }
        }
    }
}
public class Main 
{
    public static void main(String[] args) 
    {
        TicTacToe game = new TicTacToe();
        game.displayBoard();
        game.makeMove('X');
        game.displayBoard();
    }
}