package chess;

import java.io.*;

import chess.Board;
import chess.*;
import chess.Board.*;
import chess.piece.*;
import chess.piece.ChessPiece;
import chess.piece.Letter;

import java.util.ArrayList;


public class Game implements Serializable {

    private ArrayList<String> allMoves;

    /*Martin*/
    public void printMoves() {
        for (int i = 0; i < getMoves().size(); i++) {
            System.out.print(getMoves().get(i));
            i++;
            System.out.print("    | ");
            System.out.println(getMoves().get(i));

        }
    }


    public ArrayList<String> getMoves() {
        return this.allMoves;
    }

    public void setMoves(ChessPieceType type, int rowCur, int colCur, int rowDes, int colDes, boolean beatsPiece) {
        //String with moves
        String moveNotation = "";

        //text
        String text = "";
        switch (type) {
            case QUEEN:
                text += "Die Dame ";
                moveNotation += '\u2655';
                break;
            case BISHOP:
                text += "Der Läufer ";
                moveNotation += '\u2657';
                break;
            case KNIGHT:
                text += "Der Springer ";
                moveNotation += '\u2658';
                break;
            case ROOK:
                text += "Der Turm ";
                moveNotation += '\u2656';

                break;
            case PAWN:
                text += "Der Bauer ";
                moveNotation += '\u2659';

                break;
            case KING:
                text += "Der König ";
                moveNotation += '\u2654';

                break;
        }
        moveNotation += getPieceNotation(rowCur, colCur);
        moveNotation += "-";

        moveNotation += getPieceNotation(rowDes, colDes);
        allMoves.add(moveNotation);


        text += "auf ";
        text += moveNotation.substring(1, 3);
        text += " zieht nach ";
        text += moveNotation.substring(4, 6);

        if (beatsPiece) {
            text += " und schlägt dort ein gegnerischen Stein";
        }
        allMoves.add(text);
    }


    public String getPieceNotation(int row, int col) {
        String str = "";
        char colChar = 'a';
        colChar += col;
        str += colChar;
        int rowInt = 8 - row;
        str += rowInt;
        return str;
    }

    public void saveMoves(String fileName) {

        //should work
        
        BufferedWriter bw = null;
        FileWriter fw = null;
        File file = new File(fileName);
        try {
            bw = new BufferedWriter(new FileWriter(fileName, true));

            for (String moves : getMoves()) {
                bw.write(moves);
            }

            bw.newLine();
            bw.flush();
        } catch (IOException exception) {
        } finally {
            try {
                bw.close();
            } catch (IOException a) {
            }
        }
    }

    public void saveGame(String fileName) {

        //Method should work, also not tested yet

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(
                    new FileOutputStream(fileName));

            //Game game = new Game();  redundant???
            oos.writeObject(this.getMoves());
        } catch (IOException e) {
        } finally {
            if (oos != null)
                try {
                    oos.close();
                } catch (IOException e) {
                }
        }
    }

    public static Game loadGameByMoves(ArrayList<String> getMoves) {
    Game game = new Game();
        for (String moves: getMoves) {
            //Same method just a different way to do?
        }
    }

    public static Game loadGameByMoves(String fileName) {
        Game game  = new Game();
        game.add(fileName);     //How to ?



        return game;
    }




    public static Game loadGame(String fileName) {

        //Not tested yet, but should be fine

        Game game = new Game();
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(fileName));
             game = (Game) inputStream.readObject();
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        } finally {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
        }
        return game;
    }





    public static void main(String[] args) {


        Board testBoard = new Board();
        System.out.print(testBoard.toString());
    }
}
