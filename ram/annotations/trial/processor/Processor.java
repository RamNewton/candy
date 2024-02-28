package ram.annotations.trial.processor;

import ram.annotations.trial.myannotations.BoardName;
import ram.annotations.trial.stuff.CarromBoard;
import ram.annotations.trial.stuff.ChessBoard;

import java.util.List;

public class Processor {

    private boolean isAnnotatedWithBoardName(Class<?> clazz) {
        return clazz.isAnnotationPresent(BoardName.class);
    }

    public List<Class<?>> getClassesofInterest() {
        List<Class<?>> classesOfInterest = List.of(
                ChessBoard.class,
                CarromBoard.class
        );

        return classesOfInterest
                .stream()
                .filter(this::isAnnotatedWithBoardName)
                .toList();
    }
}
