package ram.annotations.trial.stuff;

import ram.annotations.trial.myannotations.BoardName;

@BoardName("it is a 8 x 8 board")
public class ChessBoard {
    public ChessBoard() {
        System.out.println("Initialized a ChessBoard");
    }

    public void printSquares() {
        System.out.println(8);
    }
}
