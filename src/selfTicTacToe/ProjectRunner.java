package selfTicTacToe;

import java.util.Scanner;
/**
 *  The Tic Tac Toe game runner
 * 
 *  @author Tien Nguyen
 *  @version Dec 7, 2024
 */
public class ProjectRunner
{
    /**
     * Run the game
     * @param args
     */
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner keyboard = new Scanner(System.in);
        gameCalculator game = new gameCalculator();
        int[] gameBoard = game.getGameBoard();
        while (!game.isWon())
        {
            //Start the game
            if (game.getGameTurn() == 0)
            {
                System.out.println("Welcome to the game of Tic Tac Toe");
                System.out.println("Player 1 is X, Player 2 is O");
                System.out.println(game.updateGame(0,1,1));
            }
            printBoard(gameBoard);
            
            
            //The game turn and which player is playing
            int mark;
            int turn = game.getGameTurn();
            if (turn % 2 == 1) {
                mark = 1;
            }
            else
            {
                mark = 2;
            }
            
            //Take in the user input
            System.out.println("Please make your move, player " + mark);
            String[] tokens = keyboard.nextLine().split("\\s");
            String player = tokens[0];
            int row = Integer.valueOf(tokens[1]);
            int col = Integer.valueOf(tokens[2]);
            
            //Check if the correct player make their turn
            if (turn % 2 == 1 && !player.equals("X")
                || turn % 2 == 0 && !player.equals("O"))
            {
                System.out.println('\n' + "Please enter the correct sign"
                    + ", it's player " + mark + "'s turn!");
            }
            else
            {
                System.out.println(game.updateGame(mark,row,col));
                
            }
        }
        //Printing the winning board
        printBoard(gameBoard);
    }
    
    /**
     * print the game board to the console
     * @param board
     *      The underlying data on the board
     */
    public static void printBoard(int[] board)
    {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                //The coordinate 
                int cor = i*3+j;
                if (board[cor] == 0)
                {
                    str.append("___");
                }
                else if (board[cor] == 1)
                {
                    str.append(" X ");
                }
                else if (board[cor] == 2)
                {
                    str.append(" O ");
                }
                str.append("||");
            }
            str.append('\n' + "===============" + '\n');
        }
        System.out.println(str.toString());
    }
    
}
