package chess.piece;

import chess.Color;

public class Pawn extends ChessPiece{

   public int[] startPosition;                // for {+2, 0} move

    public Pawn (int[] piecePosition, ChessPieceType type, Color color)
    {
        super(piecePosition,type,color);
        this.startPosition = piecePosition;

    }


    public int [][] legalMoves = {
            {+1, 0},
            {+2, 0},             //if: moves from start Position
            {+1, +1}, {+1, -1}   //if: enemy is skewed
    };

    public int [][] getLegalMoves(){
        return this.legalMoves;
    }


    @Override
    public String toString() {
        String pieceSymbol = "";
        if (this.getColor().equals(Color.WHITE))
            pieceSymbol+='\u2659';
        pieceSymbol+='\u265F';
        return pieceSymbol;
    }
}