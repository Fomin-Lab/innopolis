package ru.innopolis.university.fomin.part1.lesson05.task01;

import java.util.*;
import ru.innopolis.university.fomin.part1.lesson05.task01.models.Animal;

/**
 * Class CardFiles
 */
public class CardFiles {
    /**
     * Map animals
     */
    protected Map<Long, Animal> animals;

    /**
     * Map indexes (nickname, identifier) for fast search by nickname
     */
    protected Map<String, Long> indexes;

    /**
     * Last assigned identifier for animal
     */
    private static long lastId;

    /**
     * Initializing values for class fields
     */
    public CardFiles() {
        this.animals = new HashMap<>();
        this.indexes = new HashMap<>();
        lastId = 0;
    }

    /**
     * @return Unique identifier for object
     */
    public static long getIdentifier() {
        return lastId++;
    }

    /**
     * @param animal Animal to put in the card-files and put in indexes for fast search by nickname
     * @throws AnimalExistsException exception for double animals
     */
    public void addAnimal(Animal animal) throws AnimalExistsException {
        if (animals.containsValue(animal)) throw new AnimalExistsException("Объект уже содержится в картотеке");
        animals.put(animal.getId(), animal);
        indexes.put(animal.getNickname(), animal.getId());
    }

    /**
     * @param nickname Animal nickname
     * @return Found animal or null
     */
    public Animal findAnimalByNickname(String nickname) {
        Long identifier = indexes.get(nickname);
        if (identifier == null) return null;
        return animals.get(identifier);
    }

    /**
     * @param id Identifier from card-files
     * @param animal New animal object
     */
    public void updateAnimalById(long id, Animal animal) {
        this.animals.put(id, animal);
        this.indexes.put(animal.getNickname(), id);
    }

    /**
     * Animals sorted by:
     *      1. Owner (ask)
     *      2. Nickname (ask)
     *      3. Weight (ask)
     * @return All animals in card-files
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        List<Animal> animalList = new ArrayList<>(animals.values());

        Collections.sort(animalList, new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                int compareOwner = o1.getOwner().getName().compareTo(o2.getOwner().getName());
                int compareNickname = o1.getNickname().compareTo(o2.getNickname());
                int compareWeight = Float.compare(o1.getWeight(), o2.getWeight());

                if (compareOwner == 0) {
                    if (compareNickname == 0) {
                        return compareWeight;
                    } else {
                        return compareNickname;
                    }
                } else {
                    return compareOwner;
                }
            }
        });

        for (Animal animal : animalList) {
            result.append(animal.toString()).append("\n");
        }

        return result.toString();
    }
}
