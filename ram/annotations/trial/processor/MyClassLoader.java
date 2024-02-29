package ram.annotations.trial.processor;

import ram.annotations.trial.stuff.ChessBoard;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedList;
import java.util.List;

public class MyClassLoader {

    JarWalker jarWalker;
    ClassLoader classLoader;
    public MyClassLoader() {
        this.jarWalker = new JarWalker();
        this.classLoader = jarWalker.getClassLoader();
    }

    public Class<?> loadClassFromPath(String root, String className) {
        try {
            File file = new File(root);
            URL url = file.toURI().toURL();

            try(URLClassLoader classLoader = new URLClassLoader(new URL[]{url})){
                return classLoader.loadClass(className);
            }
        } catch (Exception e) {
            return null;
        }
    }

    public Class<?> loadClassFromJar(String className) {
        try {
            return classLoader.loadClass(className);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Class<?>> getClasses() {
        List<String> classNames = jarWalker.getClassNames();
        List<Class<?>> classes = new LinkedList<>();
        for(String className: classNames) {
            Class<?> clazz = loadClassFromJar(className);
            if (clazz != null) {
                classes.add(clazz);
            }
        }
        return classes;
    }

    public void tryThisOut() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println(System.getProperty("user.dir"));
        Class<?> clazz = loadClassFromPath("/Users/ra3/Ram/sandbox/java-annotations", "ram.annotations.trial.stuff.ChessBoard");
        Constructor<?> constructor = clazz.getConstructor();
        Object objectObject = constructor.newInstance(null);
        ChessBoard chessBoard = (ChessBoard) clazz.cast(objectObject);
        System.out.println(clazz.getCanonicalName());
        chessBoard.printSquares();
    }
}
