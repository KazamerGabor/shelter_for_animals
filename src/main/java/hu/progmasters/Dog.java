package hu.progmasters;

public class Dog extends Animal {

    public Dog(int id, String breed, String name, String date_of_birth, String status) {
        super(id, breed, name, date_of_birth, status);
    }

    public Dog(String breed, String name, String date_of_birth, String status) {
        super(breed, name, date_of_birth, status);
    }
}
