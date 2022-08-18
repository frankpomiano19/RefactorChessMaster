package Original;

import javax.swing.ImageIcon;
import java.util.ArrayList;
// import java.awt.Color;
// -------------------------------------------------------------------------
/**
 * Represents a Queen game piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class Queen
    extends ChessGamePiece{
    // ----------------------------------------------------------
    /**
     * Create a new Queen object.
     *
     * @param board
     *            the board the queen is on
     * @param row
     *            the row location of the queen
     * @param col
     *            the column location of the queen
     * @param color
     *            either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public Queen( ChessGameBoard board, int row, int col, int color ){
        super( board, row, col, color );
        maxNumMov = 8;        
    }
    /**
     * Calculates the possible moves for this Queen.
     * @param board the board to check on
     * @return ArrayList<String> the list of moves
     */
    // Codigo : RF3
    @Override
    protected ArrayList<String> calculatePossibleMoves( ChessGameBoard board ){
        ArrayList<String> northEastMoves = calculateNorthEastMoves( board, maxNumMov );
        ArrayList<String> northWestMoves = calculateNorthWestMoves( board, maxNumMov );
        ArrayList<String> southEastMoves = calculateSouthEastMoves( board, maxNumMov );
        ArrayList<String> southWestMoves = calculateSouthWestMoves( board, maxNumMov );
        ArrayList<String> northMoves = calculateNorthMoves( board, maxNumMov );
        ArrayList<String> southMoves = calculateSouthMoves( board, maxNumMov );
        ArrayList<String> eastMoves = calculateEastMoves( board, maxNumMov );
        ArrayList<String> westMoves = calculateWestMoves( board, maxNumMov );
        ArrayList<String> allMoves = new ArrayList<String>();
        allMoves.addAll( northEastMoves );
        allMoves.addAll( northWestMoves );
        allMoves.addAll( southWestMoves );
        allMoves.addAll( southEastMoves );
        allMoves.addAll( northMoves );
        allMoves.addAll( southMoves );
        allMoves.addAll( westMoves );
        allMoves.addAll( eastMoves );
        return allMoves;
    }
    /**
     * Creates an icon for this piece depending on the piece's color.
     *
     * @return ImageIcon the ImageIcon representation of this piece.
     */
    @Override
    public ImageIcon createImageByPieceType(){
        if ( getColorOfPiece() == ChessGamePiece.WHITE ){
            return new ImageIcon(
                getClass().getResource("chessImages/WhiteQueen.gif")
            );            
        }
        else if ( getColorOfPiece() == ChessGamePiece.BLACK ){
            return new ImageIcon(
                getClass().getResource("chessImages/BlackQueen.gif")
            );            
        }
        else
        {
            return new ImageIcon(
                getClass().getResource("chessImages/default-Unassigned.gif")
            ); 
        }
    }
}
