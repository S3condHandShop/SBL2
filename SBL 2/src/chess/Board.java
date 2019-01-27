package chess;

import chess.Color;
import chess.piece.*;


public class Board{

        ChessPiece[][] board ;

        public Board() {
            ChessPiece[][] board = new ChessPiece[8][8];
            int[] piecePosition;
            //pawns


            for (int i = 0; i < board[6].length; i++) {
                piecePosition = new int[] {6, i};
                board[6][i] = new Pawn(piecePosition, ChessPieceType.PAWN, Color.WHITE);
            }

            /*
            piecePosition = new int[] {6, 1};
            board[6][1] = new Pawn(piecePosition, ChessPiece.ChessPieceType.PAWN, Color.BLACK);
            piecePosition = new int[] {6, 2};
            board[6][2] = new Pawn(piecePosition, ChessPiece.ChessPieceType.PAWN, Color.BLACK);
            piecePosition = new int[] {6, 3};
            board[6][3] = new Pawn(piecePosition, ChessPiece.ChessPieceType.PAWN, Color.BLACK);
            piecePosition = new int[] {6, 4};
            board[6][4] = new Pawn(piecePosition, ChessPiece.ChessPieceType.PAWN, ChessPiece.Color.WHITE);
            piecePosition = new int[] {6, 5};
            board[6][5] = new Pawn(piecePosition, ChessPiece.ChessPieceType.PAWN, ChessPiece.Color.WHITE);
            piecePosition = new int[] {6, 6};
            board[6][6] = new Pawn(piecePosition, ChessPiece.ChessPieceType.PAWN, ChessPiece.Color.WHITE);
            piecePosition = new int[] {6, 7};
            board[6][7] = new Pawn(piecePosition, ChessPiece.ChessPieceType.PAWN, ChessPiece.Color.WHITE); */


            for (int i = 0; i < board[1].length; i++) {
                piecePosition = new int[] {1, i};
                board[1][i] = new Pawn(piecePosition, ChessPieceType.PAWN, Color.BLACK);
            }

            /*
            piecePosition = new int[] {1, 0};
            board[1][0] = new Pawn(piecePosition, ChessPiece.ChessPieceType.PAWN, ChessPiece.Color.BLACK);
            piecePosition = new int[] {1, 1};
            board[1][1] = new Pawn(piecePosition, ChessPiece.ChessPieceType.PAWN, ChessPiece.Color.BLACK);
            piecePosition = new int[] {1, 2};
            board[1][2] = new Pawn(piecePosition, ChessPiece.ChessPieceType.PAWN, ChessPiece.Color.BLACK);
            piecePosition = new int[] {1, 3};
            board[1][3] = new Pawn(piecePosition, ChessPiece.ChessPieceType.PAWN, ChessPiece.Color.BLACK);
            piecePosition = new int[] {1, 4};
            board[1][4] = new Pawn(piecePosition, ChessPiece.ChessPieceType.PAWN, ChessPiece.Color.BLACK);
            piecePosition = new int[] {1, 5};
            board[1][5] = new Pawn(piecePosition, ChessPiece.ChessPieceType.PAWN, ChessPiece.Color.BLACK);
            piecePosition = new int[] {1, 6};
            board[1][6] = new Pawn(piecePosition, ChessPiece.ChessPieceType.PAWN, ChessPiece.Color.BLACK);
            piecePosition = new int[] {1, 7};
            board[1][7] = new Pawn(piecePosition, ChessPiece.ChessPieceType.PAWN, ChessPiece.Color.BLACK);
            */
            //rooks

            //Schleifen verwenden vermeidet überflüssigen Code
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

        public void move(int rowCur, int colCur, int rowDes, int colDes){

            board[rowDes][colDes] = board[rowCur][rowCur];
            board[rowCur][colCur] = null;

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

                    if (getBoard()[row][col] == null)
                        str += '\u26da';
                    else
                        str += getBoard()[row][col].getType().toString();

                    /* Methode die die Klasse zurückgibt ist sinnvoll */

                    str += columnSpacing;
                }
                str += "\n";
                printRow--;
            }
            return str;
        }


    }

