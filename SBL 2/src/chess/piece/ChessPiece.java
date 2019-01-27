package chess.piece;

import chess.Board;
import chess.Color;

public abstract class ChessPiece {

    public int[] piecePosition;       //Da Board zweidimensional

    private Color color;

    int[] startPosition;

    private ChessPieceType type;

    public int[][] legalMoves;

    /*public enum ChessPieceType {
        KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN
    }*/

    public ChessPiece(int[] piecePosition, ChessPieceType type, Color color) {
        this.type = type;
        this.color = color;
        this.piecePosition = piecePosition;
    }


    public ChessPieceType getType() {
        /*switch (type) {
            case KING:
                return ChessPieceType.KING;
            case PAWN:
                return ChessPieceType.PAWN;
            case ROOK:
                return ChessPieceType.ROOK;
            case QUEEN:
                return ChessPieceType.QUEEN;
            case BISHOP:                            //Überflüssig geht einfacher. this als referenz auf das objekt selbst
                return ChessPieceType.BISHOP;
            case KNIGHT:
                return ChessPieceType.KNIGHT;
            default:
                return null;*/
        return this.type;
       }


    //public abstract ChessPieceType getType();

    public Color getColor() {
        switch (color) {
            case BLACK:
                return Color.BLACK;
            case WHITE:
                return Color.WHITE;
            default:
                return null;
        }
    }

    public void setType(ChessPieceType type) {
        this.type = type;
    }

    public void setColor(Color color) {
        this.color = color;

    }

    public int[][] getLegalMoves() {
        return this.legalMoves;
    }


    public abstract String toString();


    @Override
    public boolean equals(Object obj) {
        //check: obj is not null
        if (obj == null) {
            return false;
        }
        //check: both objects are identically
        if (obj == this) {
            return true;
        }
        //check: Both objects belong to the same class
        if (!obj.getClass().equals(this.getClass())) return false;

        //check: both Pieces have the same type and color
        ChessPiece chessPiece = (ChessPiece) obj;
        return (this.getColor().equals(chessPiece.getColor()) &&
                this.getType().equals(chessPiece.getType()));
    }

    public boolean canMove(Board[][] board, int row, int col) {
        //first checken ob an der Stelle[row][col] eine Figur der selben Farbe steht
        //Out of bounds error
        if (equalColor(board[row][col]))
            return false;

        //second check legal moves
        int[] differential = {row - this.piecePosition[0], col - this.piecePosition[1]};

        //special pawn
        if (this.getClass().equals(Pawn.class)) { // if bedingung für pawn, da paar legal moves an bedingung geknüpft sind
            if ((differential[0] == 1 && differential[1] == 1) || (differential[0] == 1 && differential[1] == -1)) {
                if (board[row][col] == null) { // ?
                    return false;
                }
            }
            if (differential[0] == 2 && differential[1] == 0) {
                if (this.piecePosition == this.startPosition)
                    return true;
                else
                    return false;
            }
        }

        for (int[] check : this.getLegalMoves()) {
            if (check[0] == differential[0] && check[1] == differential[1])
                return true;                                                //
        }
        return true;
    }

    public boolean equalColor(Object object) {
        //check: obj is not null
        if (object == null) {
            return false;
        }
        //check: both Pieces have the color
        ChessPiece chessPiece = (ChessPiece) object;
        return (this.getColor() == chessPiece.getColor());
    }

    public boolean[][] getPossibleDestinations(Board[][] board) {
        boolean[][] possibleDestinations = new boolean[8][8];
        for (int row = 0; row <= 7; row++) {
            for (int col = 0; col <= 7; col++) {
                possibleDestinations[row][col] = this.canMove(board, row, col);
            }
        }
        return possibleDestinations;

    }

   /* public ChessPieceType isClass () {
        return this.getType();
    }*/

    //public abstract boolean isOccupied();


}
