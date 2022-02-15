package hu.progmasters;

import java.util.ArrayList;
import java.util.List;

public class DogShelter {

    List<Dog> dogList = new ArrayList<>();
    List<Owner> ownerList = new ArrayList<>();
    List<Volunteer> volunteerList = new ArrayList<>();
    List<Worker> workerList = new ArrayList();

    public DogShelter(List<Dog> dogList, List<Owner> ownerList, List<Volunteer> volunteerList, List<Worker> workerList) {
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
