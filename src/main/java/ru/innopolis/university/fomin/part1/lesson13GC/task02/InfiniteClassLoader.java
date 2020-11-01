package ru.innopolis.university.fomin.part1.lesson13GC.task02;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.innopolis.university.fomin.part1.lesson10.task01.SomeClassLoader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InfiniteClassLoader extends ClassLoader {
    /**
     * log4j logger
     */
    protected static final Logger logger = LogManager.getLogger(SomeClassLoader.class);

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File classFile = new File(name + ".class");
        try (
                BufferedInputStream bis = new BufferedInputStream(
                        new FileInputStream(
                                classFile
                        )
                )
        ) {
            byte[] content = new byte[(int) classFile.length()];
            int readLength = bis.read(content);
            return defineClass(name, content, 0, readLength);
        } catch (IOException e) {
            logger.error("Что-то пошло не так: " + e);
            return null;
        }
    }
}
