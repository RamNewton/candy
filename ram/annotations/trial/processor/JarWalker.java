package ram.annotations.trial.processor;

import ram.annotations.trial.Main;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarWalker {
    public List<String> getClassNames() {
        try {
            String jarPath = getJarFilePath();
            JarFile jarFile = new JarFile(jarPath);
            List<String> classFiles = new LinkedList<>();
            Enumeration<JarEntry> jarEnumerator = jarFile.entries();

            while(jarEnumerator.hasMoreElements()) {
                JarEntry entry = jarEnumerator.nextElement();

                if (isClass(entry)) {
                   String className=  entry.getName().substring(0,entry.getName().length()-6);
                   className = className.replace('/', '.');
                   classFiles.add(className);
                }
            }
            return classFiles;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ClassLoader getClassLoader() {
        try {
            URL[] urls = {new URL("jar:file:" + getJarFilePath() + "!/")};
            return URLClassLoader.newInstance(urls);
        } catch (Exception e) {
            return null;
        }
    }

    private String getJarFilePath() {
        try {
            return Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isClass(JarEntry jarEntry) {
        return jarEntry.getName().endsWith(".class");
    }
}
