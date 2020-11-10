package ru.innopolis.university.fomin.examples.gof.creational.prototype.manualprototype;

public class ComplexObject {
    private Integer id;
    private String name;
    private Record record;

    public ComplexObject(Integer id, String name, Record record) {
        this.id = id;
        this.name = name;
        this.record = record;
    }

    public ComplexObject(ComplexObject obj) {
        this(obj.id, obj.name, obj.record);
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
