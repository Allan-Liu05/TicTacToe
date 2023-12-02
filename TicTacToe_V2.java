import java.util.Scanner;
/**
 * TicTacToe with computer things
 *
 * Allan Liu
 * @version (a version number or a date)
 */
public class TicTacToe_V2
{
    public static void main(String [] args)
    {
        // global variable declaration

        // Board formatting using 2d array
        String [][] board = {{" "," "," "},{" "," "," "},{" "," "," "}};
        String [][] numberedBoard = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};

        // userInput variable for game interaction
        Scanner userInput = new Scanner(System.in);
        userInput.close();
        int selection = 0;
        int turn = 0;
        int win = 0;
        boolean attempt = false;
       
        // some variables to for later
        int firstMove;
        int playerMove = 1;
        int overwriteCheck = 0;
        // int compTurn = 0;
        String computerPlay;
        // while loop conditional variable
        //int loopCondition = 0;
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

        System.out.println("Would you like to go first or second, input 1 for first, any other integer for second");
        firstMove = userInput.nextInt();
        // computer deciding if it wants to move first
        if (firstMove != 1)
        {
            board[(int)(Math.random()*3)][(int)(Math.random()*3)] = "X";
            turn++;
            playerMove = 2;
        }
        if (playerMove == 1)
        {
            computerPlay = "O";
        }
        else
        {
            computerPlay = "X";
        }
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
        // Main loop
        loop:
        while (true)
        {
            attempt = false;
            // puts values into the corresponding location on the board
            System.out.println("Please enter a value from 1 to 9 inclusive that corresponds with the number you want on the board, to exit enter 0: ");

            while (overwriteCheck == 0)
            {
                selection = userInput.nextInt();
                if (selection == 0)
                {
                    break loop;
                }
                else if (selection > 9)
                {
                    System.out.println("Out of bounds, please try another square.");
                    selection = userInput.nextInt();
                }
                int row = (int)(selection/3.1);
                int column = selection - (3*row+1);
                if (board[row][column] == " ")
                {
                    if (playerMove == 1)
                    {
                        board[row][column] = "X";
                        turn++;
                        break;
                    }
                    else if (playerMove == 2)
                    {
                        board[row][column] = "O";
                        turn++;
                        break;
                    }
                }
                else if (board[row][column] != " ")
                {
                    System.out.println("No overwriting Kiddo! Try another spot.");
                }
            }

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
                else if ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) && board[0][0] != " " || (board[2][0] == board[1][1] && board[1][1] == board[0][2]) && board[1][1] != " ")
                {
                    if (board[0][0] == "X" || board[0][2] == "X")
                    {
                        win = 1;
                        break loop;
                    }
                    else if (board[r][0] == "O" || board[0][2] == "O")
                    {
                        win = 2;
                        break loop;
                    }
                }
            }

            // Computer move
           
            for (int r = 0; r < board.length; r++)
            {
                if (!attempt)
                {
                    if (board[r][0] == board[r][1] && board[r][0] != " " && board[r][2] == " ")
                    {
                        board[r][2] = computerPlay;
                        attempt = true;
                        turn++;
                    }
                    else if (board[r][0] == board[r][2] && board[r][0] != " " && board[r][1] == " ")
                    {
                        board[r][1] = computerPlay;
                        attempt = true;
                        turn++;
                    }
                    else if (board[r][1] == board[r][2] && board[r][1] != " " && board[r][0] == " ")
                    {
                        board[r][0] = computerPlay;
                        attempt = true;
                        turn++;
                    }
                    else if (board[0][r] == board[1][r] && board[0][r] != " " && board[2][r] == " ")
                    {
                        board[2][r] = computerPlay;
                        attempt = true;
                        turn++;
                    }
                    else if (board[0][r] == board[2][r] && board[0][r] != " " && board[1][r] == " ")
                    {
                        board[1][r] = computerPlay;
                        attempt = true;
                        turn++;
                    }
                    else if (board[1][r] == board[2][r] && board[1][r] != " " && board[0][r] == " ")
                    {
                        board[0][r] = computerPlay;
                        attempt = true;
                        turn++;
                    }

                    else if (board[0][0] == board[1][1] && board[1][1] != " " && board[2][2] == " ")
                    {
                        board[2][2] = computerPlay;
                        attempt = true;
                        turn++;
                    }
                    else if (board[0][0] == board[2][2] && board[2][2] != " " && board[1][1] == " ")
                    {
                        board[1][1] = computerPlay;
                        attempt = true;
                        turn++;
                    }
                    else if (board[2][2] == board[1][1] && board[2][2] != " " && board[0][0] == " ")
                    {
                        board[0][0] = computerPlay;
                        attempt = true;
                        turn++;
                    }
                    else if (board[2][0] == board[1][1] && board[1][1] != " " && board[0][2] == " ")
                    {
                        board[0][2] = computerPlay;
                        attempt = true;
                        turn++;
                    }
                    else if (board[0][2] == board[1][1] && board[1][1] != " " && board[2][0] == " ")
                    {
                        board[2][0] = computerPlay;
                        attempt = true;
                        turn++;
                    }
                    else if (board[0][2] == board[2][0] && board[0][2] != " " && board[1][1] == " ")
                    {
                        board[1][1] = computerPlay;
                        attempt = true;
                        turn++;
                    }
                }
            }
           
            if (!attempt)
            {
                for (int i = 0; i < 100; i ++)
                {
                    int compMove = (int)(Math.random() * 9 + 1);
                    int rowComp = (int)(compMove/3.1);
                    int columnComp = compMove - (3*rowComp+1);
                    if (board[rowComp][columnComp] == " ")
                    {
                        if (playerMove == 1)
                        {
                            board[rowComp][columnComp] = "O";
                            turn++;
                            i = 100;
                        }
                        else if (playerMove == 2)
                        {
                            board[rowComp][columnComp] = "X";
                            turn++;
                            i = 100;
                        }
                    }
                }

            }
           
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
                else if ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) && board[0][0] != " " || (board[2][0] == board[1][1] && board[1][1] == board[0][2]) && board[1][1] != " ")
                {
                    if (board[0][0] == "X" || board[0][2] == "X")
                    {
                        win = 1;
                        break loop;
                    }
                    else if (board[r][0] == "O" || board[0][2] == "O")
                    {
                        win = 2;
                        break loop;
                    }
                }
            }
            if (turn >= 9)
            {
                win = 3;
                break loop;
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

        // Outputting who won
        if (win == 1 && playerMove == 1)
        {
            System.out.println("Victory for X");
        }
         else if (win == 2 && playerMove == 1)
        {
            System.out.println("Victory for O");
        }
        else if (win == 1 && playerMove == 2)
        {
            System.out.println("Victory for X");
        }
        else if (win == 2 && playerMove == 2)
        {
            System.out.println("Victory for O");
        }
        else if (win == 3)
        {
            System.out.println("Tie.");
        }
    }

}
