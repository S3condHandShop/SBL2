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
       try {
           allMoves.add(moveNotation);
       } catch (NullPointerException e) {}


        text += "auf ";
        text += moveNotation.substring(1, 3);
        text += " zieht nach ";
        text += moveNotation.substring(4, 6);

        if (beatsPiece) {
            text += " und schlägt dort ein gegnerischen Stein";
        }
       try {
           allMoves.add(text);
       } catch (NullPointerException e) {}
    }



    //Methods returns a String of the piece Notation
    public String getPieceNotation(int row, int col) {
        String str = "";
        char colChar = 'a';
        colChar += col;
        str += colChar;
        int rowInt = 8 - row;
        str += rowInt;
        return str;
    }


    //Saves all moves in an file called FileName
    public void saveMoves(String fileName) {

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

    //serialises object Game
    public void saveGame(String fileName) {


        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(
                    new FileOutputStream(fileName));

            oos.writeObject(this);
        } catch (IOException e) {
        } finally {
            if (oos != null)
                try {
                    oos.close();
                } catch (IOException e) {
                }
        }
    }
    public static int piceNotationToInt(char n){
        int i = -97;
        if (n >= 'a' && n <= 'h'){
            i += n;
            return i;
        }
        i = 56;
        if (n >= '1' && n <= '8') {
            i -= n;
            return i;
        }
        return 0;
    }

    public static Game loadGameByMoves(ArrayList<String> getMoves) {
        Game game = new Game();
        Board board = new Board();
        String temp;
        int colCur;
        int rowCur;
        int colDes;
        int rowDes;
        for (int i=0; i<= getMoves.size(); i++) {
            temp = getMoves.get(i);
            colCur = piceNotationToInt(temp.charAt(1));
            rowCur = piceNotationToInt(temp.charAt(2));
            colDes = piceNotationToInt(temp.charAt(4));
            rowDes = piceNotationToInt(temp.charAt(5));
            board.move(rowCur, colCur, rowDes, colDes);

            i++; // method skips every second getMoves String because they are only
            // descriptions of the completed move
        }
        game.allMoves = getMoves;
        return game;
    }

    public static Game loadGameByMoves(String fileName) {
        Game game = loadGame(fileName);
        return game;
    }


    //Serialises game out of file called fileName
    public static Game loadGame(String fileName) {

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

        Game game = new Game();
        Board board = new Board();
int x1 = 6, x2 = 3, y1 = 7, y2 = 1;

//loadGame("Test.bin").toString();


        board.move(x1, x2, y1, y2);
        System.out.print(board.toString());



        /*
        boolean beatsPiece = board.beatsPiece(board.getBoard(), x2, y2);
        game.setMoves(board.getBoard()[x1][y1].getType(), x1, y1, x2, y2, beatsPiece);
        board.move(x1, y1, x2, y2);
        System.out.println(board);
        System.out.println();

        x1 = 7;
        y1 = 1;
        x2 = 5;
        y2 = 2;
        beatsPiece = board.beatsPiece(board.getBoard(), x2, y2);
        game.setMoves(board.getBoard()[x1][y1].getType(), x1, y1, x2, y2, beatsPiece);
        board.move(x1, y1, x2, y2);
        System.out.println();
        System.out.println(board);
        System.out.println();

        x1 = 7;
        y1 = 2;
        x2 = 5;
        y2 = 0;
        beatsPiece = board.beatsPiece(board.getBoard(), x2, y2);
        game.setMoves(board.getBoard()[x1][y1].getType(), x1, y1, x2, y2, beatsPiece);
        board.move(x1, y1, x2, y2);
        System.out.println(board);
        System.out.println();

       try {
           game.printMoves();
       }catch (NullPointerException e) {}

        game.saveGame("TestGame.ser");


        loadGame("TestGame.ser");
        System.out.print(board);*/
    }
}