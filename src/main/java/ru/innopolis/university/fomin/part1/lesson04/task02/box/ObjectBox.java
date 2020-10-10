package ru.innopolis.university.fomin.box;

import ru.innopolis.university.fomin.math.IncompatibleTypesException;

import java.util.*;

public class ObjectBox {
    protected List<Object> objectList;

    public ObjectBox() {
        this.objectList = new ArrayList<Object>();
    }

    public void addObject(Object object) throws IncompatibleTypesException {
        this.objectList.add(object);
    }

    public void removeObject(Object object) {
        this.objectList.remove(object);
    }

    public void dump() {
        for (Object object : objectList) {
            System.out.print(object + "; ");
        }
        System.out.println();
    }
}
