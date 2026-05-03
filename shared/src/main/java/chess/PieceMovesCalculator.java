package chess;

import java.util.ArrayList;
import java.util.Collection;

public class PieceMovesCalculator {

    public static Collection<ChessMove> bishopMoves(ChessBoard board, ChessPosition myPosition)
    {
        Collection<ChessMove> moves = new ArrayList<>();
        int[][] directions = {{1,1}, {1,-1}, {-1,1}, {-1,-1}};
        ChessPiece currentPosition = board.getPiece(myPosition);

        for(int[] d:directions)
        {
            int row = myPosition.getRow();
            int col = myPosition.getColumn();
            while (true)
            {
                row += d[0];
                col += d[1];
                if (row < 1 || row > 8|| col < 1 || col > 8)
                {
                    break;
                }
                ChessPosition nextPosition = new ChessPosition(row, col);
                ChessPiece takenSpace = board.getPiece(nextPosition);
                if (takenSpace == null)
                {
                    moves.add(new ChessMove(myPosition, nextPosition, null));
                } else
                {
                    if(takenSpace.getTeamColor() != currentPosition.getTeamColor())
                    {
                        moves.add(new ChessMove(myPosition, nextPosition, null));
                    }
                    break;
                }
            }
        }
        return moves;
    }
}
