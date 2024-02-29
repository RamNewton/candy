package ram.annotations.trial.stuff;

import ram.annotations.trial.myannotations.Candy;

@Candy
public class ChessBoard {
    public ChessBoard() {
        System.out.println("Initialized a ChessBoard");
    }

    public void printSquares() {
        System.out.println(8);
    }
}
