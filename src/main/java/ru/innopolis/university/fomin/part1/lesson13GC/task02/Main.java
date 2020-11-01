package ru.innopolis.university.fomin.part1.lesson13GC.task02;

import org.apache.log4j.Logger;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class performs the task conditions lesson13 task
 * Start with VM Options: -Xmx25M -Xloggc:memory_lesson13GC2.log -XX:MaxMetaspaceSize=10M -XX:+PrintGCDetails
 */
public class Main {
    /**
     * Log4j logger
     */
    protected static final Logger LOGGER = Logger.getLogger(Main.class);

    /**
     * Switcher in loop
     */
    protected static boolean infinityCreation = true;

    /**
     * List of classes
     */
    protected static List<Class<?>> classes = new ArrayList<>();

    /**
     * Entry point
     * Infinite creation classes in loop with throw OutOfMemoryError
     * Maximum metaspace size should be 10Mb (-XX:MaxMetaspaceSize=10M)
     *
     * @param args Input args
     */
    public static void main(String[] args) throws IOException {
        int i = 0;
        while (infinityCreation) {
            classes.add(createClass("MyClass" + i++));
        }
    }

    /**
     * Create and compile class in runtime.
     * Files .java and .class will be automatically deleted
     *
     * @param className Class name
     * @return Compiled class
     * @throws IOException If I/O error occur
     */
    public static Class<?> createClass(String className) throws IOException {
        String javaClass = className + ".java";

        try (FileOutputStream outputStream = new FileOutputStream(javaClass);) {
            outputStream.write(("class " + className + " { protected static final int SOME_FIELD = 1237343; }").getBytes());

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

            if (compiler == null) return null;

            StandardJavaFileManager fileManager = compiler
                    .getStandardFileManager(null, null, null);

            Iterable<? extends JavaFileObject> compilationUnits = fileManager
                    .getJavaFileObjectsFromStrings(Collections.singletonList(javaClass));

            compiler.getTask(null, fileManager, null, null, null, compilationUnits).call();

            return Class.forName(className, true, new InfiniteClassLoader());
        } catch (ClassNotFoundException | FileNotFoundException e) {
            LOGGER.error(e);
        } finally {
            File javaFile = new File(javaClass);
            File classFile = new File(className + ".class");
            if (javaFile.delete() && classFile.delete()) {
                LOGGER.info(javaFile + " and " + classFile + " was deleted");
            }
        }
        return null;
    }
}
