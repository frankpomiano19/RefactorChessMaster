package Original;
public class Enemy {
    
    public boolean isEnemy( ChessGameBoard board, int row, int col, int color){
        if ( row > 7 || col > 7 || row < 0 || col < 0 ){
            return false;
        }
        ChessGamePiece enemyPiece =
            board.getCell( row, col ).getPieceOnSquare() == null
                ? null
                : board.getCell( row, col ).getPieceOnSquare();
        if ( enemyPiece == null
            || color == ChessGamePiece.UNASSIGNED
            || enemyPiece.getColorOfPiece() == ChessGamePiece.UNASSIGNED ){
            return false;
        }
        if ( color == ChessGamePiece.WHITE ){
            if ( enemyPiece.getColorOfPiece() == ChessGamePiece.BLACK ){
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if ( enemyPiece.getColorOfPiece() == ChessGamePiece.WHITE ){
                return true;
            }
            else
            {
                return false;
            }
        }
    }

}
