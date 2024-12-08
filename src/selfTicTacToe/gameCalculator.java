package selfTicTacToe;
/**
 *  The game Tic Tac Toe, played with 2 players X and O.
 *  
 *  I'm building my first game. :)
 * 
 *  @author Tien Nguyen
 *  @version Dec 7, 2024
 */
public class gameCalculator
{
    //~ Fields ................................................................
    
    private int gameTurn;
    private int[] gameBoard;
    private boolean won;
    /**
     * The valid grid coordinate players can choose to hit
     */
    private static final int VALID_GRID = 3;
    
    //~ Constructors ..........................................................

    /**
     * Create a new gameCalculator object.
     */
    public gameCalculator()
    {
        gameTurn = 0;
        gameBoard = new int[9];
        won = false;
    }
    
    //~Public  Methods ........................................................
    
    /**
     * Helper method. Check to see if the provided coordinates are valid for
     * a move
     * @param row
     *      The provided row
     * @param
     *      The provided column
     * @return true or false if the coordinates are valid
     */
    private boolean validMove(int row, int col)
    {
        if (row < 1 || row > VALID_GRID)
        {
            return false;
        }
        if (col < 1 || col > VALID_GRID)
        {
            return false;
        }
        return true;
    }
    
    /**
     * Make a valid move onto the board.
     * @param player
     *      The indicated player that will be put on the board, 1 for X, 2 for O
     * @param row
     *      The row for the hit
     * @param col
     *      The column for the hit
     * @return true or false if the move have been be placed
     */
    private boolean makeMove(int player, int row, int col)
    {
        if (gameBoard[(row-1)*3+(col-1)] != 0)
        {
            return false;
        }
        gameBoard[(row-1)*3+(col-1)] = player;
        gameTurn++;
        return true;
    }
    
    /**
     * The main brain of the game. Update the status of the game after each move
     * @param player
     *      The indicated player that will be put on the board, 1 for X, 2 for O
     * @param row
     *      The provided row
     * @param col
     *      The provided col
     * @return the status message of the game
     */
    public String updateGame(int player, int row, int col)
    {
        //If any mistake was made
        if (!validMove(row, col))
        {
            return "Please enter the valid cordinates for a move (1 - 3)."
                + '\n';
        }
        if (validMove(row, col) && !makeMove(player, row, col))
        {
            return "The place has been occupied, please make a move at another"
                + " grid." + '\n';
        }
        
        //We check for win condition
        //4 Wincons with the center grid 
        if (gameBoard[4] != 0)
        {
            for (int i = 1; i < 5; i++)
            {
                if (gameBoard[4] == gameBoard[4-i] 
                    && gameBoard[4] == gameBoard[4+i])
                {
                    won = true;
                }
            }
        }
        
        //2 Wincons with the top left grid
        if (gameBoard[0] != 0)
        {
            if ((gameBoard[0] == gameBoard[1] 
                && gameBoard[0] == gameBoard[2]) 
                || (gameBoard[0] == gameBoard[3] 
                    && gameBoard[0] == gameBoard[6]))
            {
                won = true;
            }
        }
        
        //2 Wincons with the bottom right grid
        if (gameBoard[8] != 0)
        {
            if ((gameBoard[8] == gameBoard[7] 
                && gameBoard[8] == gameBoard[6]) 
                || (gameBoard[8] == gameBoard[5] 
                    && gameBoard[8] == gameBoard[2]))
            {
                won = true;
            }
        }
        
        if (won)
        {
            if ((gameTurn - 1) % 2 == 1) {
                return "Player 1 won the game!";
            }
            return "Player 2 won the game!";
        }
        return '\n' + "Turn: " + gameTurn;
    }
    
    /**
     * Get the number of turns we are currently on
     * @return the turn number we are on
     */
    public int getGameTurn()
    {
        return gameTurn;
    }
    
    /**
     * Return the game board
     * @return the game board
     */
    public int[] getGameBoard()
    {
        return gameBoard;
    }
    
    /**
     * Return true or false if the game has ended
     * @return the game has ended or not
     */
    public boolean isWon()
    {
        return won;
    }
}
