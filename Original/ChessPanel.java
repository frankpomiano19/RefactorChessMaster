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
 
    private ChessGameBoard  gameBoard;
    private ChessGameEngine gameEngine;
    private ChessGameLateral gameLateral;
    // ----------------------------------------------------------
    /**
     * Create a new ChessPanel object.
     */
    public ChessPanel(){
        this.setLayout( new BorderLayout() );
        gameBoard = new ChessGameBoard();
        gameLateral = new ChessGameLateral();
        this.add( gameBoard, BorderLayout.CENTER );
    
        this.setPreferredSize( new Dimension( 800, 600 ) );
        gameEngine = new ChessGameEngine( gameBoard ); // start the game
    }
  
    // ----------------------------------------------------------
    /**
     * Gets the logger object for use in other classes.
     * 
     * @return ChessGameLog the ChessGameLog object
     */
    
    public ChessGameLateral getGameLateral(){
        return gameLateral;
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
    
}