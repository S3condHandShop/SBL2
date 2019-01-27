package chess.piece;

import chess.Color;

public class Bishop extends ChessPiece {

    public Bishop(int[] piecePosition, ChessPieceType type, Color color)
    {
        super(piecePosition, type, color);

    }

    public int [][] legalMoves = {
            {+1, -1}, {+1, +1}, {-1, -1}, {-1, +1},     //All legal moves of a Knight, no exception handling yet
            {+2, -2}, {+2, +2}, {-2, -2}, {-2, +2},      //Given as a two dimensional Array
            {+3, -3}, {+3, +3}, {-3, -3}, {-3, +3},
            {+4, -4}, {+4, +4}, {-4, -4}, {-4, +4},
            {+5, -5}, {+5, +5}, {-5, -5}, {-5, +5},
            {+6, -6}, {+6, +6}, {-6, -6}, {-6, +6},
            {+7, -7}, {+7, +7}, {-7, -7}, {-7, +7},
    };


    @Override
    public String toString() {
        String pieceSymbol = "";
        if (this.getColor().equals(Color.WHITE))
            pieceSymbol+='\u2657';      //Nach nur einer Anweisung ist das "else if" inklusive, somit überflüssig
            pieceSymbol+='\u265D';
        return pieceSymbol;
    }
}
