package ram.annotations.trial;

import ram.annotations.trial.processor.DependencyInversionContainer;
import ram.annotations.trial.stuff.ChessBoard;

import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, URISyntaxException {
        DependencyInversionContainer dic = new DependencyInversionContainer();
        dic.doTheThing();
        ChessBoard chessBoard = dic.getCandy(ChessBoard.class);
        chessBoard.printSquares();
        chessBoard.printSquares();
    }
}
