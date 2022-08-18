package Original;

import java.awt.*;
import javax.swing.*;
// -------------------------------------------------------------------------
/**
 * The main panel of the Chess game.
 * 
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class ChessPanel
    extends JPanel{
    private ChessMenuBar    menuBar;
    private ChessGameBoard  gameBoard;
    private ChessGameLog    gameLog;
    private ChessGraveyard  playerOneGraveyard;
    private ChessGraveyard  playerTwoGraveyard;
    private ChessGameEngine gameEngine;
    // ----------------------------------------------------------
    /**
     * Create a new ChessPanel object.
     */
    public ChessPanel(){
        this.setLayout( new BorderLayout() );
        menuBar = new ChessMenuBar();
        gameBoard = new ChessGameBoard();
        gameLog = new ChessGameLog();
        playerOneGraveyard = new ChessGraveyard( "Player 1's graveyard" );
        playerTwoGraveyard = new ChessGraveyard( "Player 2's graveyard" );
        this.add( menuBar, BorderLayout.NORTH );
        this.add( gameBoard, BorderLayout.CENTER );
        this.add( gameLog, BorderLayout.SOUTH );
        this.add( playerOneGraveyard, BorderLayout.WEST );
        this.add( playerTwoGraveyard, BorderLayout.EAST );
        this.setPreferredSize( new Dimension( 800, 600 ) );
        gameEngine = new ChessGameEngine( gameBoard ); // start the game
    }
    // ----------------------------------------------------------
    /**
     * Gets the logger object for use in other classes.
     * 
     * @return ChessGameLog the ChessGameLog object
     */
    public ChessGameLog getGameLog(){
        return gameLog;
    }
    // ----------------------------------------------------------
    /**
     * Gets the board object for use in other classes.
     * 
     * @return ChessGameBoard the ChessGameBoard object
     */
    public ChessGameBoard getGameBoard(){
        return gameBoard;
    }
    // ----------------------------------------------------------
    /**
     * Gets the game engine object for use in other classes
     * 
     * @return ChessGameEngine the ChessGameEngine object
     */
    public ChessGameEngine getGameEngine(){
        return gameEngine;
    }
    // ----------------------------------------------------------
    /**
     * Gets the appropriate graveyard object for use in other classes.
     * 
     * @param whichPlayer
     *            the number of the player (1 or 2)
     * @return ChessGraveyard the graveyard requested
     */
    public ChessGraveyard getGraveyard( int whichPlayer ){
        if ( whichPlayer == 1 ){
            return playerOneGraveyard;
        }
        else if ( whichPlayer == 2 ){
            return playerTwoGraveyard;
        }
        else
        {
            return null;
        }
    }
    public void reset(){//panel
        firstClick = true;
        currentPlayer = 1;
        ( (ChessPanel)board.getParent() ).getGraveyard( 1 ).clearGraveyard();
        ( (ChessPanel)board.getParent() ).getGraveyard( 2 ).clearGraveyard();
        ( (ChessPanel)board.getParent() ).getGameBoard().initializeBoard();
        ( (ChessPanel)board.getParent() ).revalidate();
        this.king1 = (King)board.getCell( 7, 3 ).getPieceOnSquare();
        this.king2 = (King)board.getCell( 0, 3 ).getPieceOnSquare();
        ( (ChessPanel)board.getParent() ).getGameLog().clearLog();
        ( (ChessPanel)board.getParent() ).getGameLog().addToLog(
            "A new chess "
                + "game has been started. Player 1 (white) will play "
                + "against Player 2 (black). BEGIN!" );
    }
    public boolean playerHasLegalMoves( int playerNum ){ //panel
        ArrayList<ChessGamePiece> pieces;
        if ( playerNum == 1 ){
            pieces = board.getAllWhitePieces();
        }
        else if ( playerNum == 2 ){
            pieces = board.getAllBlackPieces();
        }
        else
        {
            return false;
        }
        for ( ChessGamePiece currPiece : pieces ){
            if ( currPiece.hasLegalMoves( board ) ){
                return true;
            }
        }
        return false;
    }
    private void askUserToPlayAgain( String endGameStr ){ //panel
        int resp =
            JOptionPane.showConfirmDialog( board.getParent(), endGameStr
                + " Do you want to play again?" );
        if ( resp == JOptionPane.YES_OPTION ){
            reset();
        }
        else
        {
            board.resetBoard( false );
            // System.exit(0);
        }
    }
    public void determineActionFromSquareClick( MouseEvent e ){//panel
        BoardSquare squareClicked = (BoardSquare)e.getSource();
        ChessGamePiece pieceOnSquare = squareClicked.getPieceOnSquare();
        board.clearColorsOnBoard();
        if ( firstClick ){
            currentPiece = squareClicked.getPieceOnSquare();
            if ( selectedPieceIsValid() ){
                currentPiece.showLegalMoves( board );
                squareClicked.setBackground( Color.GREEN );
                firstClick = false;
            }
            else
            {
                if ( currentPiece != null ){
                    JOptionPane.showMessageDialog(
                        squareClicked,
                        "You tried to pick up the other player's piece! "
                            + "Get some glasses and pick a valid square.",
                        "Illegal move",
                        JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    JOptionPane.showMessageDialog(
                        squareClicked,
                        "You tried to pick up an empty square! "
                            + "Get some glasses and pick a valid square.",
                        "Illegal move",
                        JOptionPane.ERROR_MESSAGE );
                }
            }
        }
        else
        {
            if ( pieceOnSquare == null ||
                !pieceOnSquare.equals( currentPiece ) ) // moving
            {
                boolean moveSuccessful =
                    currentPiece.move(
                        board,
                        squareClicked.getRow(),
                        squareClicked.getColumn() );
                if ( moveSuccessful ){
                    checkGameConditions();
                }
                else
                {
                    int row = squareClicked.getRow();
                    int col = squareClicked.getColumn();
                    JOptionPane.showMessageDialog(
                        squareClicked,
                        "The move to row " + ( row + 1 ) + " and column "
                            + ( col + 1 )
                            + " is either not valid or not legal "
                            + "for this piece. Choose another move location, "
                            + "and try using your brain this time!",
                        "Invalid move",
                        JOptionPane.ERROR_MESSAGE );
                }
                firstClick = true;
            }
            else
            // user is just unselecting the current piece
            {
                firstClick = true;
            }
        }
    }
}
