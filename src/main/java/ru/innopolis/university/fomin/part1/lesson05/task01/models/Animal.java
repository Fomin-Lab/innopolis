package ru.innopolis.university.fomin.part1.lesson05.task01.models;

import java.util.Objects;

/**
 * Class Animal
 */
public class Animal {

    /**
     * Unique identifier animal for card-files
     */
    private long id;

    /**
     * Animal nickname
     */
    private String nickname;

    /**
     * Owner animal
     */
    private Person owner;

    /**
     * Animal weight in kilograms
     */
    private float weight;

    public Animal(long id, String nickname, Person owner, float weight) {
        this.id = id;
        this.nickname = nickname;
        this.owner = owner;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id &&
                Float.compare(animal.weight, weight) == 0 &&
                nickname.equals(animal.nickname) &&
                Objects.equals(owner, animal.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, owner, weight);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", owner=" + owner +
                ", weight=" + weight +
                '}';
    }
}
