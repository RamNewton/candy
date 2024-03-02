package ram.annotations.trial.stuff;

import ram.annotations.trial.myannotations.Candy;

@Candy
public class ChessGame {

    private final ChessBoard chessBoard;

    public ChessGame(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public void startGame() {
        chessBoard.printSquares();
    }
}
