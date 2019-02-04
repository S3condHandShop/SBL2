package chess.piece;

import chess.Board;
import chess.Color;

public abstract class ChessPiece {

//abstract class ChessPiece of which all other ChessPiece classes inherit


    public int[] piecePosition;

    private Color color;

    int[] startPosition;

    private ChessPieceType type;

    public int[][] legalMoves;          //each chessPiece has legal Moves which is defined in here


    public ChessPiece(int[] piecePosition, ChessPieceType type, Color color) {
        this.type = type;
        this.color = color;
        this.piecePosition = piecePosition;
    }


    /* Getter methodes to return type and color */

    public ChessPieceType getType() {
        return this.type;
    }


    public Color getColor() {
                return this.color;
        }

        /* setter methods to set type and color and legalMoves of a ChessPiece*/

    public int[][] getLegalMoves() {
        return this.legalMoves;
    }

    public void setType(ChessPieceType type) {
        this.type = type;
    }

    public void setColor(Color color) {
        this.color = color;

    }

    //abstract toString methode of which other classes inherit
    public abstract String toString();


    @Override
    public boolean equals(Object obj) {
        //check: obj is not null
        if (obj == null) return false;
        //check: both objects are identically
        if (obj == this) return true;
        //check: Both objects belong to the same class
        if (!obj.getClass().equals(this.getClass())) return false;
        //check: both Pieces have the same type and color
        ChessPiece chessPiece = (ChessPiece) obj;
        return (this.getColor().equals(chessPiece.getColor()) &&
                this.getType().equals(chessPiece.getType()));
    }

    public boolean canMove(Board[][] board, int row, int col) {
        //first: check whether piece has same alliance

        if (equalColor(board[row][col]))
            return false;

        //second check legal moves
        int[] differential = {row - this.piecePosition[0], col - this.piecePosition[1]};

        //special pawn
        if (this.getClass().equals(Pawn.class)) {
            if ((differential[0] == 1 && differential[1] == 1) || (differential[0] == 1 && differential[1] == -1))
                if (board[row][col] == null) return false;
                if (differential[0] == 2 && differential[1] == 0)
                if (this.piecePosition == this.startPosition) return true;
                else
                    return false;

        }

        for (int[] check : this.getLegalMoves()) {
            if (check[0] == differential[0] && check[1] == differential[1])
                return true;                                                //
        }
        return true;
    }


    //Method to check whether both chessPieces have the same Color
    public boolean equalColor(Object object) {
        //check: obj is not null
        if (object == null)  return false;

        //check: both Pieces have the same color
        ChessPiece chessPiece = (ChessPiece) object;
        return (this.getColor().equals(chessPiece.getColor()));
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


}
