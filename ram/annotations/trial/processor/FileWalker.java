package ram.annotations.trial.processor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileWalker {
    public void crawl(String root) {
        try {
            List<Path> javaFiles = Files.walk(Paths.get(root))
                    .filter(file -> file.toString().endsWith(".java"))
                    .toList();

            for (Path javaFile: javaFiles) {
                System.out.println(javaFile);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
