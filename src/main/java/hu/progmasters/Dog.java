package hu.progmasters;

import hu.progmasters.enums.Sex;
import hu.progmasters.enums.Status;

public class Dog {
    private int id;
    private String name;
    private String breed;
    private String dateOfBirth;
    private Sex sex;
    private int weight;
    private Status status;
    private DogCoat dogCoat;
    private DogHealth dogHealth;

    public Dog(int id, String name, String breed, String dateOfBirth, Sex sex, int weight, Status status, DogCoat dogCoat, DogHealth dogHealth) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.weight = weight;
        this.status = status;
        this.dogCoat = dogCoat;
        this.dogHealth = dogHealth;
    }

    public Dog(String name, String breed, String dateOfBirth, Sex sex, int weight, Status status, DogCoat dogCoat, DogHealth dogHealth) {
        this.name = name;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.weight = weight;
        this.status = status;
        this.dogCoat = dogCoat;
        this.dogHealth = dogHealth;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public DogCoat getDogCoat() {
        return dogCoat;
    }

    public void setDogCoat(DogCoat dogCoat) {
        this.dogCoat = dogCoat;
    }

    public DogHealth getDogHealth() {
        return dogHealth;
    }

    public void setDogHealth(DogHealth dogHealth) {
        this.dogHealth = dogHealth;
    }
}
