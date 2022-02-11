package hu.progmasters;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    protected int id;
    protected String breed;
    protected String name;
    protected String date_of_birth;
    protected String status;
    List<Dog> dogs = new ArrayList<>();
    List<Cat> cats = new ArrayList<>();
    List<Rabbit> rabbits = new ArrayList<>();

    public Animal(int id, String breed, String name, String date_of_birth, String status) {
        this.id = id;
        this.breed = breed;
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.status = status;
    }

    public Animal(String breed, String name, String date_of_birth, String status) {
        this.breed = breed;
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    public void initDog(Dog dog) {
        dogs.add(new Dog(dog.breed, dog.name, dog.date_of_birth, dog.status));
    }

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

    public void initCat(Cat cat) {
        cats.add(new Cat(cat.breed, cat.name, cat.date_of_birth, cat.status));
    }

    public List<Rabbit> getRabbits() {
        return rabbits;
    }

    public void setRabbits(List<Rabbit> rabbits) {
        this.rabbits = rabbits;
    }

    public void initRabbit(Rabbit rabbit) {
        rabbits.add(new Rabbit(rabbit.breed, rabbit.name, rabbit.date_of_birth, rabbit.status));
    }
}
