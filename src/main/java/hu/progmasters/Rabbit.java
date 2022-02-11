package hu.progmasters;

public class Rabbit extends Animal {

    public Rabbit(int id, String breed, String name, String date_of_birth, String status) {
        super(id, breed, name, date_of_birth, status);
    }

    public Rabbit(String breed, String name, String date_of_birth, String status) {
        super(breed, name, date_of_birth, status);
    }
}
