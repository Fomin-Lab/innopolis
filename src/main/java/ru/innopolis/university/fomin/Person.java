package ru.innopolis.university.fomin;

import ru.innopolis.university.fomin.algorithms.Sortable;

public class Person implements Sortable<Person> {
    protected String name;
    protected int age;
    protected Sex sex;

    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex.getSex();
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public int compareTo(Person o) {
        int compareName = this.getName().compareTo(o.getName());
        int compareAge = Integer.compare(this.getAge(), o.getAge());
        int compareSex = this.getSex().compareTo(o.getSex());

        if (compareSex == 0) {
            if (compareAge == 0) {
                return compareName;
            } else {
                return -1 * compareAge;
            }
        } else if (compareSex > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return getName() + "; " + getAge() + "; " + getSex() + ". ";
    }
}
