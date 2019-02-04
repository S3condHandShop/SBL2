package chess.piece;

import chess.Color;

public class Queen extends ChessPiece {

    public Queen (int[] piecePosition, ChessPieceType type, Color color) {
        super(piecePosition, type, color);
    }

    @Override
    public String toString() {
        String pieceSymbol = "";
        if (this.getColor().equals(Color.WHITE))
            pieceSymbol += '\u2655';
        pieceSymbol += '\u265B';
        return pieceSymbol;
    }

    //All legalMoves of a Queen

    public int [][] legalMoves = {
            {0, +1}, {0, +2}, {0, +3}, {0, +4}, {0, +5}, {0, +6}, {0, +7},
            {0, -1}, {0, -2}, {0, -3}, {0, -4}, {0, -5}, {0, -6}, {0, -7},
            {+1, 0}, {+2, 0}, {+3, 0}, {+4, 0}, {+5, 0}, {+6, 0}, {+7, 0},
            {-1, 0}, {-2, 0}, {-3, 0}, {-4, 0}, {-5, 0}, {-6, 0}, {-7, 0},
            {+1, -1}, {+1, +1}, {-1, -1}, {-1, +1},
            {+2, -2}, {+2, +2}, {-2, -2}, {-2, +2},
            {+3, -3}, {+3, +3}, {-3, -3}, {-3, +3},
            {+4, -4}, {+4, +4}, {-4, -4}, {-4, +4},
            {+5, -5}, {+5, +5}, {-5, -5}, {-5, +5},
            {+6, -6}, {+6, +6}, {-6, -6}, {-6, +6},
            {+7, -7}, {+7, +7}, {-7, -7}, {-7, +7},

    };


}
