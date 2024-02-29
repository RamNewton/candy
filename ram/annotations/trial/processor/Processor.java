package ram.annotations.trial.processor;

import ram.annotations.trial.myannotations.Candy;

import java.util.List;

public class Processor {

    private boolean isAnnotatedWithBoardName(Class<?> clazz) {
        return clazz.isAnnotationPresent(Candy.class);
    }

    public List<Class<?>> getClassesWithCandyAnnotation(List<Class<?>> classes) {
        return classes.stream()
                .filter(this::isAnnotatedWithBoardName)
                .toList();
    }
}
