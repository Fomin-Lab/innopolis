package ru.innopolis.university.fomin;

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

    /*
        TODO: Тут что то не так!
     */
    @Override
    public int compareTo(Person o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return getName() + "; " + getAge() + "; " + getSex() + ". ";
    }
}
