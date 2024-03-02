package ram.annotations.trial;

import ram.annotations.trial.processor.DependencyInversionContainer;
import ram.annotations.trial.stuff.ChessGame;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        DependencyInversionContainer dic = new DependencyInversionContainer();
        dic.doTheThing();
        ChessGame chessGame = dic.getCandy(ChessGame.class);
        chessGame.startGame();
    }
}
