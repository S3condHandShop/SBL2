package chess.piece;

import chess.Color;

public class King extends ChessPiece{

    public King(int[] piecePosition, ChessPieceType type, Color color)
    {
        super(piecePosition, type, color);

    }

    //legal Moves of a King
    public int [][] legalMoves = {
            {0, +1}, {0, -1},
            {+1, 0}, {-1, 0},
            {+1, +1}, {+1, -1},
            {-1, +1}, {-1, -1}

    };

    @Override
    public String toString() {
        String pieceSymbol = "";
        if (this.getColor().equals(Color.WHITE))
            pieceSymbol+='\u2654';
            pieceSymbol+='\u265A';
        return pieceSymbol;
    }
}