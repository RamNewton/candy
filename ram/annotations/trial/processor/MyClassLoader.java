package ram.annotations.trial.processor;

import ram.annotations.trial.stuff.ChessBoard;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;

public class MyClassLoader {
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
