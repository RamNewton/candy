package ram.annotations.trial;

import ram.annotations.trial.processor.FileWalker;

import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, URISyntaxException {
        FileWalker fileWalker = new FileWalker();
        System.out.println("My r: " + Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
        fileWalker.crawl("/Users/ra3/Ram/sandbox/java-annotations/ram/annotations/trial");
    }
}
