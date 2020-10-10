package ru.innopolis.university.fomin.part1.lesson04.task03.box;

import ru.innopolis.university.fomin.part1.lesson04.task03.math.IncompatibleTypesException;

import java.util.*;

/**
 * ObjectBox class
 *
 */
public class ObjectBox {
    protected List<Object> objectList;

    /**
     * Initial field class
     */
    public ObjectBox() {
        this.objectList = new ArrayList<>();
    }

    /**
     * @param object Object to add in collection
     */
    public void addObject(Object object) throws IncompatibleTypesException {
        this.objectList.add(object);
    }

    /**
     * @param object Object for remove from collection
     */
    public void removeObject(Object object) {
        this.objectList.remove(object);
    }

    /**
     * Outputting elements to the console
     */
    public void dump() {
        for (Object object : objectList) {
            System.out.print(object + "; ");
        }
        System.out.println();
    }
}
