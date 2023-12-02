import java.util.Scanner;
/**
 * TicTacToe, Version 1
 *
 * Allan Liu
 * Nov 14, 2022 -- Version 1.0
 */
public class TicTacToe_V1
{
    public static void main(String [] args)
    {
        // global variable declaration

        // Board formatting using 2d array
        String [][] board = {{" "," "," "},{" "," "," "},{" "," "," "}};
        String [][] numberedBoard = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};

        // userInput variable for game interaction
        Scanner userInput = new Scanner(System.in);
        int selection = 0;
        int turn = 1;
        int win = 0;
        // while loop conditional variable
        int loopCondition = 0;
        System.out.println("Welcome to Tic Tac Toe");
        System.out.println("Here is an empty Tic Tac Toe board.");
        // Displaying initial boards
        for (int r = 0; r < board.length; r++)
        {
            for (int c = 0; c < board[0].length; c++)
            {
                if (c == 2)
                {
                    System.out.print(" " + board[r][c] + " ");
                }
                else
                {
                    System.out.print(" " + board[r][c] + " " + "|");
                }
            }
            System.out.println();
            if (r != 2)
            {
                System.out.println("---+---+---"); // hyphens
            }
        }
        System.out.println();
        System.out.println("When selecting the square refer to them by these numbers:");
        System.out.println();
        for (int r = 0; r < board.length; r++)
        {
            for (int c = 0; c < board[0].length; c++)
            {
                if (c == 2)
                {
                    System.out.print(" " + numberedBoard[r][c] + " ");
                }
                else
                {
                    System.out.print(" " + numberedBoard[r][c] + " " + "|");
                }
            }
            System.out.println();
            if (r != 2)
            {
                System.out.println("---+---+---"); // hyphens
            }
        }
        System.out.println();
        System.out.println("Okay, play on!");
        System.out.println();
        System.out.println("Please enter a value from 1 to 9 inclusive that corresponds with the number you want on the board, to exit enter 0: ");
        // Main loop
        loop:
        while (loopCondition == 0)
        {

            // puts values into the corresponding location on the board
            while (true)
            {
                selection = userInput.nextInt();
                if (selection == 0)
                {
                    win = 0;
                    break loop;
                }
                else if (selection > 9 || selection < 0)
                {
                    System.out.println("Out of bounds, please try another square.");
                }
                else 
                {
                    int rowPlayer = (int)(selection/3.1);
                    int columnPlayer = selection - (3*rowPlayer+1);
                    if (board[rowPlayer][columnPlayer] == " ")
                    {
                        if (turn % 2 == 1)
                        {
                            board[rowPlayer][columnPlayer] = "X";
                            break;
                        }
                        else if (turn % 2 == 0)
                        {
                            board[rowPlayer][columnPlayer] = "O";
                            break;
                        }
                    }
                    else if (board[rowPlayer][columnPlayer] != " ")
                    {
                        System.out.println("No overwriting Kiddo! Please try another square");
                    }
                }
            }
            turn++;
            // Checking for victory

            for (int r = 0; r < board.length; r++)
            {
                // Horizontal victory
                if ((board[r][0] == board[r][1] && board[r][1] == board[r][2]) && board[r][1] != " ")
                {
                    if (board[r][0] == "X")
                    {
                        win = 1;
                        break loop;
                    }
                    else if (board[r][0] == "O")
                    {
                        win = 2;
                        break loop;
                    }
                }
                else if ((board[0][r] == board[1][r] && board[1][r] == board[2][r]) && board[0][r] != " ")
                {
                    if (board[0][r] == "X")
                    {
                        win = 1;
                        break loop;
                    }
                    else if (board[0][r] == "O")
                    {
                        win = 2;
                        break loop;
                    }
                }

                else if ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) && board[0][0] != " ")
                {
                    if (board[0][0] == "X")
                    {
                        win = 1;
                        break loop;
                    }
                    else if (board [0][0] == "O")
                    {
                        win = 2;
                        break loop;
                    }
                }
                else if ((board[2][0] == board[1][1] && board[1][1] == board[0][2]) && board[1][1] != " ")
                {
                    if (board[2][0] == "X")
                    {
                        win = 1;
                        break loop;
                    }
                    else if (board [2][0] == "O")
                    {
                        win = 2;
                        break loop;
                    } 
                    else if (turn == 9)
                    {
                        win = 3;
                        break loop;
                    }
                }
            }

            // Displaying updated board
            for (int r = 0; r < board.length; r++)
            {
                for (int c = 0; c < board[0].length; c++)
                {
                    if (c == 2)
                    {
                        System.out.print(" " + board[r][c] + " ");
                    }
                    else
                    {
                        System.out.print(" " + board[r][c] + " " + "|");
                    }
                }
                System.out.println();
                if (r != 2)
                {
                    System.out.println("---+---+---"); // hyphens
                }
            }
        }
        // Outputting who won
        for (int r = 0; r < board.length; r++)
        {
            for (int c = 0; c < board[0].length; c++)
            {
                if (c == 2)
                {
                    System.out.print(" " + board[r][c] + " ");
                }
                else
                {
                    System.out.print(" " + board[r][c] + " " + "|");
                }
            }
            System.out.println();
            if (r != 2)
            {
                System.out.println("---+---+---"); // hyphens
            }
        }
        if (win == 0)
        {
            System.out.print("Goodbye.");
        }
        else if (win == 1)
        {
            System.out.println("Victory for X!");
        }
        else if (win == 2)
        {
            System.out.println("Victory for O!");
        }
        else if (win == 3)
        {
            System.out.println("Tie.");
        }
    }
}
