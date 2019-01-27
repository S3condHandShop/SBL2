package chess.piece;

import chess.Color;

public class Knight extends ChessPiece{

    public Knight(int[] piecePosition, ChessPieceType type, Color color) {
        super(piecePosition, type, color);
    }

    public int [][] legalMoves = {
            {-2, -1}, {-2, +1}, {-1, -2}, {-1, +2},     //All legal moves of a Knight, no exception handling yet
            {+2, -1}, {-1, -2}, {-2, +1}, {-1, +2}      //Given as a two dimensional Array
    };

    @Override
    public String toString() {
        String pieceSymbol = "";
        if (this.getColor().equals(Color.WHITE)) pieceSymbol += '\u2658';
        pieceSymbol += '\u265E';
        return pieceSymbol;
    }





    /*next we have to calculate it's legal moves, given the possible moves
    Knight can only move to given position if it's either not occupied or if there's another
    chessPiece with a different color
     */





}
