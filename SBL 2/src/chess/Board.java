package chess;

import chess.Color;
import chess.piece.*;


public class Board{

    public ChessPiece[][] board ;

    public Board() {

        /* Define all necessary Pieces at the start of the board*/

        ChessPiece[][] board = new ChessPiece[8][8];
        int[] piecePosition;



        //set all pawns
        for (int i = 0; i < board[6].length; i++) {
            piecePosition = new int[] {6, i};
            board[6][i] = new Pawn(piecePosition, ChessPieceType.PAWN, Color.WHITE);
        }

        for (int i = 0; i < board[1].length; i++) {
            piecePosition = new int[] {1, i};
            board[1][i] = new Pawn(piecePosition, ChessPieceType.PAWN, Color.BLACK);
        }
        //rooks


        piecePosition = new int[] {7, 0};
        board[7][0] = new Rook(piecePosition, ChessPieceType.ROOK, Color.WHITE);
        piecePosition = new int[] {7, 7};
        board[7][7] = new Rook(piecePosition, ChessPieceType.ROOK, Color.WHITE);


        piecePosition = new int[] {0, 0};
        board[0][0] = new Rook(piecePosition, ChessPieceType.ROOK, Color.BLACK);
        piecePosition = new int[] {0, 7};
        board[0][7] = new Rook(piecePosition, ChessPieceType.ROOK, Color.BLACK);

        //knights
        piecePosition = new int[] {7, 1};
        board[7][1] = new Rook(piecePosition, ChessPieceType.KNIGHT, Color.WHITE);
        piecePosition = new int[] {7, 6};
        board[7][6] = new Rook(piecePosition, ChessPieceType.KNIGHT, Color.WHITE);


        piecePosition = new int[] {0, 1};
        board[0][1] = new Rook(piecePosition, ChessPieceType.KNIGHT, Color.BLACK);
        piecePosition = new int[] {0, 6};
        board[0][6] = new Rook(piecePosition, ChessPieceType.KNIGHT, Color.BLACK);

        //queens
        piecePosition = new int[] {7, 4};
        board[7][4] = new Rook(piecePosition, ChessPieceType.QUEEN, Color.WHITE);


        piecePosition = new int[] {0, 4};
        board[0][4] = new Rook(piecePosition, ChessPieceType.QUEEN, Color.BLACK);

        //kings
        piecePosition = new int[] {7, 3};
        board[7][3] = new Rook(piecePosition, ChessPieceType.KING, Color.WHITE);


        piecePosition = new int[] {0, 3};
        board[0][3] = new Rook(piecePosition, ChessPieceType.KING, Color.BLACK);

        //bishops
        piecePosition = new int[] {7, 2};
        board[7][2] = new Rook(piecePosition, ChessPieceType.BISHOP, Color.WHITE);
        piecePosition = new int[] {7, 5};
        board[7][5] = new Rook(piecePosition, ChessPieceType.BISHOP, Color.WHITE);

        piecePosition = new int[] {0, 2};
        board[0][2] = new Rook(piecePosition, ChessPieceType.BISHOP, Color.BLACK);
        piecePosition = new int[] {0, 5};
        board[0][5] = new Rook(piecePosition, ChessPieceType.BISHOP, Color.BLACK);
        this.board = board;
    }


    public ChessPiece[][] getBoard() {
        return this.board;
    }

    public int[] getPosition(ChessPiece piece){
        return piece.piecePosition;
    }


    //Method which moves chessPiece from Current Position to Destination Position */
    public void move(int rowCur, int colCur, int rowDes, int colDes){

        board[rowDes][colDes] = board[rowCur][rowCur];
        board[rowCur][colCur] = null;

    }


    /*Method checks whether Destination Position beats an enemy chessPiece
     Doesn't beat an enemy Piece if Destination is null or alliance*/

    public boolean beatsPiece(ChessPiece[][] board, int rowDes, int colDes){
        if (board[rowDes][colDes] == null || board[rowDes][colDes].equalColor(this))
            return false;
        else
            return true;
    }




    @Override
    public String toString(){
        String columnSpacing = "  ";
        String str= "   a   b  c   d   e  f   g   h\n";
        int printRow = 8;

        for ( int row = 0; row <= 7; row++ ) {
            str += printRow;
            str += columnSpacing;
            for ( int col = 0; col <= 7; col++ ) {

                if (this.getBoard()[row][col] == null)
                    str += '\u26da';
                else
                    str += this.getBoard()[row][col].getType();


                str += columnSpacing;
            }
            str += "\n";
            printRow--;
        }
        return str;
    }


}