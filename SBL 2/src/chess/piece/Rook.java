package chess.piece;


import chess.Color;

public class Rook extends ChessPiece {

    public Rook(int[] piecePosition, ChessPieceType type, Color color)
    {
        super(piecePosition, type, color);

    }

    public int[][] legalMoves = {
            {0, +1}, {0, +2}, {0, +3}, {0, +4}, {0, +5}, {0, +6}, {0, +7},
            {0, -1}, {0, -2}, {0, -3}, {0, -4}, {0, -5}, {0, -6}, {0, -7},
            {+1, 0}, {+2, 0}, {+3, 0}, {+4, 0}, {+5, 0}, {+6, 0}, {+7, 0},
            {-1, 0}, {-2, 0}, {-3, 0}, {-4, 0}, {-5, 0}, {-6, 0}, {-7, 0}

    };


    @Override
    public String toString() {
        String pieceSymbol = "";
        if (this.getColor().equals(Color.WHITE))
            pieceSymbol += '\u2656';
       else pieceSymbol += '\u265C';
        return pieceSymbol;
    }
}