package hu.progmasters;

import java.util.List;

public class Cat extends Animal {
    public Cat(int id, String breed, String name, String date_of_birth, String status) {
        super(id, breed, name, date_of_birth, status);
    }

    public Cat(String breed, String name, String date_of_birth, String status) {
        super(breed, name, date_of_birth, status);
    }
}
