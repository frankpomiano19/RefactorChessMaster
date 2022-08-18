package Original;

import javax.swing.*;

public class ChessGameLateral extends JPanel{
    private ChessMenuBar    menuBar;
    private ChessGameLog    gameLog;
    private ChessGraveyard  playerOneGraveyard;
    private ChessGraveyard  playerTwoGraveyard;

    
    public ChessGameLateral(){

        this.setLayout( new BorderLayout() );
        menuBar = new ChessMenuBar();
        gameLog = new ChessGameLog();
        playerOneGraveyard = new ChessGraveyard( "Player 1's graveyard" );
        playerTwoGraveyard = new ChessGraveyard( "Player 2's graveyard" );
        this.add( menuBar, BorderLayout.NORTH );
        this.add( gameLog, BorderLayout.SOUTH );
        this.add( gameLateral, BorderLayout.PAGE_END );
        this.add( playerOneGraveyard, BorderLayout.WEST );
        this.add( playerTwoGraveyard, BorderLayout.EAST );
  

    
    public ChessGameLog getGameLog(){
        return gameLog;
    }

    public ChessGameLateral getGameLateral(){
        return gameLateral;
    }
    
    
     
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