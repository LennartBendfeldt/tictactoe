package com.tts;

import java.util.Scanner;


public class TicTacToe
{

    private static char[][] board = new char[3][3];

    public static void main( String[] args )
    {

        char player1 = 'X', player2 = 'O';
        int turn = 1;

        initBoard();
        displayBoard();

        while ( true )
        {
            System.out.println( "Turn " + turn + "..." );
            if ( turn % 2 != 0 )
            {
                playerChoice(player1);
            }
            else
            {
                playerChoice(player2);
            }
            turn++;
            displayBoard();

            // check for game end
            if ( winGame(player1) )
            {
                System.out.println( "'" + player1 + "' wins the game!" );
                break;
            }
            else if ( winGame(player2) )
            {
                System.out.println( "'" + player2 + "' wins the game!" );
                break;
            }
            else if ( turn > 9 )
            {
                System.out.println( "This game is a tie." );
                break;
            }

        }

    }

    public static void initBoard()
    {
        // fills up the board with blanks
        for ( int i=0; i<3; i++ )
            for ( int j=0; j<3; j++ )
                board[i][j] = ' ';
    }


    public static void displayBoard()
    {
        System.out.println();
        System.out.println("  0  " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("    ---+---+---");
        System.out.println("  1  " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("    ---+---+---");
        System.out.println("  2  " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
        System.out.println("     0   1   2\n");
    }


    public static void playerChoice( char player )
    {
        Scanner kb = new Scanner(System.in);
        int row, column;

        System.out.print( "'" + player + "', choose your location (row, column): " );
        row = kb.nextInt();
        column = kb.nextInt();

        board[row][column] = player;
    }

    public static boolean winGame( char player )
    {
        // check horizontal
        for ( int i = 0; i < 3; i++ )
        {
            if ( player == board[i][0] && board[i][0] == board[i][1] && board[i][1] == board[i][2] )
                return true;
        }

        // check vertical
        for ( int i = 0; i < 3; i++ )
        {
            if ( player == board[0][i] && board[0][i] == board[1][i] && board[1][i] == board[2][i] )
                return true;
        }

        // check diagonal
        if ( player == board[0][0] && board[0][0] == board[1][1] && board[1][1] == board[2][2] )
            return true;
        else if ( player == board[0][2] && board[0][2] == board[1][1] && board[1][1] == board[2][0] )
            return true;


        return false;
    }
}