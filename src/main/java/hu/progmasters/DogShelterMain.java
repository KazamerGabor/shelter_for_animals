package hu.progmasters;

import hu.progmasters.animals.Dog;
//import hu.progmasters.database.config.UsageByManual;
import hu.progmasters.database.config.DogShelterRepository;
import hu.progmasters.humans.Owner;
import hu.progmasters.humans.Volunteer;
import hu.progmasters.humans.Worker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DogShelterMain {

    List<Dog> dogList = new ArrayList<>();
    List<Owner> ownerList = new ArrayList<>();
    List<Volunteer> volunteerList = new ArrayList<>();
    List<Worker> workerList = new ArrayList();

    //    List<Person> personList = new ArrayList<>();
    public static void main(String[] args) {

        DogShelterRepository dogShelterRepository = new DogShelterRepository();
        dogShelterRepository.initAllTables();


//        UsageByManual test = new UsageByManual();
//        UsageByReading test2 = null;
//        try {
//            test2 = new UsageByReading();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        test.initAddressTable();
//        test.initAddressFromFile();
//        test2.initDogTable();
//        test2.readingDogsFromFileAndIntoSQL();
//        test2.intoSQL();



    }

    public DogShelterMain(List<Dog> dogList, List<Owner> ownerList, List<Volunteer> volunteerList, List<Worker> workerList) {
        this.dogList = dogList;
        this.ownerList = ownerList;
        this.volunteerList = volunteerList;
        this.workerList = workerList;

    }

    public List<Dog> getDogList() {
        return dogList;
    }

    public void setDogList(List<Dog> dogList) {
        this.dogList = dogList;
    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<Owner> ownerList) {
        this.ownerList = ownerList;
    }

    public List<Volunteer> getVolunteerList() {
        return volunteerList;
    }

    public void setVolunteerList(List<Volunteer> volunteerList) {
        this.volunteerList = volunteerList;
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }
}
