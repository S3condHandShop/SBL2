package chess.piece;

import chess.Color;

public class King extends ChessPiece{

    public King(int[] piecePosition, ChessPieceType type, Color color)
    {
        super(piecePosition, type, color);      //rest vorher schon definiert

    }

    public int [][] legalMoves = {
            {0, +1}, {0, -1},
            {+1, 0}, {-1, 0},
            {+1, +1}, {+1, -1},
            {-1, +1}, {-1, -1}

    };

    @Override
    public String toString() {
        String pieceSymbol = "";
        if (this.getColor() == Color.WHITE)
            pieceSymbol+='\u2654';
        else if (this.getColor() == Color.BLACK)
            pieceSymbol+='\u265A';
        return pieceSymbol;
    }
    }


