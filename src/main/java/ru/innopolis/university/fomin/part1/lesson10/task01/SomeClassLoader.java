package ru.innopolis.university.fomin.part1.lesson10.task01;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Class loader for SomeClass
 * Search classes in classpath root
 */
public class SomeClassLoader extends ClassLoader {
    /**
     * log4j logger
     */
    protected static final Logger logger = LogManager.getLogger(SomeClassLoader.class);

    /**
     * @param name Class name
     * @return Found class
     */
    @Override
    protected Class<?> findClass(String name) {
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
