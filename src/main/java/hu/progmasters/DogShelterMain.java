package hu.progmasters;

import hu.progmasters.database.config.DogShelterRepository;
import hu.progmasters.database.query.InsertIntoTables;


public class DogShelterMain {

    public static void main(String[] args) {

        DogShelterRepository dogShelterRepository = new DogShelterRepository();
        dogShelterRepository.initAllTables();

        InsertIntoTables insertIntoTables = new InsertIntoTables();
        insertIntoTables.readTextFiles();
        insertIntoTables.insertIntoTables();

    }
}
