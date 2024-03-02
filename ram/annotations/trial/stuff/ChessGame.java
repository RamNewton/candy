package ram.annotations.trial.stuff;

import ram.annotations.trial.myannotations.Candy;

@Candy
public class ChessGame {

    private ChessBoard chessBoard;

    public ChessGame(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public void startGame() {
        chessBoard.printSquares();
    }
}
