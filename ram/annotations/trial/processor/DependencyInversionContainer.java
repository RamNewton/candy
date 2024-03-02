package ram.annotations.trial.processor;

import ram.annotations.trial.exception.CandyInstantiationException;
import ram.annotations.trial.exception.CandyNotFoundException;
import ram.annotations.trial.exception.DicInstantationException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DependencyInversionContainer {

    private Map<Class<?>, Object> candyMap;

    public DependencyInversionContainer() {
        this.candyMap = new java.util.HashMap<>(Map.of());
    }

    public void doTheThing() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Class<?>> classes = getCandyClasses();
        for (Class<?> clazz: classes) {
            try {
                Constructor<?> constructor = clazz.getConstructor();
                Object objectObject = constructor.newInstance(null);
                candyMap.put(clazz, objectObject);
            } catch (NoSuchMethodException ignored){}
        }
        try {
            createCandyWithDeps(classes);
        } catch (CandyNotFoundException | CandyInstantiationException e) {
            throw new DicInstantationException("DependencyInversionContainer could not be instantiated", e);
        }
    }

    private void createCandyWithDeps(List<Class<?>> classes) throws CandyNotFoundException, CandyInstantiationException {
        for (Class<?> clazz: classes) {
            if (!candyMap.containsKey(clazz)) {
                Constructor<?>[] constructors =  clazz.getConstructors();
                Constructor<?> constructor = constructors[0];
                Class<?>[] paramClasses = constructor.getParameterTypes();

                List<Object> paramCandies = new LinkedList<>();
                for(Class<?> paramClass: paramClasses) {
                    if(!candyMap.containsKey(paramClass)) {
                        throw new CandyNotFoundException("Candy of type %s was not found".formatted(paramClass.getName()));
                    }
                    paramCandies.add(candyMap.get(paramClass));
                }
                try {
                    Object candy = constructor.newInstance(paramCandies.toArray());
                    candyMap.put(clazz, candy);
                } catch(InvocationTargetException | InstantiationException | IllegalAccessException e) {
                    throw new CandyInstantiationException("Candy %s creation had an error".formatted(clazz.getName()), e);
                }
            }
        }
    }

    private List<Class<?>> getCandyClasses() {
        MyClassLoader myClassLoader = new MyClassLoader();
        List<Class<?>> classes = myClassLoader.getClasses();
        Processor processor = new Processor();
        return processor.getClassesWithCandyAnnotation(classes);
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
