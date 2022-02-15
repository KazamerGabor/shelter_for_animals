package hu.progmasters;

import hu.progmasters.database.config.DogShelterRepository;


public class DogShelterMain {

    public static void main(String[] args) {

        DogShelterRepository dogShelterRepository = new DogShelterRepository();
        dogShelterRepository.initAllTables();

    }
}
