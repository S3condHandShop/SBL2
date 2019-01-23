package chess.piece;

import chess.Color;

public class King extends ChessPiece{

    public King(int[][] piecePosition, ChessPieceType type, Color color){
        super(piecePosition,type.KING, color);
    }

    @Override
    public String toString() {
        String position = "";
        return position;
    }

}
