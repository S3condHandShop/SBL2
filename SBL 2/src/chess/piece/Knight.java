package chess.piece;

import chess.Color;

public class Knight extends ChessPiece{

    public int [][] legalMoves = {
            {-2, -1}, {-2, +1}, {-1, -2}, {-1, +2},     //All legal moves of a Knight, no exception handling yet
            {+2, -1}, {-1, -2}, {-2, +1}, {-1, +2}      //Given as a two dimensional Array
    };

    @Override
    public String toString() {
        String chessPieceLooks = "";
        char characterKnight = '\u2658';
        chessPieceLooks += characterKnight;
        return chessPieceLooks;
    }

    public Knight(int[][] piecePosition, ChessPieceType type, Color color)
    {
        super(piecePosition, type, color);
    }



    /*next we have to calculate it's legal moves, given the possible moves
    Knight can only move to given position if it's either not occupied or if there's another
    chessPiece with a different color
     */





}
