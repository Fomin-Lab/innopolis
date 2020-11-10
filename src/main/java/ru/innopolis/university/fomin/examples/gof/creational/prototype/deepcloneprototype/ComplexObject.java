package ru.innopolis.university.fomin.examples.gof.creational.prototype.deepcloneprototype;

public class ComplexObject implements Cloneable {
    private Integer id;
    private String name;
    private Record record;

    public ComplexObject(Integer id, String name, Record record) {
        this.id = id;
        this.name = name;
        this.record = record;
    }

    @Override
    public ComplexObject clone() {
        try {
            ComplexObject clone = (ComplexObject) super.clone();
            clone.record = (Record) record.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Record getRecord() {
        return record;
    }
}
