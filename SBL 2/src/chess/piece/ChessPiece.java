package chess.piece;
import chess.Board;
import chess.Color;

public abstract class ChessPiece {

    public int[][] piecePosition;       //Da Board zweidimensional

    private Color color;

    private ChessPieceType type;


    public enum ChessPieceType {
        KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN
    }

    public ChessPiece(int[][] piecePosition,ChessPieceType type, Color color){
        this.type = type;
        this.color = color;
        this.piecePosition = piecePosition;
    }



    public ChessPieceType getType(){
        switch (type){
            case KING:
                return ChessPieceType.KING;
            case PAWN:
                return ChessPieceType.PAWN;
            case ROOK:
                return ChessPieceType.ROOK;
            case QUEEN:
                return ChessPieceType.QUEEN;
            case BISHOP:
                return ChessPieceType.BISHOP;
            case KNIGHT:
                return ChessPieceType.KNIGHT;
            default:
                return null;
        }
    }
    public Color getColor(){
        switch (color){
            case BLACK:
                return Color.BLACK;
            case WHITE:
                return Color.WHITE;
            default:
                return null;
        }
    }

    public abstract String toString();



    @Override
    public boolean equals(Object obj){
        //check: obj is not null
        if (obj == null){
            return false;
        }
        //check: both objects are identically
        if (obj == this){
            return true;
        }
        //check: Both objects belong to the same class
        if (! obj.getClass().equals(this.getClass())) return false;

        //check: both Pieces have the same type and color
        ChessPiece chessPiece = (ChessPiece) obj;
        return (this.getColor() == chessPiece.getColor() &&
                this.getType() == chessPiece.getType());
    }

    //public boolean canMove (Board board, int row, int col) {

    //}
/*
    public boolean[][] getPossibleDestinations(Board board){
        // board class dafür nötig
        boolean[][] possibleDestinations = new boolean[board.length][board[0].length];

    }*/
}
