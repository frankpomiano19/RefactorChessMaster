package Original;

import javax.swing.*;
// -------------------------------------------------------------------------
/**
 * Shows the GUI for the Chess game.
 * 
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class ChessGameLateral
extends JPanel{
private ChessMenuBar    menuBar;jpa
private ChessGameLog    gameLog;
private ChessGraveyard  playerOneGraveyard;
private ChessGraveyard  playerTwoGraveyard;
// ----------------------------------------------------------
/**
 * Create a new ChessPanel object.
 */
public ChessPanel(){
    this.setLayout( new BorderLayout() );
    menuBar = new ChessMenuBar();
    gameLog = new ChessGameLog();
    playerOneGraveyard = new ChessGraveyard( "Player 1's graveyard" );
    playerTwoGraveyard = new ChessGraveyard( "Player 2's graveyard" );
    this.add( menuBar, BorderLayout.NORTH );
    this.add( gameLog, BorderLayout.SOUTH );
    this.add( playerOneGraveyard, BorderLayout.WEST );
    this.add( playerTwoGraveyard, BorderLayout.EAST );
    this.setPreferredSize( new Dimension( 800, 600 ) );
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
}
