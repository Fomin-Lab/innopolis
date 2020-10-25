package ru.innopolis.university.fomin.part1.lesson10.task01;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.*;
import java.net.URL;
import java.util.Collections;

/**
 * Class performs the task conditions lesson10.task01
 */
public class Main {
    /**
     * Template for SomeClass which auto-generate with entered code from console
     */
    private static final String INPUT_RESOURCE = "lesson10/SomeClassTemplate.txt";

    /**
     * Classname which compile in runtime
     */
    private static final String OUTPUT_CLASS = "SomeClass.java";

    /**
     * Enter code in console and this code will be compile in runtime
     *
     * example: enter line below in console and press enter
     *          "String s = "Hello"; System.out.println(s);"
     *          this code is compiled at runtime
     *
     * @param args
     *        Input arguments
     *
     * @throws IOException
     *         If an I/O error occurs while reading line
     */
    public static void main(String[] args) throws IOException {
        String codeFromConsole = readCodeFromConsole();
        makeAndCompileClass(codeFromConsole);
        executeDoWork();
    }

    /**
     * Read text code from console
     *
     * @return Entered text code
     * @throws IOException
     *         If an I/O error occurs while reading line
     */
    private static String readCodeFromConsole() throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (String line = reader.readLine(); line != null && !line.isEmpty(); line = reader.readLine()) {
            result.append(line).append("\r\n");
        }
        return result.toString();
    }

    /**
     * First make class code by template @INPUT_RESOURCE with insert code obtained from console
     * Second compile this class
     *
     * @param code
     *        String of code which need execute in method doWork (interface Worker)
     */
    private static void makeAndCompileClass(String code) {
        URL inputUrl = Main.class.getClassLoader().getResource(INPUT_RESOURCE);
        assert inputUrl != null;

        try (
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(inputUrl.getPath()
                            )
                    )
                );

                FileOutputStream outputStream = new FileOutputStream(OUTPUT_CLASS);
        ) {
            /*
                Добавляем импорт для интерфейса Worker
                Т.к. класс SomeClass реализует интерфейс Worker
             */
            outputStream.write(("import " + Worker.class.getName() + ";").getBytes());

            // Вставляем наш код в SomeClass
            String line = "";
            while ((line = reader.readLine()) != null) {
                outputStream.write((line.replaceAll("// *#dowork_placeholder", code).getBytes()));
            }

            // Компилируем SomeClass
            compileClassInRuntime();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Load SomeClass and execute method doWork in SomeClass
     */
    private static void executeDoWork() {
        SomeClassLoader someClassLoader = new SomeClassLoader();

        try {
            final Class<?> someClass = Class.forName("SomeClass", true, someClassLoader);
            Worker instance = (Worker) someClass.newInstance();
            instance.doWork();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Compile class @OUTPUT_CLASS in runtime
     */
    private static void compileClassInRuntime() {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        StandardJavaFileManager fileManager = compiler
                .getStandardFileManager(null, null, null);

        Iterable<? extends JavaFileObject> compilationUnits = fileManager
                .getJavaFileObjectsFromStrings(Collections.singletonList(OUTPUT_CLASS));

        compiler.getTask(null, fileManager, null, null, null, compilationUnits).call();

        try {
            fileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
