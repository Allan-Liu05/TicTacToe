import java.util.Scanner;
/**
 * Backup for V3
 *
 * Allan Liu
 * November 22, 2022
 * 
 */
public class CopyOfTicTacToe_V3
{
    public static void main(String [] args)
    {
        // global variable declaration

        // Board formatting using 2d array
        String [][] board = {{" "," "," "},{" "," "," "},{" "," "," "}};
        String [][] numberedBoard = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
        String [][][] turn6Cats = {

                {{"X","O","X"},{" "," "," "},{"O","X","O"}},
                {{"O","X","O"},{" "," "," "},{"X","O","X"}},
                {{"X"," ","O"},{"O"," ","X"},{"X"," ","O"}},
                {{"O"," ","X"},{"X"," ","O"},{"O"," ","X"}},

            };
        // userInput variable for game interaction
        Scanner userInput = new Scanner(System.in);
        int selection = 0;
        int turn = 1;
        int win = 0;
        boolean attempt = false;

        // some variables to for later

        int firstMove;
        int typeSelect;
        int playerMove = 1;
       // int overwriteCheck = 0;
       // int compTurn = 0;
        String computerPlay;
        int cat = 0;
        int blankCount = 0;
        // while loop conditional variable
        int loopCondition = 0;
        System.out.println("Welcome to Tic Tac Toe");
        System.out.println();
        System.out.println("Would you like to play against a person or against a computer?");
        System.out.println("1. Player vs Player");
        System.out.println("2. Player vs Computer");
        System.out.println("3. Quit");
        while (true)
        {
            typeSelect = userInput.nextInt();
            if (typeSelect == 1 || typeSelect == 2)
            {
                break;
            }
            else if (typeSelect == 3)
            {
                System.out.println("Goodbye.");
                break;
            }
            else 
            {
                System.out.println("Invalid input, try again.");
            }
        }
        if (typeSelect == 2)
        {
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

            // Main loop
            System.out.println("Please select a value from 1-9 corresponding with the squares on the board. To quit, enter 0");
            loop:
            while (loopCondition == 0)
            {
                attempt = false;
                // puts values into the corresponding location on the board

                while (true)
                {
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
                    selection = userInput.nextInt();
                    if (selection == 0)
                    {
                        break loop;
                    }
                    else if (selection > 9 || selection < 0)
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

                blankCount = 0;
                cat = 0;
                for (int r = 0; r < board.length; r++)
                {
                    for (int c = 0; c < board[0].length; c++)
                    {
                        if (board[r][c] == " ")
                        {
                            blankCount++;
                        }
                    }
                }

                if (blankCount == 3)
                {
                    for (int depth = 0; depth < turn6Cats.length; depth++)
                    {
                        int percentTrue = 0;
                        for (int row = 0; row < turn6Cats[depth].length; row++)
                        {
                            for (int column = 0; column < turn6Cats[depth][row].length; column++)
                            {
                                if (board[row][column] == turn6Cats[depth][row][column])
                                {
                                    percentTrue++;
                                    if(percentTrue == 9)
                                    {
                                        //System.out.println("They are the same");
                                        win = 3;
                                        break loop;
                                    }
                                }
                            }
                        }
                    } 
                }
                else if (blankCount == 2)
                {
                    // horizontal x
                    for (int r = 0; r < board.length; r++)
                    {
                        for (int c = 0; c < board[0].length; c++)
                        {
                            if(board[r][c % 3] == " " && board[r][(c + 1) % 3] == "X" && board[r][(c + 2) % 3] == "X")
                            {
                                cat++;
                            }
                        }
                    }
                    // vertical x
                    for (int r = 0; r < board.length; r++)
                    {
                        for (int c = 0; c < board[0].length; c++)
                        {
                            if(board[r % 3][c] == " " && board[(r + 1) % 3][c] == "X" && board[(r + 2) % 3][c] == "X")
                            {
                                cat++;
                            }
                        }
                    }
                    // negative diagonal slope
                    for (int r = 0; r < board.length; r++)
                    {
                        if(board[r % 3][r % 3] == " " && board[(r + 1) % 3][(r + 1) % 3] == "X" && board[(r + 2) % 3][(r + 2) % 3] == "X")
                        {
                            cat++;
                        }

                    }
                    // positive diagonal slope
                    if (board[2][0] == " " && board[1][1] == "X" && board[0][2] == "X")
                    {
                        cat++;
                    }
                    else if (board[2][0] == "X" && board[1][1] == " " && board[0][2] == "X")
                    {
                        cat++;
                    }
                    else if (board[2][0] == "X" && board[1][1] == "X" && board[0][2] == " ")
                    {
                        cat++;
                    }

                    // horizontal o
                    for (int r = 0; r < board.length; r++)
                    {
                        for (int c = 0; c < board[0].length; c++)
                        {
                            if(board[r][c % 3] == " " && board[r][(c + 1) % 3] == "O" && board[r][(c + 2) % 3] == "O")
                            {
                                cat++;
                            }
                        }
                    }
                    // vertical o
                    for (int r = 0; r < board.length; r++)
                    {
                        for (int c = 0; c < board[0].length; c++)
                        {
                            if(board[r % 3][c] == " " && board[(r + 1) % 3][c] == "O" && board[(r + 2) % 3][c] == "O")
                            {
                                cat++;
                            }
                        }
                    }
                    // negative diagonal slope
                    for (int r = 0; r < board.length; r++)
                    {

                        if(board[r % 3][r % 3] == " " && board[(r + 1) % 3][(r + 1) % 3] == "O" && board[(r + 2) % 3][(r + 2) % 3] == "O")
                        {
                            cat++;
                        }

                    }
                    // positive diagonal slope
                    if (board[2][0] == " " && board[1][1] == "O" && board[0][2] == "O")
                    {
                        cat++;
                    }
                    else if (board[2][0] == "O" && board[1][1] == " " && board[0][2] == "O")
                    {
                        cat++;
                    }
                    else if (board[2][0] == "O" && board[1][1] == "O" && board[0][2] == " ")
                    {
                        cat++;
                    }
                    if (cat == 0)
                    {
                        win = 3;
                        break loop;
                    }
                }
                else if (blankCount == 1)
                {
                    // horizontal x
                    for (int r = 0; r < board.length; r++)
                    {
                        for (int c = 0; c < board[0].length; c++)
                        {
                            if(board[r][c % 3] == " " && board[r][(c + 1) % 3] == "X" && board[r][(c + 2) % 3] == "X")
                            {
                                cat++;
                            }
                        }
                    }
                    // vertical x
                    for (int r = 0; r < board.length; r++)
                    {
                        for (int c = 0; c < board[0].length; c++)
                        {
                            if(board[r % 3][c] == " " && board[(r + 1) % 3][c] == "X" && board[(r + 2) % 3][c] == "X")
                            {
                                cat++;
                            }
                        }
                    }
                    // negative diagonal slope
                    for (int r = 0; r < board.length; r++)
                    {

                        if(board[r % 3][r % 3] == " " && board[(r + 1) % 3][(r + 1) % 3] == "X" && board[(r + 2) % 3][(r + 2) % 3] == "X")
                        {
                            cat++;
                        }

                    }
                    // positive diagonal slope
                    if (board[2][0] == " " && board[1][1] == "X" && board[0][2] == "X")
                    {
                        cat++;
                    }
                    else if (board[2][0] == "X" && board[1][1] == " " && board[0][2] == "X")
                    {
                        cat++;
                    }
                    else if (board[2][0] == "X" && board[1][1] == "X" && board[0][2] == " ")
                    {
                        cat++;
                    }
                    if (cat == 0)
                    {
                        win = 3; 
                        //break loop;
                    }
                }

                // check victory to prevent computer move if player just won
                for (int r = 0; r < board.length; r++)
                {
                    //System.out.println("Hello world");
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
                blankCount = 0;
                cat = 0;
                for (int r = 0; r < board.length; r++)
                {
                    for (int c = 0; c < board[0].length; c++)
                    {
                        if (board[r][c] == " ")
                        {
                            blankCount++;
                        }
                    }
                }

                if (blankCount == 3)
                {
                    for (int depth = 0; depth < turn6Cats.length; depth++)
                    {
                        int percentTrue = 0;
                        for (int row = 0; row < turn6Cats[depth].length; row++)
                        {
                            for (int column = 0; column < turn6Cats[depth][row].length; column++)
                            {
                                if (board[row][column] == turn6Cats[depth][row][column])
                                {
                                    percentTrue++;
                                    if(percentTrue == 9)
                                    {
                                        //System.out.println("They are the same");
                                        win = 3;
                                        break loop;
                                    }
                                }
                            }
                        }
                    } 
                }

                if (blankCount == 2)
                {
                    // horizontal x
                    for (int r = 0; r < board.length; r++)
                    {
                        for (int c = 0; c < board[0].length; c++)
                        {
                            if(board[r][c % 3] == " " && board[r][(c + 1) % 3] == "X" && board[r][(c + 2) % 3] == "X")
                            {
                                cat++;
                            }
                        }
                    }
                    // vertical x
                    for (int r = 0; r < board.length; r++)
                    {
                        for (int c = 0; c < board[0].length; c++)
                        {
                            if(board[r % 3][c] == " " && board[(r + 1) % 3][c] == "X" && board[(r + 2) % 3][c] == "X")
                            {
                                cat++;
                            }
                        }
                    }
                    // negative diagonal slope
                    for (int r = 0; r < board.length; r++)
                    {
                        if(board[r % 3][r % 3] == " " && board[(r + 1) % 3][(r + 1) % 3] == "X" && board[(r + 2) % 3][(r + 2) % 3] == "X")
                        {
                            cat++;
                        }

                    }
                    // positive diagonal slope
                    if (board[2][0] == " " && board[1][1] == "X" && board[0][2] == "X")
                    {
                        cat++;
                    }
                    else if (board[2][0] == "X" && board[1][1] == " " && board[0][2] == "X")
                    {
                        cat++;
                    }
                    else if (board[2][0] == "X" && board[1][1] == "X" && board[0][2] == " ")
                    {
                        cat++;
                    }

                    // horizontal o
                    for (int r = 0; r < board.length; r++)
                    {
                        for (int c = 0; c < board[0].length; c++)
                        {
                            if(board[r][c % 3] == " " && board[r][(c + 1) % 3] == "O" && board[r][(c + 2) % 3] == "O")
                            {
                                cat++;
                            }
                        }
                    }
                    // vertical o
                    for (int r = 0; r < board.length; r++)
                    {
                        for (int c = 0; c < board[0].length; c++)
                        {
                            if(board[r % 3][c] == " " && board[(r + 1) % 3][c] == "O" && board[(r + 2) % 3][c] == "O")
                            {
                                cat++;
                            }
                        }
                    }
                    // negative diagonal slope
                    for (int r = 0; r < board.length; r++)
                    {

                        if(board[r % 3][r % 3] == " " && board[(r + 1) % 3][(r + 1) % 3] == "O" && board[(r + 2) % 3][(r + 2) % 3] == "O")
                        {
                            cat++;
                        }

                    }
                    // positive diagonal slope
                    if (board[2][0] == " " && board[1][1] == "O" && board[0][2] == "O")
                    {
                        cat++;
                    }
                    else if (board[2][0] == "O" && board[1][1] == " " && board[0][2] == "O")
                    {
                        cat++;
                    }
                    else if (board[2][0] == "O" && board[1][1] == "O" && board[0][2] == " ")
                    {
                        cat++;
                    }
                    if (cat == 0)
                    {
                        win = 3;
                        break loop;
                    }
                }
                else if (blankCount == 1)
                {
                    // horizontal x
                    for (int r = 0; r < board.length; r++)
                    {
                        for (int c = 0; c < board[0].length; c++)
                        {
                            if(board[r][c % 3] == " " && board[r][(c + 1) % 3] == "X" && board[r][(c + 2) % 3] == "X")
                            {
                                cat++;
                            }
                        }
                    }
                    // vertical x
                    for (int r = 0; r < board.length; r++)
                    {
                        for (int c = 0; c < board[0].length; c++)
                        {
                            if(board[r % 3][c] == " " && board[(r + 1) % 3][c] == "X" && board[(r + 2) % 3][c] == "X")
                            {
                                cat++;
                            }
                        }
                    }
                    // negative diagonal slope
                    for (int r = 0; r < board.length; r++)
                    {

                        if(board[r % 3][r % 3] == " " && board[(r + 1) % 3][(r + 1) % 3] == "X" && board[(r + 2) % 3][(r + 2) % 3] == "X")
                        {
                            cat++;
                        }

                    }
                    // positive diagonal slope
                    if (board[2][0] == " " && board[1][1] == "X" && board[0][2] == "X")
                    {
                        cat++;
                    }
                    else if (board[2][0] == "X" && board[1][1] == " " && board[0][2] == "X")
                    {
                        cat++;
                    }
                    else if (board[2][0] == "X" && board[1][1] == "X" && board[0][2] == " ")
                    {
                        cat++;
                    }
                    if (cat == 0)
                    {
                        win = 3; 
                        break loop;
                    }
                }
                // check victory to prevent player move if computer just won
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

                if (turn >= 9)
                {
                    win = 3;
                    break loop;
                }

            }
        }
        //Player vs Player
        if (typeSelect == 1)
        {
            turn = 1;
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

            System.out.println("Please select a value from 1-9 corresponding with the squares on the board. To quit, enter 0");
            loop: 
            while (true)
            {
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

                // Checking for victory or cat's game 
                blankCount = 0;
                cat = 0;
                for (int r = 0; r < board.length; r++)
                {
                    for (int c = 0; c < board[0].length; c++)
                    {
                        if (board[r][c] == " ")
                        {
                            blankCount++;
                        }
                    }
                }

                if (blankCount == 3)
                {
                    System.out.println("Checking 6");
                    for (int depth = 0; depth < turn6Cats.length; depth++)
                    {
                        int percentTrue = 0;
                        for (int row = 0; row < turn6Cats[depth].length; row++)
                        {
                            for (int column = 0; column < turn6Cats[depth][row].length; column++)
                            {
                                if (board[row][column] == turn6Cats[depth][row][column])
                                {
                                    percentTrue++;
                                    if(percentTrue == 9)
                                    {
                                        //System.out.println("They are the same");
                                        win = 3;
                                        break loop;
                                    }
                                }
                            }
                        }
                    } 
                }

                if (blankCount == 2)
                {
                    System.out.println("Checking 7");
                    // horizontal x
                    for (int r = 0; r < board.length; r++)
                    {
                        for (int c = 0; c < board[0].length; c++)
                        {
                            if(board[r][c % 3] == " " && board[r][(c + 1) % 3] == "X" && board[r][(c + 2) % 3] == "X")
                            {
                                cat++;
                            }
                        }
                    }
                    // vertical x
                    for (int r = 0; r < board.length; r++)
                    {
                        for (int c = 0; c < board[0].length; c++)
                        {
                            if(board[r % 3][c] == " " && board[(r + 1) % 3][c] == "X" && board[(r + 2) % 3][c] == "X")
                            {
                                cat++;
                            }
                        }
                    }
                    // negative diagonal slope
                    for (int r = 0; r < board.length; r++)
                    {
                        if(board[r % 3][r % 3] == " " && board[(r + 1) % 3][(r + 1) % 3] == "X" && board[(r + 2) % 3][(r + 2) % 3] == "X")
                        {
                            cat++;
                        }
                    }
                    // positive diagonal slope
                    if (board[2][0] == " " && board[1][1] == "X" && board[0][2] == "X")
                    {
                        cat++;
                    }
                    else if (board[2][0] == "X" && board[1][1] == " " && board[0][2] == "X")
                    {
                        cat++;
                    }
                    else if (board[2][0] == "X" && board[1][1] == "X" && board[0][2] == " ")
                    {
                        cat++;
                    }

                    // horizontal o
                    for (int r = 0; r < board.length; r++)
                    {
                        for (int c = 0; c < board[0].length; c++)
                        {
                            if(board[r][c % 3] == " " && board[r][(c + 1) % 3] == "O" && board[r][(c + 2) % 3] == "O")
                            {
                                cat++;
                            }
                        }
                    }
                    // vertical o
                    for (int r = 0; r < board.length; r++)
                    {
                        for (int c = 0; c < board[0].length; c++)
                        {
                            if(board[r % 3][c] == " " && board[(r + 1) % 3][c] == "O" && board[(r + 2) % 3][c] == "O")
                            {
                                cat++;
                            }
                        }
                    }
                    // negative diagonal slope
                    for (int r = 0; r < board.length; r++)
                    {

                        if(board[r % 3][r % 3] == " " && board[(r + 1) % 3][(r + 1) % 3] == "O" && board[(r + 2) % 3][(r + 2) % 3] == "O")
                        {
                            cat++;
                        }

                    }
                    // positive diagonal slope
                    if (board[2][0] == " " && board[1][1] == "O" && board[0][2] == "O")
                    {
                        cat++;
                    }
                    else if (board[2][0] == "O" && board[1][1] == " " && board[0][2] == "O")
                    {
                        cat++;
                    }
                    else if (board[2][0] == "O" && board[1][1] == "O" && board[0][2] == " ")
                    {
                        cat++;
                    }
                    if (cat == 0)
                    {
                        win = 3;
                        break loop;
                    }
                }
                else if (blankCount == 1)
                {
                    System.out.println("Checking 8");
                    // horizontal x
                    for (int r = 0; r < board.length; r++)
                    {
                        for (int c = 0; c < board[0].length; c++)
                        {

                            if(board[r][c % 3] == " " && board[r][(c + 1) % 3] == "X" && board[r][(c + 2) % 3] == "X")
                            {

                                cat++;
                            }
                        }
                    }
                    // vertical x
                    for (int r = 0; r < board.length; r++)
                    {
                        for (int c = 0; c < board[0].length; c++)
                        {
                            if(board[r % 3][c] == " " && board[(r + 1) % 3][c] == "X" && board[(r + 2) % 3][c] == "X")
                            {

                                cat++;
                            }
                        }
                    }
                    // negative diagonal slope
                    for (int r = 0; r < board.length; r++)
                    {

                        if(board[r % 3][r % 3] == " " && board[(r + 1) % 3][(r + 1) % 3] == "X" && board[(r + 2) % 3][(r + 2) % 3] == "X")
                        {

                            cat++;
                        }

                    }
                    // positive diagonal slope
                    if (board[2][0] == " " && board[1][1] == "X" && board[0][2] == "X")
                    {

                        cat++;
                    }
                    else if (board[2][0] == "X" && board[1][1] == " " && board[0][2] == "X")
                    {

                        cat++;
                    }
                    else if (board[2][0] == "X" && board[1][1] == "X" && board[0][2] == " ")
                    {

                        cat++;
                    }
                    System.out.println(cat);
                    if (cat == 0)
                    {
                        win = 3; 
                        break loop;
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
                    }
                    else if (turn == 9)
                    {
                        win = 3;
                        break loop;
                    }

                }

            }
        }
        if(typeSelect == 2 || typeSelect == 1)
        {

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
        //System.out.println("Win type is " + win);

        // Outputting who won
        if (typeSelect == 2)
        {
            if (win == 0)
            {
                System.out.println("Goodbye.");
            }
            else if (win == 1 && playerMove == 1)
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
                System.out.println("Cat's game! Wow!");
            }
        }
        else if (typeSelect == 1)
        {
            if (win == 0)
            {
                System.out.println("Goodbye.");
            }
            else if (win == 1)
            {
                System.out.println("Victory for X");
            }
            else if (win == 2)
            {
                System.out.println("Victory for O");
            }
            else if (win == 3)
            {
                System.out.println("Cat's game! Wow!");
            }
        }

    }

}
