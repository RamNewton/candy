package ram.annotations.trial.processor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class DependencyInversionContainer {

    private Map<Class<?>, Object> candyMap;

    public DependencyInversionContainer() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Processor processor = new Processor();
        this.candyMap = new java.util.HashMap<>(Map.of());
        List<Class<?>> classes = processor.getClassesofInterest();
        for (Class<?> clazz: classes) {
            Constructor<?> constructor = clazz.getConstructor();
            Object objectObject = constructor.newInstance(null);
            candyMap.put(clazz, objectObject);
        }
    }

    public <T> T getCandy(Class<T> clazz) {
        if(candyMap.containsKey(clazz)) {
            Object object = candyMap.get(clazz);
            if (clazz.isInstance(object)) {
                return clazz.cast(object);
            }
        }
        return null;
    }
}
