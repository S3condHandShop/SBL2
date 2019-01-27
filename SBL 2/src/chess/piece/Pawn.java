package chess.piece;

import chess.Color;

public class Pawn extends ChessPiece{

    int[] startPosition;                // extra für {+2, 0} move

    public Pawn (int[] piecePosition, ChessPieceType type, Color color)
    {
        super(piecePosition,type,color);
        this.startPosition = piecePosition;

    }


    public int [][] legalMoves = {
            {+1, 0},
            {+2, 0},             //Bedingung: nur von Startposition
            {+1, +1}, {+1, -1}   //Bedingug: nur wenn gegn. Figur schräg davor ist
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
